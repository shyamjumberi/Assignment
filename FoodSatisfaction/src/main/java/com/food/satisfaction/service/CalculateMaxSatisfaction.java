/**
 * 
 */
package com.food.satisfaction.service;

/**
 * @author Shyamjumberu
 *
 */
public class CalculateMaxSatisfaction {
	
	
	private CalculateMaxSatisfaction () {}
	
	/**
	 * Returns the maximum satisfaction value.
	 * 
	 * @param timeValues
	 * @param satisfactionValues
	 * @param totalTime
	 * @param totalItems
	 * @return int
	 */
	public static int findMaxSatisfactionValue(final int[] timeValues, final int[] satisfactionValues, final int totalTime, final int totalItems ) {
 	   final int[][] tempArray = new int[totalItems + 1][totalTime];
 	   for (int i = 1; i <= totalItems; i++) {
 	       for (int j = 1; j <= totalTime; j++)  {
 	            if (j < timeValues[i - 1])  {
 	            	tempArray[i][j - 1] = tempArray[i - 1][j - 1];
 	            } else {
 	            	if (j > timeValues[i - 1]) {
 	            		tempArray[i][j - 1] = Math.max(tempArray[i - 1][j - 1], tempArray[i - 1][j - 1 - timeValues[i - 1]] + satisfactionValues[i - 1]);
 	            	} else {
 	            		tempArray[i][j - 1] = Math.max(tempArray[i - 1][j - 1], satisfactionValues[i - 1]);
 	            	}
 	            }
 	       }
 	   }
 	   return tempArray[totalItems][totalTime - 1];
 	}
}
