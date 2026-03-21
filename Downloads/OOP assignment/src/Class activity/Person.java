package Classactivity;

abstract class person {
    protected String name;
    protected int age;
    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public abstract void displayrole();
}
    