package br.com.vini.estudando.java.principais;

import br.com.vini.estudando.java.threads3.Lista;
import br.com.vini.estudando.java.threads3.TarefaImprimir;
import br.com.vini.estudando.java.threads3.model.TarefaAdicionarElemento;

public class PrincipalThread4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Listas sincronizadas
//		List<String> lista = Collections.synchronizedList(new ArrayList<String>());
		
		//Vector tambem sao thread safe, sincronizados.
//		List<String> lista = new Vector<String>();
		Lista lista = new Lista();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}
		
		new Thread(new TarefaImprimir(lista)).start();
		
		Thread.sleep(2000);
		
	}

}
