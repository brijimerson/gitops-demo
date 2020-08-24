package dev.snbv2.gitopsdemo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests for the RegistrationController class.
 * 
 * @author Brian Jimerson
 */
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class RegistrationControllerTests {

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
     * Tests the controller's get registrations method.
     * 
     * @throws Exception
     */
    @Test
    void testGetRegistrations() throws Exception {

        mvc.perform(get("/registrations")).
            andExpect(status().isOk()).
            andExpect(model().attributeExists("registrations")).
            andExpect(view().name("registrations"));

    }

    /**
     * Tests the controller's create registration method.
     * 
     * @throws Exception
     */
    @Test
    void testCreateRegistration() throws Exception {

        mvc.perform(get("/registration/new")).
            andExpect(status().isOk()).
            andExpect(model().attributeExists("registration")).
            andExpect(view().name("registration"));

    }

    /**
     * Tests the controller's edit registration method.
     * 
     * @throws Exception
     */
    @Test
    void testEditRegistration() throws Exception {

        mvc.perform(get("/registration/1")).
            andExpect(status().isOk()).
            andExpect(model().attributeExists("registration")).
            andExpect(view().name("registration"));

    }

    /**
     * Tests the controller's save registration method.
     * 
     * @throws Exception
     */
    @Test
    void testSaveRegistrations() throws Exception {

        mvc.perform(post("/registration").
            param("firstName", "John").
            param("lastName", "Smith").
            param("emailAddress", "jsmith@email.com")).
            andExpect(status().isOk()).
            andExpect(model().attributeExists("registrations")).
            andExpect(model().attributeExists("message")).
            andExpect(view().name("registrations"));

    }

    /**
     * Tests the controller's delete registration method.
     * 
     * @throws Exception
     */
    @Test
    void testDeleteRegistrations() throws Exception {

        mvc.perform(post("/registration/delete").
            param("id", "1")).
            andExpect(status().isOk()).
            andExpect(model().attributeExists("registrations")).
            andExpect(model().attributeExists("message")).
            andExpect(view().name("registrations"));

    }
    
    /**
     * Tests the controller's model validation.
     * 
     * @throws Exception
     */
    @Test
    void testModelValidation() throws Exception {

        mvc.perform(post("/registration").
            param("firstName", "").
            param("lastName", "Smith").
            param("emailAddress", "jsmith@email.com")).
            andExpect(model().attributeHasFieldErrors("registration", "firstName")).
            andExpect(view().name("registration"));

        mvc.perform(post("/registration").
            param("firstName", "John").
            param("lastName", "").
            param("emailAddress", "jsmith@email.com")).
            andExpect(model().attributeHasFieldErrors("registration", "lastName")).
            andExpect(view().name("registration"));

        mvc.perform(post("/registration").
            param("firstName", "John").
            param("lastName", "Smith").
            param("emailAddress", "")).
            andExpect(model().attributeHasFieldErrors("registration", "emailAddress")).
            andExpect(view().name("registration"));

        mvc.perform(post("/registration").
            param("firstName", "").
            param("lastName", "Smith").
            param("emailAddress", "jsmith@")).
            andExpect(model().attributeHasFieldErrors("registration", "emailAddress")).
            andExpect(view().name("registration"));

    }
}