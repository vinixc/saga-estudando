package br.com.vini.estudando.java.principais;

import java.util.List;
import java.util.Vector;

import br.com.vini.estudando.java.threads3.model.TarefaAdicionarElemento;

public class PrincipalThread4 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Listas sincronizadas
//		List<String> lista = Collections.synchronizedList(new ArrayList<String>());
		
		//Vector tambem sao thread safe, sincronizados.
		List<String> lista = new Vector<String>();
		
		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}
		
		Thread.sleep(2000);
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " - " + lista.get(i));
		}
	}

}
