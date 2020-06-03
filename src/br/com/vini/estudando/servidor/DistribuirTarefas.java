package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class DistribuirTarefas implements Runnable{

	private Socket socket;
	private ServidorTarefa servidor;
	private ExecutorService threadPool;

	public DistribuirTarefas(ExecutorService threadPool, Socket socket, ServidorTarefa servidor) {
		this.threadPool = threadPool;
		this.socket = socket;
		this.servidor = servidor;
	}

	@Override
	public void run() {
		try {
			
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
			
			while(entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				
				switch(comando) {
				case "c1":
					saidaCliente.println("Confirma��o comando c1");
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c1);
					break;
				case "c2":
					saidaCliente.println("Confirma��o comando c2");
					ComandoC2ChamaWS c2Ws = new ComandoC2ChamaWS(saidaCliente);
					ComandoC2AcessaBanco c2Banco = new ComandoC2AcessaBanco(saidaCliente);
					Future<String> futureWs = this.threadPool.submit(c2Ws);
					Future<String> futureBanco = this.threadPool.submit(c2Banco);
					
					String resultaWs = futureWs.get();
					String resultaBanco = futureBanco.get();
					break;
					
				case "fim":
					saidaCliente.println("Desligando Servidor");
					servidor.parar();
					break;
				
				default:
					saidaCliente.println("comando n�o encontrado");
					break;
				}
				
				System.out.println(comando);
			}
			
			saidaCliente.close();
			entradaCliente.close();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
