package programa;

import java.util.ArrayList;
import java.util.Scanner;

import model.ContaBancaria;

public class AgenciaBancaria {
	static Scanner input = new Scanner(System.in);
	static ArrayList<ContaBancaria> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<ContaBancaria>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
		System.out.println("-------------Bem vindos a nossa Agência---------------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta   |");
		System.out.println("|   Opção 2 - Depositar     |");
		System.out.println("|   Opção 3 - Sacar         |");
		System.out.println("|   Opção 4 - Transferir    |");
		System.out.println("|   Opção 5 - Listar        |");
		System.out.println("|   Opção 6 - Sair          |");
		
		int operacao = input.nextInt();
		
		switch(operacao) {
		case 1:
			criarConta();
			break;
			
		case 2:
			depositar();
			break;
		
		case 3:
			sacar();
			break;
			
		case 4:
			transferir();
			break;
			
		case 5:
			listarContas();
			break;
			
		case 6:
			System.out.println("flw é nóis ;)");
			System.exit(0);
			
		default:
			System.out.println("Opção inválida!");
			operacoes();
			break;
			
		}
		
	}
		
		 public static void criarConta() {

		        System.out.println("\nNome: ");
		        String nome = input.next();

		        System.out.println("\nCPF: ");
		        String cpf = input.next();

		        System.out.println("Email: ");
		        String email = input.next();

		        Cliente cliente = new Cliente(nome, cpf, email);

		        ContaBancaria conta = new ContaBancaria(cliente);

		        contasBancarias.add(conta);
		        System.out.println("--- Sua conta foi criada com sucesso! ---");

		        operacoes();
		
	}
		 
		 private static ContaBancaria encontrarConta(int numeroConta) {
			 ContaBancaria conta = null;
			 if(contasBancarias.size() > 0) {
				 for(ContaBancaria c: contasBancarias) {
					 if(c.getNumeroConta() == numeroConta);{
					 conta = c;
				     }
				 }
			 }
			 return conta;		 
		 }
		 
		 public static void depositar() {
			 System.out.println("Número da conta: ");
			 int numeroConta = input.nextInt();
			 
			 ContaBancaria conta = encontrarConta(numeroConta);
			 
			 if(conta != null) {
				 System.out.println("Qual valor deseja depositar? ");
				 Double valorDeposito = input.nextDouble();
				 conta.depositar(valorDeposito);
			 }else {
				 System.out.println("Conta não encontrada! ");
			 }
			 operacoes();
		 }
		 
		 public static void sacar() {
			 System.out.println("Número da conta: ");
			 int numeroConta = input.nextInt();
			 
			 ContaBancaria conta = encontrarConta(numeroConta);
			 
			 if(conta != null) {
				 System.out.println("Qual valor deseja sacar? ");
				 Double valorSaque = input.nextDouble();
				 conta.sacar(valorSaque);
			 }else {
				 System.out.println("Conta não encontrada! ");
			 }
			 operacoes();
		 }
		 
		 public static void transferir() {
			 System.out.println("Numero da conta do remetente: ");
			 int numeroContaRemetente = input.nextInt();
			 
			 ContaBancaria contaRemetente = encontrarConta(numeroContaRemetente);
			 
			 if(contaRemetente != null) {
				 System.out.println("Número da conta do destinatário: ");
				 int numeroContaDestinatario = input.nextInt();
				 
				 ContaBancaria contaDestinatario = encontrarConta(numeroContaDestinatario);
				 
				 if(contaDestinatario != null) {
					 System.out.println("Valor da transferência: ");
					 Double valor = input.nextDouble();
					 
					 contaRemetente.transferencia(contaDestinatario, valor);
				 }else {
					 System.out.println("A conta para depósito não foi econtrada!");
				 }
			 }else {
				 System.out.println("Conta para transferência não encontrada!");
			 }
			 operacoes();
			 
		 }
		 
		 public static void listarContas() {
			 if(contasBancarias.size() > 0) {
				 for(ContaBancaria conta : contasBancarias) {
					 System.out.println(conta);
				 }
			 }else {
				 System.out.println("Não há contas cadastradas!");
			 }
			 operacoes();
		 }
 
}
