package net.jbw;

import java.util.concurrent.TimeUnit;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import net.jbw.openproject.client.api.UsersApiImpl;
import net.jbw.openproject.client.api.rxjava.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.invoker.auth.HttpBasicAuth;

public class App extends AbstractVerticle {

	private static final String SERVER_BASE_PATH = "http://localhost";

	// branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	@Override
	public void start(Future<Void> future) {
		System.out.println("Welcome to Vertx");

		final JsonObject config = new JsonObject();
		final ApiClient defaultClient = Configuration.setupDefaultApiClient(vertx, config);
		defaultClient.setBasePath(SERVER_BASE_PATH);

		// Configure HTTP basic authorization: basicAuth
		HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
		basicAuth.setUsername(USERNAME);
		basicAuth.setPassword(APIKEY);

		final UsersApi usersApi = new UsersApi(new UsersApiImpl(defaultClient));
		usersApi.rxApiV3UsersIdGet("me").subscribe(user -> {
			System.out.println("==> User:" + user.getLogin());
		});

//		final UsersApi usersApi = new UsersApiImpl(defaultClient);
//
//		usersApi.apiV3UsersIdGet("me", result -> {
//			final User user = result.result();
//			System.out.println("==> User:" + user.getLogin());
//		});
	}

	@Override
	public void stop() {
		System.out.println("Shutting down application");
	}

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new App());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
		vertx.close();
	}

}
