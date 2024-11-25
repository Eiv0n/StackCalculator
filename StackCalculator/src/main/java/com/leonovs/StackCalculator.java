package com.leonovs;

import java.util.Scanner;
import java.util.Stack;


public class StackCalculator {

    public void start(){

        Scanner scanner = new Scanner(System.in);
        // Создаем объект класса Scanner, чтобы принимать ввод с клавиатуры

        String input = scanner.nextLine();
        // Создаем переменную String, в которую вкладываем ввод с клавиатуры

        String[] inputArray = input.split(" ");
        // Создаем массив строк, в который будем вкладывать подстроки строки ввода,
        // которые вычленним оттуда с помощью метода split(), в параметрах указываем пробел,
        // по которому будет происходить деление строки на подстроки

        Stack<Double> stack = new Stack<>();
        // Создаем Stack, в который будем помещать числа (метод push()) и в следствие брать оттуда смежные числа (метод pop()),
        // производя операции с ними, результат которых также помещая в Stack и при случае,
        // если массив подстрок inputArray еще не кончился и у нас есть еще числа в Stack,
        // то беря сверху Stack'a результат предыдущей операции
        // и производя новую операцию с результатом прошлой операции и новым числом из массива подстрок inputArray,
        // когда мы проитерируемся до конца массива подстрок inputArray,
        // мы выйдем из цикла for и просто выведем результат - последний оставшийся в Stack'e (метод pop()/метод peek())

        for (int counter = 0; counter < inputArray.length; counter++) {
        // Создаем цикл for, с помощью которого будем итерироваться по массиву подстрок и извлекать оттуда числа и знаки операций

            if (isNumber(inputArray[counter])){
                // Поскольку в массив подстрок попадают и числа и знаки операций, то нам нужно их как-то различать,
                // пишем метод(ниже), проверяющий число ли это или знак и возвращающий булево значение, с помощью которого
                // мы в if в процессе итерации проверяем является ли текущий элемент массива подстрок числом или знаком,
                // если он является числом, то мы добавляем его в стек, поскольку формат ввода требуемый от пользователя -
                // сначала числа, затем знаки, то на каждой итерации пока не закончатся числа, мы будем пушить их в Stack
                // затем, когда числа кончатся условие if не выполнится и мы начнем выполнять блок else

                stack.push(Double.parseDouble(inputArray[counter]));
                // Кладем число взятое из массива подстрок в Stack, приводя его к double

            } else {

                double firstNumber = stack.pop();
                double secondNumber = stack.pop();
                // Берем два смежных числа сверху Stack'a,
                // чтобы далее произвести над ними операцию
                // и добавить результат операции в Stack,
                // с которым будет производится операция при следующей итерации при условии,
                // которое описано выше в комментариях с 25 по 27 строки

                switch (inputArray[counter]) {
                    case "+" : stack.push(firstNumber + secondNumber); break;
                    case "-" : stack.push(firstNumber - secondNumber); break;
                    case "*" : stack.push(firstNumber * secondNumber); break;
                    case "/" : stack.push(firstNumber / secondNumber); break;
                }
                // Производим операцию с двумя смежными числами с вершины Stack'a, и пушим результат операции в Stack
            }
        }
            System.out.print(" = " + stack.pop());
            // Выводим последнее оставшееся число в Stack'e, которое и является нашим результатом
    }

    public static boolean isNumber(String str){
        // Метод, который проверяет нашу подстроку из массива подстрок inputArray на то, число ли это или знак
        // по принципу - если подстроку можно привести к double методом parseDouble(), то это число (возвращаем true) если нет,
        // то тогда это знак (возвращаем false)
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}

