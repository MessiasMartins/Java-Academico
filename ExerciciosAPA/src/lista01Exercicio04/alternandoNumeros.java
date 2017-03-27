package lista01Exercicio04;

import java.util.Random;

public class alternandoNumeros {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posi��es com n�meros inteiros
	 * gerados randomicamente. O algoritmo deve trocar o elemento da primeira posi��o do
	 * vetor com o elemento da �ltima posi��o do vetor. O algoritmo deve imprimir os
	 * n�meros da primeira e da �ltima posi��o do vetor antes e ap�s a troca.
	 */

	private int[] vetorNumeros;
	private int tamanhoVetor;


	public alternandoNumeros(int tamanho){

		vetorNumeros = preencherAleatorio(tamanho);
		tamanhoVetor = tamanho;
	}


	public alternandoNumeros(int[] vetor){

		vetorNumeros = vetor;
		tamanhoVetor = vetor.length;
	}

	/*<--------------------------------------------------------------------------------------->*/


	public static int[] preencherAleatorio(int tamanho){

		int[] vetorAleatorio = new int[tamanho];
		Random rand = new Random(System.currentTimeMillis());

		for (int i = 0; i < vetorAleatorio.length; i++){

			vetorAleatorio[i] = rand.nextInt(200);
		}

		return vetorAleatorio;
	}


	/*<--------------------------------------------------------------------------------------->*/
	
	
	
	public void printVetor(){
		
		System.out.print("\nO vetor gerado possui os n�meros: ");
		
		for (int i = 0; i < tamanhoVetor - 1; i++){
			System.out.print(vetorNumeros[i] + ", ");
		}
		
		System.out.println(vetorNumeros[tamanhoVetor - 1] + ".");
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	public void flipFlop(){

		int auxiliar = vetorNumeros[0];

		System.out.println("\nAlternando o primeiro e o ultimo numeros");		

		vetorNumeros[0] = vetorNumeros[tamanhoVetor - 1];
		vetorNumeros[tamanhoVetor - 1] = auxiliar;
	}


	/*<--------------------------------------------------------------------------------------->*/


}