package br.com.vini.estudando.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefa {
	
	private ServerSocket servidor;
	private ExecutorService threadPool;
//	private volatile boolean estaRodando; //Não utilizando o cache mantido pelas threads.
	private AtomicBoolean estaRodando; //Não utilizando o cache mantido pelas threads.

	public ServidorTarefa() throws IOException {
		System.out.println("INICIANDO SERVIDOR...");
		this.servidor = new ServerSocket(12345);
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		this.threadPool = Executors.newCachedThreadPool();
		estaRodando = new AtomicBoolean(true);
//		ScheduledExecutorService poolScheduled = Executors.newScheduledThreadPool(4);
	}

	public void parar() throws IOException {
		estaRodando = new AtomicBoolean(false);
		servidor.close();
		threadPool.shutdown();
	}

	public void rodar() throws IOException {
		while(this.estaRodando.get()) {
			try {
				Socket socket = servidor.accept();
				System.out.println("Aceitando novo cliente na porta " + socket.getPort());
				
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket,this);
				threadPool.execute(distribuirTarefas);
				
				//executamos uma tarefa a cada 60 minutos
//			poolScheduled.scheduleAtFixedRate(distribuirTarefas, 0, 60, TimeUnit.MINUTES);
			} catch (SocketException e) {
				System.out.println("SocketException, Está rodando? " + this.estaRodando);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		ServidorTarefa servidor = new ServidorTarefa();
		servidor.rodar();
		servidor.parar();
		
	}
}
