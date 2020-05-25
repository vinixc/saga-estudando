package br.com.vini.estudando.java.threads3;

import br.com.vini.estudando.java.threads3.model.Banheiro;

public class TarefaNumero2 implements Runnable {

	private Banheiro banheiro;
	

	public TarefaNumero2(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		banheiro.fazNumero2();
	}

}
