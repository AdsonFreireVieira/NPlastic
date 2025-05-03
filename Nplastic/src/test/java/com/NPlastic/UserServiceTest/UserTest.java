package com.NPlastic.UserServiceTest;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.repository.ClientesRepository;
import com.NPlastic.service.ServiceUser.ClienteServiceEmpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private ClientesRepository clientesRepository ;

    @InjectMocks
    private ClienteServiceEmpl clienteServiceEmpl;

    @BeforeEach
    void setup(){
    }

    @Test
        void CreateUserTeste(){
        Clientes clientes =  new Clientes(1, "Augusto","Augusto@Gmail.com","993423233","admin",LocalDate.of(2024,02,23));

        when(clientesRepository.save(clientes)).thenReturn(clientes);

        Clientes result = clienteServiceEmpl.criar(clientes);
    }



}
