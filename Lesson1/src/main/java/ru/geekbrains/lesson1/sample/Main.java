package ru.geekbrains.lesson1.sample;





import ru.geekbrains.lesson1.regular.Calculator;
import ru.geekbrains.lesson1.regular.Decorator;

import java.util.Scanner;

public class Main {

    /**
     * @param args стандартные аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("Выберите операцию: ");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        int choice = scanner.nextInt();

        Calculator calculator = new Calculator();
        int result = 0;

        switch (choice) {
            case 1:
                result = calculator.add(num1, num2);
                break;
            case 2:
                result = calculator.subtract(num1, num2);
                break;
            case 3:
                result = calculator.multiply(num1, num2);
                break;
            case 4:
                result = calculator.divide(num1, num2);
                break;
            default:
                new NumberFormatException("Недопустимый формат");
                return;
        }
        System.out.println(Decorator.decorate(result));
    }

}
