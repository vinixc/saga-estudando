package br.com.vini.estudando.reflection.alurator;

import java.lang.reflect.InvocationTargetException;

public class Alurator {
	
	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}
	
	public Object execute(String url) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//processa a requisicao executando o metodo da classe em questao
		//exemplo /produto/lista
		
		String[] partesUrls = url.replaceFirst("/", "")
			.split("/");
		
		String nomeControle = Character.toUpperCase(partesUrls[0].charAt(0)) +
				partesUrls[0].substring(1) + "Controller";
		
		try {
			String fullName = pacoteBase + "." + nomeControle;
			Class<?> classController = Class.forName(fullName);
			
			Object instanciaController = classController.getConstructor().newInstance();
			System.out.println(instanciaController);
			
			return null;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
