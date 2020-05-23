package br.com.vini.estudando.java.onze;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Jo�o", 39.99, LocalDate.now());
		NotaFiscal primeiraSegunda = new NotaFiscal("Vinicius", 50.99, LocalDate.now());
		NotaFiscal primeiraTerceira = new NotaFiscal("Yasmin", 40.99, LocalDate.now());
		
		
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
		
		publisher.subscribe(subscriber);
		publisher.submit(primeiraNotaFiscal);
		publisher.submit(primeiraSegunda);
		publisher.submit(primeiraTerceira);
		System.out.println("Voc� ir� receber a nota fiscal no seu e-mail");
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
