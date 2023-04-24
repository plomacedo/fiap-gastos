package com.fiap.webservices.Gastos.Controller;

import com.fiap.webservices.Gastos.DTO.UserDTO;
import com.fiap.webservices.Gastos.Services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(value="API REST Users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value="this method creates a new user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO savaedUser = userService.createUser(user);
        return new ResponseEntity<>(savaedUser, HttpStatus.CREATED);
    }
    @GetMapping
    @ApiOperation(value="this method returns the list of all users")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="this method returns a single user by id")
    public UserDTO findById(@PathVariable Long id){
        return userService.findUserById(id);
    }

}
