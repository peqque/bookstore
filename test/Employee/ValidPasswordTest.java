package Employee;

import org.junit.jupiter.api.Test;

import static Employee.Employee.passwordValidation;
import static org.junit.jupiter.api.Assertions.*;

class ValidPasswordTest {
    @Test
    void tooShortPasswordTest(){
        Employee e = new Employee("Zbch%1");
        boolean result = passwordValidation(e.password);
        assertFalse(result);
    }
    @Test
    void noLettersPasswordTest(){
        Employee e = new Employee("2415&&452");
        boolean result = passwordValidation(e.password);
        assertFalse(result);
    }
    @Test
    void noDigitsPasswordTest(){
        Employee e = new Employee("%&abecadee");
        boolean result = passwordValidation(e.password);
        assertFalse(result);
    }
    @Test
    void noSpecialCharsPasswordTest(){
        Employee e = new Employee("Mokebe677");
        boolean result = passwordValidation(e.password);
        assertFalse(result);
    }
    @Test
    void strongPasswordTest(){
        Employee e = new Employee("Gargol@@23");
        boolean result = passwordValidation(e.password);
        assertTrue(result);
    }
}