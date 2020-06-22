package br.com.vini.estudando.reflection;

import br.com.vini.estudando.reflection.controller.SubControle;

public class TesteInstanciaObjetoCorretamente {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException {
		
		Class<SubControle> subControleClasse1 = SubControle.class;
		
		Class<?> subControleClasse2 = 
				Class.forName("br.com.vini.estudando.reflection.controller.SubControle");
		
		Class<?> controleClasse1 = 
				Class.forName("br.com.vini.estudando.reflection.controller.Controle");
		
//		Constructor<SubControle> construtorSubControle
//									= subControleClasse1.getConstructor(String.class);
		
//		Constructor<SubControle> construtorSubControle
//									= subControleClasse1.getDeclaredConstructor();
//		
//		System.out.println(construtorSubControle);
//		
//		construtorSubControle.setAccessible(true);
//		SubControle subControle = construtorSubControle.newInstance();
//		
//		System.out.println(subControle);
		
//		try {
//			controleClasse1.getDeclaredConstructor().newInstance();
//		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
//				| NoSuchMethodException | SecurityException e) {
//			e.printStackTrace();
//		}
		
//		controleClasse1.newInstance();
	}

}
