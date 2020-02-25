package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WPTypes;
import retrofit2.http.GET;

public interface TypesApi {
  /**
   * List types available in a project
   * This endpoint lists the types that are *available* in a given project.
   * @param projectId ID of the project whoose types will be listed (required)
   * @return Call&lt;WPTypes&gt;
   */
  @GET("api/v3/projects/{project_id}/types")
  Observable<WPTypes> apiV3ProjectsProjectIdTypesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

  /**
   * List all Types
   * 
   * @return Call&lt;WPTypes&gt;
   */
  @GET("api/v3/types")
  Observable<WPTypes> apiV3TypesGet();
    

  /**
   * View Type
   * 
   * @param id type id (required)
   * @return Call&lt;WPType&gt;
   */
  @GET("api/v3/types/{id}")
  Observable<WPType> apiV3TypesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
