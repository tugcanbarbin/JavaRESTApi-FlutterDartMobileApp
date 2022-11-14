package com.can.rest.webservices.helloworldwebservices.User;

import com.can.rest.webservices.helloworldwebservices.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        boolean success = service.createUser(user);
        if(success)
            return ResponseEntity.created(null).build();
        else
            throw new Exception("Could not created");
    }

}
