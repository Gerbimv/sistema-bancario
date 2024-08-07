package application;

import java.util.Locale;
import java.util.Scanner;

import bank.Account;
import bank.ContaCorrente;
import bank.ContaPoupanca;

public class Program {

    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private static ContaPoupanca contaPoupanca = null;
    private static ContaCorrente contaCorrente = null;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        System.out.println("    GERBANK    ");
        System.out.println("--------------------------------------");

        char initial;
        do {
            System.out.println("Iniciar? (y/n)");
            initial = sc.next().charAt(0);
            if (initial == 'y') {
                exibirMenuPrincipal();
            }
        } while (initial != 'n');

        System.out.println("GERBANK AGRADECE PELO SEU SERVIÇO!");
        sc.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("O que deseja fazer hoje:");
        System.out.println("1 - Criar conta corrente");
        System.out.println("2 - Criar conta poupança");
        System.out.println("3 - Acessar conta corrente");
        System.out.println("4 - Acessar conta poupança");
        System.out.println("5 - Quantidade de contas");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                criarContaCorrente();
                break;
            case 2:
                criarContaPoupanca();
                break;
            case 3:
                acessarContaCorrente();
                break;
            case 4:
                acessarContaPoupanca();
                break;
            case 5:
                mostrarQuantidadeContas();
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void criarContaCorrente() {
        System.out.println("Informe o numero do banco:");
        int numberBank = sc.nextInt();
        System.out.println("Informe o numero da conta:");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o nome do titular:");
        String holder = sc.nextLine();
        System.out.println("Deseja fazer um deposito? (y/n)");
        char response = sc.next().charAt(0);

        if (response == 'y') {
            System.out.println("Insira o valor do depósito:");
            double initialDeposit = sc.nextDouble();
            contaCorrente = new ContaCorrente(numberBank, number, "Conta Corrente", holder, initialDeposit);
        } else {
            contaCorrente = new ContaCorrente(numberBank, number, holder);
        }
        System.out.println("Conta Corrente Criada com Sucesso!");
    }

    private static void criarContaPoupanca() {
        System.out.println("Informe o numero do banco:");
        int numberBank = sc.nextInt();
        System.out.println("Informe o numero da conta:");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o nome do titular:");
        String holder = sc.nextLine();
        System.out.println("Deseja fazer um deposito? (y/n)");
        char response = sc.next().charAt(0);

        if (response == 'y') {
            System.out.println("Insira o valor do depósito:");
            double initialDeposit = sc.nextDouble();
            contaPoupanca = new ContaPoupanca(numberBank, number, "Conta Poupança", holder, initialDeposit);
        } else {
            contaPoupanca = new ContaPoupanca(numberBank, number, holder);
        }
        System.out.println("Conta Poupança Criada com Sucesso!");
    }

    private static void acessarContaCorrente() {
        if (contaCorrente == null) {
            System.out.println("Nenhuma Conta Corrente encontrada.");
            return;
        }

        System.out.println("Insira o número da conta:");
        int number = sc.nextInt();
        if (number == contaCorrente.getAccountNumber()) {
            exibirMenuContaCorrente(contaCorrente, contaPoupanca);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void acessarContaPoupanca() {
        if (contaPoupanca == null) {
            System.out.println("Nenhuma Conta Poupança encontrada.");
            return;
        }

        System.out.println("Insira o número da conta:");
        int number = sc.nextInt();
        if (number == contaPoupanca.getAccountNumber()) {
            exibirMenuContaPoupanca(contaPoupanca, contaCorrente);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void exibirMenuContaCorrente(ContaCorrente conta, ContaPoupanca contaTransferencia) {
        System.out.println(conta);
        System.out.println("1 - Sacar Dinheiro");
        System.out.println("2 - Depositar Dinheiro");
        System.out.println("3 - Transferir Dinheiro");
        System.out.println("0 - Sair");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Insira a quantia que deseja sacar:");
                double amount = sc.nextDouble();
                if (conta.withdraw(amount)) {
                    System.out.println("Saque Realizado");
                } else {
                    System.out.println("Saldo Insuficiente");
                }
                break;
            case 2:
                System.out.println("Insira a quantia que deseja depositar:");
                amount = sc.nextDouble();
                conta.deposit(amount);
                System.out.println("Deposito Realizado");
                break;
            case 3:
                System.out.println("Qual o numero da conta que deseja transferir:");
                int numberTransfer = sc.nextInt();
                if (contaTransferencia != null && numberTransfer == contaTransferencia.getAccountNumber()) {
                    System.out.println("Qual o valor que deseja transferir:");
                    amount = sc.nextDouble();
                    if (conta.withdraw(amount)) {
                        contaTransferencia.deposit(amount);
                        System.out.println("Transferência Realizada");
                    } else {
                        System.out.println("Saldo Insuficiente");
                    }
                } else {
                    System.out.println("Conta não encontrada");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }
    private static void exibirMenuContaPoupanca(Account conta, Account account) {
        System.out.println(conta);
        System.out.println("1 - Sacar Dinheiro");
        System.out.println("2 - Depositar Dinheiro");
        System.out.println("3 - Transferir Dinheiro");
        System.out.println("0 - Sair");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                System.out.println("Insira a quantia que deseja sacar:");
                double amount = sc.nextDouble();
                if (conta.withdraw(amount)) {
                    System.out.println("Saque Realizado");
                } else {
                    System.out.println("Saldo Insuficiente");
                }
                break;
            case 2:
                System.out.println("Insira a quantia que deseja depositar:");
                amount = sc.nextDouble();
                conta.deposit(amount);
                System.out.println("Deposito Realizado");
                break;
            case 3:
                System.out.println("Qual o numero da conta que deseja transferir:");
                int accountTarget = sc.nextInt();
                if (contaTransferencia != null && numberTransfer == contaTransferencia.getAccountNumber()) {
                    System.out.println("Qual o valor que deseja transferir:");
                    amount = sc.nextDouble();
                    if (conta.transfer(accountTarget ,amount)) {
                        contaTransferencia.deposit(amount);
                        System.out.println("Transferência Realizada");
                    } else {
                        System.out.println("Saldo Insuficiente");
                    }
                } else {
                    System.out.println("Conta não encontrada");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void mostrarQuantidadeContas() {
        System.out.println("Contas Poupanças Criadas: " + (contaPoupanca != null ? contaPoupanca.total() : 0));
        System.out.println("Contas Corrente Criadas: " + (contaCorrente != null ? contaCorrente.total() : 0));
    }
}
