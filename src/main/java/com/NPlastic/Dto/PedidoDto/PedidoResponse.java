package com.NPlastic.Dto.PedidoDto;

import com.NPlastic.Entity.Clientes;
import com.NPlastic.Entity.Itens_Pedido;

import java.time.LocalDate;
import java.util.List;

public class PedidoResponse {


    private LocalDate data;

    private String status;

    private int quantidade;

    private double valorTotal;

    private List<Itens_Pedido> itens;

    private Clientes clientes;


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
