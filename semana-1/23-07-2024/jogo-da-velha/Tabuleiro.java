package sef.module3.sample;

public class Tabuleiro {
	private String[][] matrizTabuleiro;
	private boolean jogoAtivo;
	private int vencedor;
	
	public Tabuleiro() {
		this.matrizTabuleiro = new String[][]{
										{" ", " ", " "}, 
										{" ", " ", " "}, 
										{" ", " ", " "}
										};
		this.jogoAtivo = false;
	}
	
	public void imprimirTabuleiro() {
		System.out.print("\n\n 0   1    2\n\n");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" " + this.matrizTabuleiro[i][j]);
				if (j < 2) {
					System.out.print(" |");
				} else {
					System.out.print("  " + i);
				}
			}
			if (i < 2) {
				System.out.print("\n-----------");
			}
			System.out.println("\n");
		}
	}
	
	public void iniciarJogo() {
		this.jogoAtivo = true;
	}
	
	public void encerrarJogo(boolean resultado) {
		if (resultado) {
			this.jogoAtivo = false;
			System.out.printf("Fim de Jogo! Vitória do jogador %d!!", this.vencedor);
		}
	}
	
	public void fazerJogada(int jogador, int linha, int coluna) {
		String xizinhoOuBolinha = jogador == 1?"X":"O";
		if (this.matrizTabuleiro[linha][coluna].equals(" ")) {			
			this.matrizTabuleiro[linha][coluna] = xizinhoOuBolinha;
		} else {
			System.out.printf("Jogador %d perdeu a vez por escolher uma posição já ocupada!", jogador);
		}
	}
	
	public boolean checarVitoria(int jogador, int linha, int coluna) {
		String xizinhoOuBolinha = jogador == 1? "X":"O";
		
		int contagem1 = 0;
		int contagem2 = 0;
		int contagem3 = 0;
		int contagem4 = 0;
		
		//Diagonal
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j && this.matrizTabuleiro[i][j].equals(xizinhoOuBolinha)) {
					contagem1++;
				}
			}
		}
		
		//Secondary Diagonal
		for (int i = 2; i >= 0; i--) {
			if (this.matrizTabuleiro[i][2-i].equals(xizinhoOuBolinha)) {
				contagem2++;
			}
		}
		
		//Column
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == coluna && this.matrizTabuleiro[i][j].equals(xizinhoOuBolinha)) {
					contagem3++;
				}
			}
		}
		//Row
		for (int i = linha; i <= linha; i++) {
			for (int j = 0; j < 3; j++) {
				if (this.matrizTabuleiro[linha][j].equals(xizinhoOuBolinha)) {
					contagem4++;
				}
			}
		}
		
		//Verifying if any of the counts is true
		if (contagem1 == 3 || contagem2 == 3 || contagem3 == 3 || contagem4 == 3) {
			this.vencedor = jogador;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isJogoAtivo() {
		return this.jogoAtivo;
	}
}
