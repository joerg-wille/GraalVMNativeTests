package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  Call<Void> apiV3ExampleFormPost(
                    @retrofit2.http.Body Object body    
  );

}
