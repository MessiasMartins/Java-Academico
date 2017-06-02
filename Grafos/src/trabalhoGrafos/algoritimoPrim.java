package trabalhoGrafos;
/*Algoritmo de Prim: Encontra a uma Minimal Spanning Tree (MST), ou 
 *arvore geradora m�nima a partir de um dado grafo inserido no programa
 *(atrav�s de um arquivo .txt).
 *
 *� utilizado:
 *
 *-> int [][] GrafoArvore para guardar os dados do grafo inserido.
 *-> Classe arvoreMinimaX, que ir� funcionar como uma Fila Encadeada para representar os valores da �rvore m�nima. Guarda os valores dos v�rtices e seus pais. 
 *-> int [] RestantesQ para guardar os v�rtices que ainda n�o fazem parte da �rvore.
 *-> Int [] Chave guarda o menor peso que um v�rtice atual possui com outro.
 *
 *
 * -> GrafoArvore possui os valores dos pesos das arestas do grafo, al�m da informa��o de que existe uma aresta entre dois grafos.
 * -> arvoreMinimaX possui como vari�veis o v�rtice que faz parte da �rvore minima, e o seu pai (vertice que veio anteriormente).
 * -> RestantesQ est� preenchido com 1 se um v�rtice n�o foi utilizado ainda e 0 se j� foi utilizado.
 * -> Chave � preenchido com "Infinito" em todos os valores no come�o do programa. Chave � comparado com o peso dos v�rtices.
 * em GrafoArvore 
 * 
 * Deve possuir o m�todo:
 * 
 * -> extrairMinimo (RestantesQ[], chave[]), que usa os pesos de GrafoArvore e os valores de Chave e compara ambos. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class algoritimoPrim {

	static int [][] leituraGrafo() throws FileNotFoundException{

		// Utiliza um try para evitar erros na abertura do arquivo (caso n�o exista, etc)

		int[][] matrizGrafo = null; 

		try{

			FileReader arquivo = new FileReader("ArvoreMinima.txt");			
			BufferedReader buffer = new BufferedReader(arquivo);

			String linha = buffer.readLine();
			String[] linhaGrafo = linha.trim().split("\\s+");

			arquivo.close();
			buffer.close();

			int tamanho = linhaGrafo.length;
			int Grafo[][] = new int [tamanho][tamanho];
			int contadorLinhas = 0;

			arquivo = new FileReader("ArvoreMinima.txt");
			buffer = new BufferedReader(arquivo);	

			linha = buffer.readLine();

			do{			

				linhaGrafo = linha.trim().split("\\s+");

				for (int i = 0; i < tamanho; i++){

					Grafo[contadorLinhas][i] = Integer.parseInt(linhaGrafo[i]);
				}

				contadorLinhas++;

				linha = buffer.readLine();

			}
			while (linha != null);

			arquivo.close();
			buffer.close();

			matrizGrafo = Grafo;

		}
		catch (Exception e){}

		finally {}

		return matrizGrafo;
	}

	//-----------------------------------------------------//

	static void imprimeMatriz(int [][] pesoGrafo){

		//impress�o simples de uma matriz no console.

		System.out.println("** --------- Matriz --------- **");

		for (int i = 0; i < pesoGrafo.length; i++)
		{
			for (int j = 0; j < pesoGrafo.length; j++){

				System.out.print(pesoGrafo[i][j] + " ");
			}

			System.out.println();
		}
	}

	//-----------------------------------------------------//

	static int leituraVertice (int tamanhoG){

		/*M�todo para requisitar do usu�rio qual ser� o vertice inicial do Algoritmo de Prim.
		 * Possui tratamento de erros (valores acima ou abaixo do esperado, ou caracteres invalidos)
		 */

		int vertice = -1;

		//-----------------------------------------------------//

		while (vertice == -1){

			try{

				Scanner entrada = new Scanner(System.in);
				System.out.print("\n" + "Informe o v�rtice inicial da busca: ");
				vertice = entrada.nextInt();

				while (vertice < 0 || vertice > tamanhoG){

					System.out.println("V�rtice inexistente.");
					System.out.print("\n" + "Informe o v�rtice inicial da busca: ");
					vertice = entrada.nextInt();
				}

				entrada.close();			

			}
			catch(InputMismatchException e){

				System.out.println("O v�rtice inserido � inv�lido.");
			}
		}

		return vertice;
	}

	//-----------------------------------------------------//

	static boolean restVet(int[] restantesQ){

		/*Verifica se ainda existem vertices disponiveis para serem utilizados no
		 * vetor restantesQ[] iterando por todo o vetor e verificando se h� um valor 
		 * "1" restante, que simboliza um v�rtice n�o utilizado. 
		 */

		for (int i = 0; i < restantesQ.length; i++){

			if (restantesQ[i] == 1){

				return true;
			}
		}
		return false;
	}

	//-----------------------------------------------------//

	static int extrairMinimo(int[] restanteQ, int[] chave){

		/*O m�todo verifica nos v�rtices restantes do grafo qual possui o menor peso entre as arestas
		 * e retorna esse v�rtice (seu indice) para arvoreMinimaX[], que ir� adicionar ele na sequ�ncia de v�rtices.
		 * Integer.MAX_VALUE representa um valor Infinito (ou o maior poss�vel) de uma integer (valor inteiro)
		 */

		int menor = Integer.MAX_VALUE;
		int indice = -1;

		for (int i = 0; i < restanteQ.length; i++){

			if (restanteQ[i] == 1 && chave[i] < menor){

				menor = chave[i];
				indice = i;
			}

		}

		restanteQ[indice] = 0;
		return indice;
	}

	//-----------------------------------------------------//

	static void imprimeArvore(int[] arvoreMinima, int[] pai, int tamanhoG, int inicial){

		System.out.println("A arvore m�nima resultante, come�ando no v�rtice "
				+ inicial + " �: " + "\n");

		for (int i = 0; i < tamanhoG; i++){

			System.out.println("V�rtice: " + arvoreMinima[i] + " Pai: " + pai[arvoreMinima[i]]);
		}

		gravarArvore(arvoreMinima, pai, tamanhoG, inicial);
	}

	//-----------------------------------------------------//

	static void gravarArvore(int [] arvoreMinima, int [] pai, int tamanhoG, int inicial){

		try {			

			FileWriter file = new FileWriter("resultadoPrim.txt");
			BufferedWriter buffer = new BufferedWriter (file);

			buffer.write("A arvore m�nima resultante, come�ando no v�rtice " + inicial + " �: ");
			buffer.newLine();
			buffer.newLine();

			for (int i = 0; i < tamanhoG; i++){

				buffer.write("V�rtice: " + arvoreMinima[i] + " Pai: " + pai[arvoreMinima[i]]);
				buffer.newLine();
			}
			buffer.close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------//

	public static void main(String[] args) throws FileNotFoundException{


		//Chama o m�todo leituraGrafo para fazer a leitura do grafo fornecido no arquivo.
		//Guarda o grafo que foi lido pelo m�todo leituraGrafo() e ser� usado no programa.

		int [][] pesoGrafo = leituraGrafo();
		imprimeMatriz(pesoGrafo);

		//-----------------------------------------------------//	
		
		//Declara��o das vari�veis.

		//Captura e guarda o tamanho do meu grafo lido pelo m�todo leituraGrafo().
		final int tamanhoG = pesoGrafo.length;

		//Vari�vel fornecida pelo usu�rio (atrav�s do m�todo LeituraVertice) cujo valor indica qual v�rtice da �rvore ser� o inicial		

		int vertice = leituraVertice(tamanhoG);
		final int inicial = vertice;

		//Vari�vel resultado (final) que ter� o os v�rtices da arvore em sequencia.
		int arvoreMinima[] = new int[tamanhoG];

		//Guarda os indices que correspondem aos pais dos vertices usados na arvore m�nima.
		int pai[] = new int[tamanhoG];

		//Guarda os v�rtices que ainda n�o foram utilizados pelo programa para construir a �rvore.
		int [] restantesQ = new int [tamanhoG];

		//guarda as chaves (menor peso) dos v�rtices do grafo.
		int [] chave = new int [tamanhoG];

		//Vari�vel usada para iterar entre os indices de arvoreMinimaX.
		int contador = 0;


		//-----------------------------------------------------//	
		//inicializa��o das vari�ves.

		Arrays.fill(restantesQ,  1);
		Arrays.fill(chave, Integer.MAX_VALUE);
		Arrays.fill(pai, -1);
		Arrays.fill(arvoreMinima, -1);

		/*Sinaliza que a chave do primeiro v�rtice ser� 0, para que ele
		 * seja o primeiro escolhido pelo m�todo extrairMinimo, j� que
		 * nenhum outro v�rtice ter� peso 0 ou menor que 0.
		 */

		chave[vertice] = 0;

		//-----------------------------------------------------//	
		
		//Itera��o entre os v�rtices e processamento do Algoritmo de Prim

		/* Verifica se ainda existem valores dentro do vetor restVet,
		 * quer dizer, verifica se ainda existem vetores no grafo
		 * que n�o foram utilizados na �rvore.
		 */

		while (restVet(restantesQ) == true){

			/*Usando o m�todo extrairMinimo, atribui ao indice atual de arvoreMinimaX (o vetor resultante) a
			 * a posi��o (indice) do grafo que � adjacente a ele e possui menor peso
			 */
			arvoreMinima[contador] = extrairMinimo(restantesQ, chave);

			//atualiza o vertice analisado na se��o for abaixo usando o indice encontrado em arvoreMinimaX[contador]
			vertice = arvoreMinima[contador];

			/*Verifica quais v�rtices est�o adjacentes ao v�rtice atual e, se o peso deles for
			 * menor do que a chave (menor peso) atual, ent�o atualiza o valor.
			 */

			for (int j = 0; j < tamanhoG; j++){

				if (pesoGrafo[vertice][j] != 0 && restantesQ[j] != 0 && pesoGrafo[vertice][j] < chave[j]){

					chave[j] = pesoGrafo[vertice][j];
					pai[j] = vertice;
				}
			}	
			
			//Aumenta o valor da vari�vel que itera pelos indices de arvoreMinimaX.
			contador++;
		}

		imprimeArvore(arvoreMinima, pai, tamanhoG, inicial);

		//-----------------------------------------------------//	
	}
}