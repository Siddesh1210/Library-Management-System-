package view;

import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Book;
import model.Library;

public class View {
    public static Library library = new Library();
    static Controller controller = new Controller();
    static Scanner sc = new Scanner(System.in);
    static {
        try {
            System.out.println("-----Welcome to Library-----");
            System.out.print("Enter name of Library : ");
            String libraryName = sc.nextLine();
            library.setLibraryName(libraryName);
            System.out.print("Enter Address : ");
            library.setLibraryAddress(sc.nextLine());
            System.out.print("Enter pincode of Library : ");
            library.setLibraryPincode(sc.nextInt());
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Exception " + e + "\nPlease enter valid input");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            do {
                try {
                    System.out.println("Enter option to perform");
                    System.out.println("1.Add Book\n2.Remove Book\n3.Update Book\n4.Get Book\n0.Exit");
                    System.out.print("Enter digit respective to desired option : ");
                    byte userChoice = sc.nextByte();
                    sc.nextLine();
                    switch (userChoice) {
                        case 0:
                            sc.close();
                            System.out.println("Successfully Exit");
                            System.exit(0);
                            break;
                        case 1:
                            try {
                                Book book = new Book();
                                System.out.print("Enter Book Name : ");
                                book.setBookName(sc.nextLine());
                                System.out.print("Enter Author Name : ");
                                book.setBookAuthor(sc.nextLine());
                                System.out.print("Enter Book Price : ");
                                book.setBookPrice(sc.nextDouble());
                                sc.nextLine();
                                controller.addBook(book);
                                List<Book> books = library.getBooks();
                                for (Book b : books) {
                                    System.out.println(b.toString());
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("\nException " + e + "\nPlease enter valid input\n");
                                sc.nextLine();
                                break;
                            }
                        case 2:
                            try {
                                System.out.print("Enter book name to remove : ");
                                String bookName = sc.nextLine();
                                boolean removeBook = controller.removeBook(bookName);
                                if (removeBook) {
                                    System.out.println(bookName + " book removed succesfully");
                                } else {
                                    System.out.println("No Book found with name : " + bookName);
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("\nException " + e + "\nPlease enter valid input\n");
                                sc.nextLine();
                                break;
                            }
                        case 3:
                            try {
                                System.out.print("Enter Book Name to update : ");
                                String bookToUpdate = sc.nextLine();
                                boolean updateStatus = false;
                                System.out.println(
                                        "Enter choice to update\n1.To update Book Name , Author Name and Price\n2.To update Author Name and Price\n3.To update Author Name\n4.To update price name");
                                System.out.print("Enter digit from above choice : ");
                                byte userUpdateChoice = sc.nextByte();
                                sc.nextLine();
                                switch (userUpdateChoice) {
                                    case 1:
                                        System.out.print("Enter new book name : ");
                                        String newBookName = sc.nextLine();
                                        System.out.print("Enter new author name : ");
                                        String newAuthor = sc.nextLine();
                                        System.out.print("Enter new price of book : ");
                                        double newPrice = sc.nextInt();
                                        sc.nextLine();
                                        updateStatus = controller.updateBook(bookToUpdate, newBookName, newAuthor,
                                                newPrice);
                                        if (updateStatus) {
                                            System.out.println("Book updated successfully");
                                        } else {
                                            System.out.println("No book found with name " + bookToUpdate);
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Enter new author name : ");
                                        String newAuthorName = sc.nextLine();
                                        System.out.print("Enter new price of book : ");
                                        double newPriceName = sc.nextInt();
                                        sc.nextLine();
                                        updateStatus = controller.updateBook(bookToUpdate, newAuthorName, newPriceName);
                                        if (updateStatus) {
                                            System.out.println("Book updated successfully");
                                        } else {
                                            System.out.println("No book found with name " + bookToUpdate);
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Enter new author name : ");
                                        String newAuthrName = sc.nextLine();
                                        updateStatus = controller.updateBook(bookToUpdate, newAuthrName);
                                        if (updateStatus) {
                                            System.out.println("Book updated successfully");
                                        } else {
                                            System.out.println("No book found with name " + bookToUpdate);
                                        }
                                        break;
                                    case 4:
                                        System.out.print("Enter new price of book : ");
                                        double newPricName = sc.nextInt();
                                        sc.nextLine();
                                        updateStatus = controller.updateBook(bookToUpdate, newPricName);
                                        if (updateStatus) {
                                            System.out.println("Book updated successfully");
                                        } else {
                                            System.out.println("No book found with name " + bookToUpdate);
                                        }
                                        break;

                                    default:
                                        break;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("\nException " + e + "\nPlease enter valid input\n");
                                sc.nextLine();
                                break;
                            }
                        case 4:
                            try {
                                System.out.print("Enter book name to Get : ");
                                String bookToGet = sc.nextLine();
                                Book fetchedBook = controller.getBook(bookToGet);
                                if (fetchedBook != null) {
                                    System.out.println(fetchedBook);
                                } else {
                                    System.out.println("No Book found with name : " + bookToGet);
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("\nException " + e + "\nPlease enter valid input\n");
                                sc.nextLine();
                                break;
                            }
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("\nException " + e + "\nPlease enter valid input\n");
                    sc.nextLine();
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Exception " + e);
            sc.nextLine();
        }
    }
}
