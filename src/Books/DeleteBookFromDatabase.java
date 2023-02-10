package Books;
import java.sql.*;
import java.util.Scanner;

public class DeleteBookFromDatabase {
    public static void deleteBook() {
        System.out.println("Podaj numer ID książki");
        System.out.println();
        int id = new Scanner(System.in).nextInt();
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
            String sql = "DELETE from BOOKS where ID=" + id + ";";
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

// zrobic exception dla zle podanego id