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

public interface QueryFilterInstanceSchemaApi {
  /**
   * List Query Filter Instance Schemas for Project
   * Returns the list of QueryFilterInstanceSchemas defined for a query of the specified project.
   * @param id Id of the project. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{id}/queries/filter_instance_schemas")
  Call<Void> apiV3ProjectsIdQueriesFilterInstanceSchemasGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List Query Filter Instance Schemas
   * Returns the list of QueryFilterInstanceSchemas defined for a global query. That is a query not assigned to a project.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/filter_instance_schemas")
  Call<Void> apiV3QueriesFilterInstanceSchemasGet();
    

  /**
   * View Query Filter Instance Schema
   * Retreive an individual QueryFilterInstanceSchema as identified by the id parameter.
   * @param identifier QueryFilterInstanceSchema identifier. The identifier is the filter identifier. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/filter_instance_schemas/{identifier}")
  Call<Void> apiV3QueriesFilterInstanceSchemasIdentifierGet(
            @retrofit2.http.Path("identifier") String identifier            
  );

}
