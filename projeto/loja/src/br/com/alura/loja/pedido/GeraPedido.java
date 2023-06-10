package br.com.alura.loja.pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedido {
    private String cliente;
    private BigDecimal valorOrcamento;
    private int quantidadeItens;

    //COMMAND - padrão q cuida da execução em separado de algum processo.
    //injeção de dependência: PedidoRepository,  EmailService...
    public GeraPedido(String cliente, BigDecimal valorOrcamento, int quantidadeItens) {
        this.cliente = cliente;
        this.valorOrcamento = valorOrcamento;
        this.quantidadeItens = quantidadeItens;
    }

    public String getCliente() {
        return this.cliente;
    }

     public BigDecimal getValorOrcamento() {
        return this.valorOrcamento;
    }

    public int getQuantidadeItens() {
        return this.quantidadeItens;
    }
}


//COMMAND HANDLER
//Separar dados das execuções
