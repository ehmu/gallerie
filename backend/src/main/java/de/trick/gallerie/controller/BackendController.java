package de.trick.gallerie.controller;

import de.trick.gallerie.entity.User;
import de.trick.gallerie.exception.UserNotFoundException;
import de.trick.gallerie.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(path = "/")
    public String sayHello() {
        LOG.info("GET called on /api resource");
        return HELLO_TEXT;
    }

    @ResponseBody
    @RequestMapping(path = "/user/{firstName}/{lastName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        User savedUser = userRepository.save(new User(firstName, lastName, firstName, lastName));

        LOG.info(savedUser.toString() + " successfully saved into DB");

        return savedUser.getId();
    }

    @ResponseBody
    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new UserNotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }

    @ResponseBody
    //@Secured("ADMIN")
    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }
}
