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
import java.time.LocalDate;
import net.jbw.openproject.client.model.Description;
import net.jbw.openproject.client.model.WorkPackageLinks;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * WorkPackagePatch
 */
@JsonPropertyOrder({
  WorkPackagePatch.JSON_PROPERTY_LOCK_VERSION,
  WorkPackagePatch.JSON_PROPERTY_PERCENTAGE_DONE,
  WorkPackagePatch.JSON_PROPERTY_SUBJECT,
  WorkPackagePatch.JSON_PROPERTY_DESCRIPTION,
  WorkPackagePatch.JSON_PROPERTY_START_DATE,
  WorkPackagePatch.JSON_PROPERTY_DUE_DATE,
  WorkPackagePatch.JSON_PROPERTY_ESTIMATED_TIME,
  WorkPackagePatch.JSON_PROPERTY_LINKS
})

public class WorkPackagePatch {
  public static final String JSON_PROPERTY_LOCK_VERSION = "lockVersion";
  private Integer lockVersion;

  public static final String JSON_PROPERTY_PERCENTAGE_DONE = "percentageDone";
  private Integer percentageDone;

  public static final String JSON_PROPERTY_SUBJECT = "subject";
  private String subject;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private Description description;

  public static final String JSON_PROPERTY_START_DATE = "startDate";
  private LocalDate startDate;

  public static final String JSON_PROPERTY_DUE_DATE = "dueDate";
  private LocalDate dueDate;

  public static final String JSON_PROPERTY_ESTIMATED_TIME = "estimatedTime";
  private String estimatedTime;

  public static final String JSON_PROPERTY_LINKS = "_links";
  private WorkPackageLinks links;


  public WorkPackagePatch lockVersion(Integer lockVersion) {
    
    this.lockVersion = lockVersion;
    return this;
  }

   /**
   * Get lockVersion
   * @return lockVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LOCK_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getLockVersion() {
    return lockVersion;
  }


  public void setLockVersion(Integer lockVersion) {
    this.lockVersion = lockVersion;
  }


  public WorkPackagePatch percentageDone(Integer percentageDone) {
    
    this.percentageDone = percentageDone;
    return this;
  }

   /**
   * Get percentageDone
   * @return percentageDone
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PERCENTAGE_DONE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getPercentageDone() {
    return percentageDone;
  }


  public void setPercentageDone(Integer percentageDone) {
    this.percentageDone = percentageDone;
  }


  public WorkPackagePatch subject(String subject) {
    
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SUBJECT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSubject() {
    return subject;
  }


  public void setSubject(String subject) {
    this.subject = subject;
  }


  public WorkPackagePatch description(Description description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Description getDescription() {
    return description;
  }


  public void setDescription(Description description) {
    this.description = description;
  }


  public WorkPackagePatch startDate(LocalDate startDate) {
    
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_START_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDate getStartDate() {
    return startDate;
  }


  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }


  public WorkPackagePatch dueDate(LocalDate dueDate) {
    
    this.dueDate = dueDate;
    return this;
  }

   /**
   * Get dueDate
   * @return dueDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DUE_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LocalDate getDueDate() {
    return dueDate;
  }


  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }


  public WorkPackagePatch estimatedTime(String estimatedTime) {
    
    this.estimatedTime = estimatedTime;
    return this;
  }

   /**
   * Get estimatedTime
   * @return estimatedTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ESTIMATED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEstimatedTime() {
    return estimatedTime;
  }


  public void setEstimatedTime(String estimatedTime) {
    this.estimatedTime = estimatedTime;
  }


  public WorkPackagePatch links(WorkPackageLinks links) {
    
    this.links = links;
    return this;
  }

   /**
   * Get links
   * @return links
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LINKS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public WorkPackageLinks getLinks() {
    return links;
  }


  public void setLinks(WorkPackageLinks links) {
    this.links = links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkPackagePatch workPackagePatch = (WorkPackagePatch) o;
    return Objects.equals(this.lockVersion, workPackagePatch.lockVersion) &&
        Objects.equals(this.percentageDone, workPackagePatch.percentageDone) &&
        Objects.equals(this.subject, workPackagePatch.subject) &&
        Objects.equals(this.description, workPackagePatch.description) &&
        Objects.equals(this.startDate, workPackagePatch.startDate) &&
        Objects.equals(this.dueDate, workPackagePatch.dueDate) &&
        Objects.equals(this.estimatedTime, workPackagePatch.estimatedTime) &&
        Objects.equals(this.links, workPackagePatch.links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lockVersion, percentageDone, subject, description, startDate, dueDate, estimatedTime, links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkPackagePatch {\n");
    sb.append("    lockVersion: ").append(toIndentedString(lockVersion)).append("\n");
    sb.append("    percentageDone: ").append(toIndentedString(percentageDone)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    estimatedTime: ").append(toIndentedString(estimatedTime)).append("\n");
    sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
