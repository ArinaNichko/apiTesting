package employee;

import clients.Employee;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static config.Path.*;
import static controller.EmployeeController.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;



public class PositiveTest {



    @Test
    public void getRequestEmployee() throws IOException, ParseException {
        Employee employee = new Employee();


       Employee employeeResponse = getEmployeeRequest(employee)
                .assertThat()
                .statusCode(SUCCESS_CODE)
                .extract().response().as(Employee.class);

        assertThat(employeeResponse, equalTo(readJSONFile(pathTemplate+pathGet+pathPositiveResponse)));

    }

    @Test
    public void deleteRequestEmployee() throws IOException, ParseException {
        Employee employee = new Employee();

        String employeeResponse =  deleteEmployeeRequest(employee).
                assertThat().
                statusCode(SUCCESS_CODE)
                .extract().response().path(responsePath);

        assertThat(employeeResponse, equalTo(JSOnFileGetMessage(pathTemplate+pathDelete+pathPositiveResponse)));

    }

    @Test
    public void putRequestEmployee() throws IOException, ParseException {
        Employee employee =  readJSONFile(pathTemplate + pathPut + pathPositiveRequest);

       String response = putEmployeeRequest(employee)
                .assertThat()
                .statusCode(SUCCESS_CODE)
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate+pathPut+pathPositiveResponse)));



    }

    @Test
    public void patchRequestEmployee() throws IOException, ParseException {
        Employee employee = readJSONFile(pathTemplate+pathPatch+pathPositiveRequest);

       String response  = patchEmployeeRequest(employee)
                .assertThat()
                .statusCode(SUCCESS_CODE)
                .header("Content-Type", equalTo("text/plain;charset=UTF-8"))
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate+pathPatch+pathPositiveResponse)));

    }

    @Test
    public void postRequestEmployee() throws IOException, ParseException {
        Employee employee = readJSONFile(pathTemplate+ pathPost+pathPositiveRequest);

       String response = postEmployeeRequest(employee).
                assertThat().
                statusCode(SUCCESS_CODE)
               .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate+pathPost+pathPositiveResponse)));


    }


}
