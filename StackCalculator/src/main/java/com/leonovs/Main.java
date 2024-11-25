package com.leonovs;



public class Main {
    public static void main(String[] args) {
        StackCalculator calculator = new StackCalculator();
        System.out.println("Сначала введите числа через пробел, а потом через пробел введите знаки операций для смежных чисел.");
        calculator.start();
    }
}