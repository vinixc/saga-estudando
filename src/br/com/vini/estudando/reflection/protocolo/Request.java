package br.com.vini.estudando.reflection.protocolo;

public class Request {

	private String nomeControle;
	private String nomeMetodo;

	public Request(String url) {
		// processa a requisicao executando o metodo da classe em questao
		// exemplo /produto/lista

		String[] partesUrls = url.replaceFirst("/", "").split("/");

		this.nomeControle = Character.toUpperCase(partesUrls[0].charAt(0)) + partesUrls[0].substring(1)
				+ "Controller";
		
		this.nomeMetodo = partesUrls[1];
	}
	
	public String getNomeMetodo() {
		return nomeMetodo;
	}

	public String getNomeControle() {
		return nomeControle;
	}
}
