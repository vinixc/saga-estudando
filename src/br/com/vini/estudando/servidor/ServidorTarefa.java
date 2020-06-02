package br.com.vini.estudando.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarefa {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("INICIANDO SERVIDOR...");
		ServerSocket servidor = new ServerSocket(12345);
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta " + socket.getPort());
		}
		
	}

}
