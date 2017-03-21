package lista02;

import java.util.Random;

public class Exercicio03 {

	/*Escreva um algoritmo em Java que instancie uma matriz N x N. O algoritmo deve preencher
	 * 	todas as posi��es da Matriz com n�meros rand�micos. Crie um contador para contabilizar o
	 * 	n�mero de valores inseridos na Matriz. Ao final da execu��o, o algoritmo deve imprimir o valor
	 * 	de N seguido do valor do contador. Em seguida, repita o experimento com matrizes de tamanho
	 * 	100, 1.000, 10.000, 100.000 e 1.000.000. Construa um gr�fico "Tamanho do Vetor (N)" X
	 * 	"N�mero de Opera��es (OP)" no Excel.
	 */

	int[][] matrizAleatoria;
	int tamanhoMatriz;

	public Exercicio03(int tamanho){

		tamanhoMatriz = tamanho;
		int[][] matriz = new int[tamanho][tamanho];

		preencherMatriz(matriz);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	private void preencherMatriz(int[][] matriz){

		Random aleatorio = new Random(System.currentTimeMillis());
		int contador = 0;

		for (int i = 0; i < tamanhoMatriz; i ++){
			for (int j = 0; j < tamanhoMatriz; j ++){

				matriz[i][j] = aleatorio.nextInt(1000);
				contador++;
			}	
		}

		printResultados(contador);
	}
	
	
	/*<--------------------------------------------------------------------------------------->*/
	
	
	private void printResultados(int contador){

		System.out.println("\nTamanho da matriz: " + tamanhoMatriz);
		System.out.println("Valor do contador: " + contador + "\n");
	}
}