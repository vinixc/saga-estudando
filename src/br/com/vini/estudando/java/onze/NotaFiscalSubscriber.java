package br.com.vini.estudando.java.onze;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class NotaFiscalSubscriber implements Subscriber<NotaFiscal>{
	
	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("Chamando o onSubscribe!!");
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(NotaFiscal notaFiscal) {
		NotaFiscalWSClient nfws = new NotaFiscalWSClient();
		nfws.enviar(notaFiscal);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Todas as notas foram emitidas");
	}

}
