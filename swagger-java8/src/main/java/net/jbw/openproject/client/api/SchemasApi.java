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

public class SchemasApi {
	private ApiClient apiClient;

	public SchemasApi() {
		this(Configuration.getDefaultApiClient());
	}

	public SchemasApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * Build call for apiV3ExampleSchemaGet
	 * 
	 * @param progressListener        Progress listener
	 * @param progressRequestListener Progress request listener
	 * @return Call to execute
	 * @throws ApiException If fail to serialize the request body object
	 */
	public com.squareup.okhttp.Call apiV3ExampleSchemaGetCall(
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/api/v3/example/schema";

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
	private com.squareup.okhttp.Call apiV3ExampleSchemaGetValidateBeforeCall(
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

		com.squareup.okhttp.Call call = apiV3ExampleSchemaGetCall(progressListener, progressRequestListener);
		return call;

	}

	/**
	 * view the schema This is an example of how a schema might look like. Note that
	 * this endpoint does not exist in the actual implementation.
	 * 
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public void apiV3ExampleSchemaGet() throws ApiException {
		apiV3ExampleSchemaGetWithHttpInfo();
	}

	/**
	 * view the schema This is an example of how a schema might look like. Note that
	 * this endpoint does not exist in the actual implementation.
	 * 
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot
	 *                      deserialize the response body
	 */
	public ApiResponse<Void> apiV3ExampleSchemaGetWithHttpInfo() throws ApiException {
		com.squareup.okhttp.Call call = apiV3ExampleSchemaGetValidateBeforeCall(null, null);
		return apiClient.execute(call);
	}

	/**
	 * view the schema (asynchronously) This is an example of how a schema might
	 * look like. Note that this endpoint does not exist in the actual
	 * implementation.
	 * 
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the
	 *                      request body object
	 */
	public com.squareup.okhttp.Call apiV3ExampleSchemaGetAsync(final ApiCallback<Void> callback) throws ApiException {

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

		com.squareup.okhttp.Call call = apiV3ExampleSchemaGetValidateBeforeCall(progressListener,
				progressRequestListener);
		apiClient.executeAsync(call, callback);
		return call;
	}
}
