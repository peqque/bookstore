package Books;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class Book {

    public String title;
    public String author;
    public LocalDate releaseDate;
    public int numberOfPages;
    public String genre;
    int numberOfCopies;
    public double price;

    public Book(String title, String author, LocalDate releaseDate, int numberOfPages, String genre, int numberOfCopies, double price) {
        try{
            this.title = title;
            this.author = author;
            this.releaseDate = releaseDate;
            this.numberOfPages = numberOfPages;
            this.genre = genre;
            this.numberOfCopies = numberOfCopies;
            this.price = price;
            if (title == null) {
                throw new IncorrectBookArgException("Tytuł nie może być nullem");
            }
            if (author == null) {
                throw new IncorrectBookArgException("Autor nie może być nullem");
            }
            if (releaseDate == null) {
                throw new IncorrectBookArgException("Data wydania nie może być nullem");
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

    }
    public Book(String title, String author, LocalDate releaseDate, int numberOfPages, String genre, double price) {
        try{
            this.title = title;
            this.author = author;
            this.releaseDate = releaseDate;
            this.numberOfPages = numberOfPages;
            this.genre = genre;
            this.price = price;
            if (title == null) {
                throw new IncorrectBookArgException("Tytuł nie może być nullem");
            }
            if (author == null) {
                throw new IncorrectBookArgException("Autor nie może być nullem");
            }
            if (releaseDate == null) {
                throw new IncorrectBookArgException("Data wydania nie może być nullem");
            }
            if (numberOfPages <= 0) {
                throw new IncorrectBookArgException("Liczba stron nie może być niedodatnia");
            }
            if (price < 0) {
                throw new IncorrectBookArgException("Cena nie może być ujemna");
            }
        } catch (IncorrectBookArgException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Wprowadź poprawne dane");
        }
        catch (IllegalArgumentException e){
            System.out.println("Wprowadź poprawną wartość");
        }

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public double getPrice() {
        return price;
    }
}
