package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.TimeEntriesActivity;

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


public class TimeEntryActivitiesApiImpl implements TimeEntryActivitiesApi {

    private ApiClient apiClient;

    public TimeEntryActivitiesApiImpl() {
        this(null);
    }

    public TimeEntryActivitiesApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * View time entries activity
     * 
     * @param id time entries activity id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3TimeEntriesActivitiesIdGet(Integer id, Handler<AsyncResult<TimeEntriesActivity>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3TimeEntriesActivitiesIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/time_entries/activities/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<TimeEntriesActivity> localVarReturnType = new TypeReference<TimeEntriesActivity>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
}
