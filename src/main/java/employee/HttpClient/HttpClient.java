package employee.HttpClient;


import com.fasterxml.jackson.databind.ObjectMapper;
import employee.model.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static employee.configPath.ConfigurationPath.*;


public class HttpClient {

    public static ValidatableResponse getEmployeeRequest(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .get(employeeURL + getEmployee)
                .then();

    }

    public static ValidatableResponse postEmployeeRequest(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .post(employeeURL)
                .then();

    }

    public static ValidatableResponse putEmployeeRequest(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .put(employeeURL)
                .then();

    }

    public static ValidatableResponse patchEmployeeRequest(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .patch(employeeURL)
                .then();

    }

    public static ValidatableResponse deleteEmployeeRequest(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .delete(employeeURL + getEmployee)
                .then();

    }

    public static ValidatableResponse getEmployeeRequestNegative(Employee employee) {
        return RestAssured.given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .get(employeeURL + deleteNegativeRequest)
                .then();

    }

    public static Employee readJSONFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Employee.class);
    }

    public static String JSOnFileGetMessage(String path) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject data = (JSONObject) parser.parse(
                new FileReader(path));
        return (String) data.get("message");

    }


}
