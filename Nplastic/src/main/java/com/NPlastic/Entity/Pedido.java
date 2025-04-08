package com.NPlastic.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tbl_Pedido")
public class Pedido {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Integer Id;

    @Column
    private LocalDate data;

    @Column
    private String status;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("pedido")
    private List<Itens_Pedido> itens;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Clientes clientes;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<Itens_Pedido> getItens() {
        return itens;
    }

    public void setItens(List<Itens_Pedido> itens) {
        this.itens = itens;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
