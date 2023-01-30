package com.mongol.library;

import java.util.Scanner;

public class Library {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("				 Select From The Following Options:			 ");
        System.out.println("_____________________________________________________________");

        Books ob = new Books();
        // Creating object of students class
        Users obUser = new Users();

        int choice;
        int searchChoice;
        do {

            ob.dispMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;
                case 2:
                    ob.upgradeBookQty();
                    break;
                case 3:
                    System.out.println(
                            " press 1 to Search with Book Serial No.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();
                    switch (searchChoice) {
                        case 1:
                            ob.searchBySno();
                            break;
                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;
                case 4:
                    ob.showAllBooks();
                    break;
                case 5:
                    User s = new User();
                    obUser.addUser(s);
                    break;
                case 6:
                    obUser.showAllUsers();
                    break;
                case 7:
                    obUser.checkOutBook(ob);
                    break;
                case 8:
                    obUser.checkInBook(ob);
                    break;

                default:

                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }

        while (choice != 0);
    }
}