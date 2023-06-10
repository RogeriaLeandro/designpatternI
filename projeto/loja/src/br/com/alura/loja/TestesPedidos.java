package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.alura.loja.acao.EnviarEmailPedido;
import br.com.alura.loja.acao.SalvarPedidoNoBancoDeDados;
import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;

public class TestesPedidos {
    
    public static void main(String[] args) {

        String cliente = "Rogeria";
        BigDecimal valorOrcamento = new BigDecimal("300");
        int quantidadeItens = Integer.parseInt("2");

        //chama o COMMAND aqui
        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        
        //OBSERVER
        //ouvintes observadores q ouvem uma determinada ação
        GeraPedidoHandler handler = new GeraPedidoHandler(
                                    Arrays.asList(new SalvarPedidoNoBancoDeDados(),
                                                  new EnviarEmailPedido()
                                    )
        );
        handler.execute(gerador);


    }

}
