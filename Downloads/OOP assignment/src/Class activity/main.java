package Classactivity;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter doctor age: ");
        int doctorAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter doctor salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int patientAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient illness: ");
        String illness = scanner.nextLine();

        System.out.print("Enter appointment date: ");
        String date = scanner.nextLine();

        Doctor doctor = new Doctor(doctorName, doctorAge, specialization, salary);
        Patient patient = new Patient(patientName, patientAge, illness);
        Appointment appointment = new Appointment(doctor, patient, date);

        appointment.displayAppointmentDetails();
        System.out.println("Doctor's payment: " + doctor.calculatePayment());

        scanner.close();
    }
}