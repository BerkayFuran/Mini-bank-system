import java.util.Scanner;

public class MiniBankSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Balance: ");
        double balance = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("PIN: ");
        String pin = scanner.nextLine();

        boolean isRunning = true;

        do {
            System.out.println("\n===== MINI BANK =====");
            System.out.println("1 - Account Information");
            System.out.println("2 - Deposit Money");
            System.out.println("3 - Withdraw Money");
            System.out.println("4 - Transfer Money");
            System.out.println("5 - ATM Withdrawal");
            System.out.println("6 - Currency Exchange");
            System.out.println("7 - Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n===== ACCOUNT INFORMATION =====");
                    System.out.println("Customer Name   : " + customerName);
                    System.out.println("Account Number  : " + accountNumber);
                    System.out.println("Current Balance : " + String.format("%.2f", balance) + " EUR");
                    break;

                case 2:
                    System.out.println("\n===== DEPOSIT MONEY =====");
                    System.out.println("Current Balance: " + String.format("%.2f", balance) + " EUR");

                    System.out.print("Deposit Amount: ");
                    double depositAmount = scanner.nextDouble();

                    if (depositAmount > 0) {
                        balance += depositAmount;

                        System.out.println("Deposit successful.");
                        System.out.println("New Balance: " + String.format("%.2f", balance) + " EUR");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.println("\n===== WITHDRAW MONEY =====");
                    System.out.println("Current Balance: " + String.format("%.2f", balance) + " EUR");

                    System.out.print("Withdraw Amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;

                        System.out.println("Withdrawal successful.");
                        System.out.println("New Balance: " + String.format("%.2f", balance) + " EUR");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== TRANSFER MONEY =====");

                    scanner.nextLine();

                    System.out.print("Receiver Name: ");
                    String receiverName = scanner.nextLine();

                    System.out.print("Receiver Account Number: ");
                    String receiverAccountNumber = scanner.nextLine();

                    System.out.print("Transfer Amount: ");
                    double transferAmount = scanner.nextDouble();

                    if (transferAmount > 0 && transferAmount <= balance) {
                        balance -= transferAmount;

                        System.out.println("Transfer successful.");
                        System.out.println(
                                String.format("%.2f", transferAmount)
                                        + " EUR transferred to "
                                        + receiverName
                        );
                        System.out.println("Receiver Account: " + receiverAccountNumber);
                        System.out.println("New Balance: " + String.format("%.2f", balance) + " EUR");
                    } else if (transferAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 5:
                    System.out.println("\n===== ATM WITHDRAWAL =====");

                    scanner.nextLine();

                    System.out.print("Enter PIN: ");
                    String enteredPin = scanner.nextLine();

                    if (enteredPin.equals(pin)) {

                        System.out.print("Withdrawal Amount: ");
                        double atmWithdrawAmount = scanner.nextDouble();

                        if (atmWithdrawAmount > 0 && atmWithdrawAmount <= balance) {
                            balance -= atmWithdrawAmount;

                            System.out.println(
                                    "Withdrawn Amount: "
                                            + String.format("%.2f", atmWithdrawAmount)
                                            + " EUR"
                            );
                            System.out.println(
                                    "Remaining Balance: "
                                            + String.format("%.2f", balance)
                                            + " EUR"
                            );

                            scanner.nextLine();

                            System.out.print("Do you want a receipt? (yes/no): ");
                            String receiptChoice = scanner.nextLine();

                            if (receiptChoice.equalsIgnoreCase("yes")) {
                                System.out.println("\n===== RECEIPT =====");
                                System.out.println(
                                        "Withdrawn Amount : "
                                                + String.format("%.2f", atmWithdrawAmount)
                                                + " EUR"
                                );
                                System.out.println(
                                        "Remaining Balance: "
                                                + String.format("%.2f", balance)
                                                + " EUR"
                                );
                            }

                        } else if (atmWithdrawAmount > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            System.out.println("Invalid amount.");
                        }

                    } else {
                        System.out.println("Incorrect PIN.");
                    }
                    break;

                case 6:
                    System.out.println("\n===== CURRENCY EXCHANGE =====");
                    System.out.println("1 - EUR to USD");
                    System.out.println("2 - EUR to TRY");
                    System.out.println("3 - EUR to MKD");

                    System.out.print("Choose currency: ");
                    int currencyChoice = scanner.nextInt();

                    System.out.print("Amount: ");
                    double exchangeAmount = scanner.nextDouble();

                    if (exchangeAmount > 0 && exchangeAmount <= balance) {

                        switch (currencyChoice) {

                            case 1:
                                double usdRate = 1.17;
                                double usdAmount = exchangeAmount * usdRate;

                                balance -= exchangeAmount;

                                System.out.println(
                                        "Converted Amount: "
                                                + String.format("%.2f", usdAmount)
                                                + " USD"
                                );
                                System.out.println(
                                        "Remaining Balance: "
                                                + String.format("%.2f", balance)
                                                + " EUR"
                                );
                                break;

                            case 2:
                                double tryRate = 48.50;
                                double tryAmount = exchangeAmount * tryRate;

                                balance -= exchangeAmount;

                                System.out.println(
                                        "Converted Amount: "
                                                + String.format("%.2f", tryAmount)
                                                + " TRY"
                                );
                                System.out.println(
                                        "Remaining Balance: "
                                                + String.format("%.2f", balance)
                                                + " EUR"
                                );
                                break;

                            case 3:
                                double mkdRate = 61.50;
                                double mkdAmount = exchangeAmount * mkdRate;

                                balance -= exchangeAmount;

                                System.out.println(
                                        "Converted Amount: "
                                                + String.format("%.2f", mkdAmount)
                                                + " MKD"
                                );
                                System.out.println(
                                        "Remaining Balance: "
                                                + String.format("%.2f", balance)
                                                + " EUR"
                                );
                                break;

                            default:
                                System.out.println("Invalid currency option.");
                                break;
                        }

                    } else if (exchangeAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 7:
                    System.out.println("\nThank you for using Mini Bank.");
                    System.out.println("Goodbye!");

                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (isRunning);

        scanner.close();
    }
}
