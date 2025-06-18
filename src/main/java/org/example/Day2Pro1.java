package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

public class Day2Pro1 {
    public static void main(String[] args) {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/");
        MongoDatabase database = mongoClient.getDatabase("BookStore");
        MongoCollection<Document> collection = database.getCollection("Library");

        Scanner sc = new Scanner(System.in);

        // Two sample books to insert
        insertBookIfNotExists(collection, "The Alchemist", "Paulo Coelho", 2001);
        insertBookIfNotExists(collection, "Let Us C", "Yashavant Kanetkar", 2011);

        while (true) {
            System.out.println("\n1. Take Book");
            System.out.println("2. Return Book");
            System.out.println("3. View Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            if (choice == 1 || choice == 2) {
                System.out.print("Enter book title: ");
                String title = sc.nextLine();

                Document query = new Document("title", title);
                Document book = collection.find(query).first();

                if (book != null) {
                    boolean available = book.getBoolean("available");
                    if (choice == 1 && available) {
                        collection.updateOne(query, new Document("$set", new Document("available", false)));
                        System.out.println("Checked out: " + title);
                    } else if (choice == 2) {
                        collection.updateOne(query, new Document("$set", new Document("available", true)));
                        System.out.println("Returned: " + title);
                    } else {
                        System.out.println("Book already taken.");
                    }
                } else {
                    System.out.println("Book not found.");
                }
            } else if (choice == 3) {
                for (Document doc : collection.find()) {
                    System.out.println(doc.getString("title") + " by " + doc.getString("author") +
                            " (" + doc.getInteger("year") + ") - " +
                            (doc.getBoolean("available") ? "Available" : "Not Available"));
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
        mongoClient.close();
    }

    static void insertBookIfNotExists(MongoCollection<Document> collection, String title, String author, int year) {
        if (collection.find(new Document("title", title)).first() == null) {
            Document book = new Document("title", title)
                    .append("author", author)
                    .append("year", year)
                    .append("available", true);
            collection.insertOne(book);
        }
    }
}