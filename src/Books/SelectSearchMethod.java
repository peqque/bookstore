package Books;

import java.util.Scanner;

import static Books.SearchBooksCustomer.*;
import static Books.SearchBooksEmployee.*;
import static Books.SelectAllBooks.selectAllForCustomers;
import static Books.SelectAllBooks.selectAllForEmployees;

public class SelectSearchMethod {
    public static void chooseSearchMethodCustomer() {
        System.out.println("Wpisz 0 aby wyświetlić wszystkie dostępne książki. ");
        System.out.println("Aby zawęzić wyniki wyszukiwania wciśnij:");
        System.out.println("1 - aby szukać po tytule");
        System.out.println("2 - aby szukać po autorze");
        System.out.println("3 - aby szukać po gatunku");
        System.out.println("4 - aby szukać w odpowiednim przedziale cenowym");
        System.out.println("5 - aby szukać po numerze ID");
        System.out.println();
        String choice = new Scanner(System.in).next();
        switch (choice) {
            case "0" -> selectAllForCustomers();
            case "1" -> selectByTitleCustomer();
            case "2" -> selectByAuthorCustomer();
            case "3" -> selectByGenreCustomer();
            case "4" -> selectByPriceRangeCustomer();
            case "5" -> selectByIdCustomer();
            default -> {
                System.out.println("Podano złą wartość. Spróbuj jeszcze raz");
                chooseSearchMethodCustomer();
            }
        }
    }

    public static void chooseSearchMethodEmployee() {
        System.out.println("Wpisz 0 aby wyświetlić wszystkie książki. ");
        System.out.println("Wpisz 9 aby wyświetlić wszystkie książki dostępne dla klientów. ");
        System.out.println("Aby zawęzić wyniki wyszukiwania wciśnij:");
        System.out.println("1 - aby szukać po tytule");
        System.out.println("2 - aby szukać po autorze");
        System.out.println("3 - aby szukać po gatunku");
        System.out.println("4 - aby szukać w odpowiednim przedziale cenowym");
        System.out.println("5 - aby szukać po numerze ID");
        System.out.println("6 - aby szukać w przedziale zależnym od ilości egzemplarzy w magazynie");
        System.out.println();
        String choice = new Scanner(System.in).next();
        switch (choice) {
            case "0" -> selectAllForEmployees();
            case "9" -> selectAllForCustomers();
            case "1" -> selectByTitleEmployee();
            case "2" -> selectByAuthorEmployee();
            case "3" -> selectByGenreEmployee();
            case "4" -> selectByPriceRangeEmployee();
            case "5" -> selectByIdEmployee();
            case "6" -> selectByCopiesRangeEmployee();
            default -> {
                System.out.println("Podano złą wartość. Spróbuj jeszcze raz");
                chooseSearchMethodEmployee();
            }
        }
    }
}
