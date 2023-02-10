package Books;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddBookToDatabase {
    public static void addBook(){

            System.out.println("Podaj tytuł książki");
            System.out.println();
            String title = new Scanner(System.in).nextLine();
            System.out.println("Podaj autora książki");
            System.out.println();
            String author = new Scanner(System.in).nextLine();
            System.out.println("Podaj datę wydania książki w formacie yyyy-mm-dd");
            System.out.println();
            String date = new Scanner(System.in).nextLine();
            LocalDate releaseDate = LocalDate.parse(date);
            System.out.println("Podaj liczbę stron książki");
            System.out.println();
            int numberOfPages = new Scanner(System.in).nextInt();
            System.out.println("Podaj gatunek książki");
            System.out.println();
            String genre = new Scanner(System.in).nextLine();
            System.out.println("Podaj liczbę kopii książki");
            System.out.println();
            int numberOfCopies = new Scanner(System.in).nextInt();
            System.out.println("Podaj cenę książki");
            System.out.println();
            double price = new Scanner(System.in).nextDouble();
            try{
                if (title == null) {
                    throw new IncorrectBookArgException("Tytuł nie może być nullem");
                }
                if (author == null) {
                    throw new IncorrectBookArgException("Autor nie może być nullem");
                }
                if (numberOfPages <= 0) {
                    throw new IncorrectBookArgException("Liczba stron nie może być niedodatnia");
                }
                if (numberOfCopies < 0) {
                    throw new IncorrectBookArgException("Liczba kopii nie może być ujemna");
                }
                if (price < 0) {
                    throw new IncorrectBookArgException("Cena nie może być ujemna");
                }
            } catch (IncorrectBookArgException e) {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Wprowadź poprawny typ danych");
            }

            Book book = new Book(title,author,releaseDate,numberOfPages,genre,numberOfCopies,price);
            Connection c = null;
            Statement stmt = null;

            String formattedReleaseDate = releaseDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "Insert Into BOOKS ( ID, TITLE, AUTHOR, RELEASE_DATE, NUM_OF_PAGES, GENRE, NUM_OF_COPIES, PRICE)" +
                    "VALUES (null, '"+book.title+"', '"+book.author+"', '"+formattedReleaseDate+"', "+book.numberOfPages+", '"+book.genre+"', "+ book.getNumberOfCopies() +", "+book.price+" );";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
