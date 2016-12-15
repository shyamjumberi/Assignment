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
		final int maxSatisfactionValue = CalculateMaxSatisfaction.findMaxSatisfactionValue(satisfactionValues,timeValues,totalTime,totalItems);
		if (LOG.isInfoEnabled()) {
			LOG.info("Max satisfaction is : " + maxSatisfactionValue);
			LOG.info("FoodSatisfactionService : getMaxSatisfactionValue() end ");
		}
		return ResponseEntity.ok().body("Completed in " + (System.currentTimeMillis() - startTime)
				+ " milliseconds with max satisfaction : " + maxSatisfactionValue);
	}
}
