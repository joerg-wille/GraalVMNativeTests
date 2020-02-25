package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.Versions;
import retrofit2.http.GET;

public interface VersionsApi {
  /**
   * List versions available in a project
   * This endpoint lists the versions that are *available* in a given project. Note that due to sharing this might be more than the versions *defined* by that project.
   * @param projectId ID of the project whoose versions will be listed (required)
   * @return Call&lt;Versions&gt;
   */
  @GET("api/v3/projects/{project_id}/versions")
  Observable<Versions> apiV3ProjectsProjectIdVersionsGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

  /**
   * List versions
   * Returns a collection of versions. The client can choose to filter the versions similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain versions, for which the requesting client has sufficient permissions (*view_work_packages*).
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + sharing: filters versions by how they are shared within the server (*none*, *descendants*, *hierarchy*, *tree*, *system*). (optional)
   * @return Call&lt;Versions&gt;
   */
  @GET("api/v3/versions")
  Observable<Versions> apiV3VersionsGet(
        @retrofit2.http.Query("filters") String filters                
  );

  /**
   * View version
   * 
   * @param id version id (required)
   * @return Call&lt;Version&gt;
   */
  @GET("api/v3/versions/{id}")
  Observable<Version> apiV3VersionsIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
