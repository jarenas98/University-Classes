package co.globant.academy.finalexercise.business;

public abstract class Person {
    private String name;
    private int id;
    private static int count = 1;

    public Person() {
        this.id = count;
        count++;
    }

    public Person(String name) {
        this.name = name;
        this.id = count;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
