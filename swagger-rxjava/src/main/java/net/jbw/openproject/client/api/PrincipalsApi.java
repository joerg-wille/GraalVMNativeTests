package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PrincipalsApi {
  /**
   * List principals
   * List all principals. The client can choose to filter the principals similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain principals who are members in projects the client is allowed to see.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + type: filters principals by their type (*User*, *Group*).  + member: filters principals by the projects they are members in. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/principals")
  Observable<Void> apiV3PrincipalsGet(
        @retrofit2.http.Query("filters") String filters                
  );

}
