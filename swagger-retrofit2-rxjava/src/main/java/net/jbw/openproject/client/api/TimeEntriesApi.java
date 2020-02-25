package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.TimeEntries;
import net.jbw.openproject.client.model.TimeEntry;
import net.jbw.openproject.client.model.TimeEntryPost;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TimeEntriesApi {
  /**
   * List Time entries
   * Lists time entries. The time entries returned depend on the filters provided and also on the permission of the requesting user.
   * @param offset Page number inside the requested collection. (optional)
   * @param pageSize Number of elements to display per page. (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + work_package: Filter time entries by work package  + project: Filter time entries by project  + user: Filter time entries by users (optional)
   * @return Call&lt;TimeEntries&gt;
   */
  @GET("api/v3/time_entries")
  Observable<TimeEntries> apiV3TimeEntriesGet(
        @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                
  );

  /**
   * View time entry
   * 
   * @param id time entry id (required)
   * @return Call&lt;TimeEntry&gt;
   */
  @GET("api/v3/time_entries/{id}")
  Observable<TimeEntry> apiV3TimeEntriesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Create time entry
   * Creates a new time entry applying the attributes provided in the body. Please note that while there is a fixed set of attributes, custom fields can extend a time entries’ attributes and are accepted by the endpoint.
   * @param body Time Entry to add (a project, activity and workPackage link is requried) (required)
   * @param offset Page number inside the requested collection. (optional)
   * @param pageSize Number of elements to display per page. (optional)
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @POST("api/v3/time_entries")
  Observable<Void> apiV3TimeEntriesPost(
                    @retrofit2.http.Body TimeEntryPost body    ,     @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("sortBy") String sortBy                
  );

}
