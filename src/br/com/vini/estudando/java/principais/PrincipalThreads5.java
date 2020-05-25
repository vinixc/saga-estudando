package br.com.vini.estudando.java.principais;

import br.com.vini.estudando.java.threads3.TarefaAcessaBanco;
import br.com.vini.estudando.java.threads3.TarefaAcessaBancoProcedimento;
import br.com.vini.estudando.java.threads3.model.GerenciadorDeTransacao;
import br.com.vini.estudando.java.threads3.model.PoolDeConexao;

public class PrincipalThreads5 {
	
	public static void main(String[] args) {
		GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
		PoolDeConexao pool = new PoolDeConexao();
		
		new Thread(new TarefaAcessaBanco(pool,tx)).start();
		new Thread(new TarefaAcessaBancoProcedimento(pool,tx)).start();
	}

}
