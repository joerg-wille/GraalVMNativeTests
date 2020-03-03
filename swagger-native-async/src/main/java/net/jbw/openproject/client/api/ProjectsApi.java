/*
 * OpenProject API v3
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package net.jbw.openproject.client.api;

import net.jbw.openproject.client.invoker.ApiClient;
import net.jbw.openproject.client.invoker.ApiException;
import net.jbw.openproject.client.invoker.Pair;

import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Projects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Consumer;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;

import java.util.concurrent.CompletableFuture;

public class ProjectsApi {
	private final HttpClient memberVarHttpClient;
	private final ObjectMapper memberVarObjectMapper;
	private final String memberVarBaseUri;
	private final Consumer<HttpRequest.Builder> memberVarInterceptor;
	private final Duration memberVarReadTimeout;

	public ProjectsApi() {
		this(new ApiClient());
	}

	public ProjectsApi(ApiClient apiClient) {
		memberVarHttpClient = apiClient.getHttpClient();
		memberVarObjectMapper = apiClient.getObjectMapper();
		memberVarBaseUri = apiClient.getBaseUri();
		memberVarInterceptor = apiClient.getRequestInterceptor();
		memberVarReadTimeout = apiClient.getReadTimeout();
	}

	/**
	 * List projects Returns a collection of projects. The collection can be
	 * filtered via query parameters similar to how work packages are filtered. In
	 * addition to the provided filter, the result set is always limited to only
	 * contain projects the client is allowed to see.
	 * 
	 * @param filters JSON specifying filter conditions. Accepts the same format as
	 *                returned by the [queries](#queries) endpoint. Currently
	 *                supported filters are: + ancestor: filters projects by their
	 *                ancestor. A project is not considered to be it&#39;s own
	 *                ancestor. (optional)
	 * @return Projects
	 * @throws ApiException if fails to make API call
	 */
	public CompletableFuture<Projects> apiV3ProjectsGet(String filters) {

		HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

		String localVarPath = "/api/v3/projects";

		List<Pair> localVarQueryParams = new ArrayList<>();
		localVarQueryParams.addAll(ApiClient.parameterToPairs("filters", filters));

		if (!localVarQueryParams.isEmpty()) {
			StringJoiner queryJoiner = new StringJoiner("&");
			localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
			localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
		} else {
			localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
		}

		localVarRequestBuilder.header("Accept", "application/json");

		localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
		if (memberVarReadTimeout != null) {
			localVarRequestBuilder.timeout(memberVarReadTimeout);
		}
		if (memberVarInterceptor != null) {
			memberVarInterceptor.accept(localVarRequestBuilder);
		}
		return memberVarHttpClient.sendAsync(localVarRequestBuilder.build(), HttpResponse.BodyHandlers.ofString())
				.thenComposeAsync(localVarResponse -> {
					if (localVarResponse.statusCode() / 100 != 2) {
						return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
								"apiV3ProjectsGet call received non-success response", localVarResponse.headers(),
								localVarResponse.body()));
					} else {
						try {
							return CompletableFuture.completedFuture(memberVarObjectMapper
									.readValue(localVarResponse.body(), new TypeReference<Projects>() {
									}));
						} catch (IOException e) {
							return CompletableFuture.failedFuture(new ApiException(e));
						}
					}
				});
	}

	/**
	 * View project
	 * 
	 * @param id Project id (required)
	 * @return Project
	 * @throws ApiException if fails to make API call
	 */
	public CompletableFuture<Project> apiV3ProjectsIdGet(Integer id) throws ApiException {
		// verify the required parameter 'id' is set
		if (id == null) {
			return CompletableFuture.failedFuture(
					new ApiException(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdGet"));
		}

		HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

		String localVarPath = "/api/v3/projects/{id}".replace("{id}", ApiClient.urlEncode(id.toString()));

		localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

		localVarRequestBuilder.header("Accept", "application/json");

		localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
		if (memberVarReadTimeout != null) {
			localVarRequestBuilder.timeout(memberVarReadTimeout);
		}
		if (memberVarInterceptor != null) {
			memberVarInterceptor.accept(localVarRequestBuilder);
		}
		return memberVarHttpClient.sendAsync(localVarRequestBuilder.build(), HttpResponse.BodyHandlers.ofString())
				.thenComposeAsync(localVarResponse -> {
					if (localVarResponse.statusCode() / 100 != 2) {
						return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
								"apiV3ProjectsIdGet call received non-success response", localVarResponse.headers(),
								localVarResponse.body()));
					} else {
						try {
							return CompletableFuture.completedFuture(memberVarObjectMapper
									.readValue(localVarResponse.body(), new TypeReference<Project>() {
									}));
						} catch (IOException e) {
							return CompletableFuture.failedFuture(new ApiException(e));
						}
					}
				});
	}

	/**
	 * List projects with version This endpoint lists the projects where the given
	 * version is available. The projects returned depend on the sharing settings of
	 * the given version, but are also limited to the projects that the current user
	 * is allowed to see.
	 * 
	 * @param id Version id (required)
	 * @throws ApiException if fails to make API call
	 */
	public CompletableFuture<Void> apiV3VersionsIdProjectsGet(Integer id) throws ApiException {
		// verify the required parameter 'id' is set
		if (id == null) {
			return CompletableFuture.failedFuture(new ApiException(400,
					"Missing the required parameter 'id' when calling apiV3VersionsIdProjectsGet"));
		}

		HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

		String localVarPath = "/api/v3/versions/{id}/projects".replace("{id}", ApiClient.urlEncode(id.toString()));

		localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

		localVarRequestBuilder.header("Accept", "application/json");

		localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
		if (memberVarReadTimeout != null) {
			localVarRequestBuilder.timeout(memberVarReadTimeout);
		}
		if (memberVarInterceptor != null) {
			memberVarInterceptor.accept(localVarRequestBuilder);
		}
		return memberVarHttpClient.sendAsync(localVarRequestBuilder.build(), HttpResponse.BodyHandlers.ofString())
				.thenComposeAsync(localVarResponse -> {
					if (localVarResponse.statusCode() / 100 != 2) {
						return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
								"apiV3VersionsIdProjectsGet call received non-success response",
								localVarResponse.headers(), localVarResponse.body()));
					} else {
						try {
							return CompletableFuture.completedFuture(
									memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<>() {
									}));
						} catch (IOException e) {
							return CompletableFuture.failedFuture(new ApiException(e));
						}
					}
				});
	}
}
