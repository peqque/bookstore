import java.util.Scanner;

import static Books.AddBookToDatabase.addBook;
import static Books.ChangeNumOfCopies.changeNumOfCopies;
import static Books.ChangePrice.changePrice;
import static Books.DeleteBookFromDatabase.deleteBook;
import static Books.SelectAllBooks.selectAllForCustomers;
import static Books.SelectAllBooks.selectAllForEmployees;
import static Books.SelectSearchMethod.chooseSearchMethodEmployee;
import static Customer.Transactions.viewAllTransactionsHistory;
import static Employee.Login.login;

public class EmployeePath {
    public static void employeePath() {
        login();
        chooseActionEmployee();
    }
    public static void chooseActionEmployee(){
        while(true){
            System.out.println();
            System.out.println("Wybierz akcję:");
            System.out.println("1 - wyświetl informacje o wszystkich książkach");
            System.out.println("2 - wyświetl informacje o wszystkich dostępnych dla klientów książkach");
            System.out.println("3 - przejdź do wyboru metody wyszukiwania książek");
            System.out.println("4 - dodaj nową książkę do bazy danych");
            System.out.println("5 - usuń książkę z bazy danych");
            System.out.println("6 - zmień cenę książki");
            System.out.println("7 - zmień liczbę kopii książki");
            System.out.println("8 - wyświetl historię transakcji klientów");
            System.out.println("9 - wyloguj się");
            System.out.println("0 - wyjdź do menu głównego");
            String choice = new Scanner(System.in).next();
            switch (choice) {
                case "1" -> selectAllForEmployees();
                case "2" -> selectAllForCustomers();
                case "3" -> chooseSearchMethodEmployee();
                case "4" -> addBook();
                case "5" -> deleteBook();
                case "6" -> changePrice();
                case "7" -> changeNumOfCopies();
                case "8" -> viewAllTransactionsHistory();
                case "9" -> employeePath();
                case "0" -> Main.startMenu();
                default -> System.out.println("Podano złą wartość. Spróbuj jeszcze raz");
            }
        }
    }
}
