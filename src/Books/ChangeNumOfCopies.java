package Books;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Scanner;

public class ChangeNumOfCopies {
    public static void changeNumOfCopies() {
        System.out.println("Podaj numer ID książki");
        System.out.println();
        int id = new Scanner(System.in).nextInt();
        System.out.println("Podaj liczbę dodatkowych kopii książki (wartość może być ujemna)");
        System.out.println();
        int addedCopies = new Scanner(System.in).nextInt();
        Connection c = null;
        Statement stmt = null;
        try{
            if (id <= 0) {
                throw new IncorrectBookArgException("Identyfikator nie może być niedodatni");
            }
        } catch(IncorrectBookArgException e){
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE BOOKS set NUM_OF_COPIES = CASE WHEN NUM_OF_COPIES+"+addedCopies+">=0 THEN NUM_OF_COPIES+"+addedCopies+" ELSE 0 END where ID="+id+";";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
