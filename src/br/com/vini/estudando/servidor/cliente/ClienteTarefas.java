package br.com.vini.estudando.servidor.cliente;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTarefas {
	
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12345);
		
		System.out.println("Conexao estabelecida...");
		
		PrintStream saida = new PrintStream(socket.getOutputStream());
		saida.println("c1");
		
		Scanner teclado = new Scanner(System.in);
		teclado.nextLine();
		
		saida.close();
		socket.close();
		teclado.close();
	}

}
