import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EmployeeBook {
    private final Map<String, Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee) {
        String key = generateKey(employee);
        if (!employees.containsKey(key)) {
            employees.put(key, employee);
        } else {
            System.out.println("Employee с таким ключом уже существует");
        }
    }

    public void removeEmployee(Employee employee) {
        String key = generateKey(employee);
        if (employees.containsKey(key)) {
            employees.remove(key);
        } else {
            // Обработка ситуации, когда сотрудника с таким ключом не существует
            System.out.println("Employee not found.");
        }
    }

    public Optional<Employee> findEmployeeByName(String fullName) {
        return Optional.ofNullable(employees.get(fullName));
    }

    private String generateKey(Employee employee) {
        return employee.getFullName();
    }
}
