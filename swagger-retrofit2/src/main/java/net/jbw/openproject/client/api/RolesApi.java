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

public interface RolesApi {
  /**
   * List roles
   * List all defined roles. This includes built in roles like &#x27;Anonymous&#x27; and &#x27;Non member&#x27;.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/roles")
  Call<Void> apiV3RolesGet();
    

  /**
   * View role
   * Fetch an individual role.
   * @param id role id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/roles/{id}")
  Call<Void> apiV3RolesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
