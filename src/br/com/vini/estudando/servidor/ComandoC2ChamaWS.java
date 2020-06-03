package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComandoC2ChamaWS implements Callable<String>{

	private PrintStream saida;

	public ComandoC2ChamaWS(PrintStream saidaCliente) {
		this.saida = saidaCliente;
	}

	@Override
	public String call() throws Exception{
		System.out.println("Servidor recebeu comando C2 - WS");
		saida.println("Processadno Comando c2... - WS");
		
		Thread.sleep(5000);
		
		int numero = new Random().nextInt(100) + 1;
		
		saida.println("Finalizou comando c2 - WS.");
		
		return Integer.toString(numero);
	}
}
