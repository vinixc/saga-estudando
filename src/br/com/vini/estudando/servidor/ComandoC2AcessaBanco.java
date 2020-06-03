package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2AcessaBanco implements Callable<String>{

	private PrintStream saida;

	public ComandoC2AcessaBanco(PrintStream saidaCliente) {
		this.saida = saidaCliente;
	}

	@Override
	public String call() throws Exception{
		System.out.println("Servidor recebeu comando C2 - Banco");
		saida.println("Processadno Comando c2... Banco");
		
		Thread.sleep(25000);
		
		int numero = new Random().nextInt(100) + 1;
		
		saida.println("Finalizou comando c2 - Banco.");
		
		return Integer.toString(numero);
	}
}
