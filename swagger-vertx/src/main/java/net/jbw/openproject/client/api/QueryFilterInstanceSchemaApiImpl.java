package net.jbw.openproject.client.api;


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


public class QueryFilterInstanceSchemaApiImpl implements QueryFilterInstanceSchemaApi {

    private ApiClient apiClient;

    public QueryFilterInstanceSchemaApiImpl() {
        this(null);
    }

    public QueryFilterInstanceSchemaApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Query Filter Instance Schemas for Project
     * Returns the list of QueryFilterInstanceSchemas defined for a query of the specified project.
     * @param id Id of the project. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdQueriesFilterInstanceSchemasGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesFilterInstanceSchemasGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/queries/filter_instance_schemas".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * List Query Filter Instance Schemas
     * Returns the list of QueryFilterInstanceSchemas defined for a global query. That is a query not assigned to a project.
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFilterInstanceSchemasGet(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/filter_instance_schemas";

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
     * View Query Filter Instance Schema
     * Retreive an individual QueryFilterInstanceSchema as identified by the id parameter.
     * @param identifier QueryFilterInstanceSchema identifier. The identifier is the filter identifier. (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3QueriesFilterInstanceSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'identifier' when calling apiV3QueriesFilterInstanceSchemasIdentifierGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/queries/filter_instance_schemas/{identifier}".replaceAll("\\{" + "identifier" + "\\}", identifier.toString());

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
