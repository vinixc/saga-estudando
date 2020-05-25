package br.com.vini.estudando.java.threads3.model;

import br.com.vini.estudando.java.threads3.Lista;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroThread;

	public TarefaAdicionarElemento(Lista lista, int numeroThread) {
		this.lista = lista;
		this.numeroThread = numeroThread;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread  " +numeroThread + " - " + i);
		}

	}

}
