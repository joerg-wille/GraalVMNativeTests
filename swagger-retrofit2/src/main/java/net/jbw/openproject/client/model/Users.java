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
import net.jbw.openproject.client.model.UsersEmbedded;
/**
 * Users
 */


public class Users {
  @SerializedName("total")
  private Integer total = null;

  @SerializedName("count")
  private Integer count = null;

  @SerializedName("_embedded")
  private UsersEmbedded _embedded = null;

  public Users total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @Schema(description = "")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Users count(Integer count) {
    this.count = count;
    return this;
  }

   /**
   * Get count
   * @return count
  **/
  @Schema(description = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Users _embedded(UsersEmbedded _embedded) {
    this._embedded = _embedded;
    return this;
  }

   /**
   * Get _embedded
   * @return _embedded
  **/
  @Schema(description = "")
  public UsersEmbedded getEmbedded() {
    return _embedded;
  }

  public void setEmbedded(UsersEmbedded _embedded) {
    this._embedded = _embedded;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Users users = (Users) o;
    return Objects.equals(this.total, users.total) &&
        Objects.equals(this.count, users.count) &&
        Objects.equals(this._embedded, users._embedded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, count, _embedded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Users {\n");
    
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    _embedded: ").append(toIndentedString(_embedded)).append("\n");
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
