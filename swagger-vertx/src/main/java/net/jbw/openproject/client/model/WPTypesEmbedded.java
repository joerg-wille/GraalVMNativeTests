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


package net.jbw.openproject.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.jbw.openproject.client.model.WPType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * WPTypesEmbedded
 */
@JsonPropertyOrder({
  WPTypesEmbedded.JSON_PROPERTY_ELEMENTS
})

public class WPTypesEmbedded {
  public static final String JSON_PROPERTY_ELEMENTS = "elements";
  private java.util.List<WPType> elements = null;


  public WPTypesEmbedded elements(java.util.List<WPType> elements) {
    
    this.elements = elements;
    return this;
  }

  public WPTypesEmbedded addElementsItem(WPType elementsItem) {
    if (this.elements == null) {
      this.elements = new java.util.ArrayList<>();
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

  public java.util.List<WPType> getElements() {
    return elements;
  }


  public void setElements(java.util.List<WPType> elements) {
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
    WPTypesEmbedded wpTypesEmbedded = (WPTypesEmbedded) o;
    return Objects.equals(this.elements, wpTypesEmbedded.elements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elements);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WPTypesEmbedded {\n");
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

