package Classactivity;

public class Doctor extends person implements Payable {
    private String specialization;
    private double salary;

    public Doctor(String name, int age, String specialization, double salary) {
        super(name, age);
        this.specialization = specialization;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecialization() { return specialization; }
    public double getSalary() { return salary; }

    @Override
    public void displayrole() {
        System.out.println("Doctor: " + name + ", Age: " + age + ", Specialization: " + specialization);
    }

    @Override
    public double calculatePayment() {
        return salary;
    }

    // Format for saving to file
    public String toFileString() {
        return name + "," + age + "," + specialization + "," + salary;
    }

    // Create Doctor from file string
    public static Doctor fromFileString(String line) {
        String[] parts = line.split(",");
        return new Doctor(parts[0], Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]));
    }
}
