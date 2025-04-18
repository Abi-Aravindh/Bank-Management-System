import java.util.Scanner;

class BankAccount {
    String name;
    String accType;
    int accNumber;
    double balance;

    void openAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        name = sc.nextLine();
        System.out.print("Enter account type (Savings/Current): ");
        accType = sc.nextLine();
        System.out.print("Enter account number: ");
        accNumber = sc.nextInt();
        System.out.print("Enter initial balance: ");
        balance = sc.nextDouble();
    }

    void showAccount() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Type: " + accType);
        System.out.println("Account Number: " + accNumber);
        System.out.println("Balance: ₹" + balance);
    }

    void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    boolean search(int accNo) {
        if (accNumber == accNo) {
            showAccount();
            return true;
        }
        return false;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many accounts do you want to create? ");
        int n = sc.nextInt();
        BankAccount[] accounts = new BankAccount[n];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount();
            accounts[i].openAccount();
        }

        int choice;
        do {
            System.out.println("\n=== BANK MENU ===");
            System.out.println("1. Display All Accounts");
            System.out.println("2. Search by Account Number");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (BankAccount acc : accounts) {
                        acc.showAccount();
                        System.out.println("--------------------");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number to search: ");
                    int accNo = sc.nextInt();
                    boolean found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.search(accNo)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextInt();
                    found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.search(accNo)) {
                            acc.deposit();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accNo = sc.nextInt();
                    found = false;
                    for (BankAccount acc : accounts) {
                        if (acc.search(accNo)) {
                            acc.withdraw();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}