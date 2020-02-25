package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Projects;
import retrofit2.http.GET;

public interface ProjectsApi {
  /**
   * List projects
   * Returns a collection of projects. The collection can be filtered via query parameters similar to how work packages are filtered. In addition to the provided filter, the result set is always limited to only contain projects the client is allowed to see.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + ancestor: filters projects by their ancestor. A project is not considered to be it&#x27;s own ancestor. (optional)
   * @return Call&lt;Projects&gt;
   */
  @GET("api/v3/projects")
  Observable<Projects> apiV3ProjectsGet(
        @retrofit2.http.Query("filters") String filters                
  );

  /**
   * View project
   * 
   * @param id Project id (required)
   * @return Call&lt;Project&gt;
   */
  @GET("api/v3/projects/{id}")
  Observable<Project> apiV3ProjectsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List projects with version
   * This endpoint lists the projects where the given version is available.  The projects returned depend on the sharing settings of the given version, but are also limited to the projects that the current user is allowed to see.
   * @param id Version id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/versions/{id}/projects")
  Observable<Void> apiV3VersionsIdProjectsGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
