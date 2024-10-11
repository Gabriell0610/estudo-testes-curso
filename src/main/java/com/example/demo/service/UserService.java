package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserEditDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
    }

    public UserDto criarUsuario(UserDto dto) {

        User userEntity = userMapper.toEntity(dto);
        User userSalvo = userRepository.save(userEntity);
        return userMapper.toDto(userSalvo);
    }

    public List<UserDto> listarUsuario() {
        List<UserDto> userDto = userRepository.findAll()
                .stream()
                .map(data -> userMapper.toDto(data))
                .toList();
        return userDto;
    }

    public UserEditDto editarUsuario(UserEditDto dto, String id) throws Exception {
        var parseId = Integer.parseInt(id);
        Optional<User> existUser = userRepository.findById(parseId);

        if(existUser.isPresent()) {
            User user = existUser.get();
            user.setNome(dto.nome());
            user.setIdade(dto.idade());
            user.setTipoPessoa(dto.tipoPessoa());

            User userSaved = userRepository.save(user);

            return userMapper.toEditDto(userSaved);
        }else {
            throw new RuntimeException("Usuário não encontrado com o id ");
        }

    }

    public String deletarUsuario(Integer id) {
        userRepository.deleteById(id);
        return "Usuário deletado com sucesso!";
    }
}
