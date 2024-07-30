package sef.module4.activity;

import java.math.BigDecimal;
import java.util.Date;

public class ContaCorrente {
	private static int numero = 0;
	
	private int numeroConta;
	private Cliente cliente;
	private BigDecimal saldo;
	private Date data;
	private StringBuffer historico;
	
	public ContaCorrente(Cliente cliente) {
		ContaCorrente.numero++;//toda vez q é instanciado um novo objeto, o numero é incrementado
		this.numeroConta = numero; // atribuindo numero unico pra conta
		this.cliente = cliente;
		this.saldo = new BigDecimal("100.00"); // é preciso ter colocado 100 reais para abrir a conta
		this.data = new Date();
		this.historico = new StringBuffer("===== HISTÓRICO DE TRANSAÇÕES =====\n");
	}
	
	public class TransacaoException extends Exception {
	    public TransacaoException(String message) {
	        super(message);
	    }
	}

	public void depositar(BigDecimal valorDeposito) {
		try {
			if (valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
				throw new TransacaoException("Valor do depósito (" + valorDeposito + "R$) não atinge quantidade mínima.");
			}
			
			Date dataHoraDeposito = new Date();
			this.saldo = this.saldo.add(valorDeposito);
			System.out.printf("Conta %d: depositou R$ %.2f com sucesso.\n", this.numeroConta, valorDeposito);
			this.historico = this.historico.append("{ Deposito: +" + valorDeposito + ", Data: " + dataHoraDeposito + " }\n");
			
		} catch (TransacaoException e) {
			System.err.println("DEPÓSITO FALHOU! " + e.getMessage());
		}
	}
	
	public void sacar(BigDecimal valorSaque) {
		try {
			if (this.saldo.compareTo(valorSaque) <= 0) {
				throw new TransacaoException("Saldo insuficiente.");
			}
			
			Date dataHoraSaque = new Date();
			this.saldo = this.saldo.subtract(valorSaque);
			System.out.printf("Conta %d: sacou RS %.2f com sucesso.\n", this.numeroConta, valorSaque);
			this.historico = this.historico.append("{ Saque: -" + valorSaque + ", Data: " + dataHoraSaque + " }\n");

		} catch (TransacaoException e) {
			System.err.println("SAQUE NÃO PERMITIDO! " + e.getMessage());
		}
	}
	
	public void transferir(BigDecimal valorTransferencia, ContaCorrente contaReceptora) {
		try {
			if (this.saldo.compareTo(valorTransferencia) == -1) {
				throw new TransacaoException("Saldo insuficiente para realizar transação.");
			} else if (valorTransferencia.compareTo(BigDecimal.ONE) == -1) {
				throw new TransacaoException("O valor da transferência deve ser maior que 0.");
			} 
			
			Date dataHoraTransferencia = new Date();
			this.saldo = this.saldo.subtract(valorTransferencia);
			this.historico = this.historico.append("{ Transferência: -" + valorTransferencia + 
						", Conta Receptora: " + contaReceptora.numeroConta + 
						", CPF do Titular: " + contaReceptora.cliente.getCpf() +
						", Data: " + dataHoraTransferencia + " }\n");
			
			contaReceptora.saldo = contaReceptora.saldo.add(valorTransferencia);
			contaReceptora.historico = contaReceptora.historico.append("{ Transferência: +" + valorTransferencia + 
					", Conta Transferente: " + this.numeroConta + 
					", CPF do Titular: " + this.cliente.getCpf() +
					", Data: " + dataHoraTransferencia + " }\n");
			System.out.println("Transferência concluída.");
		} catch (TransacaoException e) {
			System.err.println("TRANSFERÊNCIA NÃO AUTORIZADA! " + e.getMessage());
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
