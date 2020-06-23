package br.com.vini.estudando.reflection;

import java.lang.reflect.Field;

import br.com.vini.estudando.reflection.anotacao.NomeTagXml;
import br.com.vini.estudando.reflection.modelo.Produto;

public class TesteManipulaAtributos {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
		
		Produto produto = new Produto("Game", 500, "xbosta");
		
		Class<? extends Produto> classe = produto.getClass();
		Field[] fields2 = classe.getDeclaredFields();
		
		for(Field f : fields2) {
			NomeTagXml anotationField = f.getDeclaredAnnotation(NomeTagXml.class);
			if(anotationField != null) {
				String value = anotationField.value();
				System.out.println(value);
			}
		}
		
		NomeTagXml nomeTagXml = classe.getDeclaredAnnotation(NomeTagXml.class);
		
		if(nomeTagXml != null) {
			String value = nomeTagXml.value();
			System.out.println(value);
		}
		
		Class<?> classe2 = Class.forName("br.com.vini.estudando.reflection.modelo.Produto");
		
		Field[] fields = classe2.getDeclaredFields();
		
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		
		Field field = classe2.getDeclaredField("nome");
		
		System.out.println(field);
	}
}
