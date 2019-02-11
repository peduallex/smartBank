package smartBank;

public abstract class Conta {
	private int numero;
	private double saldo;
	private String titular;
	
	public Conta(int numero, double saldo, String titular) {
		this.numero = numero;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}
	
}
