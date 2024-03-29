//package com.blogapp;
//
//import org.modelmapper.ModelMapper;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MainClass {
//    public static void main(String[] args) {
//        Employee1 e1 = new Employee1();
//        e1.setId(1);
//        e1.setName("mike");
//
//        Employee1 e2 = new Employee1();
//        e2.setId(2);
//        e2.setName("stallin");
//
//        List<Employee1> emp = Arrays.asList(e1, e2);
//        List<Employee1Dto> collect = emp.stream().map(e5 -> mapToDto(e5)).collect(Collectors.toList());
//    }
//
//
//    static Employee1Dto mapToDto(Employee1 e5)
//    {
//        Employee1Dto dto = new Employee1Dto();
//        dto.setId(e5.getId());
//        dto.setName(e5.getName());
//        return dto;
//
//    }
//}
