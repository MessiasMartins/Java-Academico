package trabalhoGrafos;

/* A classe Filas � utilizada para cria��o de manipula��o de Filas homog�neas (numero [identificador])
 * -> Possui uma inner class elemento que � instanciada para cada novo elemento da fila que � criado,
 * atrav�s do m�todo Inserir elemento.
 * 
 * O m�todo InserirElemento(int vertice) cria um novo elemento no final da fila e atribui uma posi��o para ele
 * o m�todo RemoverElemento() remove o primeiro elemento da fila e atribui a posi��o 1 para o elemento seguinte 
 */

public class Filas {

	//Declara��o de variaveis do tipo elemento (criado na classe abaixo) que indicam o comeco e fim da fila
	private static elemento comeco;
	private static elemento fundo;

	protected static class elemento {

		/*Atributos que compoem a vari�vel elemento. N�mero fornece a identifica��o do elemento e proximo � usado para fazer a liga��o
		 * entre um elemento e seu elemento subsequente
		 */

		int numero;
		elemento proximo;
	}

	//---------------------------------------------------------------//

	//Op��o 1
	protected static void InserirElemento(int vertice){

		/*Met�do para a inser��o de um elemento na fila. Requisita o numero de identifica��o do vertice
		 * e ent�o o adiciona na ordem de sequ�ncia da fila
		 */

		elemento novo = new elemento();
		novo.numero = vertice;

		//---------------------------------------------------------------//

		if (getComeco() == null){

			//Se n�o existerem elementos na fila; quer dizer, a fila est� vazia

			setFundo(novo);
			setComeco(novo);

			novo.proximo = null;
		}
		else{

			//Se j� existirem elementos na fila, adiciona um novo elemento no final dela.
			getFundo().proximo = novo;
			novo.proximo = null;
			setFundo(novo);

		}
	}

	//---------------------------------------------------------------//

	protected static void RemoverElemento(){

		//Remove o primeiro elemento da lista, e diminui a posi��o de todos os outros membros em 1 unidade

		if (getComeco().proximo != null){

			setComeco(getComeco().proximo);
		}
		else{
			setComeco(null);
		}
	}

	static void ConsultarFila() {

		//itera por todos os elementos da fila e imprime seu identificador (numero), nome e posi��o na fila

		System.out.println("\n" + "//-----------------------------------------------------//");

		elemento auxiliar = new elemento ();
		auxiliar = comeco;

		//---------------------------------------------------------------//	


		if (auxiliar == null){

			//Se a fila estiver vazia

			System.out.print("A fila est� vazia.");
			System.out.println("\n" + "//-----------------------------------------------------//");
		}
		else{

			System.out.println("A fila possui os elementos: " + "\n");

			while (auxiliar != null){

				System.out.println("Elemento: " + auxiliar.numero + " || Endere�o Hash: " + auxiliar.hashCode());
				auxiliar = auxiliar.proximo;
			}

			System.out.println("//-----------------------------------------------------//");
		}
	}

	//---------------------------------------------------------------//


	public static elemento getComeco() {
		return comeco;
	}

	public static void setComeco(elemento comeco) {
		Filas.comeco = comeco;
	}

	private static elemento getFundo() {
		return fundo;
	}

	private static void setFundo(elemento fundo) {
		Filas.fundo = fundo;
	}

}
