package br.com.vini.estudando.java.threads3.model;

public class Banheiro {
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta.");
		synchronized (this) {
			try {

				System.out.println(nome + " Entrando no banheiro");
				System.out.println(nome + " fazendo coisa rapida");

				Thread.sleep(5000);
				System.out.println(nome + " dando descarga");
				System.out.println(nome + " lavando a mao");
				System.out.println(nome + " saindo do banheiro");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta.");
		synchronized (this) {
			try {
				System.out.println(nome + " entrando no banheiro");
				System.out.println(nome + " fazendo coisa demorada");

				Thread.sleep(10000);
				System.out.println(nome + " dando descarga");
				System.out.println(nome + " lavando a mao");
				System.out.println(nome + " saindo do banheiro");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
