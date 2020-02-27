package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WPTypes;

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


public class TypesApiImpl implements TypesApi {

    private ApiClient apiClient;

    public TypesApiImpl() {
        this(null);
    }

    public TypesApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List types available in a project
     * This endpoint lists the types that are *available* in a given project.
     * @param projectId ID of the project whoose types will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdTypesGet(Integer projectId, Handler<AsyncResult<WPTypes>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'projectId' when calling apiV3ProjectsProjectIdTypesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{project_id}/types".replaceAll("\\{" + "project_id" + "\\}", projectId.toString());

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
        TypeReference<WPTypes> localVarReturnType = new TypeReference<WPTypes>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * List all Types
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TypesGet(Handler<AsyncResult<WPTypes>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/types";

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
        TypeReference<WPTypes> localVarReturnType = new TypeReference<WPTypes>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * View Type
     * 
     * @param id type id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TypesIdGet(Integer id, Handler<AsyncResult<WPType>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3TypesIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/types/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<WPType> localVarReturnType = new TypeReference<WPType>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
}
