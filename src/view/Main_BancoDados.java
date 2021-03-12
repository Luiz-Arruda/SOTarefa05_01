package view;

import java.util.concurrent.Semaphore;

import controller.Op_BancoDados;

public class Main_BancoDados {

	public static void main(String[] args) {

	int permissoes = 1;   // quantas Threads podem usar simultaneamente
	Semaphore semaforo = new Semaphore(permissoes);  // instanceamento
	
	for (int idT = 0; idT < 21; idT ++) {
		Thread IDT = new Op_BancoDados(idT,semaforo);
			IDT.start();
		}
	} // fim main
}  // fim classe
