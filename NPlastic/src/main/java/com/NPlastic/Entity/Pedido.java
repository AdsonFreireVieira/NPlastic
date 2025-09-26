package com.NPlastic.Entity;

import com.NPlastic.dto.Itens_PedidoDto.itens_PedidoRequest;
import com.NPlastic.dto.clientesDto.clientesRequest;
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

    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<itens_PedidoRequest> itensRequest;

    @ManyToOne
    private clientesRequest clienteRequests;

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

    public List<itens_PedidoRequest> getItensRequest() {
        return itensRequest;
    }

    public void setItensRequest(List<itens_PedidoRequest> itensRequest) {
        this.itensRequest = itensRequest;
    }

    public clientesRequest getClienteRequests() {
        return clienteRequests;
    }

    public void setClienteRequests(clientesRequest clienteRequests) {
        this.clienteRequests = clienteRequests;
    }
}