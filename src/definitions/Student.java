/*  Created by IntelliJ IDEA.
 *  User: Lakshya Yadav
 *  Date: 29/08/20
 *  Time: 6:51 PM
 *  File Name : Student.java
 * */
package definitions;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String nameOfStudent;
    private long universityRollNumber;
    private int noOfBookIssued;
    private Book[] booksStore;

    public Student() {
        this.nameOfStudent = "Himanshu";
        this.universityRollNumber = 191500341;
        this.noOfBookIssued = getNoOfBookIssued();
        this.booksStore = new Book[getNoOfBookIssued()];
        for (int i = 0; i < booksStore.length; i++) {
            booksStore[i] = new Book();
        }
    }

    public Student(String nameOfStudent, long universityRollNumber, int noOfBookIssued, Book[] booksStore) {
        this.nameOfStudent = nameOfStudent;
        this.universityRollNumber = universityRollNumber;
        this.noOfBookIssued = noOfBookIssued;
        this.booksStore = booksStore;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public long getUniversityRollNumber() {
        return universityRollNumber;
    }

    public void setUniversityRollNumber(long universityRollNumber) {
        this.universityRollNumber = universityRollNumber;
    }

    public int getNoOfBookIssued() {
        return noOfBookIssued;
    }

    public void setNoOfBookIssued(int noOfBookIssued) {
        this.noOfBookIssued = noOfBookIssued;
    }

    public Book[] getBooksStore() {
        return booksStore.clone();
    }

    public void setBooksStore(Book[] booksStore) {
        this.booksStore = booksStore;
    }

    @Override
    public String toString() {
        return "Student Name: " + nameOfStudent + "University RollNumber: " + universityRollNumber
                + "No. of Books Issued: " + noOfBookIssued + "Issued Books: " + Arrays.toString(booksStore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return getUniversityRollNumber() == student.getUniversityRollNumber()
                && getNoOfBookIssued() == student.getNoOfBookIssued()
                && Objects.equals(getNameOfStudent(), student.getNameOfStudent())
                && Arrays.equals(getBooksStore(), student.getBooksStore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfStudent(), getUniversityRollNumber(), getNoOfBookIssued())
                + Arrays.hashCode(getBooksStore());
    }

    /**
     * This method will allow us to add a new Book to our student data.
     *
     * @param bookName   The name of the new book to be added to the student data.
     * @param authorName The Author's name of the new book to be added to the
     *                   student data.
     */
    public void issueBook(String bookName, String authorName, String ISBNNumber) {
        int booksCount = getNoOfBookIssued();
        booksCount = booksCount + 1;
        setNoOfBookIssued(booksCount);
        this.booksStore = new Book[getNoOfBookIssued()];
        booksStore[getNoOfBookIssued() - 1] = new Book(bookName, authorName, ISBNNumber);
        System.out.println("Book " + bookName + " author " + authorName + " have ISBN  " + ISBNNumber + " Issued\n");
    }

    /**
     * This method will allow us to return a book.
     *
     * @param bookName   The name of the book to be returned.
     * @param authorName The Author's name of the book to be returned.
     */
    public void returnBook(String bookName, String authorName, String ISBNNumber) {
        System.out.println("Book " + bookName + " author " + authorName + " have ISBN " + ISBNNumber + " Returned\n");
    }

    /**
     * This Method will show all the books issued by student
     */
    public void showIssuedBooks() {
        if (booksStore.length == 0) {
            System.out.println("No Book Issued");
        }
        for (Book book : booksStore) {
            System.out.println("All The Books Issued are: ");
            System.out.println(book);
        }
        System.out.println();
    }
}