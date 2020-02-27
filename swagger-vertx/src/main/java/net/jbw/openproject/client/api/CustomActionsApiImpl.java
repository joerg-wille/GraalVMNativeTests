package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject1;

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


public class CustomActionsApiImpl implements CustomActionsApi {

    private ApiClient apiClient;

    public CustomActionsApiImpl() {
        this(null);
    }

    public CustomActionsApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Execute custom action
     * A POST to this end point executes the custom action on the work package provided in the payload. The altered work package will be returned. In order to avoid executing  the custom action unbeknown to a change that has already taken place, the client has to provide the work package&#39;s current lockVersion.
     * @param customActionId The id of the custom action to execute (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CustomActionsCustomActionIdExecutePost(Integer customActionId, InlineObject1 body, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'customActionId' is set
        if (customActionId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdExecutePost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/custom_actions/{custom_action_id}/execute".replaceAll("\\{" + "custom_action_id" + "\\}", customActionId.toString());

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
     * View custom action
     * 
     * @param customActionId The id of the custom action to fetch (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3CustomActionsCustomActionIdGet(Integer customActionId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'customActionId' is set
        if (customActionId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/custom_actions/{custom_action_id}".replaceAll("\\{" + "custom_action_id" + "\\}", customActionId.toString());

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
