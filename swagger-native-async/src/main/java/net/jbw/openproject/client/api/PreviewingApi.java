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


public class PreviewingApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;

  public PreviewingApi() {
    this(new ApiClient());
  }

  public PreviewingApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
  }

  /**
   * Preview plain document
   * 
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RenderPlainPost () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/render/plain";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
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
                  "apiV3RenderPlainPost call received non-success response",
                  localVarResponse.headers(),
                  localVarResponse.body())
              );
          } else {
              try {
                  return CompletableFuture.completedFuture(
                      memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<>() {})
                  );
              } catch (IOException e) {
                      return CompletableFuture.failedFuture(new ApiException(e));
              }
          }
      });
  }
  /**
   * Preview Textile document
   * 
   * @param context API-Link to the context in which the rendering occurs, for example a specific work package.  If left out only context-agnostic rendering takes place. Please note that OpenProject features textile-extensions that can only work given a context (e.g. display attached images).  **Supported contexts:**  * &#x60;/api/v3/work_packages/{id}&#x60; - an existing work package (optional)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RenderTextilePost (String context) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/render/textile";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("context", context));

    if (!localVarQueryParams.isEmpty()) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.noBody());
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
                  "apiV3RenderTextilePost call received non-success response",
                  localVarResponse.headers(),
                  localVarResponse.body())
              );
          } else {
              try {
                  return CompletableFuture.completedFuture(
                      memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<>() {})
                  );
              } catch (IOException e) {
                      return CompletableFuture.failedFuture(new ApiException(e));
              }
          }
      });
  }
}
