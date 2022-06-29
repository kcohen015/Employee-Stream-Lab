import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        for (Employee employee : employeeList)
            System.out.println(employee); //stringifies the object reference to call the tostring method
        System.out.println("\n");

        //order based on employee age, filter to less than 30
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .filter(e-> e.getAge()<=30)
                .forEach(s-> System.out.println(s));
        System.out.println("\n");

        //group based on department
        Map<String, Long> departments = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(departments + "\n");

        //order based on department, then a-z within department
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getName))
                .forEach(e-> System.out.println(e));
        System.out.println("\n");

        //add 10 to each age
        employeeList.stream()
                .map( emp -> {
                    Employee empDTO = new Employee(emp.getId(), emp.getName(), emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getYearOfJoining(), emp.getSalary());
                    empDTO.setAge( emp.getAge() + 10);
                    return empDTO;
                })
                .forEach(emp -> System.out.println(emp));
        System.out.println("\n");

        //change all names to uppercase
        employeeList.stream()
                .map( emp -> {
                    Employee empDTO = new Employee(emp.getId(), emp.getName(), emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getYearOfJoining(), emp.getSalary());
                    empDTO.setName( emp.getName().toUpperCase() );
                    return empDTO;
                })
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(emp -> System.out.println(emp));
        System.out.println("\n");

        //Output salaries in ascending order
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(e -> System.out.println(e.getSalary()));
        System.out.println("\n");

        //List of names with salary over 25000
        employeeList.stream()
                .filter(e -> e.getSalary()>25000)
                .forEach(e -> System.out.println(e.getName()));
        System.out.println("\n");

        //Give everyone a $500 raise
        employeeList.stream()
                .map( emp -> {
                    Employee empDTO = new Employee(emp.getId(), emp.getName(), emp.getAge(), emp.getGender(), emp.getDepartment(), emp.getYearOfJoining(), emp.getSalary());
                    empDTO.setSalary( emp.getSalary()+500 );
                    return empDTO;
                })
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(emp -> System.out.println(emp));
    }
}