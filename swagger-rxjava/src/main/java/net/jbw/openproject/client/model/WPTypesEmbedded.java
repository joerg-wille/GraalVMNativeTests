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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * WPTypesEmbedded
 */

public class WPTypesEmbedded {
	@SerializedName("elements")
	private List<WPType> elements = null;

	public WPTypesEmbedded elements(List<WPType> elements) {
		this.elements = elements;
		return this;
	}

	public WPTypesEmbedded addElementsItem(WPType elementsItem) {
		if (this.elements == null) {
			this.elements = new ArrayList<>();
		}
		this.elements.add(elementsItem);
		return this;
	}

	/**
	 * Get elements
	 * 
	 * @return elements
	 **/
	@Schema(description = "")
	public List<WPType> getElements() {
		return elements;
	}

	public void setElements(List<WPType> elements) {
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
