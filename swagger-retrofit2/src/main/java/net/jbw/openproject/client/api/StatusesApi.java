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

public interface StatusesApi {
  /**
   * List all Statuses
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/statuses")
  Call<Void> apiV3StatusesGet();
    

  /**
   * View Status
   * 
   * @param id status id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/statuses/{id}")
  Call<Void> apiV3StatusesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
