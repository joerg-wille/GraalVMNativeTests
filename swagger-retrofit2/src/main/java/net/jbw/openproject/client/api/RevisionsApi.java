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

public interface RevisionsApi {
  /**
   * View revision
   * 
   * @param id Revision id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/revisions/{id}")
  Call<Void> apiV3RevisionsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
