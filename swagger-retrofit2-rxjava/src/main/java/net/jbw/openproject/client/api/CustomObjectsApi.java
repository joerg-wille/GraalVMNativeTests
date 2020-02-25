package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CustomObjectsApi {
  /**
   * View Custom Object
   * 
   * @param id The custom object&#x27;s identifier (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/custom_objects/{id}")
  Observable<Void> apiV3CustomObjectsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
