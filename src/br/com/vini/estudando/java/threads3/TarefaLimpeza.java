package br.com.vini.estudando.java.threads3;

import br.com.vini.estudando.java.threads3.model.Banheiro;

public class TarefaLimpeza implements Runnable {

	private Banheiro banheiro;
	

	public TarefaLimpeza(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		
		while(true) {
			banheiro.limpa();
			
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
