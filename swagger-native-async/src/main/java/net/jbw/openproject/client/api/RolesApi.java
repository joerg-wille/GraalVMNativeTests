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


public class RolesApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;

  public RolesApi() {
    this(new ApiClient());
  }

  public RolesApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
  }

  /**
   * List roles
   * List all defined roles. This includes built in roles like &#39;Anonymous&#39; and &#39;Non member&#39;.
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RolesGet () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/roles";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
      if (memberVarReadTimeout != null) {
        localVarRequestBuilder.timeout(memberVarReadTimeout);
      }
      if (memberVarInterceptor != null) {
        memberVarInterceptor.accept(localVarRequestBuilder);
      }
      return memberVarHttpClient.sendAsync(
              localVarRequestBuilder.build(),
              HttpResponse.BodyHandlers.ofString()).thenComposeAsync(localVarResponse -> {
          if (localVarResponse.statusCode()/ 100 != 2) {
              return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
                  "apiV3RolesGet call received non-success response",
                  localVarResponse.headers(),
                  localVarResponse.body())
              );
          } else {
              return CompletableFuture.completedFuture(
                      null
              );
          }
      });
  }
  /**
   * View role
   * Fetch an individual role.
   * @param id role id (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RolesIdGet (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3RolesIdGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/roles/{id}"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
      if (memberVarReadTimeout != null) {
        localVarRequestBuilder.timeout(memberVarReadTimeout);
      }
      if (memberVarInterceptor != null) {
        memberVarInterceptor.accept(localVarRequestBuilder);
      }
      return memberVarHttpClient.sendAsync(
              localVarRequestBuilder.build(),
              HttpResponse.BodyHandlers.ofString()).thenComposeAsync(localVarResponse -> {
          if (localVarResponse.statusCode()/ 100 != 2) {
              return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
                  "apiV3RolesIdGet call received non-success response",
                  localVarResponse.headers(),
                  localVarResponse.body())
              );
          } else {
              return CompletableFuture.completedFuture(
                      null
              );
          }
      });
  }
}
