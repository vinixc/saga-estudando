package br.com.vini.estudando.reflection.controller;

public class SubControle extends Controle{
	
	private SubControle(){}
	
	private SubControle(String s){}
	
	public void metodoSubControle1() {
		System.out.println("Executando metodo SubControle.metodoSubControle1()");
	}
	
	private String metodoSubControle2() {
		System.out.println("Executando metodo SubControle.metodoSubControle2()");
		
		return "retorno do m�todo SubControle.metodoSubControle2()";
	}

}
