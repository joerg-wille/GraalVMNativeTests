package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StringObjectsApi {
  /**
   * View String Object
   * 
   * @param value The string value being resolved (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/string_objects")
  Observable<Void> apiV3StringObjectsGet(
        @retrofit2.http.Query("value") String value                
  );

}
