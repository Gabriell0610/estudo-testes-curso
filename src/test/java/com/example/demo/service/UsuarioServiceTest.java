package com.example.demo.service;


import com.example.demo.dto.UserDto;
import com.example.demo.entity.TipoPessoa;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void init() {
        ReflectionTestUtils.setField(userService, "userMapper", userMapper);
    }

    @Test
    public void deveTestarPostComSucesso() {
        UserDto dto = new UserDto(
                "Pedro",
                "17116668765",
                "SP",
                34,
                TipoPessoa.PF
        );

        User user = new User();
        user.setTipoPessoa(TipoPessoa.PF);
        user.setNome("Pedro");
        user.setIdade(34);
        user.setCpf("17116668765");
        user.setEstado("SP");

        //comportamentos
        when(userRepository.save(any())).thenReturn(user);

        //ACT
        UserDto retorno = userService.criarUsuario(dto);

        //Assert
        assertNotNull(retorno);
        assertEquals("Pedro", retorno.nome());
        assertEquals(34, retorno.idade());
        assertEquals("17116668765", retorno.cpf());
        assertEquals("SP", retorno.estado());
        assertEquals(TipoPessoa.PF, retorno.tipoPessoa());
    }
}
