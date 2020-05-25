package br.com.vini.estudando.java.threads3.model;

public class PoolDeConexao {
	
	public String getConnection() {
		
		System.out.println("Emprestando conexao");
		
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		return "connection";
		
	}

}
