package br.com.vini.estudando.servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorTarefa {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("INICIANDO SERVIDOR...");
		ServerSocket servidor = new ServerSocket(12345);
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
			threadPool.execute(distribuirTarefas);
		}
		
	}

}
