package br.com.vini.estudando.java.threads;

public class ProcessadoresDisponiveis {
	
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		int qtdProcessadores = runtime.availableProcessors();
		System.out.println("QTD PROCESSADORES: " + qtdProcessadores);
	}
}
