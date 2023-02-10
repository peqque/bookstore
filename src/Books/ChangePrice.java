package Books;
import java.sql.*;
import java.util.Scanner;

public class ChangePrice{
    public static void changePrice() {
        System.out.println("Podaj numer ID książki");
        System.out.println();
        int id = new Scanner(System.in).nextInt();
        System.out.println("Podaj nową cenę książki");
        System.out.println();
        double newPrice = new Scanner(System.in).nextDouble();
        Connection c = null;
        Statement stmt = null;
        try{
            if (id <= 0) {
                throw new IncorrectBookArgException("Identyfikator nie może być niedodatni");
            }
            if (newPrice  < 0) {
                throw new IncorrectBookArgException("Cena nie może być ujemna");
            }
        } catch(IncorrectBookArgException e){
            System.out.println(e.getMessage());
        }

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:C:\\users\\martix\\desktop\\bookstore\\database sqlite\\Books sqlite.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE BOOKS set PRICE = "+newPrice+" where ID="+id+";";
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
