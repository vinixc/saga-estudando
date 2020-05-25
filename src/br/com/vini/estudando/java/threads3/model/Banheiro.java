package br.com.vini.estudando.java.threads3.model;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta.");
		synchronized (this) {
			try {

				System.out.println(nome + " Entrando no banheiro");
				
				if(ehSujo) {
					esperaLaFora(nome);
				}
				
				System.out.println(nome + " fazendo coisa rapida");

				Thread.sleep(5000);
				System.out.println(nome + " dando descarga");
				System.out.println(nome + " lavando a mao");
				System.out.println(nome + " saindo do banheiro");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta.");
		synchronized (this) {
			try {
				System.out.println(nome + " entrando no banheiro");
				
				if(ehSujo) {
					esperaLaFora(nome);
				}
				
				System.out.println(nome + " fazendo coisa demorada");

				Thread.sleep(10000);
				System.out.println(nome + " dando descarga");
				System.out.println(nome + " lavando a mao");
				System.out.println(nome + " saindo do banheiro");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " batendo na porta.");
		
		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");
			
			if(!ehSujo) {
				System.out.println(nome + " não esta sujo, vou sair.");
				return;
			}
			
			System.out.println(nome + " Limpando banheiro");
			this.ehSujo = false;
			
			try {
				Thread.sleep(13000);
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
			
			this.notifyAll();
			System.out.println(nome + " saindo do banheiro");
		}
		
	}
	
	private void esperaLaFora(String nome) throws InterruptedException {
		System.out.println(nome + ", eca, banheiro ta sujo");
		this.wait();
	}
}
