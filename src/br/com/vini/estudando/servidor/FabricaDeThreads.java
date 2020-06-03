package br.com.vini.estudando.servidor;

import java.util.concurrent.ThreadFactory;

public class FabricaDeThreads implements ThreadFactory {

	private ThreadFactory defaultFactory;

	public FabricaDeThreads(ThreadFactory defaultFactory) {
		this.defaultFactory = defaultFactory;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = defaultFactory.newThread(r);
		thread.setUncaughtExceptionHandler(new TratadorDeExcecao());
		return thread;
	}
}
