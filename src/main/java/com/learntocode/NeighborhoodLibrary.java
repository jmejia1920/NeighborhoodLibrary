package com.learntocode;

import java.util.ArrayList;
import java.util.Scanner;

public class NeighborhoodLibrary {
   private static ArrayList<Book> amountOfBooks;
    public static void main() {
        amountOfBooks = new ArrayList<>();
        amountOfBooks.add(new Book(10092,"1098758","The Black Cat"));
        amountOfBooks.add(new Book(10093,"1098754","The Raven"));
        amountOfBooks.add(new Book(10094,"1098756","The Tell-Tale Heart"));
        amountOfBooks.add(new Book(10095,"1098757","Anabel Lee"));
       amountOfBooks.add(new Book(10096,"1098759","Macbeth"));

        Scanner scanner = new Scanner(System.in);


        boolean exit = false;
        while(!exit){
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Exit");
            System.out.println("Enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: listAvailableBooks(scanner);
                    break;
                case 2:checkedOutBooks(scanner);
                    break;
                case 3:return;
                default:
                    System.out.println("Invalid Input");
            }

        }
    }
    private static void listAvailableBooks(Scanner scanner) {
        System.out.println("Available Books:");
        for (Book book : amountOfBooks) {
            if (!book.isCheckedOut()) {
                System.out.println(book.getId()+ " - " + book.getTitle());
            }
        }
        System.out.println("Enter the ID of the book you want to check out, or enter 'X' to go back to the home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            return;
        }
        try {
            int bookId = Integer.parseInt(input);
            Book book = getBookById(bookId);
            if (book == null) {
                System.out.println("Invalid book ID");
                return;
            }
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            book.CheckOut(name);
            System.out.println(book.getTitle() + " has been checked out to " + name);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    private static void checkedOutBooks(Scanner scanner) {
        System.out.println("Checked Out Books:");
        for (Book book : amountOfBooks) {
            if (book.isCheckedOut()) {
                System.out.println(book.getId() + ". " + book.getIsbn() + " - " + book.getTitle() + " (checked out to " + book.getCheckedOutTo() + ")");
            }
        }
        System.out.println("Enter 'C' to check in a book, or enter 'X' to go back to the home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("X")) {
            return;
        }
        if (input.equalsIgnoreCase("C")) {
            System.out.println("Enter the ID of the book you want to check in:");
            input = scanner.nextLine();
            try {
                int bookId = Integer.parseInt(input);
                Book book = getBookById(bookId);
                if (book == null) {
                    System.out.println("Invalid book ID");
                    return;
                }
                book.checkIn();
                System.out.println(book.getTitle() + " has been checked in");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    private static Book getBookById(int id) {
        for (Book book : amountOfBooks) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        NeighborhoodLibrary library = new NeighborhoodLibrary();
        library.main();
    }





}

