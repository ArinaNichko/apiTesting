package controller;

import clients.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;


import static io.restassured.RestAssured.given;

public class EmployeeController {

    private static final String URL = "http://localhost:9090/";



    public static ValidatableResponse getEmployeeRequest(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .get("employee/102")
                .then();

    }

    public static ValidatableResponse postEmployeeRequest(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                    .post("employee/")
                .then();

    }

    public static ValidatableResponse putEmployeeRequest(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .put("employee/")
                .then();

    }

    public static ValidatableResponse patchEmployeeRequest(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .patch("employee/")
                .then();

    }

    public static ValidatableResponse deleteEmployeeRequest(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .delete("employee/102")
                .then();

    }

    public static ValidatableResponse getEmployeeRequestNegative(Employee employee) {
        return given()
                .baseUri(URL)
                .contentType(ContentType.JSON)
                .body(employee)
                .when()
                .get("employee/105")
                .then();

    }


}
