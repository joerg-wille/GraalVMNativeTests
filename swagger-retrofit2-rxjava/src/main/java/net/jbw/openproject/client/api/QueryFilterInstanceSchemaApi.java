package net.jbw.openproject.client.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface QueryFilterInstanceSchemaApi {
  /**
   * List Query Filter Instance Schemas for Project
   * Returns the list of QueryFilterInstanceSchemas defined for a query of the specified project.
   * @param id Id of the project. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{id}/queries/filter_instance_schemas")
  Observable<Void> apiV3ProjectsIdQueriesFilterInstanceSchemasGet(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * List Query Filter Instance Schemas
   * Returns the list of QueryFilterInstanceSchemas defined for a global query. That is a query not assigned to a project.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/filter_instance_schemas")
  Observable<Void> apiV3QueriesFilterInstanceSchemasGet();
    

  /**
   * View Query Filter Instance Schema
   * Retreive an individual QueryFilterInstanceSchema as identified by the id parameter.
   * @param identifier QueryFilterInstanceSchema identifier. The identifier is the filter identifier. (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/filter_instance_schemas/{identifier}")
  Observable<Void> apiV3QueriesFilterInstanceSchemasIdentifierGet(
            @retrofit2.http.Path("identifier") String identifier            
  );

}
