package com.mongol.library;

import java.util.Scanner;

public class User {

    String userName;
    String regNum;
    Book borrowedBooks[] = new Book[3];
    public int booksCount = 0;
    Scanner input = new Scanner(System.in);

    public User()
    {
        System.out.println("Enter User Name:");
        this.userName = input.nextLine();
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}