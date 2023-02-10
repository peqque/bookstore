import Customer.*;
import Employee.*;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        employeesSample();
        startMenu();
    }
    public static void startMenu(){
        System.out.println("Witamy w naszej księgarni!");
        System.out.println("Aby przejść do zakupów możesz wpisać cokolwiek oprócz 1 i 0 :)");
        System.out.println("Jeśli jesteś naszym pracownikiem wpisz 1");
        System.out.println("Jeśli chcesz wyjść z programu wpisz 0");
        System.out.println();
        String choice = new Scanner(System.in).next();
        if (choice.equals("1")){
            EmployeePath.employeePath();
        }
        else if (choice.equals("0")){
            System.exit(0);
        }
        else{
            CustomerPath.customerPath();
        }
    }
    public static void employeesSample(){
        Employee jTravolta = new Employee("John","Travolta", LocalDate.of(2000,11,14),"Arystoteles15%");
        Employee jNowak = new Employee("Jarek","Nowak",LocalDate.of(1989,10,10),"kapusta10!");
        Employee wWilk = new Employee("Wioletta","Wilk",LocalDate.of(1997,6,24),"grzybobr@n1e");
        Employee aKot = new Employee("Alfred","Kot",LocalDate.of(1988,2,22),"kochammame123$");
        Employee mJackson = new Employee("Michael","Jackson",LocalDate.of(1988,6,2),"program1@");
        Employee sZakolski = new Employee("Stanisław","Zakolski",LocalDate.of(2001,1,27),"1!zakolski");
    }
}
