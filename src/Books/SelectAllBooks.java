package Books;
import java.sql.*;

public class SelectAllBooks {
    public static void selectAllForEmployees(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS;" );

            while ( rs.next() ) {
                int id = rs.getInt("ID");
                String title = rs.getString("TITLE");
                String author = rs.getString("AUTHOR");
                String releaseDate = rs.getString("RELEASE_DATE");
                int numberOfPages = rs.getInt("NUM_OF_PAGES");
                String genre = rs.getString("GENRE");
                int numberOfCopies = rs.getInt("NUM_OF_COPIES");
                double price = rs.getDouble("PRICE");

                System.out.println("ID: "+id);
                System.out.println("Tytuł: "+title);
                System.out.println("Autor: "+author);
                System.out.println("Data wydania: "+releaseDate);
                System.out.println("Liczba stron: "+ numberOfPages);
                System.out.println("Gatunek: "+genre);
                System.out.println("Liczba egzemplarzy: "+numberOfCopies);
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
    public static void selectAllForCustomers(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM BOOKS;" );

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
}
