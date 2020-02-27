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

import net.jbw.openproject.client.model.InlineObject1;

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


public class CustomActionsApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;

  public CustomActionsApi() {
    this(new ApiClient());
  }

  public CustomActionsApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
  }

  /**
   * Execute custom action
   * A POST to this end point executes the custom action on the work package provided in the payload. The altered work package will be returned. In order to avoid executing  the custom action unbeknown to a change that has already taken place, the client has to provide the work package&#39;s current lockVersion.
   * @param customActionId The id of the custom action to execute (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3CustomActionsCustomActionIdExecutePost (Integer customActionId, InlineObject1 body) throws ApiException {
    // verify the required parameter 'customActionId' is set
    if (customActionId == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdExecutePost"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/custom_actions/{custom_action_id}/execute"
        .replace("{custom_action_id}", ApiClient.urlEncode(customActionId.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(body);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
                  "apiV3CustomActionsCustomActionIdExecutePost call received non-success response",
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
    } catch (IOException e) {
      return CompletableFuture.failedFuture(new ApiException(e));
    }
  }
  /**
   * View custom action
   * 
   * @param customActionId The id of the custom action to fetch (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3CustomActionsCustomActionIdGet (Integer customActionId) throws ApiException {
    // verify the required parameter 'customActionId' is set
    if (customActionId == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'customActionId' when calling apiV3CustomActionsCustomActionIdGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/custom_actions/{custom_action_id}"
        .replace("{custom_action_id}", ApiClient.urlEncode(customActionId.toString()));

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
                  "apiV3CustomActionsCustomActionIdGet call received non-success response",
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