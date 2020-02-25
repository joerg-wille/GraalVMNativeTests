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

public interface StringObjectsApi {
  /**
   * View String Object
   * 
   * @param value The string value being resolved (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/string_objects")
  Call<Void> apiV3StringObjectsGet(
        @retrofit2.http.Query("value") String value                
  );

}
