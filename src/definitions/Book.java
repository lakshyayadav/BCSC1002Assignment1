/*  Created by IntelliJ IDEA.
 *  User: Lakshya Yadav
 *  Date: 29/08/20
 *  Time: 6:51 PM
 *  File Name : Book.java
 * */
package definitions;

import java.util.Objects;

public class Book {
    private String nameOfBook;
    private String nameOfAuthorOfTheBook;
    private String ISBNNumberOfTheBook;

    public Book() {
        this.nameOfBook = "A Song of Ice and Fire";
        this.nameOfAuthorOfTheBook = "George R.R. Martin";
        this.ISBNNumberOfTheBook = "1982736452938";
    }

    public Book(String nameOfBook, String nameOfAuthorOfTheBook, String ISBNNumberOfTheBook) {
        this.nameOfBook = nameOfBook;
        this.nameOfAuthorOfTheBook = nameOfAuthorOfTheBook;
        this.ISBNNumberOfTheBook = ISBNNumberOfTheBook;
    }

    public String getBookName() {
        return nameOfBook;
    }

    public void setBookName(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthorName() {
        return nameOfAuthorOfTheBook;
    }

    public void setAuthorName(String nameOfAuthorOfTheBook) {
        this.nameOfAuthorOfTheBook = nameOfAuthorOfTheBook;
    }

    public String getISBNNumber() {
        return ISBNNumberOfTheBook;
    }

    public void setISBNNumber(String ISBNNumberOfTheBook) {
        ISBNNumberOfTheBook = ISBNNumberOfTheBook;
    }

    @Override
    public String toString() {
        return "Book Name: " + getBookName() + ", " + "Author Name: " + getAuthorName() + ", " + "ISBN Number: "
                + getISBNNumber() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return getAuthorName() == book.getAuthorName() && getISBNNumber() == book.getISBNNumber()
                && Objects.equals(getBookName(), book.getBookName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName(), getAuthorName(), getISBNNumber());
    }

}

