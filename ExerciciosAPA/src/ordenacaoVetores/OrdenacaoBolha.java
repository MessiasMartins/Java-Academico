package ordenacaoVetores;

import java.security.SecureRandom;

public class OrdenacaoBolha extends Ordena {

	/*Escreva um pacote em linguagem Java para ordena��o de vetores. O pacote deve conter o
	 * algoritmo de ordena��o pelo m�todo bolha. Teste o algoritmo de ordena��o implementado no
	 * pacote, usando vetores de tamanho (N). Os elementos dos vetores devem ser gerados aleatoriamente.
	 */

	public OrdenacaoBolha(int tamanho){

		Ordena nomealeatorio = new Ordena();
		
		this.tamanhoVetor = tamanho;
		int[] vetor = new int[tamanho];

		this.vetor = preencherAleatorio(vetor);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	

	
	
	public void ordenarVetor(){

		
	}

	
	/*<--------------------------------------------------------------------------------------->*/
	

	/*public void printVetor(){

		for (int i = 0; i < this.tamanhoVetor; i ++){

			System.out.print(this.vetor[i] + ", ");
		}

	}
	 */
	
	
}