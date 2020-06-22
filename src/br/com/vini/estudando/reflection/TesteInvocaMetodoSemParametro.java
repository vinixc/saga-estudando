package br.com.vini.estudando.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> subControleClasse = 
				Class.forName("br.com.vini.estudando.reflection.controller.SubControle");
		
		
		Constructor<?> construtorPadrao = subControleClasse.getDeclaredConstructor();
		construtorPadrao.setAccessible(true);
		
		Object subControle = construtorPadrao.newInstance();
		
		for(Method m : subControleClasse.getMethods()) {
			System.out.println(m);
		}
		
		System.out.println("------------------------------------------------------");
		
		for(Method m : subControleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		Method method = subControleClasse.getDeclaredMethod("metodoSubControle2");
		method.setAccessible(true);
		Object retorno = method.invoke(subControle);
		
		System.out.println(retorno);
		
	}

}
