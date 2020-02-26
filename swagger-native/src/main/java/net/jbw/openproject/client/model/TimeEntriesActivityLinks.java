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
import java.util.ArrayList;
import java.util.List;
import net.jbw.openproject.client.model.Link;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * TimeEntriesActivityLinks
 */
@JsonPropertyOrder({
  TimeEntriesActivityLinks.JSON_PROPERTY_SELF,
  TimeEntriesActivityLinks.JSON_PROPERTY_PROJECTS
})

public class TimeEntriesActivityLinks {
  public static final String JSON_PROPERTY_SELF = "self";
  private Link self;

  public static final String JSON_PROPERTY_PROJECTS = "projects";
  private List<Link> projects = null;


  public TimeEntriesActivityLinks self(Link self) {
    
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Link getSelf() {
    return self;
  }


  public void setSelf(Link self) {
    this.self = self;
  }


  public TimeEntriesActivityLinks projects(List<Link> projects) {
    
    this.projects = projects;
    return this;
  }

  public TimeEntriesActivityLinks addProjectsItem(Link projectsItem) {
    if (this.projects == null) {
      this.projects = new ArrayList<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

   /**
   * Get projects
   * @return projects
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PROJECTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Link> getProjects() {
    return projects;
  }


  public void setProjects(List<Link> projects) {
    this.projects = projects;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeEntriesActivityLinks timeEntriesActivityLinks = (TimeEntriesActivityLinks) o;
    return Objects.equals(this.self, timeEntriesActivityLinks.self) &&
        Objects.equals(this.projects, timeEntriesActivityLinks.projects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, projects);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeEntriesActivityLinks {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
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

