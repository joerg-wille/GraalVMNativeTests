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


public class RelationsApiImpl implements RelationsApi {

    private ApiClient apiClient;

    public RelationsApiImpl() {
        this(null);
    }

    public RelationsApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Relations
     * Lists all relations according to the given (optional, logically conjunctive) filters and ordered by ID. The response only includes relations between work packages which the user is allowed to see.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Valid fields to filter by are:  + id - ID of relation  + from - ID of work package from which the filtered relations emanates.  + to - ID of work package to which this related points.  + involved - ID of either the &#x60;from&#x60; or the &#x60;to&#x60; work package.  + type - The type of relation to filter by, e.g. \&quot;follows\&quot;. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsGet(String filters, String sortBy, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/relations";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
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

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Delete Relation
     * Deletes the relation.
     * @param id Relation ID (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3RelationsIdDelete"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Relation edit form
     * 
     * @param id ID of the relation being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3RelationsIdFormPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/{id}/form".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * View Relation
     * 
     * @param id Relation id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3RelationsIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Edit Relation
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. It is only allowed to provide properties or links supporting the **write** operation.  Note that changing the &#x60;type&#x60; of a relation invariably also changes the respective &#x60;reverseType&#x60; as well as the \&quot;name\&quot; of it. The returned Relation object will reflect that change. For instance if you change a Relation&#39;s &#x60;type&#x60; to \&quot;follows\&quot; then the &#x60;reverseType&#x60; will be changed to &#x60;precedes&#x60;.
     * @param id Relation ID (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsIdPatch(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3RelationsIdPatch"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * View relation schema
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsSchemaGet(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/schema";

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
     * View relation schema for type
     * 
     * @param type Type of the schema (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3RelationsSchemaTypeGet(String type, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'type' is set
        if (type == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'type' when calling apiV3RelationsSchemaTypeGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/relations/schema/{type}".replaceAll("\\{" + "type" + "\\}", type.toString());

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
