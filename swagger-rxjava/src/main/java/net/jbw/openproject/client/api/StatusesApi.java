package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StatusesApi {
  /**
   * List all Statuses
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/statuses")
  Observable<Void> apiV3StatusesGet();
    

  /**
   * View Status
   * 
   * @param id status id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/statuses/{id}")
  Observable<Void> apiV3StatusesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
