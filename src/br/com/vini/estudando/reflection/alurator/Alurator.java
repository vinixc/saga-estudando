package br.com.vini.estudando.reflection.alurator;

import java.lang.reflect.InvocationTargetException;

import br.com.vini.estudando.reflection.alurator.reflexao.Reflexao;
import br.com.vini.estudando.reflection.protocolo.Request;

public class Alurator {

	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
	}

	public Object execute(String url)
			throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Request request = new Request(url);

		String nomeControle = request.getNomeControle();

		Object instanciaController = new Reflexao().refleteClasse(pacoteBase +"."+ nomeControle).getConstrutorPadrao()
				.invoca();

//			String fullName = pacoteBase + "." + nomeControle;
//			Class<?> classController = Class.forName(fullName);
//			
//			Object instanciaController = classController.getConstructor().newInstance();
		
		System.out.println(instanciaController);

		return null;
	}
}
