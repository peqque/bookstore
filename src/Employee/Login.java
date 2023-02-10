package Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static Employee.Employee.listOfEmployees;

public class Login{
    public static boolean login(){
        String user = "";
        boolean check = false;
        while (!check){
            System.out.println("Wpisz swoją nazwę użytkownika (imięnazwisko):");
            user = new Scanner(System.in).next();
            for(Map.Entry<String, String> entry : listOfEmployees.entrySet()) {
                String username = entry.getKey();
                String password = entry.getValue();
                if (Objects.equals(user, username)){
                    System.out.println("Hasło:");
                    String passwordInput = new Scanner(System.in).next();
                    if(Objects.equals(passwordInput, password)){
                        check = true;
                    }
                    while (!Objects.equals(passwordInput, password)){
                        System.out.println("Wpisz poprawne hasło. Wpisz '0' aby wrócić do ekranu logowania.");
                        System.out.println("Hasło:");
                        String newPasswordInput = new Scanner(System.in).next();
                        if(Objects.equals(newPasswordInput, password)){
                            check = true;
                        }
                        if(Objects.equals(newPasswordInput, "0")){
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }
}
