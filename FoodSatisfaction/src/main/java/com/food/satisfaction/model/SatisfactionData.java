/**
 * 
 */
package com.food.satisfaction.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 
 * @author Shyamjumberu
 *
 */
public class SatisfactionData implements Serializable {

	/**
	 * SerialVerionUID
	 */
	private static final long serialVersionUID = -5688773204975293908L;

	/** Holds Time */
	private int[] timeValues;
	
	/** Holds Satisfaction values */
	private int[] satisfactionValues;
	
	/** Holds Total Time */
	private int totalTime;
	
	/** Holds total number of items */
	private int totalItems;
	
	/**
	 * @return the timeValues
	 */
	public int[] getTimeValues() {
		return timeValues;
	}
	/**
	 * @param timeValues the timeValues to set
	 */
	public void setTimeValues(final int[] timeValues) {
		this.timeValues = timeValues;
	}
	/**
	 * @return the satisfactionValues
	 */
	public int[] getSatisfactionValues() {
		return satisfactionValues;
	}
	/**
	 * @param satisfactionValues the satisfactionValues to set
	 */
	public void setSatisfactionValues(final int[] satisfactionValues) {
		this.satisfactionValues = satisfactionValues;
	}

	/**
	 * @return the totalTime
	 */
	public int getTotalTime() {
		return totalTime;
	}
	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(final int totalTime) {
		this.totalTime = totalTime;
	}
	/**
	 * @return the totalItems
	 */
	public int getTotalItems() {
		return totalItems;
	}
	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(final int totalItems) {
		this.totalItems = totalItems;
	}
	/**
	 * String representation of SatisfactionData
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("SatisfactionData [timeValues=");
		builder.append(Arrays.toString(timeValues));
		builder.append(", satisfactionValues=");
		builder.append(Arrays.toString(satisfactionValues));
		builder.append(", totalTime=");
		builder.append(totalTime);
		builder.append(", totalItems=");
		builder.append(totalItems);
		builder.append("]");
		return builder.toString();
	}
}
