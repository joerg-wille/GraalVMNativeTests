package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Projects;

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


public class ProjectsApiImpl implements ProjectsApi {

    private ApiClient apiClient;

    public ProjectsApiImpl() {
        this(null);
    }

    public ProjectsApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List projects
     * Returns a collection of projects. The collection can be filtered via query parameters similar to how work packages are filtered. In addition to the provided filter, the result set is always limited to only contain projects the client is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + ancestor: filters projects by their ancestor. A project is not considered to be it&#39;s own ancestor. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsGet(String filters, Handler<AsyncResult<Projects>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/projects";

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
        
        String[] localVarAccepts = { "*/*" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };
        TypeReference<Projects> localVarReturnType = new TypeReference<Projects>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * View project
     * 
     * @param id Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdGet(Integer id, Handler<AsyncResult<Project>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<Project> localVarReturnType = new TypeReference<Project>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * List projects with version
     * This endpoint lists the projects where the given version is available.  The projects returned depend on the sharing settings of the given version, but are also limited to the projects that the current user is allowed to see.
     * @param id Version id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3VersionsIdProjectsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3VersionsIdProjectsGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/versions/{id}/projects".replaceAll("\\{" + "id" + "\\}", id.toString());

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
