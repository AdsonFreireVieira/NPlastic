package com.NPlastic.dto.clientesDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class clientesRequest {

   private Integer Id;

    private String nomeEmpresa;

    private String email;

    private String senha;

    private Enum Role;
}
