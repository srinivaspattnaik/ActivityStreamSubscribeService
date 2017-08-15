package com.stackroute.activitystream.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stackroute.activitystream.SubscribeCircleBoot;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SubscribeCircleBoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT,classes=SubscribeCircleBoot.class)
public class SubscribeControllerTest 
{
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
		
	@Before
	public void setup() throws Exception 
	{
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testCaseForgetAllSubscribeCircle()throws Exception
	{
	    this.mockMvc.perform(get("http://localhost:8089/getAllSubscribeCircle/sunita@gmail.com")).andExpect(status().isOk());
	    //assertEquals("application/json;charset=UTF-8",mvcResult.getResponse().getContentType());
	}

}
