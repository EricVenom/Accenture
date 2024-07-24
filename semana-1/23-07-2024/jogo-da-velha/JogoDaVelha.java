package sef.module3.sample;

import java.util.Scanner;

public class JogoDaVelha {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Tabuleiro novoJogo = new Tabuleiro();
		
		System.out.println("Deseja Iniciar O Jogo? (Y/N)");
		String opcao = input.nextLine();
		
		if (opcao.toLowerCase().equals("y")) {			
			novoJogo.iniciarJogo();
			novoJogo.imprimirTabuleiro();
		} else {
			System.out.println("Encerrando...");
		}
		
		while(novoJogo.isJogoAtivo()) {			
			//loop for player 1 and 2 to play
			for (int i=1; i<=2; i++) {
				System.out.printf("Jogador %d: Informe a linha (0 a 2)", i);
				int linha = input.nextInt();
				
				System.out.printf("Jogador %d: Informe a coluna (0 a 2)", i);
				int coluna = input.nextInt();
				
				//checking if columns and rows are invalid numbers.
				if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
					System.out.println("Linha ou coluna inválida. Tente novamente.");
					i--;
				} else {					
					novoJogo.fazerJogada(i, linha, coluna);
					novoJogo.imprimirTabuleiro();
					//checking if the game should end
					novoJogo.encerrarJogo(novoJogo.checarVitoria(i, linha, coluna));	
					if (!novoJogo.isJogoAtivo()) {
						i++;
					}
				}
			}
			
			
		}
	}
}
