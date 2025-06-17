package org.example;

import java.util.Scanner;

class Book {
    private final String title;
    private final String author;
    private final int year;
    private boolean available;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public void checkout() {
        if (available) {
            available = false;
            System.out.println("Book checked out: " + title);
        } else {
            System.out.println("Book unavailable: " + title);
        }
    }

    public void returnBook() {
        available = true;
        System.out.println("Book returned: " + title);
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println();
    }

    public String getTitle() {
        return title;
    }
}

class FictionBook extends Book {
    public FictionBook(String title, String author, int year) {
        super(title, author, year);
    }
}

class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, int year) {
        super(title, author, year);
    }
}


public class Day2Pro1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FictionBook novel = new FictionBook("The Alchemist", "Paulo Coelho", 2001);
        NonFictionBook textbook = new NonFictionBook("Let Us C", "Yashavant Kanetkar", 2011);

        while (true) {
            System.out.println("\nChoose an option:\n1 - Take a book\n2 - Return a book\n3 - View all books\n0 - Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter book title to checkout:");
                    sc.nextLine();  // consume leftover newline
                    String takeTitle = sc.nextLine();
                    if (takeTitle.equalsIgnoreCase(novel.getTitle())) {
                        novel.checkout();
                    } else if (takeTitle.equalsIgnoreCase(textbook.getTitle())) {
                        textbook.checkout();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter book title to return:");
                    sc.nextLine();
                    String returnTitle = sc.nextLine();
                    if (returnTitle.equalsIgnoreCase(novel.getTitle())) {
                        novel.returnBook();
                    } else if (returnTitle.equalsIgnoreCase(textbook.getTitle())) {
                        textbook.returnBook();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.println("Available Books:");
                    novel.displayInfo();
                    textbook.displayInfo();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}