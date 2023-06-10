package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;


//Tentamos utilizar o pattern Strategy, se tivesse q usar, teríamos q ter um Desconto como interface
//como não sabemos qual o desconto, não conseguimos montar qual o desconto em classes separadas.
public class CalculadoraDeDescontos {
    
    public BigDecimal calcular(Orcamento orcamento){
        
        //Chain of Responsability
        //encadeia os tipos de descontos
        Desconto cadeiaDeDescontos = new DescontoParaOrcamentoComMaisDeCincoItens(
                            new DescontoParaOrcamentoComValorMaiorQueQuinhentos(
                            new SemDesconto()));

        return cadeiaDeDescontos.calcular(orcamento);
    }

}
