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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.jbw.openproject.client.invoker.ApiCallback;
import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.ApiResponse;
import net.jbw.openproject.client.invoker.Configuration;
import net.jbw.openproject.client.invoker.Pair;
import net.jbw.openproject.client.invoker.ProgressRequestBody;
import net.jbw.openproject.client.invoker.ProgressResponseBody;

public class CustomActionsApi {
	private ApiClient apiClient;

	public CustomActionsApi() {
		this(Configuration.getDefaultApiClient());
	}

	public CustomActionsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Build call for apiV3CustomActionsCustomActionIdExecutePost
	 * 
	 * @param customActionId          The id of the custom action to execute
	 *                                (required)
	 * @param body                    (optional)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdExecutePostCall(Integer customActionId, Object body,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/api/v3/custom_actions/{custom_action_id}/execute"
				.replaceAll("\\{" + "custom_action_id" + "\\}", apiClient.escapeString(customActionId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/hal+json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = { "*/*" };
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
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	@SuppressWarnings("rawtypes")
	private com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdExecutePostValidateBeforeCall(
			Integer customActionId, Object body, final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'customActionId' is set
		if (customActionId == null) {
			throw new ApiException(
					"Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdExecutePost(Async)");
		}

		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdExecutePostCall(customActionId, body,
				progressListener, progressRequestListener);
		return call;

	}

	/**
	 * Execute custom action A POST to this end point executes the custom action on
	 * the work package provided in the payload. The altered work package will be
	 * returned. In order to avoid executing the custom action unbeknown to a change
	 * that has already taken place, the client has to provide the work
	 * package&#x27;s current lockVersion.
	 * 
	 * @param customActionId The id of the custom action to execute (required)
	 * @param body           (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3CustomActionsCustomActionIdExecutePost(Integer customActionId, Object body) throws ApiException {
		apiV3CustomActionsCustomActionIdExecutePostWithHttpInfo(customActionId, body);
	}

	/**
	 * Execute custom action A POST to this end point executes the custom action on
	 * the work package provided in the payload. The altered work package will be
	 * returned. In order to avoid executing the custom action unbeknown to a change
	 * that has already taken place, the client has to provide the work
	 * package&#x27;s current lockVersion.
	 * 
	 * @param customActionId The id of the custom action to execute (required)
	 * @param body           (optional)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3CustomActionsCustomActionIdExecutePostWithHttpInfo(Integer customActionId,
			Object body) throws ApiException {
		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdExecutePostValidateBeforeCall(customActionId,
				body, null, null);
		return apiClient.execute(call);
	}

	/**
	 * Execute custom action (asynchronously) A POST to this end point executes the
	 * custom action on the work package provided in the payload. The altered work
	 * package will be returned. In order to avoid executing the custom action
	 * unbeknown to a change that has already taken place, the client has to provide
	 * the work package&#x27;s current lockVersion.
	 * 
	 * @param customActionId The id of the custom action to execute (required)
	 * @param body           (optional)
	 * @param callback       The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdExecutePostAsync(Integer customActionId,
			Object body, final ApiCallback<Void> callback) throws ApiException {

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

		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdExecutePostValidateBeforeCall(customActionId,
				body, progressListener, progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}

	/**
	 * Build call for apiV3CustomActionsCustomActionIdGet
	 * 
	 * @param customActionId          The id of the custom action to fetch
	 *                                (required)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdGetCall(Integer customActionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/custom_actions/{custom_action_id}".replaceAll("\\{" + "custom_action_id" + "\\}",
				apiClient.escapeString(customActionId.toString()));

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
	private com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdGetValidateBeforeCall(Integer customActionId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'customActionId' is set
		if (customActionId == null) {
			throw new ApiException(
					"Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdGet(Async)");
		}

		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdGetCall(customActionId, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * View custom action
	 * 
	 * @param customActionId The id of the custom action to fetch (required)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3CustomActionsCustomActionIdGet(Integer customActionId) throws ApiException {
		apiV3CustomActionsCustomActionIdGetWithHttpInfo(customActionId);
	}

	/**
	 * View custom action
	 * 
	 * @param customActionId The id of the custom action to fetch (required)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3CustomActionsCustomActionIdGetWithHttpInfo(Integer customActionId)
			throws ApiException {
		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdGetValidateBeforeCall(customActionId, null,
				null);
		return apiClient.execute(call);
	}

	/**
	 * View custom action (asynchronously)
	 * 
	 * @param customActionId The id of the custom action to fetch (required)
	 * @param callback       The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3CustomActionsCustomActionIdGetAsync(Integer customActionId,
			final ApiCallback<Void> callback) throws ApiException {

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

		com.squareup.okhttp.Call call = apiV3CustomActionsCustomActionIdGetValidateBeforeCall(customActionId,
				progressListener, progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}
}
