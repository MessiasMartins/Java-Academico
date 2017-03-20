package lista01;

import java.util.Random;

public class Exercicio04 {
	
	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posi��es com n�meros inteiros
	 * gerados randomicamente. O algoritmo deve trocar o elemento da primeira posi��o do
	 * vetor com o elemento da �ltima posi��o do vetor. O algoritmo deve imprimir os
	 * n�meros da primeira e da �ltima posi��o do vetor antes e ap�s a troca.
	 */

	private int[] vetorNumeros;


	public Exercicio04(){

		int[] vetorAleatorio = new int[10];
		setVetorNumeros(randomFill(vetorAleatorio));
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[] randomFill(int[] vetorAleatorio){

		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < vetorAleatorio.length; i++){

			vetorAleatorio[i] = rand.nextInt();
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void flipFlop(){

		int[] vetor = getVetorNumeros();
		int tamanho = vetor.length;
		int hold = vetor[0];

		System.out.println("\nO primeiro numero do vetor e: " + vetor[0] + " e o ultimo n�mero e: " + vetor[tamanho-1]);
		System.out.println("Alternando o primeiro e o ultimo numeros");		

		vetor[0] = vetor[tamanho-1];
		vetor[tamanho-1] = hold;

		System.out.println("O primeiro numero do vetor e: " + vetor[0] + " e o ultimo n�mero e: " + vetor[tamanho-1]);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public int[] getVetorNumeros() {
		return vetorNumeros;
	}


	public void setVetorNumeros(int[] vetorNumeros) {
		this.vetorNumeros = vetorNumeros;
	}
}