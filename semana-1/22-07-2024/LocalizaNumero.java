package sef.module3.sample;
//Fa�a um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
public class LocalizaNumero {
	// Corrigir este algoritmo.
	public static void main(String[] args) {
		int vetor[] = {1, 3, 5, 8, 9, 10};
		int numero = 8;
		int posicao = localizarNumero(numero, vetor);
		boolean encontrado = posicao == -1 ? false:true;
		
		if (encontrado) {
	        System.out.println("Encontrado!");
	        System.out.printf("O numero \"%d\" está localizado no índice \"%d\".", vetor[posicao], posicao);			
		} else {
			System.out.println("Erro 404. Numero não encontrado!");
		}

	}

	public static int localizarNumero(int numeroBuscado, int[] vetorDeNumeros) {
		//retorna a primeira ocorrencia do numero procurado
		int posicao = 0;
		
		for (int numero: vetorDeNumeros) {
			if(numero == numeroBuscado) {
				return posicao;
			}
			
			posicao += 1;
		}
		
		return -1;
	}
}
