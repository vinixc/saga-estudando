package br.com.vini.estudando.java.dez;

import java.util.HashMap;

public class InteferenciaVariavel {
	
//	var nome = "joao"; n�o pode ser declarado em nivel de class
	
	public static void main(String[] args) {
		var cpfPorNome = new HashMap<String,String>();
		
		cpfPorNome.put("Jo�o", "12345678");
		
		System.out.println(cpfPorNome);
	}

}
