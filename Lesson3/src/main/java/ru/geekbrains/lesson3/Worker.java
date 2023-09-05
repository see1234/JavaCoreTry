package ru.geekbrains.lesson3;

public class Worker extends Human {
    private double monthlySalary;

    public Worker(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    public double calcMonthSalary() {
        return monthlySalary;
    }
}
