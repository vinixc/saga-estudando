package br.com.vini.estudando.java.quatorze;

public class SwitchExpressions {
	
	public static void main(String[] args) {
		String nome = "Joao";
		
		switch(nome) {
		case "Renata" -> System.out.println("Acertou: " + nome);
		case "Joao" -> System.out.println("Acertou: " + nome);
		default -> System.out.println("Nenhum nome encontrado.");
		}
	}

}
