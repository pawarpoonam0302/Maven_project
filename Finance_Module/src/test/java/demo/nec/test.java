package demo.nec;

import com.nec.financem.PayrollProcessing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SalaryCalculatorTest {

    @Test
    public void testCalculateTaxForSalaryBelow5LPA() {
        PayrollProcessing calculator = new PayrollProcessing();
        double salary = 4.5;
        double expectedTax = 0.0;
        double actualTax = calculator.calculateTaxBasedOnSalary();
        assertEquals(expectedTax, actualTax, "Tax should be 0 for salaries below 5 LPA.");
    }


    @Test
    public void testCalculateSalaryValidInput() {
        PayrollProcessing calculator = new PayrollProcessing();
        double result = calculator.calculateSalary(123, 20, 500);
        assertEquals(10000.0, result, 0.001, "The calculated salary should be 10000 Rs for 20 days with 500 Rs per day.");
    }
}
