package ru.geekbrains.lesson1.regular;

/**
 * Калькулятор. Он считает цифры.
 */
public class Calculator {
    /**
     * Функция суммирования двух целых чисел
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a и b.
     */
    public int add(int a, int b) {
        return a + b;
    }
    /**
     * Функция вычитания двух целых чисел
     *
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность a и b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }
    /**
     * Функция умножения двух целых чисел
     *
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение a и b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    /**
     * Функция вычитания двух целых чисел
     *
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность a и b.
     */
    public int divide(int a, int b) {
        return a / b;
    }
}