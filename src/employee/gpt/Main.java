package employee.gpt;
import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}

// Department class
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

// Company class
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("ABC Company");

        // Creating departments
        Department department1 = new Department("IT");
        Department department2 = new Department("HR");

        // Creating employees
        Employee employee1 = new Employee("John Doe", "Developer");
        Employee employee2 = new Employee("Jane Smith", "HR Manager");

        // Adding employees to departments
        department1.addEmployee(employee1);
        department2.addEmployee(employee2);

        // Adding departments to the company
        company.addDepartment(department1);
        company.addDepartment(department2);

        // Displaying departments in the company
        List<Department> departments = company.getDepartments();
        for (Department department : departments) {
            System.out.println("Department name: " + department.getName());
            // Displaying employees in the department
            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                System.out.println("Employee name: " + employee.getName() + ", position: " + employee.getPosition());
            }
            System.out.println();
        }
    }
}

