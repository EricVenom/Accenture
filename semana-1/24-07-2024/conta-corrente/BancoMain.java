package sef.module4.activity;

public class BancoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente1 = new Cliente("Jose", "Silva", "111.111.111-11");
		ContaCorrente conta1 = new ContaCorrente(cliente1);
		System.out.println(conta1.toString());
		
		Cliente cliente2 = new Cliente("Maria", "Santos", "222.222.222-22");
		ContaCorrente conta2 = new ContaCorrente(cliente2);
		System.out.println(conta2.toString());
		
		conta1.depositar(300);
		conta1.depositar(30);
		conta1.sacar(230);
		conta1.transferir(100, conta2);
		conta1.exibirExtrato();
		
		conta2.sacar(200);
		conta2.exibirExtrato();
	}

}
