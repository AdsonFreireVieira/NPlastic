package com.NPlastic.dto.PedidoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class pedidoRequest {

    private Integer Id;

    private Date data;

    private double valorTotal;

    private int quantidadeItensTotal;

    private List<Itens_Pedido> itens;

    private Clientes clientes;

}
