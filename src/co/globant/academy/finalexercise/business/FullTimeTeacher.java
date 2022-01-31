package co.globant.academy.finalexercise.business;

public class FullTimeTeacher extends Teacher {
    private short experienceYears;

    public FullTimeTeacher() {
        super();
    }

    public FullTimeTeacher(String name) {
        super(name);
    }

    public FullTimeTeacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public FullTimeTeacher(String name, double baseSalary, short experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    public short getExperienceYears() {
        return this.experienceYears;
    }

    public void setExperienceYears(short experienceYears) {
        this.experienceYears = experienceYears;
    }
}
