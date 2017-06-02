package analisadorLexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;


//-----------------------------------------------------//


public class Analisador {

	void readFile(){

		try{

			FileReader arquivo = new FileReader("analisadorLexicoTeste.cpt");			
			BufferedReader buffer = new BufferedReader(arquivo);

			String conteudoArquivo = "";
			String linha;

			do{

				linha = buffer.readLine();
				conteudoArquivo += " " + linha; 
			}
			while (linha != null);

			arquivo.close();
			buffer.close();

			conteudoArquivo = conteudoArquivo.replace("  ", "@ ");

			System.out.println(conteudoArquivo);

			stringToChar(conteudoArquivo);

		}
		catch (Exception e){

			System.err.println("Erro na leitura de arquivo");
		}
	}


	//-----------------------------------------------------//


	void stringToChar(String arquivo){

		char[] caracteres = arquivo.toCharArray();
		analise(caracteres);
	}

	//-----------------------------------------------------//


	void analise(char[] caracteres){

		int tamanho = caracteres.length;
		String palavra = "";
		List<String> lexema = new ArrayList<String>();
		List<String> token = new ArrayList<String>();

		//Map<String,String> hashMap = new LinkedHashMap<String,String>();


		for (int i = 1; i < tamanho; i++){

			char charAnterior;


			//-----------------------------------------------------//			
			//Caso Atribui��o Aspas Duplas String


			if (caracteres[i] == '"'){

				//Adiciona a aspas duplas de abertura � lista de lexemas e atribui o token atribuicao_Aspas
				palavra += caracteres[i];

				lexema.add(palavra);
				token.add("atribuicao_Aspas");

				palavra = "";

				i++;

				//Verifica se o pr�ximo caractere � uma Aspas. Se n�o for, ent�o ir� ler o conteudo at� achar uma aspas e atribuir o token cadeia_Caracteres
				if (caracteres[i] != '"'){
					while (caracteres[i] != '"'){

						palavra += caracteres[i];
						i++;
					}

					lexema.add(palavra);
					token.add("cadeia_Caracteres");

					palavra = "";
				}

				//Atribui � aspas duplas de fechamento o token atribuicao_Aspas 
				palavra += caracteres[i];

				lexema.add(palavra);
				token.add("atribuicao_Aspas");

				palavra = "";
			}	


			//-----------------------------------------------------//
			//Caso Barra


			else if (caracteres[i] == '/'){

				charAnterior = caracteres[i];
				i++;

				//Verifica se h� um espa�o ap�s a barra. Se houver, ent�o o lexema recebe o valor de token divis�o
				if (caracteres[i] == ' '){

					palavra += charAnterior;

					lexema.add(palavra);
					token.add("divisao");

					palavra = "";

				}

				//Verifica se existe um asterisco ap�s a barra. Se houver, ent�o o conjunto /* recebe o token comentario_Paragrafo
				else if (caracteres[i] == '*'){

					palavra += charAnterior;
					palavra += caracteres[i];

					lexema.add(palavra);
					token.add("inicio_Comentario_Paragrafo");

					i++;				
					palavra = "";
					boolean fim = false;

					//Loop While para garantir que um poss�vel * lido n�o seja identificado como fim de coment�rio ao inv�s de simbolo normal
					while (fim == false){

						if (caracteres[i] == '*'){

							charAnterior = caracteres[i];
							i++;

							if (caracteres[i] == '/'){

								lexema.add(palavra);
								token.add("cadeia_Caracteres");

								palavra = "";
								palavra += charAnterior; 
								palavra += caracteres[i];

								lexema.add(palavra);
								token.add("fim_Comentario_Paragrafo");

								fim = true;
								palavra = "";
							}							
							else {

								if (charAnterior != '@')
									palavra+= charAnterior;
							}
						}

						else {

							if (caracteres[i] != '@'){
								palavra+= caracteres[i];

							}
							i++;
						}
					}
				}


				//Caso sobre coment�rio-linha que n�o sabemos como encontrar o final
				else if (caracteres[i] == '/'){

				}
			}


			//if ((caracteres[i] >= 'a' && caracteres[i] <= 'z') || (caracteres[i] >= 'A' && caracteres[i] <= 'Z' )){

		}

		saveFile(lexema, token);
	}

	//-----------------------------------------------------//
   //Gravando o resultado em um arquivo

	void saveFile(List lexema, List token){

		try {			

			int tamanho = lexema.size();

			FileWriter file = new FileWriter("resultadoAnalisador.cpx");
			BufferedWriter buffer = new BufferedWriter (file);

			for (int i = 0; i < tamanho; i++){

				buffer.write("Lexema: " + lexema.get(i));
				buffer.newLine();
				buffer.write("Token:  " + token.get(i));
				buffer.newLine();
				buffer.newLine();
			}
			buffer.close();	
		} 
		catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}

}