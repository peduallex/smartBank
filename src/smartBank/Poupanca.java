package smartBank;

public class Poupanca extends Conta implements CaixaEletronico {
	private static int total;
	
	public Poupanca(int numero, double saldo, String titular) {
		super(numero, saldo, titular);
		total++;
	}
	
	public static int getTotal() {
		return total;
	}
	
	@Override
	public void exibirSaldo() {
		System.out.println("Seu saldo é: " + this.getSaldo());
		
	}

	@Override
	public void transferir(Conta conta, double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("Transação realizada!");
		}else {
			System.out.println("Saldo insuficiente!");
		}
		
	}

	@Override
	public void depositar(Conta conta, double valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		System.out.println("Transação realizada!");
	}

	@Override
	public void sacar(double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("Transação realizada!");
		}else {
			System.out.println("Saldo insuficiente!");
		}
		
	}
}
