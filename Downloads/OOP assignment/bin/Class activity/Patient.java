package Classactivity;

public class Patient extends person {
    private String illness;

    public Patient(String name, int age, String illness) {
        super(name, age);
        this.illness = illness;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getIllness() { return illness; }

    @Override
    public void displayrole() {
        System.out.println("Patient: " + name + ", Age: " + age + ", Illness: " + illness);
    }

    // Format for saving to file
    public String toFileString() {
        return name + "," + age + "," + illness;
    }

    // Create Patient from file string
    public static Patient fromFileString(String line) {
        String[] parts = line.split(",");
        return new Patient(parts[0], Integer.parseInt(parts[1]), parts[2]);
    }
}

