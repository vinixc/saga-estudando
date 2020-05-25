package br.com.vini.estudando.java.threads2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TarefaBuscaTextual2 implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual2(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try(BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
			
			int numeroLinha = 1;
			
			String linha = br.readLine();
			while(linha != null) {
				
				if(linha.toLowerCase().contains(nome.toLowerCase())) {
					System.out.println(nomeArquivo + " - "+ numeroLinha +" - " + linha);
				}
				numeroLinha++;
				linha = br.readLine();
			}
			
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
