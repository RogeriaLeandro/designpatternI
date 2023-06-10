package br.com.alura.loja.desconto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Desconto {
    
    //instanciar classes filhas  s

    //da classe filha acessar esse atributo: protected
    protected Desconto proximo;


    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }

    //Template Method
    //extend dessa classe e se deveAplicar, faça o desconto sem repetição de código
    public BigDecimal calcular(Orcamento orcamento) {
        if(deveAplicar(orcamento)) {
            return efetuarCalculo(orcamento);
        }
        return proximo.calcular(orcamento);
    }

    protected abstract BigDecimal efetuarCalculo(Orcamento orcamento);
    public abstract boolean deveAplicar(Orcamento orcamento);

}
