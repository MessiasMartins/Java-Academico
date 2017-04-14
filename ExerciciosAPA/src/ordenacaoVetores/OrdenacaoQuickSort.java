package ordenacaoVetores;

import custom.Objects.Item;
import custom.Objects.VetorItems;

public class OrdenacaoQuickSort extends Ordena {

	/*Escreva um pacote em linguagem Java para ordena��o de vetores. O pacote deve conter o
	 * algoritmo de ordena��o pelo m�todo QuickSort. Teste o algoritmo de ordena��o implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */


	/*<--------------------------------------------------------------------------------------->*/


	public OrdenacaoQuickSort(int tamanho){

		this.vetorOrdena = new VetorItems(tamanho);
	}


	public OrdenacaoQuickSort(int[] vetor){

		this.vetorOrdena = new VetorItems(vetor);
	}
}