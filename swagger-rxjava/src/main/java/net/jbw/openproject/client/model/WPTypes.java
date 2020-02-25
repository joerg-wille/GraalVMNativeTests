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

import com.google.gson.annotations.SerializedName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WPTypes
 */

public class WPTypes {
	@SerializedName("total")
	private Integer total = null;

	@SerializedName("count")
	private Integer count = null;

	@SerializedName("_embedded")
	private WPTypesEmbedded _embedded = null;

	@SerializedName("_links")
	private WPTypeLinks _links = null;

	public WPTypes total(Integer total) {
		this.total = total;
		return this;
	}

	/**
	 * Get total
	 * 
	 * @return total
	 **/
	@Schema(description = "")
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public WPTypes count(Integer count) {
		this.count = count;
		return this;
	}

	/**
	 * Get count
	 * 
	 * @return count
	 **/
	@Schema(description = "")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public WPTypes _embedded(WPTypesEmbedded _embedded) {
		this._embedded = _embedded;
		return this;
	}

	/**
	 * Get _embedded
	 * 
	 * @return _embedded
	 **/
	@Schema(description = "")
	public WPTypesEmbedded getEmbedded() {
		return _embedded;
	}

	public void setEmbedded(WPTypesEmbedded _embedded) {
		this._embedded = _embedded;
	}

	public WPTypes _links(WPTypeLinks _links) {
		this._links = _links;
		return this;
	}

	/**
	 * Get _links
	 * 
	 * @return _links
	 **/
	@Schema(description = "")
	public WPTypeLinks getLinks() {
		return _links;
	}

	public void setLinks(WPTypeLinks _links) {
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
		WPTypes wpTypes = (WPTypes) o;
		return Objects.equals(this.total, wpTypes.total) && Objects.equals(this.count, wpTypes.count)
				&& Objects.equals(this._embedded, wpTypes._embedded) && Objects.equals(this._links, wpTypes._links);
	}

	@Override
	public int hashCode() {
		return Objects.hash(total, count, _embedded, _links);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WPTypes {\n");

		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
