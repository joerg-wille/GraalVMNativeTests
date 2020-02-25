package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CategoriesApi {
  /**
   * View Category
   * 
   * @param id category id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/categories/{id}")
  Observable<Void> apiV3CategoriesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List categories of a project
   * 
   * @param projectId ID of the project whoose categories will be listed (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{project_id}/categories")
  Observable<Void> apiV3ProjectsProjectIdCategoriesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

}
