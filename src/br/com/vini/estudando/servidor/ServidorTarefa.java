package br.com.vini.estudando.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServidorTarefa {
	
	private ServerSocket servidor;
	private ExecutorService threadPool;
//	private volatile boolean estaRodando; //Não utilizando o cache mantido pelas threads.
	private AtomicBoolean estaRodando; //Não utilizando o cache mantido pelas threads.
	private BlockingQueue<String> filaComandos;
	private int qtdConsumidores = 2;

	public ServidorTarefa() throws IOException {
		System.out.println("INICIANDO SERVIDOR...");
		this.servidor = new ServerSocket(12345);
		
//		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		ThreadFactory defaultFactory = Executors.defaultThreadFactory();
		this.threadPool = Executors.newCachedThreadPool(new FabricaDeThreads(defaultFactory)); //newCachedThreadPool();
		estaRodando = new AtomicBoolean(true);
//		ScheduledExecutorService poolScheduled = Executors.newScheduledThreadPool(4);
		
		this.filaComandos = new ArrayBlockingQueue<>(2);
		iniciarConsumidores();
	}

	private void iniciarConsumidores() {
		for (int i = 0; i < qtdConsumidores ; i++) {
			TarefaConsumir tarefa = new TarefaConsumir(filaComandos);
			this.threadPool.execute(tarefa);
		}
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
				
				DistribuirTarefas distribuirTarefas = new DistribuirTarefas(threadPool,filaComandos,socket,this);
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
