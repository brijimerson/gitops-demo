package com.thinkahead.gitopsdemo.repository;

import java.util.List;

import com.thinkahead.gitopsdemo.domain.Registration;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA CRUD repository for the Registration entity.
 * 
 * @author Brian Jimerson
 */
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

    public List<Registration> findByLastName(String lastName);
}