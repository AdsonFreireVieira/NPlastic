package com.NPlastic.dto.PedidoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;

import java.util.Date;
import java.util.List;


public class pedidoRequest {

    private Integer Id;

    private Date data;

    private double valorTotal;

    private int quantidadeItensTotal;

    private List<Itens_Pedido> itens;

    private Clientes clientes;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidadeItensTotal() {
        return quantidadeItensTotal;
    }

    public void setQuantidadeItensTotal(int quantidadeItensTotal) {
        this.quantidadeItensTotal = quantidadeItensTotal;
    }

    public List<Itens_Pedido> getItens() {
        return itens;
    }

    public void setItens(List<Itens_Pedido> itens) {
        this.itens = itens;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
