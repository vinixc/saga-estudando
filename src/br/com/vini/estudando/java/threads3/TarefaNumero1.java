package br.com.vini.estudando.java.threads3;

import br.com.vini.estudando.java.threads3.model.Banheiro;

public class TarefaNumero1 implements Runnable {

	private Banheiro banheiro;
	

	public TarefaNumero1(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		banheiro.fazNumero1();
	}

}
