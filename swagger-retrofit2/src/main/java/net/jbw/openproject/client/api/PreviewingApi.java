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

public interface PreviewingApi {
  /**
   * Preview plain document
   * 
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/render/plain")
  Call<Void> apiV3RenderPlainPost();
    

  /**
   * Preview Textile document
   * 
   * @param context API-Link to the context in which the rendering occurs, for example a specific work package.  If left out only context-agnostic rendering takes place. Please note that OpenProject features textile-extensions that can only work given a context (e.g. display attached images).  **Supported contexts:**  * &#x60;/api/v3/work_packages/{id}&#x60; - an existing work package (optional)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/render/textile")
  Call<Void> apiV3RenderTextilePost(
        @retrofit2.http.Query("context") String context                
  );

}
