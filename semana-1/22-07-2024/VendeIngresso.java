package sef.module3.sample;

import java.util.Scanner;

public class VendeIngresso {
	static Scanner input = new Scanner(System.in);
	static Scanner input2 = new Scanner(System.in);
	public static void main(String[] args) {
		int qtdClasseA = 0, qtdClasseB = 0, qtdClasseC = 0;
		double valorA = 50, valorB = 30, valorC = 20;
		
		int opcao = 0;
		do {
			System.out.println("Sistema Venda de Ingressos!!\n"
					+ "Selecione uma Opção:\n"
					+ "1. Comprar Ingresso\n"
					+ "2. Exibir Renda\n"
					+ "3. Sair\n"
					+ ">>>");
			opcao = input.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Menu de Ingressos\n"
						+ "Selecione uma Opção:\n"
						+ "1. Classe A (R$ 50)\n"
						+ "2. Classe B (R$ 30)\n"
						+ "3. Classe C (R$ 20)\n"
						+ "4. Voltar Ao Menu Principal\n"
						+ ">>>");
				int opcaoVenda = input.nextInt();
				switch(opcaoVenda) {
				case 1:
					qtdClasseA++;
					System.out.println("Venda Efetuada Com Sucesso!\n"
							+ "Pressione 'Enter' Para Continuar...");
					input2.nextLine();
					break;
				case 2:
					qtdClasseB++;
					System.out.println("Venda Efetuada Com Sucesso!\n"
							+ "Pressione 'Enter' Para Continuar...");
					input2.nextLine();
					break;
				case 3:
					qtdClasseC++;
					System.out.println("Venda Efetuada Com Sucesso!\n"
							+ "Pressione 'Enter' Para Continuar...");
					input2.nextLine();
					break;
				case 4:
					break;
				default:
					System.out.println("Opção Inválida.");
					break;
				}
				break;
			case 2:
				double totalA = ((double) qtdClasseA * valorA), 
				totalB = ((double) qtdClasseB * valorB), 
				totalC = ((double) qtdClasseC * valorC);
				
				System.out.printf("Valor total arrecadado\n"
						+ "Classe A: R$ %.2f%n"
						+ "Classe B: R$ %.2f%n"
						+ "Classe C: R$ %.2f%n"
						+ "Total: R$ %.2f%n", totalA, totalB, totalC, (totalA + totalB + totalC));
				
				System.out.println("Pressione 'Enter' Para Continuar...");
				input2.nextLine();
				break;
			case 3:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(opcao != 3);
	}
}
