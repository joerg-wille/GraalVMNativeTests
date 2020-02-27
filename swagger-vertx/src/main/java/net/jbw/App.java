package net.jbw;

import io.vertx.core.Context;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.invoker.auth.HttpBasicAuth;
import net.jbw.openproject.client.model.User;

public class App {

	private static final String SERVER_BASE_PATH = "http://localhost";

	// branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public static void main(String[] args) throws Exception {
		System.out.println("Hello swagger-vertx!");

		final Vertx vertx = Vertx.vertx();
//		final Context context = vertx.getOrCreateContext();
		final JsonObject config = new JsonObject();
		final ApiClient defaultClient = Configuration.setupDefaultApiClient(vertx, config);

		defaultClient.setBasePath(SERVER_BASE_PATH);

		// Configure HTTP basic authorization: basicAuth
		HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
		basicAuth.setUsername(USERNAME);
		basicAuth.setPassword(APIKEY);

		final net.jbw.openproject.client.api.UsersApi usersApiDelegate = new net.jbw.openproject.client.api.UsersApiImpl(
				defaultClient);

		usersApiDelegate.apiV3UsersIdGet("me", result -> {

			final User user = result.result();
			System.out.println("==> User:" + user.getLogin());

//			Async async; // = context.async();
//			context.async.complete();
		});

//		final UsersApi usersApi = new UsersApi(usersApiDelegate);
//		usersApi.rxApiV3UsersIdGet("me").subscribe(user -> {
//			System.out.println("==> User:" + user.getLogin());
//		});
	}
}
