package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;

public interface ActivitiesApi {
  /**
   * View activity
   * 
   * @param id Activity id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/activities/{id}")
  Observable<Void> apiV3ActivitiesIdGet(
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
  Observable<Void> apiV3ActivitiesIdPatch(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body Object body    
  );

}
