package net.jbw;

import net.jbw.openproject.client.api.UsersApi;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class App implements Callback<User> {

	// branch stable/10.3.1 joerg@kermit
	private static final String APIKEY = "3275030fced07dedcf3fb1d609e833d1788d29bbfb167c1a17ec93c5af118cf4";

	// branch release/10.4 joerg@indspdev
//	private static final String APIKEY C="34967d2b46496e94bdb1da235e470c4fb6e2f9f4e7e1ed0e8660dce93239722a";

	private static final String USERNAME = "apikey";

	public App() {
		super();

		UsersApi usersApi = new ApiClient("basicAuth", USERNAME, APIKEY).createService(UsersApi.class);
		Call<User> call = usersApi.apiV3UsersIdGet("me");
		call.enqueue(this);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello swagger-retrofit2!");

		new App();
	}

	@Override
	public void onResponse(Call<User> call, Response<User> response) {
		if (response.isSuccessful()) {
			System.out.println("==> User:" + response.body().getLogin());
		} else {
			System.out.println(response.errorBody());
		}
		System.exit(0);
	}

	@Override
	public void onFailure(Call<User> call, Throwable t) {
		t.printStackTrace();
		System.exit(-1);
	}
}
