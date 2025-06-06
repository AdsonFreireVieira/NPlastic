package com.NPlastic.dto.Itens_PedidoDto;

import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class itens_PedidoRequest {

    private Integer Id;

    private int quantidade;

    private Produto produto;

    private Pedido pedido;

}
