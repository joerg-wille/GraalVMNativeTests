package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ConfigurationApi {
  /**
   * View configuration
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/configuration")
  Observable<Void> apiV3ConfigurationGet();
    

}
