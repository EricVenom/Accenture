package sef.module3.sample;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class JogoDaVelha {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Tabuleiro novoJogo = new Tabuleiro();
		int numeroDeJogadas = 0;
		String opcao = JOptionPane.showInputDialog(null, "Deseja iniciar o jogo? (Y/N)");
		
		if (opcao.toLowerCase().equals("y")) {			
			novoJogo.iniciarJogo();
			novoJogo.imprimirTabuleiro();
		} else {
			JOptionPane.showMessageDialog(null, "Encerrando...");
		}
		
		while(novoJogo.isJogoAtivo() && numeroDeJogadas < 9) {			
			//loop for player 1 and 2 to play
			for (int i=1; i<=2; i++) {
				numeroDeJogadas++;
				String linhaString = JOptionPane.showInputDialog(null, "Jogador " + i + ": Informe a linha");
				int linha = Integer.parseInt(linhaString);
				
				String colunaString = JOptionPane.showInputDialog(null, "Jogador " + i + ": Informe a coluna (0 a 2)");
				int coluna = Integer.parseInt(colunaString);
				
				//checking if columns and rows are invalid numbers.
				if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
					JOptionPane.showMessageDialog(null, "Linha ou coluna inválida. Tente novamente.");
					i--;
					numeroDeJogadas--;
				} else {					
					novoJogo.fazerJogada(i, linha, coluna);
					novoJogo.imprimirTabuleiro();
					//checking if the game should end
					novoJogo.encerrarJogo(novoJogo.checarVitoria(i, linha, coluna));	
					if (!novoJogo.isJogoAtivo()) {
						i++;
					} else if (numeroDeJogadas > 8) {
						JOptionPane.showMessageDialog(null, "Empate.");
						i++;
					}
				}
			}
		}
	}
}
