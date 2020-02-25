package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RootApi {
  /**
   * View root
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3")
  Observable<Void> apiV3Get();
    

}
