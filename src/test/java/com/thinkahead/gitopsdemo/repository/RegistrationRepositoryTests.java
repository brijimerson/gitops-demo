package com.thinkahead.gitopsdemo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.thinkahead.gitopsdemo.domain.Registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 * Tests for the RegistrationRepository class.
 * 
 */
@DataJpaTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class RegistrationRepositoryTests {
    
    @Autowired
    RegistrationRepository registrationRepository;

    Registration registration;

    /**
     * Sets up the test case.
     */
    @BeforeEach
    void setUp() {
        registration = new Registration();
        registration.setFirstName("John");
        registration.setLastName("Smith");
        registration.setEmailAddress("jsmith@email.com");
    }

    /**
     * Tests the repository's save method.
     * 
     * @throws Exception
     */
    @Test
    void testSave() throws Exception {
        registration = registrationRepository.save(registration);
        registration = registrationRepository.findById(
            registration.getId()).get();
        assertNotNull(registration);
        assertEquals("John", registration.getFirstName());
        assertEquals("Smith", registration.getLastName());
        assertEquals("jsmith@email.com", registration.getEmailAddress());
    }

    /**
     * Tests the repository's find all method
     * 
     * @throws Exception
     */
    @Test
    void testFindAll() throws Exception {

        List<Registration> registrations = new ArrayList<Registration>();
        for (Registration registration : registrationRepository.findAll()) {
            registrations.add(registration);
        }
        assertTrue(registrations.size() > 0);
        registration = registrations.get(0);
        assertNotNull(registration.getId());
        assertNotNull(registration.getFirstName());
        assertNotNull(registration.getLastName());
        assertNotNull(registration.getEmailAddress());
    }

    /**
     * Tests the repository's deleteById method.
     * 
     * @throws Exception
     */
    @Test
    void testDeleteById() throws Exception {
        registrationRepository.save(registration);
        registrationRepository.deleteById(registration.getId());
        Optional<Registration> r = registrationRepository.findById(1001L);
        assertFalse(r.isPresent());
    }

    /**
     * Tests the repository's delete method.
     * 
     * @throws Exception
     */
    @Test
    void testDelete() throws Exception {
        registrationRepository.save(registration);
        registrationRepository.delete(registration);
        Optional<Registration> r = registrationRepository.findById(1001L);
        assertFalse(r.isPresent());
    }
}