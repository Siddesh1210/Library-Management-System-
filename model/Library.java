package model;

import java.util.List;

public class Library {
    // All Attribute of Library
    private String libraryName;
    private String libraryAddress;
    private int libraryPincode;
    private List<Book> books;

    // All method to get attribute of Library
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public int getLibraryPincode() {
        return libraryPincode;
    }

    public void setLibraryPincode(int libraryPincode) {
        this.libraryPincode = libraryPincode;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
