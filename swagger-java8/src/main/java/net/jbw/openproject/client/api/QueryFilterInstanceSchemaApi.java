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

public class QueryFilterInstanceSchemaApi {
	private ApiClient apiClient;

	public QueryFilterInstanceSchemaApi() {
		this(Configuration.getDefaultApiClient());
	}

	public QueryFilterInstanceSchemaApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Build call for apiV3ProjectsIdQueriesFilterInstanceSchemasGet
	 * 
	 * @param id                      Id of the project. (required)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3ProjectsIdQueriesFilterInstanceSchemasGetCall(Integer id,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/projects/{id}/queries/filter_instance_schemas".replaceAll("\\{" + "id" + "\\}",
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
	private com.squareup.okhttp.Call apiV3ProjectsIdQueriesFilterInstanceSchemasGetValidateBeforeCall(Integer id,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'id' is set
		if (id == null) {
			throw new ApiException(
					"Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesFilterInstanceSchemasGet(Async)");
		}

		com.squareup.okhttp.Call call = apiV3ProjectsIdQueriesFilterInstanceSchemasGetCall(id, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * List Query Filter Instance Schemas for Project Returns the list of
	 * QueryFilterInstanceSchemas defined for a query of the specified project.
	 * 
	 * @param id Id of the project. (required)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3ProjectsIdQueriesFilterInstanceSchemasGet(Integer id) throws ApiException {
		apiV3ProjectsIdQueriesFilterInstanceSchemasGetWithHttpInfo(id);
	}

	/**
	 * List Query Filter Instance Schemas for Project Returns the list of
	 * QueryFilterInstanceSchemas defined for a query of the specified project.
	 * 
	 * @param id Id of the project. (required)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3ProjectsIdQueriesFilterInstanceSchemasGetWithHttpInfo(Integer id)
			throws ApiException {
		com.squareup.okhttp.Call call = apiV3ProjectsIdQueriesFilterInstanceSchemasGetValidateBeforeCall(id, null,
				null);
		return apiClient.execute(call);
	}

	/**
	 * List Query Filter Instance Schemas for Project (asynchronously) Returns the
	 * list of QueryFilterInstanceSchemas defined for a query of the specified
	 * project.
	 * 
	 * @param id       Id of the project. (required)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3ProjectsIdQueriesFilterInstanceSchemasGetAsync(Integer id,
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

		com.squareup.okhttp.Call call = apiV3ProjectsIdQueriesFilterInstanceSchemasGetValidateBeforeCall(id,
				progressListener, progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}

	/**
	 * Build call for apiV3QueriesFilterInstanceSchemasGet
	 * 
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasGetCall(
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/queries/filter_instance_schemas";

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
	private com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasGetValidateBeforeCall(
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasGetCall(progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * List Query Filter Instance Schemas Returns the list of
	 * QueryFilterInstanceSchemas defined for a global query. That is a query not
	 * assigned to a project.
	 * 
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3QueriesFilterInstanceSchemasGet() throws ApiException {
		apiV3QueriesFilterInstanceSchemasGetWithHttpInfo();
	}

	/**
	 * List Query Filter Instance Schemas Returns the list of
	 * QueryFilterInstanceSchemas defined for a global query. That is a query not
	 * assigned to a project.
	 * 
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3QueriesFilterInstanceSchemasGetWithHttpInfo() throws ApiException {
		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasGetValidateBeforeCall(null, null);
		return apiClient.execute(call);
	}

	/**
	 * List Query Filter Instance Schemas (asynchronously) Returns the list of
	 * QueryFilterInstanceSchemas defined for a global query. That is a query not
	 * assigned to a project.
	 * 
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasGetAsync(final ApiCallback<Void> callback)
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

		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasGetValidateBeforeCall(progressListener,
				progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}

	/**
	 * Build call for apiV3QueriesFilterInstanceSchemasIdentifierGet
	 * 
	 * @param identifier              QueryFilterInstanceSchema identifier. The
	 *                                identifier is the filter identifier.
	 *                                (required)
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasIdentifierGetCall(String identifier,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/queries/filter_instance_schemas/{identifier}"
				.replaceAll("\\{" + "identifier" + "\\}", apiClient.escapeString(identifier.toString()));

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
	private com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasIdentifierGetValidateBeforeCall(String identifier,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		// verify the required parameter 'identifier' is set
		if (identifier == null) {
			throw new ApiException(
					"Missing the required parameter 'identifier' when calling apiV3QueriesFilterInstanceSchemasIdentifierGet(Async)");
		}

		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasIdentifierGetCall(identifier, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * View Query Filter Instance Schema Retreive an individual
	 * QueryFilterInstanceSchema as identified by the id parameter.
	 * 
	 * @param identifier QueryFilterInstanceSchema identifier. The identifier is the
	 *                   filter identifier. (required)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3QueriesFilterInstanceSchemasIdentifierGet(String identifier) throws ApiException {
		apiV3QueriesFilterInstanceSchemasIdentifierGetWithHttpInfo(identifier);
	}

	/**
	 * View Query Filter Instance Schema Retreive an individual
	 * QueryFilterInstanceSchema as identified by the id parameter.
	 * 
	 * @param identifier QueryFilterInstanceSchema identifier. The identifier is the
	 *                   filter identifier. (required)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3QueriesFilterInstanceSchemasIdentifierGetWithHttpInfo(String identifier)
			throws ApiException {
		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasIdentifierGetValidateBeforeCall(identifier,
				null, null);
		return apiClient.execute(call);
	}

	/**
	 * View Query Filter Instance Schema (asynchronously) Retreive an individual
	 * QueryFilterInstanceSchema as identified by the id parameter.
	 * 
	 * @param identifier QueryFilterInstanceSchema identifier. The identifier is the
	 *                   filter identifier. (required)
	 * @param callback   The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3QueriesFilterInstanceSchemasIdentifierGetAsync(String identifier,
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

		com.squareup.okhttp.Call call = apiV3QueriesFilterInstanceSchemasIdentifierGetValidateBeforeCall(identifier,
				progressListener, progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}
}
