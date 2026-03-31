package Classactivity;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital("City Hospital");

        // Load any previously saved data
        System.out.println("Loading saved data...");
        hospital.loadDataFromFiles();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Admit Patient");
            System.out.println("3. Create Appointment");
            System.out.println("4. List All Doctors");
            System.out.println("5. List All Patients");
            System.out.println("6. List All Appointments");
            System.out.println("7. Save Data to Files");
            System.out.println("8. View Total Patients");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();

                    System.out.print("Enter doctor age: ");
                    int doctorAge;
                    try {
                        doctorAge = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age.");
                        break;
                    }

                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();

                    System.out.print("Enter salary: ");
                    double salary;
                    try {
                        salary = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary.");
                        break;
                    }

                    hospital.addDoctor(new Doctor(doctorName, doctorAge, specialization, salary));
                    break;

                case 2:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int patientAge;
                    try {
                        patientAge = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age.");
                        break;
                    }

                    System.out.print("Enter illness: ");
                    String illness = scanner.nextLine();

                    hospital.admitPatient(new Patient(patientName, patientAge, illness));
                    break;

                case 3:
                    System.out.print("Enter doctor name for appointment: ");
                    String apptDoctorName = scanner.nextLine();

                    System.out.print("Enter doctor age: ");
                    int apptDoctorAge;
                    try {
                        apptDoctorAge = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age.");
                        break;
                    }

                    System.out.print("Enter doctor specialization: ");
                    String apptSpec = scanner.nextLine();

                    System.out.print("Enter doctor salary: ");
                    double apptSalary;
                    try {
                        apptSalary = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary.");
                        break;
                    }

                    System.out.print("Enter patient name: ");
                    String apptPatientName = scanner.nextLine();

                    System.out.print("Enter patient age: ");
                    int apptPatientAge;
                    try {
                        apptPatientAge = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age.");
                        break;
                    }

                    System.out.print("Enter patient illness: ");
                    String apptIllness = scanner.nextLine();

                    System.out.print("Enter appointment date (e.g. 2025-04-01): ");
                    String apptDate = scanner.nextLine();

                    Doctor apptDoctor = new Doctor(apptDoctorName, apptDoctorAge, apptSpec, apptSalary);
                    Patient apptPatient = new Patient(apptPatientName, apptPatientAge, apptIllness);
                    hospital.addAppointment(new Appointment(apptDoctor, apptPatient, apptDate));
                    break;

                case 4:
                    hospital.listAllDoctors();
                    break;

                case 5:
                    hospital.listAllPatients();
                    break;

                case 6:
                    hospital.listAllAppointments();
                    break;

                case 7:
                    hospital.saveDataToFiles();
                    break;

                case 8:
                    System.out.println("Total patients admitted: " + Hospital.getTotalPatients());
                    break;

                case 9:
                    System.out.print("Save data before exiting? (yes/no): ");
                    String saveChoice = scanner.nextLine().trim().toLowerCase();
                    if (saveChoice.equals("yes") || saveChoice.equals("y")) {
                        hospital.saveDataToFiles();
                    }
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
