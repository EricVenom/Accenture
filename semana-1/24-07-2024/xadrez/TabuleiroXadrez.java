package sef.module3.sample;

public class TabuleiroXadrez {
	private String[][] tabuleiro;
	
	public TabuleiroXadrez() {
		this.tabuleiro = new String[][] { 
			{"R","N","B","Q","K","B","N","R"},
			{"P","P","P","P","P","P","P","P"},
			{" "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "},
			{"p","p","p","p","p","p","p","p"},
			{"r","n","b","q","k","b","n","r"}
			};
	}
	
	public String[][] getTabuleiro(){
		return this.tabuleiro;
	}
}
