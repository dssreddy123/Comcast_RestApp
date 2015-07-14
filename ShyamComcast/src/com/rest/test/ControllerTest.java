package com.rest.test;

//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpSession;
//import org.springframework.test.web.servlet.MockMvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


	
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = "classpath:user-servlet.xml" )
	@WebAppConfiguration 
	public class ControllerTest {
		
	
    @Autowired MockHttpSession session;
    @Autowired MockHttpServletRequest request;
		
		
	 
	    @Autowired
	    private WebApplicationContext ctx;
	 
	    private MockMvc mockMvc;
	 
	    @Before
	    public void setUp() {
	        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	    }
	    
	    @Test
	    public void getAccount() throws Exception {
//	        UserDomain user = new UserDomain();
//	        user.setFirstName("johnny");
//
//	        session.setAttribute("sessionParm",user);
	        this.mockMvc.perform(get("/add").session(session)
	        .accept(MediaType.TEXT_HTML))
	        .andExpect(status().isOk())
	        .andExpect(view().name("test"));
	    }
	    
	    
	 
//	    @Test
//	    public void contact() throws Exception {
//	        Integer id = 1;
//	        mockMvc.perform(post("/add",id).accept(MediaType.APPLICATION_JSON))
//	                .andExpect(status().isOk())
//	                .andExpect(content().contentType("application/json;charset=UTF-8"))
//	                .andExpect(jsonPath("id").value(id));
//	    }
	 
//	    @Configuration
//	    @EnableWebMvc
////	    public static class TestConfiguration {
//	 
//////	        @Bean
//////	        public ContactController contactController() {
//////	            return new ContactController();
////	        }
	 
	    
	 
	}


