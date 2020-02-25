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
import net.jbw.openproject.client.model.ProjectsEmbedded;
import net.jbw.openproject.client.model.TimeEntriesActivityLinks;
/**
 * TimeEntriesActivity
 */


public class TimeEntriesActivity {
  @SerializedName("id")
  private Integer id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("position")
  private Integer position = null;

  @SerializedName("default")
  private Boolean _default = null;

  @SerializedName("_embedded")
  private ProjectsEmbedded _embedded = null;

  @SerializedName("_links")
  private TimeEntriesActivityLinks _links = null;

  public TimeEntriesActivity id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(description = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TimeEntriesActivity name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @Schema(description = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TimeEntriesActivity position(Integer position) {
    this.position = position;
    return this;
  }

   /**
   * Get position
   * @return position
  **/
  @Schema(description = "")
  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public TimeEntriesActivity _default(Boolean _default) {
    this._default = _default;
    return this;
  }

   /**
   * Get _default
   * @return _default
  **/
  @Schema(description = "")
  public Boolean isDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public TimeEntriesActivity _embedded(ProjectsEmbedded _embedded) {
    this._embedded = _embedded;
    return this;
  }

   /**
   * Get _embedded
   * @return _embedded
  **/
  @Schema(description = "")
  public ProjectsEmbedded getEmbedded() {
    return _embedded;
  }

  public void setEmbedded(ProjectsEmbedded _embedded) {
    this._embedded = _embedded;
  }

  public TimeEntriesActivity _links(TimeEntriesActivityLinks _links) {
    this._links = _links;
    return this;
  }

   /**
   * Get _links
   * @return _links
  **/
  @Schema(description = "")
  public TimeEntriesActivityLinks getLinks() {
    return _links;
  }

  public void setLinks(TimeEntriesActivityLinks _links) {
    this._links = _links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimeEntriesActivity timeEntriesActivity = (TimeEntriesActivity) o;
    return Objects.equals(this.id, timeEntriesActivity.id) &&
        Objects.equals(this.name, timeEntriesActivity.name) &&
        Objects.equals(this.position, timeEntriesActivity.position) &&
        Objects.equals(this._default, timeEntriesActivity._default) &&
        Objects.equals(this._embedded, timeEntriesActivity._embedded) &&
        Objects.equals(this._links, timeEntriesActivity._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, position, _default, _embedded, _links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimeEntriesActivity {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    _embedded: ").append(toIndentedString(_embedded)).append("\n");
    sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
