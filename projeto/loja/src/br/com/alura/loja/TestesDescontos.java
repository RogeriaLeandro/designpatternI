package br.com.alura.loja;


import java.math.BigDecimal;
import br.com.alura.loja.desconto.CalculadoraDeDescontos;
import br.com.alura.loja.orcamento.Orcamento;


public class TestesDescontos {
    
    public static void main(String[] args) {
    
        Orcamento primeiro = new Orcamento(new BigDecimal(200), 6);
        Orcamento segundo = new Orcamento(new BigDecimal(1000), 1);

        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        System.out.println(calculadoraDeDescontos.calcular(primeiro));
        System.out.println(calculadoraDeDescontos.calcular(segundo));

    }
    
}