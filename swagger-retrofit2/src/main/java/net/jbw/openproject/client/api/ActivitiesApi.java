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

public interface ActivitiesApi {
  /**
   * View activity
   * 
   * @param id Activity id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/activities/{id}")
  Call<Void> apiV3ActivitiesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Update activity
   * Updates an activity&#x27;s comment and, on success, returns the updated activity.
   * @param id Activity id (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @PATCH("api/v3/activities/{id}")
  Call<Void> apiV3ActivitiesIdPatch(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body Object body    
  );

}
