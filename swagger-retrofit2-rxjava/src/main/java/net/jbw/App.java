package net.jbw;

import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;

public class App {

	// branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public static void main(String[] args) throws Exception {
		System.out.println("Hello swagger-retrofit2-rxjava!");

		UsersApi usersApi = new ApiClient("basicAuth", USERNAME, APIKEY).createService(UsersApi.class);
		usersApi.apiV3UsersIdGet("me").subscribe(user -> {
			System.out.println("==> User:" + user.getLogin());
		});
	}
}
