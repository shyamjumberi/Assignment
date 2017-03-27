/**
 * 
 */
package com.food.satisfaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.food.satisfaction.model.SatisfactionData;

/**
 * @author Shyamjumberu
 *
 */
@Configuration
@EnableConfigurationProperties(value=FoodSatisfactionConfiguration.class)
@EnableAutoConfiguration
public class FoodSatisfactionAutoConfiguration {
	
	@Autowired
	private FoodSatisfactionConfiguration config;
	
	
	
	
	
	
	
	@Bean
	@Qualifier(value="satisfactionData")
	public SatisfactionData getSatisfactionData() {
		final int totalItems = Integer.parseInt(config.getTotalItems());
		final int[] satisfactionValues = new int[totalItems];
		final int[] timeValues = new int[totalItems];
		int index = 0;
		for(String value : config.getValues()) {
			timeValues[index] = Integer.parseInt(value.split(" ")[0]);
			satisfactionValues[index] = Integer.parseInt(value.split(" ")[1]);
			++index;
		}
		final SatisfactionData data = createSatisfactionData();
		// setting yml values to SatisfactionData
		data.setTotalTime(Integer.parseInt(config.getTotalTime()));
		data.setSatisfactionValues(satisfactionValues);
		data.setTimeValues(timeValues);
		data.setTotalItems(Integer.parseInt(config.getTotalItems()));
		return data;
				
	}
	
	@Bean
	public SatisfactionData createSatisfactionData() {
		return new SatisfactionData();
	}
}
