package Customer;

import Books.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transactions extends Cart{
    public static List<String> listOfAllTransactions = new ArrayList<>();

    public Transactions(String imie, String nazwisko, String numerTelefonu, List<Book> listOfBooksInCart, List<Book>listOfCustomerHistory) {
        super(imie, nazwisko, numerTelefonu);
        this.listOfBooksInCart = listOfBooksInCart;
        this.listOfCustomerHistory = listOfCustomerHistory;
    }

    public double checkIn(){
        double totalPrice = 0;
        for (Book book : listOfBooksInCart) {
            totalPrice += book.getPrice();
            listOfAllTransactions.add(name +" "+ surname +" - tel. "+ phoneNumber+'\n'+book.title+" - "+book.author+" - "+book.price);
            System.out.println();
            listOfCustomerHistory.add(book);
        }
        listOfBooksInCart.clear();
        System.out.println("Dokonano zakupu na kwotę "+totalPrice);
        System.out.println();
        return totalPrice;
    }

    public static void viewAllTransactionsHistory(){
        System.out.println("Wszystkie dokonane transakcje:");
        for (String i : listOfAllTransactions){
            System.out.println(i);
            System.out.println();
        }
        System.out.println();
    }

    public void viewPaymentHistory(){
        System.out.println("Historia zakupów klienta "+this.getName()+" "+this.getSurname()+":");
        for(Book book : listOfCustomerHistory){
            System.out.println(book.getTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getReleaseDate());
            System.out.println(book.getNumberOfPages());
            System.out.println(book.getGenre());
            System.out.println(book.getPrice());
            System.out.println();
        }
        System.out.println();
    }

}
