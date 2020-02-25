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

public interface QueriesApi {
  /**
   * View default query for project
   * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query. The query will already be scoped for the project.
   * @param id Id of the project the default query is requested for (required)
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#x27;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#x27; result collection of work packages. (optional)
   * @param pageSize Number of elements to display per page for the queries&#x27; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sums property. (optional)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{id}/queries/default")
  Call<Void> apiV3ProjectsIdQueriesDefaultGet(
            @retrofit2.http.Path("id") Integer id            ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("sortBy") String sortBy                ,     @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") Boolean showSums                ,     @retrofit2.http.Query("timelineVisible") Boolean timelineVisible                ,     @retrofit2.http.Query("showHierarchies") Boolean showHierarchies                
  );

  /**
   * View schema for project queries
   * Retrieve the schema for project queries.
   * @param id ID of project to return (required)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/projects/{id}/queries/schema")
  Call<Void> apiV3ProjectsIdQueriesSchemaGet(
            @retrofit2.http.Path("id") Long id            
  );

  /**
   * Available projects
   * Gets a list of projects that are available as projects a query can be assigned to.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/available_projects")
  Call<Void> apiV3QueriesAvailableProjectsGet();
    

  /**
   * View default query
   * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query.
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#x27;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#x27; result collection of work packages. (optional)
   * @param pageSize Number of elements to display per page for the queries&#x27; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sums property. (optional)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional)
   * @param timelineZoomLevel Indicates in what zoom level the timeline should be shown. Valid values are  &#x60;days&#x60;, &#x60;weeks&#x60;, &#x60;months&#x60;, &#x60;quarters&#x60;, and &#x60;years&#x60;. (optional)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/default")
  Call<Void> apiV3QueriesDefaultGet(
        @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("sortBy") String sortBy                ,     @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") Boolean showSums                ,     @retrofit2.http.Query("timelineVisible") Boolean timelineVisible                ,     @retrofit2.http.Query("timelineZoomLevel") String timelineZoomLevel                ,     @retrofit2.http.Query("showHierarchies") Boolean showHierarchies                
  );

  /**
   * Query Create Form
   * 
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/queries/form")
  Call<Void> apiV3QueriesFormPost();
    

  /**
   * List queries
   * Returns a collection of queries. The collection can be filtered via query parameters similar to how work packages are filtered. Please note however, that the filters are applied to the queries and not to the work packages the queries in turn might return.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + project: filters queries by the project they are assigned to. If the project filter is passed with the &#x60;!*&#x60; (not any) operator, global queries are returned. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries")
  Call<Void> apiV3QueriesGet(
        @retrofit2.http.Query("filters") String filters                
  );

  /**
   * Delete query
   * Delete the query identified by the id parameter
   * @param id Query id (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/v3/queries/{id}")
  Call<Void> apiV3QueriesIdDelete(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * View query
   * Retreive an individual query as identified by the id parameter. Then end point accepts a number of parameters that can be used to override the resources&#x27; persisted parameters.
   * @param id Query id (required)
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#x27;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#x27; result collection of work packages. (optional)
   * @param pageSize Number of elements to display per page for the queries&#x27; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#x27;s result collection of work packages overriding the query&#x27;s persisted sums property. (optional)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional)
   * @param timelineLabels Overridden labels in the timeline view (optional)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional)
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/{id}")
  Call<Void> apiV3QueriesIdGet(
            @retrofit2.http.Path("id") Integer id            ,     @retrofit2.http.Query("filters") String filters                ,     @retrofit2.http.Query("offset") Integer offset                ,     @retrofit2.http.Query("pageSize") Integer pageSize                ,     @retrofit2.http.Query("sortBy") String sortBy                ,     @retrofit2.http.Query("groupBy") String groupBy                ,     @retrofit2.http.Query("showSums") Boolean showSums                ,     @retrofit2.http.Query("timelineVisible") Boolean timelineVisible                ,     @retrofit2.http.Query("timelineLabels") String timelineLabels                ,     @retrofit2.http.Query("showHierarchies") Boolean showHierarchies                
  );

  /**
   * Edit Query
   * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.
   * @param id Query id (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:*/*"
  })
  @PATCH("api/v3/queries/{id}")
  Call<Void> apiV3QueriesIdPatch(
            @retrofit2.http.Path("id") Integer id            ,                 @retrofit2.http.Body Object body    
  );

  /**
   * Star query
   * 
   * @param id Query id (required)
   * @return Call&lt;Void&gt;
   */
  @PATCH("api/v3/queries/{id}/star")
  Call<Void> apiV3QueriesIdStarPatch(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Unstar query
   * 
   * @param id Query id (required)
   * @return Call&lt;Void&gt;
   */
  @PATCH("api/v3/queries/{id}/unstar")
  Call<Void> apiV3QueriesIdUnstarPatch(
            @retrofit2.http.Path("id") Integer id            
  );

  /**
   * Create query
   * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Query can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
   * @return Call&lt;Void&gt;
   */
  @POST("api/v3/queries")
  Call<Void> apiV3QueriesPost();
    

  /**
   * View schema for global queries
   * Retrieve the schema for global queries, those, that are not assigned to a project.
   * @return Call&lt;Void&gt;
   */
  @GET("api/v3/queries/schema")
  Call<Void> apiV3QueriesSchemaGet();
    

}
