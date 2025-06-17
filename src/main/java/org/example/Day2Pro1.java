package org.example;

import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;
    boolean available;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    void checkout() {
        if (available) {
            available = false;
            System.out.println("Checked out: " + title);
        } else {
            System.out.println("Already taken: " + title);
        }
    }

    void returnBook() {
        available = true;
        System.out.println("Returned: " + title);
    }

    void display() {
        System.out.println(title + " by " + author + " (" + year + ") - " + (available ? "Available" : "Not Available"));
    }
}

public class Day2Pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book("The Alchemist", "Paulo Coelho", 2001);
        Book book2 = new Book("Let Us C", "Yashavant Kanetkar", 2011);

        while (true) {
            System.out.println("\n1. Take Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            if (choice == 1 || choice == 2) {
                System.out.print("Enter book title: ");
                String title = sc.nextLine();

                if (title.equalsIgnoreCase(book1.title)) {
                    if (choice == 1) book1.checkout();
                    else book1.returnBook();
                } else if (title.equalsIgnoreCase(book2.title)) {
                    if (choice == 1) book2.checkout();
                    else book2.returnBook();
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                book1.display();
                book2.display();
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}