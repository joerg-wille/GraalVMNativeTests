/*
 * OpenProject API v3
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * 
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package net.jbw.openproject.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import net.jbw.openproject.client.model.Project;
import net.jbw.openproject.client.model.Version;
import net.jbw.openproject.client.model.WPType;
import net.jbw.openproject.client.model.WorkPackage;
/**
 * WorkPackageEmbedded
 */


public class WorkPackageEmbedded {
  @SerializedName("parent")
  private WorkPackage parent = null;

  @SerializedName("project")
  private Project project = null;

  @SerializedName("type")
  private WPType type = null;

  @SerializedName("version")
  private Version version = null;

  public WorkPackageEmbedded parent(WorkPackage parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @Schema(description = "")
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
  @Schema(description = "")
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
  @Schema(description = "")
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
  @Schema(description = "")
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
