package com.food.satisfaction.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Shyamjumberu
 *
 */
@ConfigurationProperties(prefix = "satisfaction")
public class FoodSatisfactionConfiguration {

	/** Holds satisfaction and time values */
	private List<String> values;

	/** Holds total time */
	private String totalTime;
	
	/** Holds total number of items */
	private String totalItems;

	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(final List<String> values) {
		this.values = values;
	}

	/**
	 * @return the totalTime
	 */
	public String getTotalTime() {
		return totalTime;
	}

	/**
	 * @param totalTime
	 *            the totalTime to set
	 */
	public void setTotalTime(final String totalTime) {
		this.totalTime = totalTime;
	}
	/**
	 * @return the totalItems
	 */
	public String getTotalItems() {
		return totalItems;
	}

	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(final String totalItems) {
		this.totalItems = totalItems;
	}

	/**
	 * String representation of FoodSatisfactionConfiguration
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("FoodSatisfactionConfiguration [values=");
		builder.append(values);
		builder.append(", totalTime=");
		builder.append(totalTime);
		builder.append(", totalItems=");
		builder.append(totalItems);
		builder.append("]");
		return builder.toString();
	}
}
