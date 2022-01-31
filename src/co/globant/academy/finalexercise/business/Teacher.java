package co.globant.academy.finalexercise.business;

public abstract class Teacher extends Person {
    double baseSalary;

    public Teacher() {
        super();
    }

    public Teacher(String name) {
        super(name);
    }

    public Teacher(String name, double baseSalary) {
        super(name);
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}
