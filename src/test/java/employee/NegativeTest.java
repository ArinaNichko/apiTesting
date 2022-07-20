package employee;

import clients.Employee;
import org.junit.jupiter.api.Test;

import static controller.EmployeeController.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class NegativeTest {

    @Test
    public void getRequestEmployee(){
        Employee employee = new Employee();

        getEmployeeRequestNegative(employee)
                .assertThat()
                .statusCode(500)
                .body("message", containsString("Employee with such id = 105 not found"));

    }

    @Test
    public void postRequestEmployee(){
        Employee employee = new Employee();
        employee.setId(104);
        employee.setName("Max");
        employee.setPassportNumber("MX456798");
        employee.setEducation("High");

        putEmployeeRequest(employee).
                assertThat().
                statusCode(500)
                .body("message", containsString("Employee with such id = 104 already exist"));

    }

    @Test
    public void putRequestEmployee(){
        Employee employee = new Employee();
        employee.setId(101);
        employee.setName("Max");
        employee.setPassportNumber("MX456798");
        employee.setEducation("High");

        putEmployeeRequest(employee).
                assertThat().
                statusCode(500)
                .body("message", equalTo("Employee with such id = 101 doesn't exist"));

    }

    @Test
    public void deleteRequestEmployee(){
        Employee employee = new Employee();

        deleteEmployeeRequest(employee).
                assertThat().
                statusCode(500)
                .body("message", equalTo("Employee with such id = 102 not found"));

    }


}
