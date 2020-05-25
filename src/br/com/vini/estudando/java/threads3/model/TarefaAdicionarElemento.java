package br.com.vini.estudando.java.threads3.model;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

	private List<String> lista;
	private int numeroThread;

	public TarefaAdicionarElemento(List<String> lista, int numeroThread) {
		this.lista = lista;
		this.numeroThread = numeroThread;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			lista.add("Thread  " +numeroThread + " - " + i);
		}

	}

}
