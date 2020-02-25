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

public interface QuerySortBysApi {
  /**
   * View Query Sort By
   * Retreive an individual QuerySortBy as identified by the id parameter.
   * @param id QuerySortBy identifier. The identifier is a combination of the column identifier and the direction. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/sort_bys/{id}")
  Call<Void> apiV3QueriesSortBysIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
