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

public interface QueryColumnsApi {
  /**
   * View Query Column
   * Retreive an individual QueryColumn as identified by the &#x60;id&#x60; parameter.
   * @param id QueryColumn id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/columns/{id}")
  Call<Void> apiV3QueriesColumnsIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
