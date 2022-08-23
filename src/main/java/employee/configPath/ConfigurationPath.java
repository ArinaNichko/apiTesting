package employee.configPath;

public class ConfigurationPath {
    public static final String URL = "http://localhost:9090/";
    public static final String getEmployee = "/102";
    public static final String deleteNegativeRequest = "/105";
    public static final String employeeURL = "employee";
    public static String pathTemplate = "src/test/resources/templates/gcp";
    public static String pathPut = "/put_employee";
    public static String pathPatch = "/patch_employee";
    public static String pathDelete = "/delete_employee";
    public static String pathPositiveRequest = "/request.json";
    public static String pathPositiveResponse = "/response.json";
    public static String pathNegativeResponse = "/negative_response.json";
    public static String pathNegativeRequest = "/request_negative.json";
    public static String pathPost = "/post_employee";
    public static String pathGet = "/get_employee";
    public static String responsePath = "message";
    public static int SUCCESS_CODE = 200;
    public static int INTERNAL_SERVER_ERROR = 500;

    public String fullPathPositiveResponse(String httpMethod) {
        return pathTemplate + httpMethod + pathPositiveResponse;
    }

}
