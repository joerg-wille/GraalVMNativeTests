package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserPreferencesApi {
  /**
   * Show my preferences
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/my_preferences")
  Call<Void> apiV3MyPreferencesGet();
    

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
  Call<Void> apiV3MyPreferencesPatch(
                    @retrofit2.http.Body Object body    
  );

}
