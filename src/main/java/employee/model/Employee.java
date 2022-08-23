package employee.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    int id;
    String name;
    String passportNumber;
    String education;

    public Employee(Object readJSONFile) {
    }
}
