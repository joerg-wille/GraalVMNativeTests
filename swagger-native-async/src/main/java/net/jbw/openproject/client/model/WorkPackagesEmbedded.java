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


package net.jbw.openproject.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import net.jbw.openproject.client.model.WorkPackage;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * WorkPackagesEmbedded
 */
@JsonPropertyOrder({
  WorkPackagesEmbedded.JSON_PROPERTY_ELEMENTS
})

public class WorkPackagesEmbedded {
  public static final String JSON_PROPERTY_ELEMENTS = "elements";
  private List<WorkPackage> elements = null;


  public WorkPackagesEmbedded elements(List<WorkPackage> elements) {
    
    this.elements = elements;
    return this;
  }

  public WorkPackagesEmbedded addElementsItem(WorkPackage elementsItem) {
    if (this.elements == null) {
      this.elements = new ArrayList<>();
    }
    this.elements.add(elementsItem);
    return this;
  }

   /**
   * Get elements
   * @return elements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ELEMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<WorkPackage> getElements() {
    return elements;
  }


  public void setElements(List<WorkPackage> elements) {
    this.elements = elements;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkPackagesEmbedded workPackagesEmbedded = (WorkPackagesEmbedded) o;
    return Objects.equals(this.elements, workPackagesEmbedded.elements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elements);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkPackagesEmbedded {\n");
    sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

