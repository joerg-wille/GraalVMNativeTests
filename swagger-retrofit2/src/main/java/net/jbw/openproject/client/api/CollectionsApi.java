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

public interface CollectionsApi {
  /**
   * view aggregated result
   * 
   * @param groupBy The column to group by. Note: Aggregation is as of now only supported by the work package collection. You can pass any column name as returned by the [queries](#queries) endpoint. (optional)
   * @param showSums  (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/examples")
  Call<Void> apiV3ExamplesGet(
        @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") String showSums                
  );

}
