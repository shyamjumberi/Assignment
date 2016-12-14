/**
 * 
 */
package com.food.satisfaction.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.food.satisfaction.model.SatisfactionData;

/**
 * @author Shyamjumberu
 *
 */
public class FoodSatisfactionServiceTest {

	private MockMvc mockMvc;

	@InjectMocks
	private FoodSatisfactionService service;

	@Mock
	private SatisfactionData satisfactionData;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
		final int[] satisfactionValues = new int[] { 300, 60, 90, 100, 240 };
		final int[] timeValues = new int[] { 50, 10, 20, 40, 30 };
		int totalTime = 60;
		Mockito.when(satisfactionData.getSatisfactionValues()).thenReturn(satisfactionValues);
		Mockito.when(satisfactionData.getTimeValues()).thenReturn(timeValues);
		Mockito.when(satisfactionData.getTotalTime()).thenReturn(totalTime);

	}

	@Test
	public void testgetMaxSatisfactionValue() {
		try {
			final MvcResult mvcResult = this.mockMvc.perform(get("/getMaxSatisfaction")).andReturn();
			final String response = mvcResult.getResponse().getContentAsString();
			Assert.assertNotNull(response);
			Assert.assertTrue(response.contains("390"));
		} catch (Exception e) {
			Assert.fail("Exception occurred while running testgetMaxSatisfactionValue test case");
		}
	}
}
