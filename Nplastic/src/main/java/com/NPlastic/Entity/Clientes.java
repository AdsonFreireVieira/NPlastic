package com.NPlastic.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="tbl_Clientes")
public class Clientes {


    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;

    @Column
    private String senha;

    @Column
    private LocalDate data;

    @OneToMany(mappedBy = "clientes" , cascade = CascadeType.ALL)
   private List<Endereco> enderecoList;

    @OneToMany(mappedBy = "clientes",cascade = CascadeType.ALL)
    private List<Pedido> pedidoList;

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
