package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QuerySortBysApi {
  /**
   * View Query Sort By
   * Retreive an individual QuerySortBy as identified by the id parameter.
   * @param id QuerySortBy identifier. The identifier is a combination of the column identifier and the direction. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/sort_bys/{id}")
  Observable<Void> apiV3QueriesSortBysIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
