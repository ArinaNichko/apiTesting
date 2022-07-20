package employee;

import clients.Employee;
import org.junit.jupiter.api.Test;


import static controller.EmployeeController.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class PositiveTest {

    @Test
    public void getRequestEmployee(){
        Employee employee = new Employee();

        getEmployeeRequest(employee)
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(102),
                "name", equalTo("Maxim"),
                        "passportNumber",equalTo("MX456798"),
                        "education", equalTo("School"));

    }

    @Test
    public void deleteRequestEmployee(){
        Employee employee = new Employee();

        deleteEmployeeRequest(employee).
                assertThat().
                statusCode(200)
                .body("message", equalTo("Employee with id = 102 has been successfully deleted!"));

    }

    @Test
    public void putRequestEmployee(){
        Employee employee = new Employee();
        employee.setId(104);
        employee.setName("Max");
        employee.setPassportNumber("MX456798");
        employee.setEducation("High");

        putEmployeeRequest(employee)
                .assertThat()
                .statusCode(200)
                .body("message", equalTo("Employee with id = 104 has been updated!"));

    }

    @Test
    public void patchRequestEmployee(){
        Employee employee = new Employee();
        employee.setId(104);
        employee.setName("Ben");
        employee.setPassportNumber("MX456798");
        employee.setEducation("School");

        putEmployeeRequest(employee)
                .assertThat()
                .statusCode(200)
                .header("Content-Type", equalTo("text/plain;charset=UTF-8"))
                .body("message", equalTo("Employee with id = 104 has been updated!"));

    }

    @Test
    public void postRequestEmployee(){
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Sarah");
        employee.setPassportNumber("MX788798");
        employee.setEducation("School");

       postEmployeeRequest(employee).
                assertThat().
                statusCode(200)
               .body("message", equalTo("Employee with id = 123 has been added!"));

    }


}
