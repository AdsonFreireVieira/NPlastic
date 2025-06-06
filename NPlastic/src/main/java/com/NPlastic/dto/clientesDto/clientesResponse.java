package com.NPlastic.dto.clientesDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class clientesResponse {


    private String nomeEmpresa;

    private String email;

    private String senha;

    private Enum Role;
}
