//package com.blogapp.service;
//
//import io.micrometer.observation.Observation;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//public class StreamTest {
//    public static void main(String[] args) {
////       Consumer<Integer> val = n-> System.out.println(n);
////       val.accept(20);
//
////        Consumer<String> val = n-> System.out.println(n);
////        val.accept("jyoti");
//
//        // Consumer functional interface example.
//
////        Consumer<Integer> items = n-> System.out.println(n);
////
////        List<Integer> number = new ArrayList<>();
////        number.add(1);
////        number.add(2);
////        number.add(10);
////        number.add(32);
////        number.add(54);
////        number.add(44);
////
////        number.forEach(items);
//
//        // Supplier functional interface example
//
//
////        Supplier<Double> val = () -> Math.random();
////        Double result = val.get();
////        System.out.println(result);
//
//        List<Employee> data = Arrays.asList(
//                new Employee(1,"ram",5000,"delhi"),
//                new Employee(2, "sam", 4000,"mumbai"),
//                new Employee(3, "stallin", 6000,"delhi"),
//                new Employee(4, "adam", 5500,"hyderabad"),
//                new Employee(5, "mike", 6000,"chennai")
//        );
//
////        Map<Integer, List<Employee>> collect = data.stream().collect(Collectors.groupingBy(e -> e.getSalary()));
////        collect.forEach((salary, employees) ->
////                System.out.println("Salary: " + salary + ", Employees: " + employees));
//
////        List<Employee> newData = data.stream().filter(e -> e.getLocation().equals("delhi")&&e.getSalary()>=5000).collect(Collectors.toList());
////        for (Employee e:newData) {
////            System.out.println(e);
//
//        List<Employee> result = data.stream().filter(e -> e.getName().startsWith("s")).collect(Collectors.toList());
//        for (Employee e:result) {
//            System.out.println(e);
//        }
//    }
//}
//
//
//
//
//
//
