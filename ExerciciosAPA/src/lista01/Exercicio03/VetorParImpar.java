package lista01.Exercicio03;

import custom.Objects.VetorInt;

public class VetorParImpar {

	/*
	 * Escreva um algoritmo que preencha um vetor de 10 posi��es com n�meros inteiros
	 * gerados randomicamente. O algoritmo deve informar se o primeiro elemento do vetor �
	 * par ou impar.
	 */

	private VetorInt vetorNumeros;

	public VetorParImpar(int tamanho){

		vetorNumeros = new VetorInt(tamanho);
		vetorNumeros.preencherAleatorio();
	}

	public VetorParImpar(int[] vetor){

		vetorNumeros = new VetorInt(vetor);
		vetorNumeros.preencherAleatorio();
	}


	/*<--------------------------------------------------------------------------------------->*/


	public void parImpar(){

		int primeiro = vetorNumeros.getValor(0);

		switch (primeiro % 2){

		case(0): System.out.println("\nO primeiro numero do vetor e " + primeiro + " e, portanto, e par"); break;		
		case(1): System.out.println("\nO primeiro numero do vetor e " + primeiro + " e, portanto, e impar"); break;
		}
	}


	/*<--------------------------------------------------------------------------------------->*/


	public VetorInt getVetorInt() {

		return vetorNumeros;
	}
}