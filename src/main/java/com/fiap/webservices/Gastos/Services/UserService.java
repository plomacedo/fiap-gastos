package com.fiap.webservices.Gastos.Services;

import com.fiap.webservices.Gastos.DTO.UserDTO;
import com.fiap.webservices.Gastos.Entity.User;
import com.fiap.webservices.Gastos.Mapper.UserMapper;
import com.fiap.webservices.Gastos.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService{

    @Autowired
    private UserRepository repository;

    public UserDTO createUser(UserDTO userDTO){
        User entity = UserMapper.mapToUser(userDTO);
        User savedUser = repository.save(entity);
        UserDTO savedUserDTO = UserMapper.maptoUserDTO(savedUser);
        return savedUserDTO;
    }

    public UserDTO findUserById(Long id){
        User entity = repository.findById(id).get();
        UserDTO dto = new UserDTO(entity);
        return dto;
    }

    public List<UserDTO> getAllUsers() {
        List<User> entities = repository.findAll();
        return entities.stream().map( UserMapper::maptoUserDTO)
                .collect( Collectors.toList());
    }


}
