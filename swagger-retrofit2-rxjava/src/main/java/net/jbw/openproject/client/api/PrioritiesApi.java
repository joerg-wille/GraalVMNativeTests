package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PrioritiesApi {
  /**
   * List all Priorities
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/priorities")
  Observable<Void> apiV3PrioritiesGet();
    

  /**
   * View Priority
   * 
   * @param id Priority id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/priorities/{id}")
  Observable<Void> apiV3PrioritiesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
