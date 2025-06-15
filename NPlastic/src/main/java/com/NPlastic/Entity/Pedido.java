package com.NPlastic.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Date data;

    @Column
    private double valorTotal;

    @Column
    private int quantidadeItensTotal;

    @OneToMany(mappedBy ="pedido", cascade = CascadeType.ALL)
    private List<Itens_Pedido> itens;

    @ManyToOne
    private Clientes clientes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
