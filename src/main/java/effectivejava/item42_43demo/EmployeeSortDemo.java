package effectivejava.item42_43demo;

import java.util.*;

class Employee {
    String name;
    int age;
    Employee(String name, int age) { this.name = name; this.age = age; }
    public int getAge() { return age; }
    public String toString() { return name + "(" + age + ")"; }
}

public class EmployeeSortDemo {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", 25),
                new Employee("Bob", 30),
                new Employee("Charlie", 20)
        );

        // ① 無名クラス
        employees.stream()
                .sorted(new Comparator<Employee>() {
                    public int compare(Employee e1, Employee e2) {
                        return Integer.compare(e1.getAge(), e2.getAge());
                    }
                })
                .forEach(System.out::println);

        // ② ラムダ
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .forEach(System.out::println);

        // ③ メソッド参照
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);
    }
}
