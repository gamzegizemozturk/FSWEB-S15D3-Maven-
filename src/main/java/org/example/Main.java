package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Burcu", "Aydın"));
        employees.add(new Employee(2, "Esra", "Berkant"));
        employees.add(new Employee(3, "Yıldız", "Yılmaz"));
        employees.add(new Employee(1, "Burcu", "Aydın")); // Duplicate
        employees.add(new Employee(2, "Esra", "Berkant")); // Duplicate
        employees.add(new Employee(4, "Cem", "Yılmaz"));
        employees.add(new Employee(5, "Ayşe", "Kara"));

        System.out.println("Number of duplicates: " + findDuplicates(employees).size());
        System.out.println("Number of unique entries: " + findUniques(employees).size());
        System.out.println("List after removing duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        employeeMap = new HashMap<>();
        duplicatedEmployees = new ArrayList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("Null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> unique = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(unique.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}