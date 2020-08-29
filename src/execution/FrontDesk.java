/*  Created by IntelliJ IDEA.
 *  User: Lakshya Yadav
 *  Date: 29/08/20
 *  Time: 6:51 PM
 *  File Name : FrontDesk.java
 * */
package execution;

import definitions.Student;

import java.util.Scanner;

public class FrontDesk {
    private static final int ISSUE_BOOK = 1;
    private static final int RETURN_BOOK = 2;
    private static final int SHOW_ALL_BOOKS = 3;
    private static final int EXIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int customerInput;
        Student studentInfo = new Student();
        String bookName;
        String authorName;
        String ISBNNumber;
        do {
            System.out.print("-=-=--=-=-");
            System.out.print("Welcome To The Front Desk");
            System.out.println("-=-=--=-=-");
            System.out.println("How may I help you today?");
            System.out.println("1. Issue a new book.");
            System.out.println("2. Return a previously issues book.");
            System.out.println("3. Show all my Issue books.");
            System.out.println("4. Exit.");
            customerInput = scanner.nextInt();
            switch (customerInput) {
                case ISSUE_BOOK:
                    System.out.println("Enter the name of the Book you want to issue: ");
                    scanner.nextLine();
                    bookName = scanner.nextLine();
                    System.out.println("Enter Author Name");
                    authorName = scanner.nextLine();
                    System.out.println("Enter ISBN Number of Book");
                    ISBNNumber = scanner.nextLine();
                    studentInfo.issueBook(bookName, authorName, ISBNNumber);
                    break;
                case RETURN_BOOK:
                    System.out.println("Enter the name of the Book you want to return: ");
                    scanner.nextLine();
                    bookName = scanner.nextLine();
                    System.out.println("Enter Author Name");
                    authorName = scanner.nextLine();
                    System.out.println("Enter ISBN Number of Book");
                    ISBNNumber = scanner.nextLine();
                    studentInfo.returnBook(bookName, authorName, ISBNNumber);
                    break;
                case SHOW_ALL_BOOKS:
                    studentInfo.showIssuedBooks();
                    break;
                default:
                    break;
            }
        } while (customerInput != EXIT);
        System.out.println("Thank You For Your Visit");
        scanner.close();
    }

}
