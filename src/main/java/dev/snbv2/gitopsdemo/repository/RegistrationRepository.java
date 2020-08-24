package dev.snbv2.gitopsdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.snbv2.gitopsdemo.domain.Registration;

/**
 * JPA CRUD repository for the Registration entity.
 * 
 * @author Brian Jimerson
 */
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    public List<Registration> findByLastName(String lastName);
}