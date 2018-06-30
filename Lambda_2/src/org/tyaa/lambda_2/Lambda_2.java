/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.lambda_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.tyaa.lambda_2.interfaces.Greeter;

/**
 *
 * @author student
 */
public class Lambda_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /* 1. В лямбда-выражение попадают не сами переменные,
        а их значения, которые должны быть фиксированными*/
        
        //String name = "Vasia";
        final String name = "Vasia";
        //Попытка сделать переменную name не эффективно финальной
        //name += "!";
        
        launcher((prefix) -> {
        
            System.out.println(prefix + name);
        });
        
        /* 2 Оператор diamond вызывает выведение и подстановку типа  */
        
        //Начиная с Java7 можно явно указывать типизацию только для переменной
        Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();
        Map<String, Integer> diamondWordCounts = new HashMap<>();
        
        //Начиная с Java8 можно передавать в конструктор вызов
        //конструктора шаблонного класса без явной типизации
        useHashmap(new HashMap<>());
        
        //Благодаря выше сказанному автоматически определяется тип
        //и для лямбда-выражений (по типизации переменной),
        //которой лямбда присваивается
        Predicate<Integer> atLeast5 = х -> х > 5;
        //Так не скомпилируется: неоткуда брать тип значения,
        //которое должна вернуть лямбда,
        //поэтому компитлятор считает, что тип - Object,
        //а к нему не применим арифметический оператор "+"
        //BinaryOperator add = (х, у) -> х + у;
        //А так скомпилируется
        BinaryOperator<Integer> add = (х, у) -> х + у;
        
        //System.out.println(atLeast5());
        
        /*List<Integer> numbersIn = Arrays.asList(1, 2, 3, 0, 10, 15, 8);
        List<Integer> numbersOut =
                numbersIn.stream()
                    .filter(atLeast5)
                    .map((num) -> num + 1)
                    .collect(Collectors.toList());
        
        for (Integer integer : numbersOut) {
            System.out.println(integer);
        }*/
        
        Map<Integer, Integer> numbers2In = new HashMap<>();
        numbers2In.put(1, 2);
        numbers2In.put(3, 4);
        List<Integer> numbersOut2;
        numbersOut2 = numbers2In.entrySet().stream()
                .map((el) -> el.getKey() + el.getValue())
                .collect(Collectors.toList());
        
        Map<Integer, Integer> numbersOut3 = numbers2In.entrySet().stream()
                .map((el) -> {
                    return new HashMap.SimpleEntry<Integer, Integer>(
                            el.getKey() + 2, el.getValue() + 2
                    );
                })
                .collect(Collectors.toMap((el) -> {
                    return el.getKey(); //To change body of generated lambdas, choose Tools | Templates.
                }, (el) -> {
                    return el.getValue(); //To change body of generated lambdas, choose Tools | Templates.
                }));
        
        for (Map.Entry<Integer, Integer> entry : numbersOut3.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    
    private static void launcher(Greeter _greeter){
    
        _greeter.sayAGreeting("Hello ");
    }
    
    private static void useHashmap(Map<String, String> _values){}
}
