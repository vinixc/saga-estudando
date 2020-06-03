package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JuntaResultadosFutureWsFutureBanco implements Callable<Void> {

	private Future<String> futureWs;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadosFutureWsFutureBanco(Future<String> futureWs, Future<String> futureBanco,
			PrintStream saidaCliente) {
				this.futureWs = futureWs;
				this.futureBanco = futureBanco;
				this.saidaCliente = saidaCliente;
	}

	@Override
	public Void call(){
		System.out.println("Aguardando resultados do futureWs e Banco");
		
		try {
			String resultaWs = futureWs.get(15,TimeUnit.SECONDS);
			String resultaBanco = futureBanco.get(15,TimeUnit.SECONDS);
			
			this.saidaCliente.println("Resultado comando c2: " + resultaBanco + ", " + resultaWs);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			
			this.saidaCliente.println("Timeout da execucao do comando C2");
			this.futureWs.cancel(true);
			this.futureBanco.cancel(true);
		}
		
		System.out.println("Finalizou JuntaResultadosFutureWsFutureBanco");
		return null;
	}

}
