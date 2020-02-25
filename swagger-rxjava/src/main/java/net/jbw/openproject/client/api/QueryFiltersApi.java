package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QueryFiltersApi {
  /**
   * View Query Filter
   * Retreive an individual QueryFilter as identified by the id parameter.
   * @param id QueryFilter identifier. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/filters/{id}")
  Observable<Void> apiV3QueriesFiltersIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
