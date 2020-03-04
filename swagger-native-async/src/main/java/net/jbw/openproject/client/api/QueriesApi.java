/*
 * OpenProject API v3
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
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

import net.jbw.openproject.client.model.InlineObject3;

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


public class QueriesApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;

  public QueriesApi() {
    this(new ApiClient());
  }

  public QueriesApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
  }

  /**
   * View default query for project
   * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query. The query will already be scoped for the project.
   * @param id Id of the project the default query is requested for (required)
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
   * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3ProjectsIdQueriesDefaultGet (Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, Boolean showHierarchies) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesDefaultGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/projects/{id}/queries/default"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("filters", filters));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("offset", offset));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("pageSize", pageSize));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sortBy", sortBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("groupBy", groupBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showSums", showSums));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timelineVisible", timelineVisible));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showHierarchies", showHierarchies));

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
                  "apiV3ProjectsIdQueriesDefaultGet call received non-success response",
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
   * View schema for project queries
   * Retrieve the schema for project queries.
   * @param id ID of project to return (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3ProjectsIdQueriesSchemaGet (Long id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3ProjectsIdQueriesSchemaGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/projects/{id}/queries/schema"
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
                  "apiV3ProjectsIdQueriesSchemaGet call received non-success response",
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
   * Available projects
   * Gets a list of projects that are available as projects a query can be assigned to.
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesAvailableProjectsGet () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/available_projects";

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
                  "apiV3QueriesAvailableProjectsGet call received non-success response",
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
   * View default query
   * Same as [viewing an existing, persisted Query](#queries-query-get) in its response, this resource returns an unpersisted query and by that allows to get the default query configuration. The client may also provide additional parameters which will modify the default query.
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
   * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
   * @param timelineZoomLevel Indicates in what zoom level the timeline should be shown. Valid values are  &#x60;days&#x60;, &#x60;weeks&#x60;, &#x60;months&#x60;, &#x60;quarters&#x60;, and &#x60;years&#x60;. (optional, default to &quot;days&quot;)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesDefaultGet (String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineZoomLevel, Boolean showHierarchies) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/default";

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("filters", filters));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("offset", offset));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("pageSize", pageSize));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sortBy", sortBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("groupBy", groupBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showSums", showSums));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timelineVisible", timelineVisible));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timelineZoomLevel", timelineZoomLevel));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showHierarchies", showHierarchies));

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
                  "apiV3QueriesDefaultGet call received non-success response",
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
   * Query Create Form
   * 
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesFormPost () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/form";

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
                  "apiV3QueriesFormPost call received non-success response",
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
   * List queries
   * Returns a collection of queries. The collection can be filtered via query parameters similar to how work packages are filtered. Please note however, that the filters are applied to the queries and not to the work packages the queries in turn might return.
   * @param filters JSON specifying filter conditions. Accepts the same format as returned by the [queries](#queries) endpoint. Currently supported filters are:  + project: filters queries by the project they are assigned to. If the project filter is passed with the &#x60;!*&#x60; (not any) operator, global queries are returned. (optional)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesGet (String filters) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries";

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
      return memberVarHttpClient.sendAsync(
              localVarRequestBuilder.build(),
              HttpResponse.BodyHandlers.ofString()).thenComposeAsync(localVarResponse -> {
          if (localVarResponse.statusCode()/ 100 != 2) {
              return CompletableFuture.failedFuture(new ApiException(localVarResponse.statusCode(),
                  "apiV3QueriesGet call received non-success response",
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
   * Delete query
   * Delete the query identified by the id parameter
   * @param id Query id (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesIdDelete (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3QueriesIdDelete"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/{id}"
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
                  "apiV3QueriesIdDelete call received non-success response",
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
   * View query
   * Retreive an individual query as identified by the id parameter. Then end point accepts a number of parameters that can be used to override the resources&#39; persisted parameters.
   * @param id Query id (required)
   * @param filters JSON specifying filter conditions. The filters provided as parameters are not applied to the query but are instead used to override the query&#39;s persisted filters. All filters also accepted by the work packages endpoint are accepted. (optional)
   * @param offset Page number inside the queries&#39; result collection of work packages. (optional, default to 1)
   * @param pageSize Number of elements to display per page for the queries&#39; result collection of work packages. (optional)
   * @param sortBy JSON specifying sort criteria. The sort criteria is applied to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sort criteria. (optional)
   * @param groupBy The column to group by. The grouping criteria is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted group criteria. (optional)
   * @param showSums Indicates whether properties should be summed up if they support it. The showSums parameter is applied to the to the querie&#39;s result collection of work packages overriding the query&#39;s persisted sums property. (optional, default to false)
   * @param timelineVisible Indicates whether the timeline should be shown. (optional, default to false)
   * @param timelineLabels Overridden labels in the timeline view (optional, default to &quot;{}&quot;)
   * @param showHierarchies Indicates whether the hierarchy mode should be enabled. (optional, default to true)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesIdGet (Integer id, String filters, Integer offset, Integer pageSize, String sortBy, String groupBy, Boolean showSums, Boolean timelineVisible, String timelineLabels, Boolean showHierarchies) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3QueriesIdGet"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/{id}"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    localVarQueryParams.addAll(ApiClient.parameterToPairs("filters", filters));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("offset", offset));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("pageSize", pageSize));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("sortBy", sortBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("groupBy", groupBy));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showSums", showSums));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timelineVisible", timelineVisible));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("timelineLabels", timelineLabels));
    localVarQueryParams.addAll(ApiClient.parameterToPairs("showHierarchies", showHierarchies));

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
                  "apiV3QueriesIdGet call received non-success response",
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
   * Edit Query
   * When calling this endpoint the client provides a single object, containing the properties and links that it wants to change, in the body. Note that it is only allowed to provide properties or links supporting the **write** operation.
   * @param id Query id (required)
   * @param body  (optional)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesIdPatch (Integer id, InlineObject3 body) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3QueriesIdPatch"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/{id}"
        .replace("{id}", ApiClient.urlEncode(id.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(body);
      localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
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
                  "apiV3QueriesIdPatch call received non-success response",
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
   * Star query
   * 
   * @param id Query id (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesIdStarPatch (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3QueriesIdStarPatch"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/{id}/star"
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
                  "apiV3QueriesIdStarPatch call received non-success response",
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
   * Unstar query
   * 
   * @param id Query id (required)
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesIdUnstarPatch (Integer id) throws ApiException {
    // verify the required parameter 'id' is set
    if (id == null) {
        return CompletableFuture.failedFuture(new ApiException(400, "Missing the required parameter 'id' when calling apiV3QueriesIdUnstarPatch"));
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/{id}/unstar"
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
                  "apiV3QueriesIdUnstarPatch call received non-success response",
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
   * Create query
   * When calling this endpoint the client provides a single object, containing at least the properties and links that are required, in the body. The required fields of a Query can be found in its schema, which is embedded in the respective form. Note that it is only allowed to provide properties or links supporting the write operation.
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesPost () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries";

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
                  "apiV3QueriesPost call received non-success response",
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
   * View schema for global queries
   * Retrieve the schema for global queries, those, that are not assigned to a project.
   * @throws ApiException if fails to make API call
   */
  public CompletableFuture<Void> apiV3QueriesSchemaGet () throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/api/v3/queries/schema";

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
                  "apiV3QueriesSchemaGet call received non-success response",
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
