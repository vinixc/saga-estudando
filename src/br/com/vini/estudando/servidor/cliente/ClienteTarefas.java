package br.com.vini.estudando.servidor.cliente;

import java.net.Socket;

public class ClienteTarefas {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("Conexao estabelecida...");
		
		socket.close();
	}

}
