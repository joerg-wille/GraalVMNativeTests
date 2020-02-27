package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject3;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.*;

import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.invoker.Pair;


public class QueriesApiImpl implements QueriesApi {

    private ApiClient apiClient;

    public QueriesApiImpl() {
        this(null);
    }

    public QueriesApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * View default query for project
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query. The query will already be scoped for the project.
     * @param id Id of the project the default query is requested for (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesDefaultGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesDefaultGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/queries/default".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "groupBy", groupBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showSums", showSums));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "timelineVisible", timelineVisible));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showHierarchies", showHierarchies));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * View schema for project queries
     * Retrieve the schema for project queries.
     * @param id ID of project to return (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesSchemaGet(Long id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesSchemaGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/queries/schema".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Available projects
     * Gets a list of projects that are available as projects a query can be assigned to.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesAvailableProjectsGet(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/available_projects";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * View default query
     * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query.
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineZoomLevel Indicates in what zoom level the timeline should be shown. Valid values are  &#x60;days&#x60;, &#x60;weeks&#x60;, &#x60;months&#x60;, &#x60;quarters&#x60;, and &#x60;years&#x60;. (optional, default to &quot;days&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesDefaultGet(String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineZoomLevel, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/default";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "groupBy", groupBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showSums", showSums));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "timelineVisible", timelineVisible));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "timelineZoomLevel", timelineZoomLevel));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showHierarchies", showHierarchies));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Query Create Form
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFormPost(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/form";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * List queries
     * Returns a collection of queries. The collection can be filtered via query parameters similar to how work packages are filtered. Please note however, that the filters are applied to the queries and not to the work packages the queries in turn might return.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + project: filters queries by the project they are assigned to. If the project filter is passed with the &#x60;!*&#x60; (not any) operator, global queries are returned. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesGet(String filters, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Delete query
     * Delete the query identified by the id parameter
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3QueriesIdDelete"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "DELETE", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * View query
     * Retreive an individual query as identified by the id parameter. Then end point accepts a number of parameters that can be used to override the resources&#39; persisted parameters.
     * @param id Query id (required)
     * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
     * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
     * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
     * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
     * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
     * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
     * @param timelineLabels Overridden labels in the timeline view (optional, default to &quot;{}&quot;)
     * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdGet(Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineLabels, Boolean showHierarchies, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3QueriesIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "groupBy", groupBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showSums", showSums));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "timelineVisible", timelineVisible));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "timelineLabels", timelineLabels));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showHierarchies", showHierarchies));

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Edit Query
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.
     * @param id Query id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdPatch(Integer id, InlineObject3 body, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3QueriesIdPatch"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Star query
     * 
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdStarPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3QueriesIdStarPatch"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/{id}/star".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Unstar query
     * 
     * @param id Query id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesIdUnstarPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3QueriesIdUnstarPatch"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/{id}/unstar".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Create query
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Query can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesPost(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * View schema for global queries
     * Retrieve the schema for global queries, those, that are not assigned to a project.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesSchemaGet(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/schema";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "application/hal+json" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
}
