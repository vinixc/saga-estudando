package br.com.vini.estudando.reflection.alurator.reflexao;

import java.lang.reflect.Method;

public class ManipuladorObjeto {

	private Object instancia;

	public ManipuladorObjeto(Object instancia) {
		this.instancia = instancia;
	}

	public ManipuladorMetodo getMetodo(String nomeMetodo) {
		Method metodo;
		try {
			metodo = instancia.getClass().getDeclaredMethod(nomeMetodo);
			return new ManipuladorMetodo(instancia,metodo);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
