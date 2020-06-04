package br.com.vini.estudando.reflection;

import java.util.Scanner;

import br.com.vini.estudando.reflection.alurator.Alurator;

public class Main {

	/**
	 * Simula o navegador.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Casos possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 */
		
		try (Scanner s = new Scanner(System.in)) {
			String url = s.nextLine();
			
			Alurator alurator = new Alurator("br.com.vini.estudando.reflection.controller");
			while (!url.equals("exit")) {
				Object response = alurator.execute(url);
				
				System.out.println("Response: " + response);
				
				url = s.nextLine();
			}
		}
	}

}
