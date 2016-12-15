/**
 * 
 */
package com.food.satisfaction.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.food.satisfaction.model.SatisfactionData;

/**
 * @author Shyamjumberu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FoodSatisfactionServiceTest {

	private MockMvc mockMvc;

	@Autowired
	private FoodSatisfactionService service;

	@Autowired
	@Qualifier(value = "satisfactionData")
	private SatisfactionData satisfactionData;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}

	@Test
	public void testgetMaxSatisfactionValue() {
		try {
			final MvcResult mvcResult = this.mockMvc.perform(get("/getMaxSatisfaction")).andReturn();
			final String response = mvcResult.getResponse().getContentAsString();
			Assert.assertNotNull(response);
			Assert.assertTrue(response.contains("1829"));
		} catch (Exception e) {
			Assert.fail("Exception occurred while running testgetMaxSatisfactionValue test case ");
		}
	}
	
	@Test
	public void testZeroMaxSatisfactionValue() {
		int totalTime = satisfactionData.getTotalTime();
		try {
			satisfactionData.setTotalTime(0);
			final MvcResult mvcResult = this.mockMvc.perform(get("/getMaxSatisfaction")).andReturn();
			final String response = mvcResult.getResponse().getContentAsString();
			Assert.assertNotNull(response);
			Assert.assertTrue(response.contains("0"));
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		} finally {
			satisfactionData.setTotalTime(totalTime);
		}
	}
	@Test
	public void testZeroTotalItems() {
		int totalItems = satisfactionData.getTotalItems();
		try {
			satisfactionData.setTotalItems(0);
			final MvcResult mvcResult = this.mockMvc.perform(get("/getMaxSatisfaction")).andReturn();
			final String response = mvcResult.getResponse().getContentAsString();
			Assert.assertNotNull(response);
			Assert.assertTrue(response.contains("0"));
		} catch(Exception e) {
			Assert.fail(e.getMessage());
		} finally {
			satisfactionData.setTotalItems(totalItems);
		}
	}
}
