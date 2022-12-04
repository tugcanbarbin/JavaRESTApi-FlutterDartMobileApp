package com.can.rest.webservices.helloworldwebservices.User;

import com.can.rest.webservices.helloworldwebservices.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.cglib.core.Local;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    UserDaoService service = new UserDaoService();

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> retrieveAllUsers()
    {
        return service.retrieveAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User getUser(@PathVariable int id)
    {
        User res =service.getUser(id);
        if(res == null)
            throw new UserNotFoundException("Id: " + id);
        return res;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        boolean res =service.deleteUser(id);
        if(res == false)
            throw new UserNotFoundException("Id: " + id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/users/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
        User createdUser = service.createUser(user);
        if(createdUser != null)
        {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
        else
            throw new Exception("Could not created");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalized")
    public String HelloWorldInternationalized()
    {
        //
        Locale locale = LocaleContextHolder.getLocale();
        if(locale.getLanguage().equals(Locale.ENGLISH.toString()))
            return "Hello World";
        return "We do not support the language for " + locale.toString();
    }
}
