package smartBank;

public class Corrente extends Conta implements CaixaEletronico {
	private double creditoEspecial = 1000.00;
	private double taxa = 0.45;
	private double emprestimo = 0;
	private double jurosEmprestimo = 0;
	private double taxaEmprestimo = 1.8;
	
	public Corrente(int numero, double saldo, String titular) {
		super(numero, saldo, titular);
	}
	
	public void calcularTaxa() {
		if (this.creditoEspecial < 1000) {
			double novoCred = 1000 - this.creditoEspecial;
			novoCred *= taxa;
			this.setSaldo(getSaldo() - novoCred);
		} 
		if (this.emprestimo > 0) {
			jurosEmprestimo = emprestimo * taxaEmprestimo;
		}
	}

	@Override
	public void exibirSaldo() {
		calcularTaxa();
		System.out.println("Seu saldo é: " + this.getSaldo());
		System.out.println("Seu credito especial é: " + this.creditoEspecial);
		System.out.println("Valor de seu empréstimo " + this.emprestimo);
		System.out.println("Juros de seu empréstimo " + this.jurosEmprestimo);
		
	}

	@Override
	public void transferir(Conta conta, double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("Transação realizada!");
		}else if (this.creditoEspecial >= valor) {
			this.creditoEspecial -= valor; 
			this.setSaldo(this.getSaldo() - valor);
			conta.setSaldo(conta.getSaldo() + valor);
			System.out.println("Transação realizada!");
		} else {
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
		}else if (this.creditoEspecial >= valor) {
			this.creditoEspecial -= valor; 
			this.setSaldo(this.getSaldo() - valor);
			System.out.println("Transação realizada!");
		} else {
			System.out.println("Saldo insuficiente!");
		}
		
	}
	
	public double pegarEmprestimo(double valor) {
		this.setSaldo(this.getSaldo() + valor);
		return emprestimo = valor;
	}
	
	public double getJurosEmprestimo() {
		return jurosEmprestimo;
	}
	
	public double getEmprestimo() {
		return emprestimo;
	}
	
}
