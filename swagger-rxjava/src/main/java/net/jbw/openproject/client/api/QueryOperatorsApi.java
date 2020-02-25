package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QueryOperatorsApi {
  /**
   * View Query Operator
   * Retreive an individual QueryOperator as identified by the &#x60;id&#x60; parameter.
   * @param id QueryOperator id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/operators/{id}")
  Observable<Void> apiV3QueriesOperatorsIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
