package net.jbw;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;
import java.time.Duration;

import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.model.User;

public class App {

	private static final String SERVER_BASE_PATH = "http://localhost";

	// branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public static void main(String[] args) throws Exception {
		System.out.println("Hello swagger-native!");
		System.out.println("Requires Java 11!");
		System.out.println("Detected Java Version: " + System.getProperty("java.version"));

		ApiClient defaultClient = Configuration.getDefaultApiClient().setHttpClientBuilder(
				HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).authenticator(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USERNAME, APIKEY.toCharArray());
					}
				})).setReadTimeout(Duration.ofSeconds(10)); // .setBasePath(SERVER_BASE_PATH);

		final UsersApi usersApi = new UsersApi(defaultClient);
		User me = null;
		try {
			me = usersApi.apiV3UsersIdGet("me");
			System.out.println("==> User: " + me.getFirstName() + ", " + me.getLastName() + ", " + me.getLogin());
		} catch (ApiException e) {
			System.err.println("Connection Error!");
			e.printStackTrace();
		}
	}
}
