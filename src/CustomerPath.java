import Customer.Customer;
import Customer.Cart;
import Customer.Transactions;
import Customer.IncorrectCustomerArgException;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static Books.AddBookToDatabase.addBook;
import static Books.ChangeNumOfCopies.changeNumOfCopies;
import static Books.ChangePrice.changePrice;
import static Books.DeleteBookFromDatabase.deleteBook;
import static Books.SelectAllBooks.selectAllForCustomers;
import static Books.SelectAllBooks.selectAllForEmployees;
import static Books.SelectSearchMethod.chooseSearchMethodCustomer;
import static Books.SelectSearchMethod.chooseSearchMethodEmployee;
import static Customer.Customer.listOfCustomers;
import static Customer.Transactions.viewAllTransactionsHistory;

public class CustomerPath {
    public static void customerPath() {
        Customer newCustomer = new Customer();
        for (Customer customer : listOfCustomers){
            if (newCustomer.equals(customer)){
                listOfCustomers.remove(newCustomer);
                newCustomer = customer;
                break;
            }
        }
        Cart newCart = new Cart(newCustomer.getName(),newCustomer.getSurname(),newCustomer.getPhoneNumber());
        Transactions newTransactions = new Transactions(newCart.getName(),newCart.getSurname(),newCart.getPhoneNumber(),newCart.getListOfBooksInCart(),newCart.getListOfCustomerHistory());
        while (true) {
            System.out.println();
            System.out.println("Wybierz akcję:");
            System.out.println("1 - wyświetl informacje o wszystkich dostępnych książkach");
            System.out.println("2 - przejdź do wyboru metody wyszukiwania książek");
            System.out.println("3 - dodaj książkę do koszyka");
            System.out.println("4 - wyświetl zawartość koszyka");
            System.out.println("5 - usuń pozycję z koszyka");
            System.out.println("6 - dokonaj zakupu książek z koszyka");
            System.out.println("7 - wyświetl historię swoich transakcji");
            System.out.println("0 - wyjdź do menu głównego");
            String choice = new Scanner(System.in).next();
            switch (choice) {
                case "1" -> selectAllForCustomers();
                case "2" -> chooseSearchMethodCustomer();
                case "3" -> newCart.addToCart();
                case "4" -> newCart.viewCart();
                case "5" -> newCart.removeFromCart();
                case "6" -> newTransactions.checkIn();
                case "7" -> newTransactions.viewPaymentHistory();

                case "0" -> Main.startMenu();
                default -> System.out.println("Podano złą wartość. Spróbuj jeszcze raz");
            }
        }
    }
}

