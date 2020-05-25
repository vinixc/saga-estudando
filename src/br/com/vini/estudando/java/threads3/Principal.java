package br.com.vini.estudando.java.threads3;

import br.com.vini.estudando.java.threads3.model.Banheiro;

public class Principal {
	
	public static void main(String[] args) {
		Banheiro banheiro = new Banheiro();
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "Joao");
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread convidado3 = new Thread(new TarefaNumero1(banheiro), "Claudio");
		Thread convidado4 = new Thread(new TarefaNumero2(banheiro), "Jose");
		
		convidado1.start();
		convidado2.start();
		convidado3.start();
		convidado4.start();
	}

}
