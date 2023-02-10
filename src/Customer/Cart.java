package Customer;
import Books.Book;
import Books.IncorrectBookArgException;

import java.sql.*;

import java.util.*;

import static Books.ChangeNumOfCopies.changeNumOfCopies;
import java.time.LocalDate;

public class Cart extends Customer {
    public static List<Book> listOfBooksInCart = new ArrayList<>();
    public static List<Book> listOfCustomerHistory = new ArrayList<>();

    public Cart(String imie, String nazwisko, String numerTelefonu) {
        super(imie, nazwisko, numerTelefonu);
    }


    public List<Book> getListOfBooksInCart() {
        return listOfBooksInCart;
    }

    public List<Book> getListOfCustomerHistory() {
        return listOfCustomerHistory;
    }

    public void addToCart() {
        System.out.println("Podaj numer ID książki");
        System.out.println();
        int bookId = new Scanner(System.in).nextInt();
        Connection c = null;
        Statement stmt = null;
        try {
            if (bookId <= 0) {
                throw new IncorrectBookArgException("Identyfikator nie może być niedodatni");
            }
        } catch (IncorrectBookArgException e) {
            System.out.println(e.getMessage());
        }
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE ID='" + bookId + "' AND NUM_OF_COPIES >= 1;");
            String title = rs.getString("TITLE");
            String author = rs.getString("AUTHOR");
            String releaseDate = rs.getString("RELEASE_DATE");
            int numberOfPages = rs.getInt("NUM_OF_PAGES");
            String genre = rs.getString("GENRE");
            double price = rs.getDouble("PRICE");
            Book book = new Book(title, author, LocalDate.parse(releaseDate), numberOfPages, genre, price);
            listOfBooksInCart.add(book);
            String sql = "UPDATE BOOKS set NUM_OF_COPIES = NUM_OF_COPIES - 1 where ID="+bookId+";";
            stmt.executeUpdate(sql);
            c.commit();
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void viewCart() {
        System.out.println("Zawartość koszyka klienta " + this.getName() + " " + this.getSurname() + ":");
        System.out.println();
        for (Book book : listOfBooksInCart) {
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getReleaseDate());
            System.out.println(book.getNumberOfPages());
            System.out.println(book.getGenre());
            System.out.println(book.getPrice());
            System.out.println();
        }
    }

    public void removeFromCart() {
        System.out.println("Podaj tytuł książki:");
        System.out.println();
        String title = new Scanner(System.in).nextLine();
        if (listOfBooksInCart.isEmpty()) {
            System.out.println("Koszyk jest pusty.");
        } else {
            listOfBooksInCart.removeIf(next -> Objects.equals(next.getTitle(), title) );
            Connection c = null;
            Statement stmt = null;
            try{
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
                c.setAutoCommit(false);
                stmt = c.createStatement();
                String sql = "UPDATE BOOKS set NUM_OF_COPIES = NUM_OF_COPIES + 1 where TITLE='"+title+"';";
                stmt.executeUpdate(sql);
                c.commit();
                stmt.close();
                c.close();
            }
            catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }
    }
}