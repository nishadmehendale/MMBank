package com.mmbank.app;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/*
 * Reference URL: https://medium.com/@gustavo.ponce.ch/spring-boot-restful-junit-mockito-hamcrest-eclemma-5add7f725d4e
 */


//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppApplication.class)
@SpringBootTest
public class AppApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	/*@Test
	public void contextLoads() {
	}*/
	
	@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/201").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.customerId").exists())
		.andExpect(jsonPath("$.customerName").exists())
		.andExpect(jsonPath("$.contactNumber").exists())
		.andExpect(jsonPath("$.customerId").value(201))
		.andExpect(jsonPath("$.customerName").value("Nishad"))
		.andExpect(jsonPath("$.contactNumber").value(1212121))
		.andDo(print());
		/*{
		    "customerId": 201,
		    "customerName": "Nishad",
		    "contactNumber": 1212121,
		    "emailId": "n@m.com",
		    "dateOfBirth": "08/11/1996",
		    "accountNumber": [
		        101,
		        104,
		        0
		    ]
		}*/
	}

}
