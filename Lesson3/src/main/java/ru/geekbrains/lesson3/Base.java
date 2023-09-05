package ru.geekbrains.lesson3;

import java.util.ArrayList;

public class Base {


    public ArrayList<Human> humanArrayList;

    public Base() {
        humanArrayList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humanArrayList.add(human);
    }

    public void addHumans(Human... humans) {
        for(Human human : humans) {
            addHuman(human);
        }
    }

    public void removeHumans(Human human) {
        if(humanArrayList.contains(human)) {
            humanArrayList.remove(human);
        }
    }

    public ArrayList<Human> getHumanArrayList() {
        return humanArrayList;
    }
}
