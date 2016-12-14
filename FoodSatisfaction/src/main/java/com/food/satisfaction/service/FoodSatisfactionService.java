/**
 * 
 */
package com.food.satisfaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.satisfaction.model.SatisfactionData;

/**
 * @author Shyamjumberu
 *
 */
@RestController
public class FoodSatisfactionService {

	private static final Logger LOG = LoggerFactory.getLogger(FoodSatisfactionService.class);

	@Autowired
	@Qualifier(value = "satisfactionData")
	private SatisfactionData satisfactionData;

	@RequestMapping(value = "/getMaxSatisfaction", method = RequestMethod.GET)
	public ResponseEntity<String> getMaxSatisfactionValue() {
		if (LOG.isInfoEnabled()) {
			LOG.info("FoodSatisfactionService : getMaxSatisfactionValue() start ");
		}
		final long startTime = System.currentTimeMillis();
		final int[] satisfactionValues = satisfactionData.getSatisfactionValues();
		final int[] timeValues = satisfactionData.getTimeValues();
		final int totalTime = satisfactionData.getTotalTime();

		final int totalItems = satisfactionData.getTotalItems();
		final long[][] values = new long[totalItems + 1][totalTime + 1];
		for (int index = 1; index <= totalItems; index++) {
			for (int element = 1; element <= totalTime; element++) {
				if (timeValues[index - 1] <= element) {
					values[index][element] =  Math.max(
							satisfactionValues[index - 1] + values[index - 1][element - timeValues[index - 1]],
							values[index - 1][element]);
				} else {
					values[index][element] = values[index - 1][element];
				}
			}

		}
		if (LOG.isInfoEnabled()) {
			LOG.info("Max satisfaction is : " + values[totalItems][totalTime]);
			LOG.info("FoodSatisfactionService : getMaxSatisfactionValue() end ");
		}
		return ResponseEntity.ok().body("Completed in " + (System.currentTimeMillis() - startTime)
				+ " milliseconds with max satisfaction : " + values[totalItems][totalTime]);
	}
}
