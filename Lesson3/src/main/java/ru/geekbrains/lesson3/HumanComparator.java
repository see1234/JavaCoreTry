package ru.geekbrains.lesson3;

import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {
    public int compare(Human emp1, Human emp2) {
        return Double.compare(emp1.calcMonthSalary(), emp2.calcMonthSalary());
    }
}
