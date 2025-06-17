/*package org.example;

import java.util.Scanner;

class Bank {
    private final String Account_Holder_Name;
    private   final long Account_Number;
    private int Bank_Balance;
    

    public Bank(String Account_Holder_Name, long Account_Number, int Bank_Balance) {
        this.Account_Holder_Name = Account_Holder_Name;
        this.Account_Number = Account_Number;
        this.Bank_Balance = Bank_Balance;
    }

    public void withdraw() {
        System.out.println("Enter Withdraw Amount:");
        int withdraw_amount= sc.nextInt();
        if (Bank_Balance>=withdraw_amount) {
            Bank_Balance = Bank_Balance-withdraw_amount;
        } else {
            System.out.println("Insufficient Funds!");
        }
    }

    public void deposit() {
        System.out.println("Enter Deposit Amount:");
        int deposit_amount= sc.nextInt();
        Bank_Balance=Bank_Balance+deposit_amount;
    }

        }

    public int getBalance() {
        return Bank_Balance;
    }



public class Day2Pro2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        
    }
}*/

package org.example;

import java.util.Scanner;

class Bank {
    private final String accountHolderName;
    private final long accountNumber;
    private int bankBalance;
    private final Scanner sc;

    public Bank(String accountHolderName, long accountNumber, int bankBalance, Scanner sc) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
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

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        long accNumber = sc.nextLong();
        System.out.print("Enter Initial Balance: ");
        int balance = sc.nextInt();

        Bank myAccount = new Bank(name, accNumber, balance, sc);

        int choice;
        do {
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
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
