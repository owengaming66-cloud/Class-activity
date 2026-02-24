package Class activity;

public class Doctor extends person implements Payable {
    private String specialization;
    private double salary;

    public Doctor(String name, int age, String specialization, double salary) {
        super(name, age);
        this.specialization = specialization;
        this.salary = salary;
    }

    @Override
    public void displayrole() {
        System.out.println("Doctor: " + name + ", Age: " + age + ", Specialization: " + specialization);
    }

    @Override
    public double calculatePayment() {
        return salary;
    }
}