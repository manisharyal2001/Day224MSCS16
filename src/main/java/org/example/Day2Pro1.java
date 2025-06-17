package org.example;

import java.util.Scanner;
public class Day2Pro1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("First Number:");
        int x = sc.nextInt();
        System.out.println("Second Number:");
        int y = sc.nextInt();

        System.out.println("enter Choice:");
        String Choice = sc.next();
        switch(Choice) {
            case "+":
                System.out.println("Sum is :"+ (x+y));
                break;
            case "-":
                System.out.println("Diff is :"+ (x-y));
                break;
            case "*":
                System.out.println("Product is :"+ (x*y));
                break;
            case "/":
                System.out.println("Division is :"+ (x/y));
                break;
            default:

                System.out.println("Invalid Choice!");

        }



    }
}