package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.TimeEntries;
import net.jbw.openproject.client.model.TimeEntry;
import net.jbw.openproject.client.model.TimeEntryPost;

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


public class TimeEntriesApiImpl implements TimeEntriesApi {

    private ApiClient apiClient;

    public TimeEntriesApiImpl() {
        this(null);
    }

    public TimeEntriesApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Time entries
     * Lists time entries. The time entries returned depend on the filters provided and also on the permission of the requesting user.
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + work_package: Filter time entries by work package  + project: Filter time entries by project  + user: Filter time entries by users (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesGet(Integer offset, Integer pageSize, String filters, Handler<AsyncResult<TimeEntries>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/time_entries";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
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
        TypeReference<TimeEntries> localVarReturnType = new TypeReference<TimeEntries>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * View time entry
     * 
     * @param id time entry id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesIdGet(Integer id, Handler<AsyncResult<TimeEntry>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3TimeEntriesIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/time_entries/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<TimeEntry> localVarReturnType = new TypeReference<TimeEntry>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Create time entry
     * Creates a new time entry applying the attributes provided in the body. Please note that while there is a fixed set of attributes, custom fields can extend a time entries’ attributes and are accepted by the endpoint.
     * @param body Time Entry to add (a project, activity and workPackage link is requried) (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesPost(TimeEntryPost body, Integer offset, Integer pageSize, String filters, String sortBy, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'body' when calling apiV3TimeEntriesPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/time_entries";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));

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
}
