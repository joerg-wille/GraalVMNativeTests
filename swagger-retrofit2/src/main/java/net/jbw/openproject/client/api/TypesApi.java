package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WPTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TypesApi {
  /**
   * List types available in a project
   * This endpoint lists the types that are *available* in a given project.
   * @param projectId ID of the project whoose types will be listed (required)
   * @return Call&lt;WPTypes&gt;
   */
  @GET("api/v3/projects/{project_id}/types")
  Call<WPTypes> apiV3ProjectsProjectIdTypesGet(
            @retrofit2.http.Path("project_id") Integer projectId            
  );

  /**
   * List all Types
   * 
   * @return Call&lt;WPTypes&gt;
   */
  @GET("api/v3/types")
  Call<WPTypes> apiV3TypesGet();
    

  /**
   * View Type
   * 
   * @param id type id (required)
   * @return Call&lt;WPType&gt;
   */
  @GET("api/v3/types/{id}")
  Call<WPType> apiV3TypesIdGet(
            @retrofit2.http.Path("id") Integer id            
  );

}
