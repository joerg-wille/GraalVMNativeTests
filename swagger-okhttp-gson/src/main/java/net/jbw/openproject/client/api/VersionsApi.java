/*
 * OpenProject API v3
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.jbw.openproject.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import net.jbw.openproject.client.invoker.ApiCallback;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.ApiResponse;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.invoker.Pair;
import net.jbw.openproject.client.invoker.ProgressRequestBody;
import net.jbw.openproject.client.invoker.ProgressResponseBody;
import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.Versions;

public class VersionsApi {
	private ApiClient apiClient;

	public VersionsApi() {
		this(Configuration.getDefaultApiClient());
	}

	public VersionsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Build call for apiV3ProjectsProjectIdVersionsGet
	 * 
	 * @param projectId               ID of the project whoose versions will be
	 *                                listed (required)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3ProjectsProjectIdVersionsGetCall(Integer projectId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/projects/{project_id}/versions".replaceAll("\\{" + "project_id" + "\\}",
				apiClient.escapeString(projectId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/hal+json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] { "basicAuth" };
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	@SuppressWarnings("rawtypes")
	private com.squareup.okhttp.Call apiV3ProjectsProjectIdVersionsGetValidateBeforeCall(Integer projectId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(
					"Missing the required parameter 'projectId' when calling apiV3ProjectsProjectIdVersionsGet(Async)");
		}

		com.squareup.okhttp.Call call = apiV3ProjectsProjectIdVersionsGetCall(projectId, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * List versions available in a project This endpoint lists the versions that
	 * are *available* in a given project. Note that due to sharing this might be
	 * more than the versions *defined* by that project.
	 * 
	 * @param projectId ID of the project whoose versions will be listed (required)
	 * @return Versions
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public Versions apiV3ProjectsProjectIdVersionsGet(Integer projectId) throws ApiException {
		ApiResponse<Versions> resp = apiV3ProjectsProjectIdVersionsGetWithHttpInfo(projectId);
		return resp.getData();
	}

	/**
	 * List versions available in a project This endpoint lists the versions that
	 * are *available* in a given project. Note that due to sharing this might be
	 * more than the versions *defined* by that project.
	 * 
	 * @param projectId ID of the project whoose versions will be listed (required)
	 * @return ApiResponse&lt;Versions&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Versions> apiV3ProjectsProjectIdVersionsGetWithHttpInfo(Integer projectId) throws ApiException {
		com.squareup.okhttp.Call call = apiV3ProjectsProjectIdVersionsGetValidateBeforeCall(projectId, null, null);
		Type localVarReturnType = new TypeToken<Versions>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * List versions available in a project (asynchronously) This endpoint lists the
	 * versions that are *available* in a given project. Note that due to sharing
	 * this might be more than the versions *defined* by that project.
	 * 
	 * @param projectId ID of the project whoose versions will be listed (required)
	 * @param callback  The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3ProjectsProjectIdVersionsGetAsync(Integer projectId,
			final ApiCallback<Versions> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = apiV3ProjectsProjectIdVersionsGetValidateBeforeCall(projectId, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<Versions>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}

	/**
	 * Build call for apiV3VersionsGet
	 * 
	 * @param filters                 JSON specifying filter conditions. Accepts the
	 *                                same format as returned by the
	 *                                [queries](#queries) endpoint. Currently
	 *                                supported filters are: + sharing: filters
	 *                                versions by how they are shared within the
	 *                                server (*none*, *descendants*, *hierarchy*,
	 *                                *tree*, *system*). (optional)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3VersionsGetCall(String filters,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/versions";

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		if (filters != null)
			localVarQueryParams.addAll(apiClient.parameterToPair("filters", filters));

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/hal+json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] { "basicAuth" };
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	@SuppressWarnings("rawtypes")
	private com.squareup.okhttp.Call apiV3VersionsGetValidateBeforeCall(String filters,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

		com.squareup.okhttp.Call call = apiV3VersionsGetCall(filters, progressListener, progressRequestListener);
		return call;

	}

	/**
	 * List versions Returns a collection of versions. The client can choose to
	 * filter the versions similar to how work packages are filtered. In addition to
	 * the provided filters, the server will reduce the result set to only contain
	 * versions, for which the requesting client has sufficient permissions
	 * (*view_work_packages*).
	 * 
	 * @param filters JSON specifying filter conditions. Accepts the same format as
	 *                returned by the [queries](#queries) endpoint. Currently
	 *                supported filters are: + sharing: filters versions by how they
	 *                are shared within the server (*none*, *descendants*,
	 *                *hierarchy*, *tree*, *system*). (optional)
	 * @return Versions
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public Versions apiV3VersionsGet(String filters) throws ApiException {
		ApiResponse<Versions> resp = apiV3VersionsGetWithHttpInfo(filters);
		return resp.getData();
	}

	/**
	 * List versions Returns a collection of versions. The client can choose to
	 * filter the versions similar to how work packages are filtered. In addition to
	 * the provided filters, the server will reduce the result set to only contain
	 * versions, for which the requesting client has sufficient permissions
	 * (*view_work_packages*).
	 * 
	 * @param filters JSON specifying filter conditions. Accepts the same format as
	 *                returned by the [queries](#queries) endpoint. Currently
	 *                supported filters are: + sharing: filters versions by how they
	 *                are shared within the server (*none*, *descendants*,
	 *                *hierarchy*, *tree*, *system*). (optional)
	 * @return ApiResponse&lt;Versions&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Versions> apiV3VersionsGetWithHttpInfo(String filters) throws ApiException {
		com.squareup.okhttp.Call call = apiV3VersionsGetValidateBeforeCall(filters, null, null);
		Type localVarReturnType = new TypeToken<Versions>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * List versions (asynchronously) Returns a collection of versions. The client
	 * can choose to filter the versions similar to how work packages are filtered.
	 * In addition to the provided filters, the server will reduce the result set to
	 * only contain versions, for which the requesting client has sufficient
	 * permissions (*view_work_packages*).
	 * 
	 * @param filters  JSON specifying filter conditions. Accepts the same format as
	 *                 returned by the [queries](#queries) endpoint. Currently
	 *                 supported filters are: + sharing: filters versions by how
	 *                 they are shared within the server (*none*, *descendants*,
	 *                 *hierarchy*, *tree*, *system*). (optional)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3VersionsGetAsync(String filters, final ApiCallback<Versions> callback)
			throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = apiV3VersionsGetValidateBeforeCall(filters, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<Versions>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}

	/**
	 * Build call for apiV3VersionsIdGet
	 * 
	 * @param id                      version id (required)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3VersionsIdGetCall(Integer id,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/versions/{id}".replaceAll("\\{" + "id" + "\\}",
				apiClient.escapeString(id.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/hal+json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] { "basicAuth" };
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	@SuppressWarnings("rawtypes")
	private com.squareup.okhttp.Call apiV3VersionsIdGetValidateBeforeCall(Integer id,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'id' is set
		if (id == null) {
			throw new ApiException("Missing the required parameter 'id' when calling apiV3VersionsIdGet(Async)");
		}

		com.squareup.okhttp.Call call = apiV3VersionsIdGetCall(id, progressListener, progressRequestListener);
		return call;

	}

	/**
	 * View version
	 * 
	 * @param id version id (required)
	 * @return Version
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public Version apiV3VersionsIdGet(Integer id) throws ApiException {
		ApiResponse<Version> resp = apiV3VersionsIdGetWithHttpInfo(id);
		return resp.getData();
	}

	/**
	 * View version
	 * 
	 * @param id version id (required)
	 * @return ApiResponse&lt;Version&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Version> apiV3VersionsIdGetWithHttpInfo(Integer id) throws ApiException {
		com.squareup.okhttp.Call call = apiV3VersionsIdGetValidateBeforeCall(id, null, null);
		Type localVarReturnType = new TypeToken<Version>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * View version (asynchronously)
	 * 
	 * @param id       version id (required)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3VersionsIdGetAsync(Integer id, final ApiCallback<Version> callback)
			throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = apiV3VersionsIdGetValidateBeforeCall(id, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<Version>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}
}
