package employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String firstName;
    private String lastName;
    private String lavozimi;


    public Employee(String firstName, String lastName, String lavozimi) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lavozimi = lavozimi;
    }

        public String getFirstName () {
        return firstName;
    }

        public void setFirstName (String firstName){
        this.firstName = firstName;
    }

        public String getLastName () {
        return lastName;
    }

        public void setLastName (String lastName){
        this.lastName = lastName;
    }

        public String getLavozimi () {
        return lavozimi;
    }

        public void setLavozimi (String lavozimi){
        this.lavozimi = lavozimi;
    }

}

class Department {
    private final String name;
    private final List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}

class Company {
    private final String name;
    private final List<Department> departmentList;

    public void addCompany(Department department) {
        departmentList.add(department);
    }

    public Company(String name) {
        this.name = name;
        this.departmentList = new ArrayList<>();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kompaniyani kiriting ");
        String company1 = scanner.next();
        Company company = new Company(company1);

        System.out.println("Bo'limni kiriting ");
        String department2 = scanner.next();
        Department department = new Department(department2);
        Department department1 = new Department(department2);

        System.out.println("ishchi haqida malumot kiriting ");
        String name = scanner.next();
        String lName = scanner.next();
        String position = scanner.next();
        Employee employee = new Employee(name, lName, position);

        department.addEmployee(employee);
        department1.addEmployee(employee);
        company.addCompany(department);
        company.addCompany(department1);

        List<Department> departments = company.getDepartmentList();
        for (Department d :
                departments) {
            System.out.println("Bo'lim nomi " + d.getName());
            List<Employee> employeeList = d.getEmployeeList();
            for (Employee e :
                    employeeList) {
                System.out.println("Employee firstname " + e.getFirstName() + "Employee firstname " + e.getLastName() + "Employee position " + e.getLavozimi());
            }
            System.out.println();
        }
    }
}
