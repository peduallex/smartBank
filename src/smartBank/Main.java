package smartBank;

public class Main {

	public static void main(String[] args) {
		Poupanca poupancaDoRobson = new Poupanca(1, 10.50, "Robson");
		poupancaDoRobson.depositar(poupancaDoRobson, 1500);
		Corrente contaDoWesley = new Corrente(2, 1000, "Wesley");
		contaDoWesley.transferir(poupancaDoRobson, 1000);
		poupancaDoRobson.exibirSaldo();
		contaDoWesley.sacar(239.28);
		contaDoWesley.exibirSaldo();
		Poupanca poupancaDaEloa = new Poupanca(3, 500, "Eloá");
		contaDoWesley.pegarEmprestimo(1000);
		contaDoWesley.exibirSaldo();
		
		System.out.println(Poupanca.getTotal());
	
		

	}

}
