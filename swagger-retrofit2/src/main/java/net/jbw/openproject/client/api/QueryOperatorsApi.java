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

public interface QueryOperatorsApi {
  /**
   * View Query Operator
   * Retreive an individual QueryOperator as identified by the &#x60;id&#x60; parameter.
   * @param id QueryOperator id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/operators/{id}")
  Call<Void> apiV3QueriesOperatorsIdGet(
            @retrofit2.http.Path("id") String id            
  );

}
