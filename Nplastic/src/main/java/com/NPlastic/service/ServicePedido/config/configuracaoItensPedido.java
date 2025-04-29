package com.NPlastic.service.ServicePedido.config;


import com.NPlastic.Entity.Itens_Pedido;
import com.NPlastic.Entity.Pedido;
import com.NPlastic.Entity.Produto;
import com.NPlastic.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class configuracaoItensPedido {

    @Autowired
    private ProdutoRepository repository;


    public double calculaValorTotal(Pedido pedido) {


        return pedido.getItens().stream().mapToDouble(itens -> itens.getValorItens()).sum();
    }

    public double calculaValorProduto(Pedido pedido) {

        for(Itens_Pedido itens : pedido.getItens()){

            int id = itens.getProduto().getId_Produto();
               Produto produto = repository.findById(id).orElse(null);
          return   produto.getValorKg()* produto.getPeso();



        }
        return 0;
    }

    public Produto retornaProdutoCadastrado(Pedido pedido) {

        for (Itens_Pedido item : pedido.getItens()) {
            int idProduto = item.getProduto().getId_Produto();
            return repository.findById(idProduto).orElse(null);
        }
        return null;
    }

}