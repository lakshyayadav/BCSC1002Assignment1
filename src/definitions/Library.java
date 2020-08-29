/*  Created by IntelliJ IDEA.
 *  User: Lakshya yadav
 *  Date: 29/08/20
 *  Time: 6:51 PM
 *  File Name : Library.java
 * */
package definitions;

import java.util.Arrays;

public class Library {
    private Book[] booksCurrentlyAvailable;

    public Library() {
        this.booksCurrentlyAvailable = new Book[10];
        for (int i = 0; i < booksCurrentlyAvailable.length; i++) {
            booksCurrentlyAvailable[i] = new Book();
        }
    }

    public Library(Book[] booksCurrentlyAvailable) {
        this.booksCurrentlyAvailable = booksCurrentlyAvailable;
    }

    public Book[] getBooksAvailable() {
        return booksCurrentlyAvailable;
    }

    public void setBooksAvailable(Book[] booksAvailable) {
        this.booksCurrentlyAvailable = booksAvailable;
    }

    @Override
    public String toString() {
        return Arrays.toString(booksCurrentlyAvailable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Library library = new Library();
        return Arrays.equals(getBooksAvailable(), library.getBooksAvailable());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getBooksAvailable());
    }

}
