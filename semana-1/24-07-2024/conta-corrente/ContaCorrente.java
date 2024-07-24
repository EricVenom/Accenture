package sef.module4.activity;

import java.util.Date;

public class ContaCorrente {
	private static int numero = 0;
	
	private int numeroConta;
	private Cliente cliente;
	private double saldo;
	private Date data;
	private String historico;
	
	public ContaCorrente(Cliente cliente) {
		ContaCorrente.numero++;//toda vez q é instanciado um novo objeto, o numero é incrementado
		this.numeroConta = numero; // atribuindo numero unico pra conta
		this.cliente = cliente;
		this.saldo = 100; // é preciso ter colocado 100 reais para abrir a conta
		this.data = new Date();
		this.historico = "===== HISTÓRICO DE TRANSAÇÕES =====\n";
	}
	
	public void depositar(double valorDeposito) {
		Date dataHoraDeposito = new Date();
		if (valorDeposito > 0) {			
			this.saldo += valorDeposito;
			System.out.printf("Conta %d: depositou R$ %.2f com sucesso.\n", this.numeroConta, valorDeposito);
			this.historico += "{ Deposito: +" + valorDeposito + ", Data: " + dataHoraDeposito + " }\n";
		} else {
			System.out.println("Quantidade inválida.");
		}
	}
	
	public void sacar(double valorSaque) {
		Date dataHoraSaque = new Date();
		if (this.saldo >= valorSaque) {
			this.saldo -= valorSaque;
			System.out.printf("Conta %d: sacou RS %.2f com sucesso.\n", this.numeroConta, valorSaque);
			this.historico += "{ Saque: -" + valorSaque + ", Data: " + dataHoraSaque + " }\n";

		} else {
			System.out.println("Saldo indisponível.");
		}
	}
	
	public void transferir(double valorTransferencia, ContaCorrente contaReceptora) {
		Date dataHoraTransferencia = new Date();
		if (this.saldo >= valorTransferencia && valorTransferencia > 0) {
			this.saldo -= valorTransferencia;
			this.historico += "{Transferência: -" + valorTransferencia + 
					", Conta Receptora: " + contaReceptora.numeroConta + 
					", CPF do Titular: " + contaReceptora.cliente.getCpf() +
					", Data: " + dataHoraTransferencia + " }\n";
			
			contaReceptora.saldo += valorTransferencia;
			contaReceptora.historico += "{Transferência: +" + valorTransferencia + 
					", Conta Transferente: " + this.numeroConta + 
					", CPF do Titular: " + this.cliente.getCpf() +
					", Data: " + dataHoraTransferencia + " }\n";
			
		}
	}
	
	public void exibirExtrato() {
		System.out.printf("\nEXTRATO\n{ Numero da Conta: %d, CPF: %s, Saldo: R$%.2f }\n", this.numeroConta, this.cliente.getCpf(), this.saldo);
		System.out.println(this.historico);
	}
	
	@Override
	public String toString() {
		return "Numero: " + this.numeroConta + "\n" +
				"Nome: " + this.cliente.getNome() + "\n" +
				"Sobrenome: " + this.cliente.getSobrenome() + "\n" +
				"CPF: " + this.cliente.getCpf() + "\n" +
				"Saldo: " + this.saldo + "\n" +
				"Data de Abertura: " + this.data + "\n";
	}

}
