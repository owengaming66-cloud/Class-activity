package Classactivity;

public class Patient extends person {
    private String illness;

    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    @Override
    public void displayrole() {
        System.out.println("Patient: " + name + ", Age: " + age + ", Illness: " + illness);
    }
    
}
