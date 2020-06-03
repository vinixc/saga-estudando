package br.com.vini.estudando.servidor;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistribuirTarefas implements Runnable{

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
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
					break;
				case "c2":
					saidaCliente.println("Confirma��o comando c2");
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
