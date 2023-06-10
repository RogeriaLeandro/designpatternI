package br.com.alura.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.loja.acao.AcaoAposGerarPedido;
import br.com.alura.loja.acao.EnviarEmailPedido;
import br.com.alura.loja.acao.SalvarPedidoNoBancoDeDados;
import br.com.alura.loja.orcamento.Orcamento;

public class GeraPedidoHandler {
    
    //construtor com injeção de dependências: Repository, services, etc...

    private List<AcaoAposGerarPedido> acoes;


    //recebe todas os metodos q implementam a interface AcçaoAposGerarPedido
    //OBSERVER
    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }


    //OBSERVER - observadores, ouvintes q estão serão executados qdo chamados. 
    //Quem tiver observando, vai ser notificada e executada
    //INVERSÃO DE CONTROLE
    public void execute(GeraPedido dados) {

        //Pode crescer a medida q o sistema cresce e surgem novas transações, várias execuções//
        //Usar OBSERVER
        Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens(), null);
        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(a -> a.executarAcao(pedido));


        // EnviarEmailPedido email = new EnviarEmailPedido();
        // SalvarPedidoNoBancoDeDados salvar = new SalvarPedidoNoBancoDeDados();

        // email.executar(pedido);
        // salvar.executar(pedido);

    }
    

}
