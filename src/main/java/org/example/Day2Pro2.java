package org.example;

import java.util.Scanner;

class Bank {
    private int bankBalance;
    private final Scanner sc;

    public Bank(int bankBalance, Scanner sc) {
        this.bankBalance = bankBalance;
        this.sc = sc;
    }

    public void withdraw() {
        System.out.print("Enter Withdraw Amount: ");
        int withdrawAmount = sc.nextInt();
        if (bankBalance >= withdrawAmount) {
            bankBalance -= withdrawAmount;
            System.out.println("Withdrawal successful. New balance: " + bankBalance);
        } else {
            System.out.println("Insufficient Funds!");
        }
    }

    public void deposit() {
        System.out.print("Enter Deposit Amount: ");
        int depositAmount = sc.nextInt();
        bankBalance += depositAmount;
        System.out.println("Deposit successful. New balance: " + bankBalance);
    }

    public int getBalance() {
        return bankBalance;
    }
}

public class Day2Pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Balance: ");
        int balance = sc.nextInt();

        Bank myAccount = new Bank( balance, sc);

        int choice;
        while(true){
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myAccount.deposit();
                    break;
                case 2:
                    myAccount.withdraw();
                    break;
                case 3:
                    System.out.println("Current Balance: " + myAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for banking with us.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
