package smartBank;

public interface CaixaEletronico {
	public void exibirSaldo();
	public void transferir(Conta conta, double valor);
	public void depositar(Conta conta, double valor);
	public void sacar(double valor);
}
