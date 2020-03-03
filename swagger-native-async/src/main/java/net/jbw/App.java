package net.jbw;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import net.jbw.openproject.client.api.ProjectsApi;
import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.api.WorkPackagesApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.User;
import net.jbw.openproject.client.model.WorkPackage;

public class App {

//	private static final String SERVER_SCHEME = "http";
//	private static final String SERVER_HOST = "localhost";
//	private static final String SERVER_BASE_PATH = "/";
//	// branch stable/10.3.1 joerg@kermit
//	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

//	private static final String SERVER_SCHEME = "https";
//	private static final String SERVER_HOST = "joergwille.openproject.com";
//	private static final String SERVER_BASE_PATH = "/";
//	// https://joergwille.openproject.com
//	private static final String APIKEY = "5b8a073a2e97bdd8a54bce05e1cac36cc83d8160706e40929088687c598383cf";

	private static final String SERVER_SCHEME = "https";
	private static final String SERVER_HOST = "make.haus";
	private static final String SERVER_BASE_PATH = "/";
	// branch release/10.4 joerg@indspdev
	private static final String APIKEY = "34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public static void main(String[] args) throws Exception {
		System.out.println("Requires Java 11!");
		System.out.println("Detected Java Version: " + System.getProperty("java.version"));
		System.out.println("Server: " + SERVER_SCHEME + "://" + SERVER_HOST + SERVER_BASE_PATH);

		ApiClient apiClient = Configuration.getDefaultApiClient()
				.setHttpClientBuilder(HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
						.followRedirects(Redirect.NORMAL).authenticator(new Authenticator() {
							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(USERNAME, APIKEY.toCharArray());
							}
						}))
				.setReadTimeout(Duration.ofSeconds(10)).setScheme(SERVER_SCHEME).setHost(SERVER_HOST)
				.setBasePath(SERVER_BASE_PATH);

		final UsersApi usersApi = new UsersApi(apiClient);

		System.out.println("Hello swagger-native-async!");
		User me = usersApi.apiV3UsersIdGet("me").get();
		System.out.println("==> User: " + me.getFirstName() + ", " + me.getLastName() + ", " + me.getLogin());

		System.out.println("Hello swagger-native-async wrapped in rxjava!");
		Observable<User> meObservable = Observable.fromCompletionStage(usersApi.apiV3UsersIdGet("me"));
		meObservable.subscribeOn(Schedulers.io()).blockingSubscribe(user -> {
			System.out.println("==> User: " + user.getFirstName() + ", " + user.getLastName() + ", " + user.getLogin());
		});

		getProjects(apiClient).subscribeOn(Schedulers.io()).subscribe(projects -> {
			projects.forEach(project -> {
				System.out.println("==> Project: " + project.getName());
				getWorkPackages(apiClient, project.getId()).subscribeOn(Schedulers.io()).subscribe(workPackages -> {
					workPackages.forEach(workPackage -> System.out.println(workPackage.getSubject()));
				});
			});
		});

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
	}

	private static Observable<List<Project>> getProjects(final ApiClient apiClient) {
		final ProjectsApi projectsApi = new ProjectsApi(apiClient);
		return Observable.fromCompletionStage(projectsApi.apiV3ProjectsGet(null))
				.map(projects -> projects.getEmbedded().getElements());
	}

	private static Observable<List<WorkPackage>> getWorkPackages(final ApiClient apiClient, int projectId) {
		final WorkPackagesApi workPackagesApi = new WorkPackagesApi(apiClient);
		return Observable
				.fromCompletionStage(
						workPackagesApi.apiV3ProjectsIdWorkPackagesGet(projectId, null, null, null, null, null, null))
				.map(workPackages -> workPackages.getEmbedded().getElements());
	}
}
