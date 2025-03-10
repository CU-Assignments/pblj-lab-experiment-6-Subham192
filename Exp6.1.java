import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void display() {
        System.out.println(name + " (" + age + ", " + salary + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));
        employees.add(new Employee("Alex", 28, 45000));
        employees.add(new Employee("Alex", 32, 47000));
        employees.add(new Employee("David", 29, 50000));
        employees.add(new Employee("Eve", 31, 50000));
        employees.add(new Employee("Frank", 27, 50000));

        
        System.out.println("Sorting by Name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(Employee::display);

        
        System.out.println("\nSorting by Age:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(Employee::display);

    
        System.out.println("\nSorting by Salary:");
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(Employee::display);

        
        System.out.println("\nEdge Case - Same Name, Different Age:");
        List<Employee> sameNameEmployees = new ArrayList<>();
        sameNameEmployees.add(new Employee("Alex", 28, 45000));
        sameNameEmployees.add(new Employee("Alex", 32, 47000));
        sameNameEmployees.add(new Employee("Alex", 25, 46000));
        
        sameNameEmployees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(Employee::display);

        
        System.out.println("\nEdge Case - Same Salary:");
        List<Employee> sameSalaryEmployees = new ArrayList<>();
        sameSalaryEmployees.add(new Employee("David", 29, 50000));
        sameSalaryEmployees.add(new Employee("Eve", 31, 50000));
        sameSalaryEmployees.add(new Employee("Frank", 27, 50000));
        
        sameSalaryEmployees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(Employee::display);
    }
}
