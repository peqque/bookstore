package Employee;

import Customer.IncorrectCustomerArgException;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
    String name;
    String surname;
    LocalDate birthdate;
    String password;
    public static HashMap<String,String> listOfEmployees = new HashMap<>();

    public Employee(String password) {
        this.password = password;
    }

    public Employee() {
    }

    public Employee(String name, String surname, LocalDate birthdate, String password) {
        try{
            this.name = name;
            this.surname = surname;
            this.birthdate = birthdate;
            this.password = password;
            if (name == null) {
                throw new IncorrectEmployeeArgException("Imię nie może być nullem");
            }
            if (surname == null) {
                throw new IncorrectEmployeeArgException("Nazwisko nie może być nullem");
            }
            if (birthdate == null) {
                throw new IncorrectEmployeeArgException("Data urodzenia nie może być nullem");
            }
            if (!passwordValidation(password)) {
                throw new IncorrectEmployeeArgException("Niewystarczająca siła hasła. Hasło musi mieć co najmniej 8 znaków, w tym literę, cyfrę oraz znak specjalny.");
            }
            String username = (name+surname).toLowerCase();
            listOfEmployees.put(username,password);

        } catch (IncorrectEmployeeArgException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Wprowadź poprawny typ danych");
        }
        catch (IllegalArgumentException e){
            System.out.println("Wprowadź poprawną wartość");
        }
    }

    public static boolean passwordValidation(String password)
    {
        if(password.length()>=8)
        {
            Pattern letter = Pattern.compile("[a-zA-z]");
            Pattern digit = Pattern.compile("[0-9]");
            Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

            Matcher hasLetter = letter.matcher(password);
            Matcher hasDigit = digit.matcher(password);
            Matcher hasSpecial = special.matcher(password);

            return hasLetter.find() && hasDigit.find() && hasSpecial.find();

        }
        else
            return false;
    }

}
