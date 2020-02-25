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

public interface CustomActionsApi {
  /**
   * Execute custom action
   * A POST to this end point executes the custom action on the work package provided in the payload. The altered work package will be returned. In order to avoid executing  the custom action unbeknown to a change that has already taken place, the client has to provide the work package&#x27;s current lockVersion.
   * @param customActionId The id of the custom action to execute (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/custom_actions/{custom_action_id}/execute")
  Call<Void> apiV3CustomActionsCustomActionIdExecutePost(
            @retrofit2.http.Path("custom_action_id") Integer customActionId            ,                 @retrofit2.http.Body Object body    
  );

  /**
   * View custom action
   * 
   * @param customActionId The id of the custom action to fetch (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/custom_actions/{custom_action_id}")
  Call<Void> apiV3CustomActionsCustomActionIdGet(
            @retrofit2.http.Path("custom_action_id") Integer customActionId            
  );

}
