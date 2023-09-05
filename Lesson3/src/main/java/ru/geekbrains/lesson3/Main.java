package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Base base = new Base();
        base.addHumans(new FreeLancer("1", 444.0), new Worker("2", 333.0), new Worker("3", 222.0), new FreeLancer("4", 111.0));

        Collections.sort(base.getHumanArrayList(), new HumanComparator());

        for (Human human : base.getHumanArrayList()) {
            System.out.println("Имя: " + human.getName() + ", Заработная плата: " + human.calcMonthSalary());
        }
    }
}
