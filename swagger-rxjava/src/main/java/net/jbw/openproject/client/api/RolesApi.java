package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RolesApi {
  /**
   * List roles
   * List all defined roles. This includes built in roles like &#x27;Anonymous&#x27; and &#x27;Non member&#x27;.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/roles")
  Observable<Void> apiV3RolesGet();
    

  /**
   * View role
   * Fetch an individual role.
   * @param id role id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/roles/{id}")
  Observable<Void> apiV3RolesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
