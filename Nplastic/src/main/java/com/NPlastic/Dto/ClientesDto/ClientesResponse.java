package com.NPlastic.Dto.ClientesDto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class ClientesResponse {

    private String nome;

    private String email;

    private String telefone;

    private String senha;

    private LocalDate data;

    public String getNome() {
        return nome;
    }

    public ClientesResponse(String nome, String email, String telefone, String senha, LocalDate data) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.data = data;
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
