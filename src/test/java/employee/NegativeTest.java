package employee;

import employee.model.Employee;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static employee.HttpClient.HttpClient.*;
import static employee.configPath.ConfigurationPath.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class NegativeTest {

    @Test
    public void getRequestEmployee() throws Exception {
        Employee employee = new Employee();

        String response = getEmployeeRequestNegative(employee)
                .assertThat()
                .statusCode(INTERNAL_SERVER_ERROR)
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate + pathGet + pathNegativeResponse)));


    }

    @Test
    public void postRequestEmployee() throws IOException, ParseException {
        Employee employee = readJSONFile(pathTemplate + pathPost + pathNegativeRequest);


        String response = postEmployeeRequest(employee).
                assertThat().
                statusCode(INTERNAL_SERVER_ERROR)
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate + pathPost + pathNegativeResponse)));


    }

    @Test
    public void putRequestEmployee() throws IOException, ParseException {
        Employee employee = readJSONFile(pathTemplate + pathPut + pathNegativeRequest);

        String response = putEmployeeRequest(employee).
                assertThat().
                statusCode(INTERNAL_SERVER_ERROR)
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate + pathPut + pathNegativeResponse)));


    }

    @Test
    public void deleteRequestEmployee() throws IOException, ParseException {
        Employee employee = new Employee();

        String response = deleteEmployeeRequest(employee).
                assertThat().
                statusCode(INTERNAL_SERVER_ERROR)
                .extract().response().path(responsePath);
        assertThat(response, containsString(JSOnFileGetMessage(pathTemplate + pathDelete + pathNegativeResponse)));

    }


}
