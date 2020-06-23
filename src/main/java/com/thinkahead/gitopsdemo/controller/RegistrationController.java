package com.thinkahead.gitopsdemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.thinkahead.gitopsdemo.domain.Registration;
import com.thinkahead.gitopsdemo.repository.RegistrationRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for the registrations list view and registration edit view.
 * 
 * @author Brian Jimerson
 */
@Controller
public class RegistrationController {
    

    @Autowired
    RegistrationRepository registrationRepository;

    private static final Log LOG = LogFactory.getLog(RegistrationController.class);

    /**
     * Method to list all registrations.
     * 
     * @param model The model for the view.
     * @return The view name.
     */
    @GetMapping("/registrations")
    public String getRegistrations(Model model) {

        Iterable<Registration> registrations = registrationRepository.findAll();
        LOG.debug(String.format("Registrations: [%s]", registrations));

        model.addAttribute("registrations", registrations);
        
        return "registrations";
    }

    /**
     * Method to create a new registration
     * 
     * @param model The model for the view.
     * @return The view name.
     */
    @GetMapping("/registration/new")
    public String createRegistration(Model model) {
        
        LOG.debug("Creating new registration.");
        model.addAttribute("registration", new Registration());

        return "registration";
    }

    /**
     * Method to get an existing registration to edit.
     * 
     * @param id The id of the registration to edit.
     * @param model The model for the view.
     * @return The view name.
     */
    @GetMapping("/registration/{id}")
    public String editRegistration(@PathVariable("id") Long id, Model model) {

        Optional<Registration> registration = registrationRepository.findById(id);
        LOG.debug(String.format("Registration to edit: [%s]", registration));

        model.addAttribute("registration", registration.get());

        return "registration";
    }

    /**
     * Method to save a current or new registration.
     * 
     * @param registration The registration to save.
     * @param bindingResult The view form binding result.
     * @param model The model for the view.
     * @return The view name.
     */
    @PostMapping("/registration")
    public String saveRegistration(@Valid Registration registration, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            LOG.debug(String.format("Binding errors found for registration [%s]", registration));
            return "registration";
        }

        registrationRepository.save(registration);
        LOG.debug(String.format("Registration saved: [%s]", registration));

        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("message", "Sucessfully saved registration.");

        return "registrations";
    }

    /**
     * Method to delete an existing registration.
     * 
     * @param id The id of the registration to delete.
     * @param model The model for the view.
     * @return The view name.
     */
    @PostMapping("/registration/delete")
    public String deleteRegistration(@RequestParam("id") Long id, Model model) {

        registrationRepository.deleteById(id);
        LOG.debug(String.format("Deleted registration %d", id));

        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("message", "Successfully deleted registration.");

        return "registrations";
    }
}