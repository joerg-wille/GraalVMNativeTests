package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FormsApi {
  /**
   * show or validate form
   * This is an example of how a form might look like. Note that this endpoint does not exist in the actual implementation.
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/example/form")
  Observable<Void> apiV3ExampleFormPost(
                    @retrofit2.http.Body Object body    
  );

}
