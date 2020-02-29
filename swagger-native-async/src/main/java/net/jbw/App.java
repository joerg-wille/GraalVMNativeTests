package net.jbw;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.time.Duration;

import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.model.User;

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
		System.out.println("Hello swagger-native-async!");
		System.out.println("Requires Java 11!");
		System.out.println("Detected Java Version: " + System.getProperty("java.version"));
		System.out.println("Server: " + SERVER_SCHEME + "://" + SERVER_HOST + SERVER_BASE_PATH);

		ApiClient defaultClient = Configuration.getDefaultApiClient()
				.setHttpClientBuilder(HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
						.followRedirects(Redirect.NORMAL).authenticator(new Authenticator() {
							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(USERNAME, APIKEY.toCharArray());
							}
						}))
				.setReadTimeout(Duration.ofSeconds(10)).setScheme(SERVER_SCHEME).setHost(SERVER_HOST)
				.setBasePath(SERVER_BASE_PATH);

		final UsersApi usersApi = new UsersApi(defaultClient);

		User me = usersApi.apiV3UsersIdGet("me").get();
		System.out.println("==> User: " + me.getFirstName() + ", " + me.getLastName() + ", " + me.getLogin());
		System.exit(0);
	}
}
