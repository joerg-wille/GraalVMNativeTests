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

public interface CategoriesApi {
  /**
   * View Category
   * 
   * @param id category id (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/categories/{id}")
  Call<Void> apiV3CategoriesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List categories of a project
   * 
   * @param projectId ID of the project whoose categories will be listed (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{project_id}/categories")
  Call<Void> apiV3ProjectsProjectIdCategoriesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

}
