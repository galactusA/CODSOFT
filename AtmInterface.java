import java.util.Scanner;

class BankAccount {
    private double balance;
    // Updating the Balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    // To know the Balance
    public double getBalance() {
        return balance;
    }
    // To deposite in the bank
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }
    // To withdraw from the bank
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: " + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
            }
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the bank account
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.run();
    }
}
