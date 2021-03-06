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
    private int numberOfBookIssued;
    private Book[] booksStore;

    public Student() {
        this.nameOfStudent = "Lakshya Yadav";
        this.universityRollNumber = 191500427;
        this.numberOfBookIssued = getNumberOfBookIssued();
        this.booksStore = new Book[getNumberOfBookIssued()];
        for (int index = 0; index < booksStore.length; index++) {
            booksStore[index] = new Book();
        }
    }

    public Student(String nameOfStudent, long universityRollNumber, int numberOfBooksIssued, Book[] booksStore) {
        this.nameOfStudent = nameOfStudent;
        this.universityRollNumber = universityRollNumber;
        this.numberOfBookIssued = numberOfBooksIssued;
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

    public int getNumberOfBookIssued() {
        return numberOfBookIssued;
    }

    public void setNoOfBookIssued(int numberOfBookIssued) {
        this.numberOfBookIssued = numberOfBookIssued;
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
                + "No. of Books Issued: " + numberOfBookIssued + "Issued Books: " + Arrays.toString(booksStore);
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
                && getNumberOfBookIssued() == student.getNumberOfBookIssued()
                && Objects.equals(getNameOfStudent(), student.getNameOfStudent())
                && Arrays.equals(getBooksStore(), student.getBooksStore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfStudent(), getUniversityRollNumber(), getNumberOfBookIssued())
                + Arrays.hashCode(getBooksStore());
    }

    /**
     * This method will allow us to add a new Book to our student data.
     *
     * @param bookName   The name of the new book to be added to the student data.
     * @param authorName The Author's name of the new book to be added to the
     *                   student data.
     * @param ISBNNumber The ISBN number to be added to student data.
     */
    public void issueBook(String bookName, String authorName, String ISBNNumber) {
        int booksCount = getNumberOfBookIssued();
        booksCount = booksCount + 1;
        setNoOfBookIssued(booksCount);
        this.booksStore = new Book[getNumberOfBookIssued()];
        booksStore[getNumberOfBookIssued() - 1] = new Book(bookName, authorName, ISBNNumber);
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