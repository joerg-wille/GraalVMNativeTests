package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QueryColumnsApi {
  /**
   * View Query Column
   * Retreive an individual QueryColumn as identified by the &#x60;id&#x60; parameter.
   * @param id QueryColumn id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/columns/{id}")
  Observable<Void> apiV3QueriesColumnsIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
