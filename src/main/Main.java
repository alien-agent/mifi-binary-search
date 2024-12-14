package main;


import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Тест для массива int[]
        int[] intArray = {1, 3, 5, 7, 9, 11};
        int intKey = 5;
        int intResult = main.Arrays.binarySearch(intArray, intKey);
        System.out.println("Index of " + intKey + " in intArray: " + intResult);

        // Тест для массива объектов с Comparator
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        String stringKey = "cherry";
        int stringResult = main.Arrays.binarySearch(stringArray, stringKey, Comparator.naturalOrder());
        System.out.println("Index of \"" + stringKey + "\" in stringArray: " + stringResult);

        // Тест для списка объектов с Comparator
        List<String> stringList = java.util.Arrays.asList("apple", "banana", "cherry", "date");
        int listResult = main.Collections.binarySearch(stringList, stringKey, Comparator.naturalOrder());
        System.out.println("Index of \"" + stringKey + "\" in stringList: " + listResult);
    }
}