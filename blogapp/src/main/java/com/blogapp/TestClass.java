import java.util.function.Function;
import java.util.function.Predicate;

//package com.blogapp;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class TestClass {
//    public static void main(String[] args) {
////
////        Predicate<String> result = str->str.equalsIgnoreCase("mike");
////        boolean val = result.test("Mike");
////        System.out.println(val);
////
////        Function<Integer, Integer> val = n->n*10;
////        Integer result = val.apply(10);
////        System.out.println(result);
////
////       Function<Integer,String> value = n->"the output is "+n;
////        String result1 = value.apply(20);
////        System.out.println(result1);
//
////        List<Integer> data = Arrays.asList(10, 79, 34, 40, 49, 81, 54);
////        List<Integer> odd = data.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
////        System.out.println("odd numbers are : "+odd);
//
////        List<String> val = Arrays.asList("ram","sam","sudhir","ankit","smith","adam","Ram");
////        List<String> s = val.stream().filter(str -> str.equalsIgnoreCase("ram")).collect(Collectors.toList());
////        System.out.println(s.size());
////
//
////        List<String> list = Arrays.asList("ram", "sam", "sudhir", "ankit", "smith", "adam", "ram");
////        List<String> val = list.stream().distinct().collect(Collectors.toList());
////        System.out.println(val);
//
////        List<Integer> data = Arrays.asList(41, 54, 74, 52, 95, 81, 34, 64, 43);
////        List<Integer> newData = data.stream().map(n -> n * n).collect(Collectors.toList());
////        for (int i=0;i< data.size();i++)
////        System.out.println("the square of : "+data.get(i)+" = "+newData.get(i));
//
////        List<Integer> data = Arrays.asList(10,20,30,40,50,60);
////        Function<Integer,Integer> datas = n->n*n;
////        List<Integer> collect = data.stream().map(datas).collect(Collectors.toList());
////
////        for (int i=0;i< data.size();i++)
////        {
////            System.out.println("square of "+data.get(i)+" = "+collect.get(i));
////        }
//
//
//
////         IntStream.rangeClosed(1, 20).mapToObj(n ->"square of "+(20-n+1)+" = "+ (20-n+1) * (20-n+1)).forEach(System.out::println);
//
//
//        List<String> list = Arrays.asList("jyoti", "dipun", "dipun", "jyoti", "kishore", "dipun", "kishore", "jyoti");
//        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
//        System.out.println(collect);
//
//        Function<Integer,Integer> val = n->n+n;
//        Integer result = val.apply(50);
//        System.out.println(result);

//        Predicate<Integer> val = n->n%2==0;
//        boolean test = val.test(20);
//        System.out.println(test);
//
//   }
//
//}
