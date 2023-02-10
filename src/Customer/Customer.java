package Customer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    public String name;
    public String surname;
    public String phoneNumber;
    public static List<Customer> listOfCustomers = new ArrayList<>();

    public Customer(String name, String surname, String phoneNumber) {
        try{
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
            listOfCustomers.add(this);
            if (name == null) {
                throw new IncorrectCustomerArgException("Imię nie może być nullem");
            }
            if (surname == null) {
                throw new IncorrectCustomerArgException("Nazwisko nie może być nullem");
            }
            if (phoneNumber == null) {
                throw new IncorrectCustomerArgException("Numer telefonu nie może być nullem");
            }
        } catch (IncorrectCustomerArgException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Wprowadź poprawny typ danych");
        }
    }

    public Customer() {
        System.out.println("Imię:");
        System.out.println();
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nazwisko:");
        System.out.println();
        this.surname = new Scanner(System.in).nextLine();
        System.out.println("Numer telefonu:");
        System.out.println();
        this.phoneNumber = new Scanner(System.in).nextLine();
        listOfCustomers.add(this);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

}
