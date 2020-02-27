package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.Versions;

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


public class VersionsApiImpl implements VersionsApi {

    private ApiClient apiClient;

    public VersionsApiImpl() {
        this(null);
    }

    public VersionsApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List versions available in a project
     * This endpoint lists the versions that are *available* in a given project. Note that due to sharing this might be more than the versions *defined* by that project.
     * @param projectId ID of the project whoose versions will be listed (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdVersionsGet(Integer projectId, Handler<AsyncResult<Versions>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'projectId' when calling apiV3ProjectsProjectIdVersionsGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{project_id}/versions".replaceAll("\\{" + "project_id" + "\\}", projectId.toString());

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
        TypeReference<Versions> localVarReturnType = new TypeReference<Versions>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * List versions
     * Returns a collection of versions. The client can choose to filter the versions similar to how work packages are filtered. In addition to the provided filters, the server will reduce the result set to only contain versions, for which the requesting client has sufficient permissions (*view_work_packages*).
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + sharing: filters versions by how they are shared within the server (*none*, *descendants*, *hierarchy*, *tree*, *system*). (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsGet(String filters, Handler<AsyncResult<Versions>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/versions";

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
        TypeReference<Versions> localVarReturnType = new TypeReference<Versions>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * View version
     * 
     * @param id version id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsIdGet(Integer id, Handler<AsyncResult<Version>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3VersionsIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/versions/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<Version> localVarReturnType = new TypeReference<Version>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
}
