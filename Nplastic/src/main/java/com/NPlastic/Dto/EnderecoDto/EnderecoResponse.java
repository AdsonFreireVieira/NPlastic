package com.NPlastic.Dto.EnderecoDto;

import com.NPlastic.Entity.Clientes;

public class EnderecoResponse {


    private String numero;

    private int cep;

    private String cidade;

    private String bairro;


    private String estado;

    private Clientes clientes;

    public String getNumero() {
        return numero;
    }

    public EnderecoResponse() {
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
