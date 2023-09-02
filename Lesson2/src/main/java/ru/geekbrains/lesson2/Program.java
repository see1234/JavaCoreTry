package ru.geekbrains.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final int WIN_COUNT = 4; // Выигрышная комбинация
    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        field = new char[3][];

        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }


    private static void initialize(){

        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }

    }


    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();

    }


    private static void humanTurn(){
        int x, y;

        do {

            while (true){
                System.out.print(String.format("Введите координату хода X (от %d до %d): ", 1, fieldSizeX));
                if (scanner.hasNextInt()){
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.print(String.format("Введите координату хода Y (от %d до %d): ", 1, fieldSizeY));
                if (scanner.hasNextInt()){
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    private static void aiTurn(){
        //чучуть по-умнее
        int x = -1, y = -1;
        //Проверяет есть ли выигрышный ход
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (isCellEmpty(i, j)) {
                    field[i][j] = DOT_AI;
                    if (checkWin(DOT_AI)) {
                        x = i;
                        y = j;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        //Если уже нету выигрышных ходов
        if (x == -1 && y == -1) {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellEmpty(x, y));
        }

        field[x][y] = DOT_AI;
    }

    private static boolean checkGameState(char c, String s){
        if (checkWin(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    private static boolean checkWin(char c){
        int size = field.length;
        int winCount = WIN_COUNT;

        // Проверка по горизонталям и вертикалям
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winCount; j++) {
                boolean winInRow = true;
                boolean winInColumn = true;

                for (int k = 0; k < winCount; k++) {
                    if (field[i][j + k] != c) {
                        winInRow = false;
                    }
                    if (field[j + k][i] != c) {
                        winInColumn = false;
                    }
                }

                if (winInRow || winInColumn) {
                    return true;
                }
            }
        }

        // Проверка по диагоналям
        for (int i = 0; i <= size - winCount; i++) {
            for (int j = 0; j <= size - winCount; j++) {
                boolean winInDiagonal1 = true;
                boolean winInDiagonal2 = true;

                for (int k = 0; k < winCount; k++) {
                    if (field[i + k][j + k] != c) {
                        winInDiagonal1 = false;
                    }
                    if (field[i + k][j + winCount - 1 - k] != c) {
                        winInDiagonal2 = false;
                    }
                }

                if (winInDiagonal1 || winInDiagonal2) {
                    return true;
                }
            }
        }

        return false;

    }


    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
