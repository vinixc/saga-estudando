package br.com.vini.estudando.java.principais;

import br.com.vini.estudando.java.threads3.Lista;
import br.com.vini.estudando.java.threads3.model.TarefaAdicionarElemento;

public class PrincipalThread4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Lista lista = new Lista();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}
		
		Thread.sleep(2000);
		
		for (int i = 0; i < lista.tamanho(); i++) {
			System.out.println(lista.pegaElemento(i));
		}
	}

}
