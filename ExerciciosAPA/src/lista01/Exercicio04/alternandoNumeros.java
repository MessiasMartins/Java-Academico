package lista01.Exercicio04;

import custom.Objects.VetorInt;

public class alternandoNumeros {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posi��es com n�meros inteiros
	 * gerados randomicamente. O algoritmo deve trocar o elemento da primeira posi��o do
	 * vetor com o elemento da �ltima posi��o do vetor. O algoritmo deve imprimir os
	 * n�meros da primeira e da �ltima posi��o do vetor antes e ap�s a troca.
	 */

	private VetorInt vetorNumeros;
	int tamanhoVetor;

	public alternandoNumeros(int tamanho){

		vetorNumeros = new VetorInt(tamanho);
		tamanhoVetor = tamanho;
	}


	public alternandoNumeros(int[] vetor){

		vetorNumeros = new VetorInt(vetor);
		tamanhoVetor = vetor.length;
	}

	/*<--------------------------------------------------------------------------------------->*/


	public void flipFlop(){

		int auxiliar = vetorNumeros.getValor(0);

		System.out.println("\nAlternando o primeiro e o ultimo numeros");		

		vetorNumeros.setValor(0, vetorNumeros.getValor(tamanhoVetor - 1));
		vetorNumeros.setValor(tamanhoVetor - 1, auxiliar);
	}


	/*<--------------------------------------------------------------------------------------->*/


	public VetorInt getVetorInt() {
		return vetorNumeros;
	}


	/*<--------------------------------------------------------------------------------------->*/


}