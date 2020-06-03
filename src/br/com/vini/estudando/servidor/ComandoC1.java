package br.com.vini.estudando.servidor;

import java.io.PrintStream;

public class ComandoC1 implements Runnable{

	private PrintStream saida;

	public ComandoC1(PrintStream saidaCliente) {
		this.saida = saidaCliente;
	}

	@Override
	public void run() {
		System.out.println("Executando comando C1");
		
		try {
			Thread.sleep(20000);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		saida.println("Comando c1 executado com sucesso!");
	}
}
