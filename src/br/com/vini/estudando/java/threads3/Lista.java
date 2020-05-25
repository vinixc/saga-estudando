package br.com.vini.estudando.java.threads3;

public class Lista {
	
	private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento) {
    	this.elementos[indice] = elemento;
        this.indice++;
        
        try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
        
        if(this.indice == this.elementos.length) {
        	System.out.println("Lista cheia Inicia a impressao ai tioooo");
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
        	this.notify();
        }
    } 

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }

}
