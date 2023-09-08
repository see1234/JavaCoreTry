package ru.geekbrains.lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        try {
            String[][] arr = {{"1", "2", "f", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}, {"1", "2", "3", "4"},};
            System.out.println("Sum: " + sum_arr(arr));
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int sum_arr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            for(int i = arr.length - 1; i >= 0; i--) {
                if(arr[i].length != 4) {
                    throw new MyArraySizeException("Size need 4x4");
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("number in [" + i + "] " + "[" + j + "] not int");
                }
            }
        }
        return sum;
    }
}
