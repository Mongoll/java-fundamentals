package com.mongol.library;
import java.util.Scanner;

public class Users {

    Scanner input = new Scanner(System.in);
    User theUsers[] = new User[50];
    public static int count = 0;

    public void addUser(User s)
    {
        for (int i = 0; i < count; i++) {
            if (s.regNum.equalsIgnoreCase(
                    theUsers[i].regNum)) {
                System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
                return;
            }
        }

        if (count <= 50) {
            theUsers[count] = s;
            count++;
        }
    }

    public void showAllUsers()
    {
        System.out.println("User Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theUsers[i].userName + "\t\t" + theUsers[i].regNum);
        }
    }

    public int isUser()
    {
        System.out.println("Enter Reg Number:");
        String regNum = input.nextLine();
        for (int i = 0; i < count; i++) {
            if (theUsers[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        System.out.println("User is not Registered.");
        System.out.println("Get Registered First.");
        return -1;
    }

    public void checkOutBook(Books book)
    {
        int userIndex = this.isUser();

        if (userIndex != -1) {
            System.out.println("checking out");
            book.showAllBooks();
            Book b = book.checkOutBook();
            System.out.println("checking out");
            if (b != null) {
                if (theUsers[userIndex].booksCount <= 3) {
                    System.out.println("adding book");
                    theUsers[userIndex].borrowedBooks[theUsers[userIndex].booksCount] = b;
                    theUsers[userIndex].booksCount++;
                    return;
                }
                else {
                    System.out.println("User Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    public void checkInBook(Books book)
    {
        int userIndex = this.isUser();
        if (userIndex != -1) {
            System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
            User s = theUsers[userIndex];
            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            System.out.println("Enter Serial Number of Book to be Checked In:");
            int sNo = input.nextInt();
            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
                    return;
                }
            }

            System.out.println("Book of Serial No " + sNo + "not Found");
        }
    }
}