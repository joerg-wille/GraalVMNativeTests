package net.jbw;

import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.model.User;

public class App {

	private static final boolean DEBUG = false;
	private static final String SERVER_BASE_PATH = "http://localhost";

        // branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public static void main(String[] args) throws Exception {
		System.out.println("Hello swagger-okhttp-gson!");

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(SERVER_BASE_PATH);
		apiClient.setDebugging(DEBUG);
		if (APIKEY == null || APIKEY.isEmpty()) {
			throw new IllegalArgumentException("API Key missing - pass it as parameter on start [ -DapiKey=foobar ]");
		}
		apiClient.setUsername(USERNAME);
		apiClient.setPassword(APIKEY);

		Configuration.setDefaultApiClient(apiClient);
		UsersApi usersApi = new UsersApi();
		User me = null;
		try {
			me = usersApi.apiV3UsersIdGet("me");
			System.out.println("==> User:" + me.getLogin());
		} catch (ApiException e) {
			System.err.println("Connection Error!");
			e.printStackTrace();
		}
	}

}
