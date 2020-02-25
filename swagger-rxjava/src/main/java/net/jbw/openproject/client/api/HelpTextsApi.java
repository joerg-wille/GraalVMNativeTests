package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HelpTextsApi {
  /**
   * List all help texts
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/help_texts")
  Observable<Void> apiV3HelpTextsGet();
    

  /**
   * View help text
   * 
   * @param id Help text id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/help_texts/{id}")
  Observable<Void> apiV3HelpTextsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
