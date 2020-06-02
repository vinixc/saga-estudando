package br.com.vini.estudando.servidor;

import java.net.Socket;

public class DistribuirTarefas implements Runnable{

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			
			System.out.println("Aceitando novo cliente na porta: " + socket.getPort());
			Thread.sleep(20000);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
