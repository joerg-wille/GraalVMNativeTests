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


public class RelationsApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;

  public RelationsApi() {
    this(new ApiClient());
  }

  public RelationsApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
  }

  /**
   * List Relations
   * Lists all relations according to the given (optional, logically conjunctive) filters and ordered by ID. The response only includes relations between work packages which the user is allowed to see.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Valid fields to filter by are:  + id - ID of relation  + from - ID of work package from which the filtered relations emanates.  + to - ID of work package to which this related points.  + involved - ID of either the &#x60;from&#x60; or the &#x60;to&#x60; work package.  + type - The type of relation to filter by, e.g. \&quot;follows\&quot;. (optional)
   * @param sortBy JSON specifying sort criteria. Accepts the same format as returned by the [queries](#queries) endpoint. (optional)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsGet (String filters, String sortBy) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("filters", filters));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sortBy", sortBy));

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
      return memberVarHttpClient.sendAsync(
              localVarRequestBuilder.build(),
              HttpResponse.BodyHandlers.ofString()).thenComposeAsync(localVarResponse -> {
          if (localVarResponse.statusCode()/ 100 != 2) {
              return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
                  "apiV3RelationsGet call received non-success response",
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
   * Delete Relation
   * Deletes the relation.
   * @param id Relation ID (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsIdDelete (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3RelationsIdDelete"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/{id}"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
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
                  "apiV3RelationsIdDelete call received non-success response",
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
   * Relation edit form
   * 
   * @param id ID of the relation being modified (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsIdFormPost (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3RelationsIdFormPost"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/{id}/form"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

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
                  "apiV3RelationsIdFormPost call received non-success response",
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
   * View Relation
   * 
   * @param id Relation id (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsIdGet (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3RelationsIdGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/{id}"
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
                  "apiV3RelationsIdGet call received non-success response",
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
   * Edit Relation
   * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. It is only allowed to provide properties or links supporting the **write** operation.  Note that changing the &#x60;type&#x60; of a relation invariably also changes the respective &#x60;reverseType&#x60; as well as the \&quot;name\&quot; of it. The returned Relation object will reflect that change. For instance if you change a Relation&#39;s &#x60;type&#x60; to \&quot;follows\&quot; then the &#x60;reverseType&#x60; will be changed to &#x60;precedes&#x60;.
   * @param id Relation ID (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsIdPatch (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3RelationsIdPatch"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/{id}"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

      localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.noBody());
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
                  "apiV3RelationsIdPatch call received non-success response",
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
   * View relation schema
   * 
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsSchemaGet () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/schema";

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
                  "apiV3RelationsSchemaGet call received non-success response",
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
   * View relation schema for type
   * 
   * @param type Type of the schema (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3RelationsSchemaTypeGet (String type) throws ApiException {
    // verify the required parameter 'type' is set
    if (type == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'type' when calling apiV3RelationsSchemaTypeGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/relations/schema/{type}"
        .replace("{type}", ApiClient.urlEncode(type.toString()));

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
                  "apiV3RelationsSchemaTypeGet call received non-success response",
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
