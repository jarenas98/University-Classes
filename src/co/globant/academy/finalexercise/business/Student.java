package co.globant.academy.finalexercise.business;

public class Student extends Person {
    private short age;

    public Student() {
        super();
    }

    public Student(String name) {
        super(name);
    }

    public Student(String name, short age) {
        super(name);
        this.age = age;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
