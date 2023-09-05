package ru.geekbrains.lesson3;

public class FreeLancer extends Human {
    private double hourlyRate;

    public FreeLancer(String name, double hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
    }

    public double calcMonthSalary() {
        return 20.8 * 8 * hourlyRate;
    }

}