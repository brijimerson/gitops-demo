package dev.snbv2.gitopsdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests for the IndexController class
 * 
 * @author Brian Jimerson
 */
@SpringBootTest
public class IndexControllerTests {
    
    @Autowired
    WebApplicationContext context;

    MockMvc mvc;

    /**
     * Sets up each test.
     */
    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    /**
     * Tests the controller's index method
     * 
     * @throws Exception
     */
    @Test
    void testIndex() throws Exception {
        mvc.perform(get("/index")).
            andExpect(status().isOk()).
            andExpect(model().size(3)).
            andExpect(view().name("index"));   
    }
}