package br.com.bank.cli;

import br.com.bank.repository.AccountRepository;
import br.com.bank.service.BankService;
import br.com.bank.model.Account;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        BankService service = new BankService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== BANK SIMULATOR ===");
            System.out.println("1 - Create Checking Account");
            System.out.println("2 - Create Savings Account");
            System.out.println("3 - Deposit");
            System.out.println("4 - Withdraw");
            System.out.println("5 - Transfer");
            System.out.println("6 - List Accounts");
            System.out.println("7 - Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (option) {
                    case 1:
                        System.out.print("Account number: ");
                        int ccNumber = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Owner name: ");
                        String ccOwner = scanner.nextLine();

                        service.createCheckingAccount(ccNumber, ccOwner);
                        System.out.println("Checking account created successfully.");
                        break;

                    case 2:
                        System.out.print("Account number: ");
                        int saNumber = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Owner name: ");
                        String saOwner = scanner.nextLine();

                        service.createSavingsAccount(saNumber, saOwner);
                        System.out.println("Savings account created successfully.");
                        break;

                    case 3:
                        System.out.print("Account number: ");
                        int depNumber = scanner.nextInt();
                        System.out.print("Amount: ");
                        double depValue = scanner.nextDouble();

                        service.deposit(depNumber, depValue);
                        System.out.println("Deposit successful.");
                        break;

                    case 4:
                        System.out.print("Account number: ");
                        int wdNumber = scanner.nextInt();
                        System.out.print("Amount: ");
                        double wdValue = scanner.nextDouble();

                        service.withdraw(wdNumber, wdValue);
                        System.out.println("Withdrawal successful.");
                        break;

                    case 5:
                        System.out.print("Source account number: ");
                        int source = scanner.nextInt();

                        System.out.print("Destination account number: ");
                        int destination = scanner.nextInt();

                        System.out.print("Amount: ");
                        double amount = scanner.nextDouble();

                        service.transfer(source, destination, amount);
                        System.out.println("Transfer successful.");
                        break;

                    case 6:
                        for (Account account : service.listAccounts()) {
                            System.out.println(account);
                        }
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}