package br.com.vini.estudando.reflection;

import br.com.vini.estudando.reflection.controller.Controle;

public class TesteInstanciaObjeto {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//url -> /controle/lista
		
		Class<Controle> controleClasse1 = Controle.class;
		
		Controle controle = new Controle();
		Class<? extends Controle> controleClasse2 = controle.getClass();
		
		Class<?> controleClasse3 
			= Class.forName("br.com.vini.estudando.reflection.controller.Controle");
		
		Controle objetoControle = controleClasse1.newInstance();
		
		Object outroObjetoControle = controleClasse3.newInstance();
		
		System.out.println(objetoControle instanceof Controle);
		System.out.println(outroObjetoControle instanceof Controle);
		
	}

}
