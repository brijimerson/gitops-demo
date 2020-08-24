package dev.snbv2.gitopsdemo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dev.snbv2.gitopsdemo.domain.Registration;

/**
 * Tests for the Registration domain class.
 * 
 * @author Brian Jimerson
 */
@SpringBootTest
public class RegistrationTests {

    private Registration registration;

    /**
     * Sets up the test case
     */
    @BeforeEach
    void setUp() {
        registration = new Registration();
        registration.setId(1L);
        registration.setFirstName("John");
        registration.setLastName("Smith");
        registration.setEmailAddress("jsmith@email.com");
    }

    /**
     * Tests the getId method.
     * 
     * @throws Exception
     */
    @Test
    void testGetId() throws Exception {
        assertEquals(1L, registration.getId());

    }

    /**
     * Tests the getFirstName method.
     * 
     * @throws Exception
     */
    @Test
    void testGetFirstName() throws Exception {
        assertEquals("John", registration.getFirstName());
    }

    /**
     * Tests the getLastName method.
     * 
     * @throws Exception
     */
    @Test
    void testGetLastName() throws Exception {
        assertEquals("Smith", registration.getLastName());
    }

    /**
     * Tests the getEmailAddress method.
     * 
     * @throws Exception
     */
    @Test
    void testGetEmailAddress() throws Exception {
        assertEquals("jsmith@email.com", registration.getEmailAddress());
    }

    /**
     * Tests the toString method.
     * 
     * @throws Exception
     */
    @Test
    void testToString() throws Exception {
        assertEquals(
            "Registration: [id=1, firstName=John, lastName=Smith, " +
            "emailAddress=jsmith@email.com]",
            registration.toString());
    }
    
}