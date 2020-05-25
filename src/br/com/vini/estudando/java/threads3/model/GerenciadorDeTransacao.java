package br.com.vini.estudando.java.threads3.model;

public class GerenciadorDeTransacao {
	
	public void begin() {
		System.out.println("Começando a transacao");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
