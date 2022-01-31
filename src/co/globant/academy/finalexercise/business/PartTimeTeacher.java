package co.globant.academy.finalexercise.business;

public class PartTimeTeacher extends Teacher {
    private short activeHoursWeek;

    public PartTimeTeacher(String name) {
        super(name);
    }

    public PartTimeTeacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    public PartTimeTeacher(String name, double baseSalary, short activeHoursWeek) {
        super(name, baseSalary);
        this.activeHoursWeek = activeHoursWeek;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary * activeHoursWeek;
    }

    public short getActiveHoursWeek() {
        return activeHoursWeek;
    }

    public void setActiveHoursWeek(short activeHoursWeek) {
        this.activeHoursWeek = activeHoursWeek;
    }
}
