package controller;

import java.util.concurrent.Semaphore;

public class Op_BancoDados extends Thread {
	
	private int idthread;
	private int resultado;
	private int tempo;
	private Semaphore semaforo;
	
	
	public Op_BancoDados(int idthread, Semaphore semaforo ) {
		this.idthread = idthread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
				calculo();
			// -------------- inicio da secao critica
				try {
					semaforo.acquire();
					gravacao();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
				semaforo.release();
				} // fim da secao critica
		
	} // fim run

	private void calculo() {
		resultado = (idthread / 3);  // resultado = 1 
		if (resultado == 1) {
			int tempo = (int) ((Math.random() * 1001) + 200);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calculo resultado = 1 " + idthread);
		} // fim if 1
		
		resultado = (idthread / 3);   // resultado = 2
		if (resultado == 2) {
			int tempo = (int) ((Math.random() * 1501) + 500);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calculo resultado = 2 " + idthread);
		} // fim if 2
		
		resultado = (idthread / 3);   // resultado = 3
		if (resultado == 3) {
			int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Calculo resultado = 3 " + idthread);
		} // fim if 3
	}  // fim calculo
	
	
	private void gravacao() {
		resultado = (idthread / 3);  // resultado =1
		if (resultado == 1) {
			tempo = 1000;		// tempo de gravacao de 1 segundo
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Gravação resultado = 1 " + idthread);	
		} // fim if 1
		
		resultado = (idthread / 3);   //  resultado 2
		if (resultado == 2) {
			tempo = 1500;		// tempo de gravacao de 1 segundo
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Gravação resultado = 2 " + idthread);	
		} // fim if 2
		
		resultado = (idthread / 3);   //  resultado 3
		if (resultado == 3) {
			tempo = 1500;		// tempo de gravacao de 1 segundo
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Gravação resultado = 3 " + idthread);	
		} // fim if 3
		
	} // gravação 
} // fim classe
