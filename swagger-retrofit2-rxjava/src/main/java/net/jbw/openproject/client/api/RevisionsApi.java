package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RevisionsApi {
  /**
   * View revision
   * 
   * @param id Revision id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/revisions/{id}")
  Observable<Void> apiV3RevisionsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
