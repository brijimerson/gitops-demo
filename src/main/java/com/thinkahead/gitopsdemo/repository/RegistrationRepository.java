package com.thinkahead.gitopsdemo.repository;

import com.thinkahead.gitopsdemo.domain.Registration;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA CRUD repository for the Registration entity.
 * 
 * @author Brian Jimerson
 */
public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}