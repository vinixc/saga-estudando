package br.com.vini.estudando.java.nove;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FabricaCollection {
	
	public static void main(String[] args) {
		List<String> nomes = List.of("primeiroNome","segundoNome","terceiroNome");
		Set.of("quartoNome");
		Map<String, String> map = Map.of("nome","joao");
		/*
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("primeiroNome");
		nomes.add("segundoNome");
		nomes.add("terceiroNome");
		
		List<String> nomesImutaveis = Collections.unmodifiableList(nomes);
		System.out.println(nomesImutaveis);
		 */
	}

}
