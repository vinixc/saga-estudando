package br.com.vini.estudando.java.threads;

import java.util.Set;

public class ListandoTodasAsThreads {
	
	public static void main(String[] args) {
		Set<Thread> todasAsThreads = Thread.getAllStackTraces().keySet();
		
		todasAsThreads.forEach(thread -> System.out.println(thread.getName()));
	}

}
