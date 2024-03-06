package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Book;
import model.Library;
import view.View;

public class Controller {
    Library library = View.library;
    List<Book> books = library.getBooks();

    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
        library.setBooks(books);
    }

    public boolean removeBook(String bookName) {
        if (books == null)
            return false; // List does not exist
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookName)) {
                iterator.remove();
                return true;// Book removed successfully
            }
        }
        // Book does not exist
        return false;
    }

    public boolean updateBook(String bookToUpdate, String newBookName, String newAuthor, double newPrice) {
        if (books == null)
            return false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookToUpdate)) {
                b.setBookName(newBookName);
                b.setBookAuthor(newAuthor);
                b.setBookPrice(newPrice);
                return true;// Book updated successfully
            }
        }
        // Book does not exist
        return false;
    }

    public boolean updateBook(String bookToUpdate, String newAuthor, double newPrice) {
        if (books == null)
            return false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookToUpdate)) {
                b.setBookAuthor(newAuthor);
                b.setBookPrice(newPrice);
                return true;// Book updated successfully
            }
        }
        // Book does not exist
        return false;
    }

    public boolean updateBook(String bookToUpdate, String newAuthor) {
        if (books == null)
            return false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookToUpdate)) {
                b.setBookAuthor(newAuthor);
                return true;// Book updated successfully
            }
        }
        // Book does not exist
        return false;
    }

    public boolean updateBook(String bookToUpdate, double newPrice) {
        if (books == null)
            return false;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookToUpdate)) {
                b.setBookPrice(newPrice);
                return true;// Book updated successfully
            }
        }
        // Book does not exist
        return false;
    }

    public Book getBook(String bookName) {
        if (books == null)
            return null; // List does not exist
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book b = iterator.next();
            if (b.getBookName().equalsIgnoreCase(bookName)) {
                return b;// Book Fetched successfully
            }
        }
        // Book does not exist
        return null;
    }
}
