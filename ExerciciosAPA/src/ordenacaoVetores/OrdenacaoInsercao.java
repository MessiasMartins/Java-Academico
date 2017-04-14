package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoInsercao extends Ordena {

	/*Escreva um pacote em linguagem Java para ordena��o de vetores. O pacote deve conter o
	 * algoritmo de ordena��o pelo m�todo Insercao. Teste o algoritmo de ordena��o implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoInsercao(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
		this.vetorOrdena.preencherAleatorio(200);
	}


	public OrdenacaoInsercao(int[] vetor){

		vetorOrdena = new VetorItems(vetor);
	}


	/*<--------------------------------------------------------------------------------------->*/

}