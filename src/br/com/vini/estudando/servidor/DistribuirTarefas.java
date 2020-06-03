package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

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
					saidaCliente.println("Confirmação comando c1");
					ComandoC1 c1 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c1);
					break;
				case "c2":
					saidaCliente.println("Confirmação comando c2");
					ComandoC1 c2 = new ComandoC1(saidaCliente);
					this.threadPool.execute(c2);
					break;
					
				case "fim":
					saidaCliente.println("Desligando Servidor");
					servidor.parar();
					break;
				
				default:
					saidaCliente.println("comando não encontrado");
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
