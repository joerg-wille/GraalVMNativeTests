package net.jbw.openproject.client.api;

import net.jbw.openproject.client.model.InlineObject7;
import net.jbw.openproject.client.model.InlineObject8;
import net.jbw.openproject.client.model.WorkPackage;
import net.jbw.openproject.client.model.WorkPackages;

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


public class WorkPackagesApiImpl implements WorkPackagesApi {

    private ApiClient apiClient;

    public WorkPackagesApiImpl() {
        this(null);
    }

    public WorkPackagesApiImpl(ApiClient apiClient) {
        this.apiClient = apiClient != null ? apiClient : Configuration.getDefaultApiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Work Package Create Form
     * 
     * @param id ID of the project in which the work package will be created (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdWorkPackagesFormPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/work_packages/form".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * List Work Packages
     * 
     * @param id Project id (required)
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesGet(Integer id, Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdWorkPackagesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/work_packages".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "groupBy", groupBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showSums", showSums));

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
        TypeReference<WorkPackages> localVarReturnType = new TypeReference<WorkPackages>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param id Project id (required)
     * @param workPackage Work package to add to the project (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsIdWorkPackagesPost(Integer id, WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> resultHandler) {
        Object localVarBody = workPackage;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdWorkPackagesPost"));
            return;
        }
        
        // verify the required parameter 'workPackage' is set
        if (workPackage == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackage' when calling apiV3ProjectsIdWorkPackagesPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{id}/work_packages".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "notify", notify));

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
        TypeReference<WorkPackage> localVarReturnType = new TypeReference<WorkPackage>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Available assignees
     * Gets a list of users that can be assigned to work packages in the given project.
     * @param projectId Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet(Integer projectId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'projectId' when calling apiV3ProjectsProjectIdWorkPackagesAvailableAssigneesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{project_id}/work_packages/available_assignees".replaceAll("\\{" + "project_id" + "\\}", projectId.toString());

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
     * Available responsibles
     * Gets a list of users that can be assigned as the responsible of a work package in the given project.
     * @param projectId Project id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet(Integer projectId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'projectId' when calling apiV3ProjectsProjectIdWorkPackagesAvailableResponsiblesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/projects/{project_id}/work_packages/available_responsibles".replaceAll("\\{" + "project_id" + "\\}", projectId.toString());

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
     * Work Package Create Form
     * 
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesFormPost(Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/form";

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
     * List Work Packages
     * 
     * @param offset Page number inside the requested collection. (optional, default to 1)
     * @param pageSize Number of elements to display per page. (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param groupBy The column to group by. (optional)
     * @param showSums Indicates whether properties should be summed up if they support it. (optional, default to false)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesGet(Integer offset, Integer pageSize, String filters, String sortBy, String groupBy, Boolean showSums, Handler<AsyncResult<WorkPackages>> resultHandler) {
        Object localVarBody = null;
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "offset", offset));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "groupBy", groupBy));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "showSums", showSums));

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
        TypeReference<WorkPackages> localVarReturnType = new TypeReference<WorkPackages>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * List work package activities
     * 
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdActivitiesGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdActivitiesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/activities".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Comment work package
     * Creates an activity for the selected work package and, on success, returns the updated activity.
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdActivitiesPost(Integer id, Boolean notify, InlineObject8 body, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdActivitiesPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/activities".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "notify", notify));

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
     * Available projects
     * Gets a list of projects that are available as projects to which the work package can be moved.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableProjectsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdAvailableProjectsGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/available_projects".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Available relation candidates
     * 
     * @param id ID of workpackage to return (required)
     * @param pageSize Maximum number of candidates to list (default 10) (optional)
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
     * @param query Shortcut for filtering by ID or subject (optional)
     * @param type Type of relation to find candidates for (default \&quot;relates\&quot;) (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableRelationCandidatesGet(Long id, Integer pageSize, String filters, String query, String type, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdAvailableRelationCandidatesGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/available_relation_candidates".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "pageSize", pageSize));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filters", filters));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "type", type));

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
     * Available watchers
     * Gets a list of users that are able to be watchers of the specified work package.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdAvailableWatchersGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdAvailableWatchersGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/available_watchers".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Delete Work Package
     * Deletes the work package, as well as:  * all associated time entries  * its hierarchy of child work packages
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdDelete(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdDelete"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Work Package Edit Form
     * 
     * @param id ID of the work package being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdFormPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/form".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * View Work Package
     * 
     * @param id Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdGet(Integer id, Handler<AsyncResult<WorkPackage>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

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
        TypeReference<WorkPackage> localVarReturnType = new TypeReference<WorkPackage>() {};
        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Edit Work Package
     * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.  Additionally to the fields the client wants to change, it is mandatory to provide the value of &#x60;lockVersion&#x60; which was received by the &#x60;GET&#x60; request this change originates from.  The value of &#x60;lockVersion&#x60; is used to implement [optimistic locking](http://en.wikipedia.org/wiki/Optimistic_concurrency_control).
     * @param id Work package id (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdPatch(Integer id, Boolean notify, WorkPackage body, Handler<AsyncResult<WorkPackage>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdPatch"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}".replaceAll("\\{" + "id" + "\\}", id.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "notify", notify));

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
        TypeReference<WorkPackage> localVarReturnType = new TypeReference<WorkPackage>() {};
        apiClient.invokeAPI(localVarPath, "PATCH", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * Relation create form
     * 
     * @param id ID of the relation being modified (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdRelationsFormPost(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdRelationsFormPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/relations/form".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Revisions
     * Gets a list of revisions that are linked to this work package, e.g., because it is referenced in the commit message of the revision. Only linked revisions from repositories are shown if the user has the view changesets permission in the defining project.
     * @param id work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesIdRevisionsGet(Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesIdRevisionsGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{id}/revisions".replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Create Work Package
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a WorkPackage can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.  A project link must be set when creating work packages through this route.
     * @param workPackage Work package to add (a project link is requried) (required)
     * @param notify Indicates whether change notifications (e.g. via E-Mail) should be sent. Note that this controls notifications for all users interested in changes to the work package (e.g. watchers, author and assignee), not just the current user. (optional, default to true)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesPost(WorkPackage workPackage, Boolean notify, Handler<AsyncResult<WorkPackage>> resultHandler) {
        Object localVarBody = workPackage;
        
        // verify the required parameter 'workPackage' is set
        if (workPackage == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackage' when calling apiV3WorkPackagesPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages";

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "notify", notify));

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
        TypeReference<WorkPackage> localVarReturnType = new TypeReference<WorkPackage>() {};
        apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, localVarReturnType, resultHandler);
    }
    /**
     * List Work Package Schemas
     * List work package schemas.
     * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + id: The schema&#39;s id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesSchemasGet(String filters, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'filters' is set
        if (filters == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'filters' when calling apiV3WorkPackagesSchemasGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/schemas/";

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
     * View Work Package Schema
     * 
     * @param identifier Identifier of the schema (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesSchemasIdentifierGet(String identifier, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'identifier' when calling apiV3WorkPackagesSchemasIdentifierGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/schemas/{identifier}".replaceAll("\\{" + "identifier" + "\\}", identifier.toString());

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
     * List relations
     * Lists all relations this work package is involved in.
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdRelationsGet(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'workPackageId' is set
        if (workPackageId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackageId' when calling apiV3WorkPackagesWorkPackageIdRelationsGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{work_package_id}/relations".replaceAll("\\{" + "work_package_id" + "\\}", workPackageId.toString());

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();

        // header params
        MultiMap localVarHeaderParams = MultiMap.caseInsensitiveMultiMap();
        
        // cookie params
        MultiMap localVarCookieParams = MultiMap.caseInsensitiveMultiMap();
        
        // form params
        // TODO: sending files within multipart/form-data is not supported yet (because of vertx web-client)
        Map<String, Object> localVarFormParams = new HashMap<>();
        
        String[] localVarAccepts = { "text/plain" };
        String[] localVarContentTypes = {  };
        String[] localVarAuthNames = new String[] { "basicAuth" };

        apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccepts, localVarContentTypes, localVarAuthNames, null, resultHandler);
    }
    /**
     * Create Relation
     * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Relation can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdRelationsPost(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'workPackageId' is set
        if (workPackageId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackageId' when calling apiV3WorkPackagesWorkPackageIdRelationsPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{work_package_id}/relations".replaceAll("\\{" + "work_package_id" + "\\}", workPackageId.toString());

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
     * List watchers
     * 
     * @param workPackageId Work package id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersGet(Integer workPackageId, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'workPackageId' is set
        if (workPackageId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackageId' when calling apiV3WorkPackagesWorkPackageIdWatchersGet"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{work_package_id}/watchers".replaceAll("\\{" + "work_package_id" + "\\}", workPackageId.toString());

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
     * Remove watcher
     * Removes the specified user from the list of watchers for the given work package.  If the request succeeds, the specified user is not watching the work package anymore.  *Note: This might also be the case, if the specified user did not watch the work package prior to the request.*
     * @param workPackageId Work package id (required)
     * @param id User id (required)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersIdDelete(Integer workPackageId, Integer id, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = null;
        
        // verify the required parameter 'workPackageId' is set
        if (workPackageId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackageId' when calling apiV3WorkPackagesWorkPackageIdWatchersIdDelete"));
            return;
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'id' when calling apiV3WorkPackagesWorkPackageIdWatchersIdDelete"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{work_package_id}/watchers/{id}".replaceAll("\\{" + "work_package_id" + "\\}", workPackageId.toString()).replaceAll("\\{" + "id" + "\\}", id.toString());

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
     * Add watcher
     * Adds a watcher to the specified work package.  The request is expected to contain a single JSON object, that contains a link object under the &#x60;user&#x60; key.  The response will be user added as watcher. In case the user was already watching the work package an &#x60;HTTP 200&#x60; is returned, an &#x60;HTTP 201&#x60; if the user was added as a new watcher.
     * @param workPackageId Work package id (required)
     * @param body  (optional)
     * @param resultHandler Asynchronous result handler
     */
    public void apiV3WorkPackagesWorkPackageIdWatchersPost(Integer workPackageId, InlineObject7 body, Handler<AsyncResult<Void>> resultHandler) {
        Object localVarBody = body;
        
        // verify the required parameter 'workPackageId' is set
        if (workPackageId == null) {
            resultHandler.handle(ApiException.fail(400, "Missing the required parameter 'workPackageId' when calling apiV3WorkPackagesWorkPackageIdWatchersPost"));
            return;
        }
        
        // create path and map variables
        String localVarPath = "/api/v3/work_packages/{work_package_id}/watchers".replaceAll("\\{" + "work_package_id" + "\\}", workPackageId.toString());

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
}
