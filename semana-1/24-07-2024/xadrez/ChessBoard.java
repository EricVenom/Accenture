package sef.module3.sample;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChessBoard {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		TabuleiroXadrez board = new TabuleiroXadrez();
		boolean jogoAtivo = true;
		imprimirBoard(board.getTabuleiro());
		
		while(jogoAtivo) {
			String escolhaString = JOptionPane.showInputDialog(null, "Você é as peças de baixo. Mova os peões\n"
					+ "Escolha um deles para mover (1 à 8): ");
			int escolha = Integer.parseInt(escolhaString);
			escolha -= 1; 
			int boost;
			
			// Mover Peao
			if (board.getTabuleiro()[6][escolha].equals("p")) {
				System.out.println("");
				String boostString = JOptionPane.showInputDialog(null, "Quantas casas avançar? (1 ou 2)");
				boost = Integer.parseInt(boostString);
				board.getTabuleiro()[6-boost][escolha] = board.getTabuleiro()[6][escolha];
				board.getTabuleiro()[6][escolha] = " ";
			} else {
				for (int i = 1; i < board.getTabuleiro()[i].length -1; i++) {
					if (board.getTabuleiro()[i][escolha].equals("p") && board.getTabuleiro()[i-1][escolha].equals(" ")) {
						board.getTabuleiro()[i-1][escolha] = board.getTabuleiro()[i][escolha];
						board.getTabuleiro()[i][escolha] = " ";
					}
				}
			}
			imprimirBoard(board.getTabuleiro());
		}
		 
	}
	
	public static void imprimirBoard(String[][] board) {
		 for (int i = 0; i < board.length; i++) {
		        for (int j = 0; j < board[i].length; j++) {
		        	System.out.print(board[i][j]+"  ");
		        }
		        System.out.println("");
		    }
		 System.out.println("=======================");
	}
}
