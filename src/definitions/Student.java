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
    private long universityRollNumberOfStudent;
    private int numberOfBookIssuedByStudent;
    private Book[] nameOfBooksIssuedByStudent;

    public Student() {
        this.nameOfStudent = "Lakshya";
        this.universityRollNumberOfStudent = 191500427;
        this.numberOfBookIssuedByStudent = getNumberOfBookIssued();
        this.nameOfBooksIssuedByStudent = new Book[getNumberOfBookIssued()];
        for (int index = 0; index < nameOfBooksIssuedByStudent.length; index++) {
            nameOfBooksIssuedByStudent[index] = new Book();
        }
    }

    public Student(String nameOfStudent, long universityRollNumber, int numberOfBookIssued, Book[] bookStore) {
        this.nameOfStudent = nameOfStudent;
        this.universityRollNumberOfStudent = universityRollNumber;
        this.numberOfBookIssuedByStudent = numberOfBookIssued;
        this.nameOfBooksIssuedByStudent = bookStore;
    }

    public String getNameOfStudent() {
        return nameOfStudent;
    }

    public void setNameOfStudent(String nameOfStudent) {
        this.nameOfStudent = nameOfStudent;
    }

    public long getUniversityRollNumber() {
        return universityRollNumberOfStudent;
    }

    public void setUniversityRollNumber(long universityRollNumber) {
        this.universityRollNumberOfStudent = universityRollNumber;
    }

    public int getNumberOfBookIssued() {
        return numberOfBookIssuedByStudent;
    }

    public void setNoOfBookIssued(int numberOfBookIssued) {
        this.numberOfBookIssuedByStudent = numberOfBookIssued;
    }

    public Book[] getBooksStore() {
        return nameOfBooksIssuedByStudent.clone();
    }

    public void setBooksStore(Book[] booksStore) {
        this.nameOfBooksIssuedByStudent = booksStore;
    }

    @Override
    public String toString() {
        return "Student Name: " + nameOfStudent + "University RollNumber: " + universityRollNumberOfStudent
                + "No. of Books Issued: " + numberOfBookIssuedByStudent + "Issued Books: " + Arrays.toString(nameOfBooksIssuedByStudent);
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
     * @param bookName              The name of the new book to be added to the student data.
     * @param nameOfAuthorOfTheBook The Author's name of the new book to be added to the
     *                              student data.
     */
    public void issueBook(String bookName, String nameOfAuthorOfTheBook, String ISBNNumber) {
        int booksCount = getNumberOfBookIssued();
        booksCount = booksCount + 1;
        setNoOfBookIssued(booksCount);̥
        this.nameOfBooksIssuedByStudent = new Book[getNumberOfBookIssued()];
        nameOfBooksIssuedByStudent[getNumberOfBookIssued() - 1] = new Book(bookName, nameOfAuthorOfTheBook, ISBNNumber);
        System.out.println("Book " + bookName + " author " + nameOfAuthorOfTheBook + " have ISBN  " + ISBNNumber + " Issued\n");
    }

    /**
     * This method will allow us to return a book.
     *
     * @param bookName              The name of the book to be returned.
     * @param nameOfAuthorOfTheBook The Author's name of the book to be returned.
     */
    public void returnBook(String bookName, String nameOfAuthorOfTheBook, String ISBNNumber) {
        System.out.println("Book " + bookName + " author " + nameOfAuthorOfTheBook + " have ISBN " + ISBNNumber + " Returned\n");
    }

    /**
     * This Method will show all the books issued by student
     */
    public void showIssuedBooks() {
        if (nameOfBooksIssuedByStudent.length == 0) {
            System.out.println("No Book Issued");
        }
        for (Book book : nameOfBooksIssuedByStudent) {
            System.out.println("All The Books Issued are: ");
            System.out.println(book);
        }
        System.out.println();
    }
}
