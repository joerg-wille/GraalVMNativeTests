package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;

public interface UserPreferencesApi {
  /**
   * Show my preferences
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/my_preferences")
  Observable<Void> apiV3MyPreferencesGet();
    

  /**
   * Update UserPreferences
   * When calling this endpoint the client provides a single object, containing the properties that it wants to change, in the body.
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @PATCH("api/v3/my_preferences")
  Observable<Void> apiV3MyPreferencesPatch(
                    @retrofit2.http.Body Object body    
  );

}
