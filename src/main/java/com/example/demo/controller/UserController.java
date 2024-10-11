package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserEditDto;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto criarUsuario(@RequestBody UserDto userDto) {
        return userService.criarUsuario(userDto);
    }

    @GetMapping
    public List<UserDto> listarUsuario() {
        return userService.listarUsuario();
    }

    @PutMapping("/{id}")
    public UserEditDto editarUsuario(@RequestBody UserEditDto userEditDto, @PathVariable String id) throws Exception {
        return userService.editarUsuario(userEditDto, id);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Integer id) {
        return userService.deletarUsuario(id);
    }

}
