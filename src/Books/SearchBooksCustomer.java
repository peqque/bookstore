package Books;

import java.sql.*;
import java.util.Scanner;


public class SearchBooksCustomer {
    public static void selectByIdCustomer(){
        System.out.println("Wyszukiwanie po numerze ID:");
        System.out.println();
        int bookId = new Scanner(System.in).nextInt();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS WHERE ID="+bookId+";" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String releaseDate = rs.getString("RELEASE_DATE");
                int numberOfPages = rs.getInt("NUM_OF_PAGES");
                String genre = rs.getString("GENRE");
                double price = rs.getDouble("PRICE");

                System.out.println("ID: "+id);
                System.out.println("Tytuł: "+title);
                System.out.println("Autor: "+author);
                System.out.println("Date wydania: "+releaseDate);
                System.out.println("Liczba stron: "+ numberOfPages);
                System.out.println("Gatunek: "+genre);
                System.out.println("Cena: "+price);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void selectByTitleCustomer(){
        System.out.println("Wyszukiwanie po tytule:");
        System.out.println();
        String bookTitle = new Scanner(System.in).nextLine();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS WHERE TITLE LIKE '"+bookTitle+"%';" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String releaseDate = rs.getString("RELEASE_DATE");
                int numberOfPages = rs.getInt("NUM_OF_PAGES");
                String genre = rs.getString("GENRE");
                double price = rs.getDouble("PRICE");
                int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                if (numberOfCopies <1){
                    continue;
                }
                System.out.println("ID: "+id);
                System.out.println("Tytuł: "+title);
                System.out.println("Autor: "+author);
                System.out.println("Date wydania: "+releaseDate);
                System.out.println("Liczba stron: "+ numberOfPages);
                System.out.println("Gatunek: "+genre);
                System.out.println("Cena: "+price);
                if (numberOfCopies == 1)
                {
                    System.out.println("Spiesz się! Została ostatnia sztuka!");
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void selectByAuthorCustomer(){
        System.out.println("Wyszukiwanie po autorze:");
        System.out.println();
        String bookAuthor = new Scanner(System.in).nextLine();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS WHERE AUTHOR LIKE '"+bookAuthor+"%';" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String releaseDate = rs.getString("RELEASE_DATE");
                int numberOfPages = rs.getInt("NUM_OF_PAGES");
                String genre = rs.getString("GENRE");
                double price = rs.getDouble("PRICE");
                int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                if (numberOfCopies <1){
                    continue;
                }
                System.out.println("ID: "+id);
                System.out.println("Tytuł: "+title);
                System.out.println("Autor: "+author);
                System.out.println("Date wydania: "+releaseDate);
                System.out.println("Liczba stron: "+ numberOfPages);
                System.out.println("Gatunek: "+genre);
                System.out.println("Cena: "+price);
                if (numberOfCopies == 1)
                {
                    System.out.println("Spiesz się! Została ostatnia sztuka!");
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void selectByGenreCustomer(){
        System.out.println("Wyszukiwanie po gatunku:");
        System.out.println();
        String bookGenre = new Scanner(System.in).nextLine();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS WHERE GENRE LIKE '"+bookGenre+"%';" );
            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String releaseDate = rs.getString("RELEASE_DATE");
                int numberOfPages = rs.getInt("NUM_OF_PAGES");
                String genre = rs.getString("GENRE");
                double price = rs.getDouble("PRICE");
                int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                if (numberOfCopies <1){
                    continue;
                }
                System.out.println("ID: "+id);
                System.out.println("Tytuł: "+title);
                System.out.println("Autor: "+author);
                System.out.println("Date wydania: "+releaseDate);
                System.out.println("Liczba stron: "+ numberOfPages);
                System.out.println("Gatunek: "+genre);
                System.out.println("Cena: "+price);
                if (numberOfCopies == 1)
                {
                    System.out.println("Spiesz się! Została ostatnia sztuka!");
                }
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static void selectByPriceRangeCustomer() {
        System.out.println("Wyszukiwanie w przedziale cenowym - podaj dwie wartości:");
        System.out.println();
        double x = new Scanner(System.in).nextDouble();
        double y = new Scanner(System.in).nextDouble();
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            if (y >= x) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE PRICE BETWEEN " + x + " AND " + y + ";");
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String title = rs.getString("TITLE");
                    String author = rs.getString("AUTHOR");
                    String releaseDate = rs.getString("RELEASE_DATE");
                    int numberOfPages = rs.getInt("NUM_OF_PAGES");
                    String genre = rs.getString("GENRE");
                    double price = rs.getDouble("PRICE");
                    int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                    if (numberOfCopies <1){
                        continue;
                    }
                    System.out.println("ID: "+id);
                    System.out.println("Tytuł: "+title);
                    System.out.println("Autor: "+author);
                    System.out.println("Date wydania: "+releaseDate);
                    System.out.println("Liczba stron: "+ numberOfPages);
                    System.out.println("Gatunek: "+genre);
                    System.out.println("Cena: "+price);
                    if (numberOfCopies == 1)
                    {
                        System.out.println("Spiesz się! Została ostatnia sztuka!");
                    }
                    System.out.println();
                }
                rs.close();
            } else {
                ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE PRICE BETWEEN " + y + " AND " + x + ";");
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String title = rs.getString("TITLE");
                    String author = rs.getString("AUTHOR");
                    String releaseDate = rs.getString("RELEASE_DATE");
                    int numberOfPages = rs.getInt("NUM_OF_PAGES");
                    String genre = rs.getString("GENRE");
                    double price = rs.getDouble("PRICE");
                    int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                    if (numberOfCopies <1){
                        continue;
                    }
                    System.out.println("ID: "+id);
                    System.out.println("Tytuł: "+title);
                    System.out.println("Autor: "+author);
                    System.out.println("Date wydania: "+releaseDate);
                    System.out.println("Liczba stron: "+ numberOfPages);
                    System.out.println("Gatunek: "+genre);
                    System.out.println("Cena: "+price);
                    if (numberOfCopies == 1)
                    {
                        System.out.println("Spiesz się! Została ostatnia sztuka!");
                    }
                    System.out.println();
                }
                rs.close();
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
