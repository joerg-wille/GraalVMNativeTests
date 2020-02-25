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

public interface HelpTextsApi {
  /**
   * List all help texts
   * 
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/help_texts")
  Call<Void> apiV3HelpTextsGet();
    

  /**
   * View help text
   * 
   * @param id Help text id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/help_texts/{id}")
  Call<Void> apiV3HelpTextsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
