package br.com.vini.estudando.java.threads2;

public class Principal {
	
	public static void main(String[] args) {
		String nome = "da";
		
		Thread threadAssinatura1 = new Thread(new TarefaBuscaTextual2("assinaturas1.txt", nome));
		Thread threadAssinatura2 = new Thread(new TarefaBuscaTextual2("assinaturas2.txt", nome));
		Thread threadAutores = new Thread(new TarefaBuscaTextual2("autores.txt", nome));
		
		threadAssinatura1.start();
		threadAssinatura2.start();
		threadAutores.start();
	}
}
