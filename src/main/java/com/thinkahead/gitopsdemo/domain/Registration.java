package com.thinkahead.gitopsdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Entity object for a registration entry.
 * 
 * @author Brian Jimerson
 */
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull(message="First name is required.")
    @Size(min=3, max=50, message="First name should be between 3 and 50 characters.")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message="Last name is required.")
    @Size(min=3, max=50, message="Last name should be between 3 and 50 characters.")
    private String lastName;

    @Column(name = "email_address")
    @NotNull(message="Email address is required.")
    @Size(min=3, max=50, message="Email address should be between 3 and 50 characters.")
    @Email(message="Please enter a valid email address.")
    private String emailAddress;

    /**
     * Gets the id of the registration.
     * 
     * @return The id of the registration.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the registration.
     * 
     * @param id The id of the registration.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the registration.
     * 
     * @return The first name of the registration.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the registration.
     * 
     * @param firstName The first name of the registration.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the registration.
     * 
     * @return The last name of the registration.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the registration.
     * 
     * @param lastName The last name of the registration.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the registration.
     * 
     * @return The email address of the registration.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the registration.
     * 
     * @param emailAddress The email address of the registration.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Overrides Object's toString method.
     * 
     * @return A string representation of this registration.
     * @see Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Registration: [");
        sb.append(String.format("id=%d, ", this.getId()));
        sb.append(String.format("firstName=%s, ", this.getFirstName()));
        sb.append(String.format("lastName=%s, ", this.getLastName()));
        sb.append(String.format("emailAddress=%s]", this.getEmailAddress()));
        return sb.toString();
    }

    
}