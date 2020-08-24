package dev.snbv2.gitopsdemo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the index view.
 * 
 * @author Brian Jimerson
 */
@Controller
public class IndexController {

    private static final Log LOG = LogFactory.getLog(IndexController.class);
    
    /**
     * Index view method.
     * 
     * @param model The model for the view.
     * @return The view name.
     */
    @GetMapping("/index")
    public String index(Model model) {

        String podName = System.getenv("POD_NAME");
        String podNamespace = System.getenv("POD_NAMESPACE");
        String podIp = System.getenv("POD_IP");

        LOG.debug(String.format("Pod attributes: [Name: %s, namespace: %s, IP: %s]", 
            podName, podNamespace, podIp));
        
        model.addAttribute("podName", podName);
        model.addAttribute("podNamespace", podNamespace);
        model.addAttribute("podIp", podIp);
        
        return "index";
    }
    
}