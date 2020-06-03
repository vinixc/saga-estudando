package br.com.vini.estudando.servidor;

import java.io.PrintStream;

public class ComandoC2 implements Runnable{

	private PrintStream saida;

	public ComandoC2(PrintStream saidaCliente) {
		this.saida = saidaCliente;
	}

	@Override
	public void run() {
		System.out.println("Executando comando C2");
		
		try {
			Thread.sleep(20000);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		saida.println("Comando c2 executado com sucesso!");
	}
}
