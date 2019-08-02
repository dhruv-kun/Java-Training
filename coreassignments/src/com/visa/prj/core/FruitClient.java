package com.visa.prj.core;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitClient {

    public static void main(String[] args) {
        String[] fruits = {
                "mango", "pear", "apple",
                "mango", "pear", "banana",
                "apple", "apple"};
        List<String> fruitList = Arrays.asList(fruits);
        fruitList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue())
                .forEach(System.out::println);
    }
}
