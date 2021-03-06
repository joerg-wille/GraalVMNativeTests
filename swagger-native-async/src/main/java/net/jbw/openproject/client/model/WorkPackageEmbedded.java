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
import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WorkPackage;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * WorkPackageEmbedded
 */
@JsonPropertyOrder({
  WorkPackageEmbedded.JSON_PROPERTY_PARENT,
  WorkPackageEmbedded.JSON_PROPERTY_PROJECT,
  WorkPackageEmbedded.JSON_PROPERTY_TYPE,
  WorkPackageEmbedded.JSON_PROPERTY_VERSION
})

public class WorkPackageEmbedded {
  public static final String JSON_PROPERTY_PARENT = "parent";
  private WorkPackage parent;

  public static final String JSON_PROPERTY_PROJECT = "project";
  private Project project;

  public static final String JSON_PROPERTY_TYPE = "type";
  private WPType type;

  public static final String JSON_PROPERTY_VERSION = "version";
  private Version version;


  public WorkPackageEmbedded parent(WorkPackage parent) {
    
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PARENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WorkPackage getParent() {
    return parent;
  }


  public void setParent(WorkPackage parent) {
    this.parent = parent;
  }


  public WorkPackageEmbedded project(Project project) {
    
    this.project = project;
    return this;
  }

   /**
   * Get project
   * @return project
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PROJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Project getProject() {
    return project;
  }


  public void setProject(Project project) {
    this.project = project;
  }


  public WorkPackageEmbedded type(WPType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WPType getType() {
    return type;
  }


  public void setType(WPType type) {
    this.type = type;
  }


  public WorkPackageEmbedded version(Version version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Version getVersion() {
    return version;
  }


  public void setVersion(Version version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkPackageEmbedded workPackageEmbedded = (WorkPackageEmbedded) o;
    return Objects.equals(this.parent, workPackageEmbedded.parent) &&
        Objects.equals(this.project, workPackageEmbedded.project) &&
        Objects.equals(this.type, workPackageEmbedded.type) &&
        Objects.equals(this.version, workPackageEmbedded.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parent, project, type, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkPackageEmbedded {\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

