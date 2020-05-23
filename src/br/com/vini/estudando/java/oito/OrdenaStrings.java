package br.com.vini.estudando.java.oito;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class OrdenaStrings {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		palavras.sort((s1,s2) -> Integer.compare(s1.length(), s2.length()) );
		
		palavras.sort(comparing(String::length));
		
		Function<String, Integer> funcao = String::length;
		Comparator<String> comparator = Comparator.comparing(funcao);
		palavras.sort(comparator);
		
		System.out.println(palavras);
		
		
		palavras.forEach(System.out::println);
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}

