package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.User;
import net.jbw.openproject.client.model.Users;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface UsersApi {
  /**
   * List Users
   * Lists users. Only administrators have permission to do this.
   * @param offset Page number inside the requested collection. (optional)
   * @param pageSize Number of elements to display per page. (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + status: Status the user has  + group: Name of the group in which to-be-listed users are members.  + name: Filter users in whose first or last names, or email addresses the given string occurs.  + login: User&#x27;s login (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @return Call&lt;Users&gt;
   */
  @GET("api/v3/users")
  Observable<Users> apiV3UsersGet(
        @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("sortBy") String sortBy                
  );

  /**
   * Delete user
   * Permanently deletes the specified user account.
   * @param id User id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/users/{id}")
  Observable<Void> apiV3UsersIdDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View user
   * 
   * @param id User id. Use &#x60;me&#x60; to reference current user, if any. (required)
   * @return Call&lt;User&gt;
   */
  @GET("api/v3/users/{id}")
  Observable<User> apiV3UsersIdGet(
            @retrofit2.http.Path("id") String id            
  );

  /**
   * Remove Lock
   * 
   * @param id User id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/users/{id}/lock")
  Observable<Void> apiV3UsersIdLockDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Set Lock
   * 
   * @param id User id (required)
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/users/{id}/lock")
  Observable<Void> apiV3UsersIdLockPost(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Update user
   * Updates the user&#x27;s writable attributes. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.
   * @param id User id (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @PATCH("api/v3/users/{id}")
  Observable<Void> apiV3UsersIdPatch(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body Object body    
  );

  /**
   * Create User
   * Creates a new user. Only administrators have permission to do so. When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body.  Valid values for &#x60;status&#x60;:  1) \&quot;active\&quot; - In this case a password has to be provided in addition to the other attributes. 2) \&quot;invited\&quot; - In this case nothing but the email address is required. The rest is optional. An invitation will be sent to the user.
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/users")
  Observable<Void> apiV3UsersPost(
                    @retrofit2.http.Body Object body    
  );

}
