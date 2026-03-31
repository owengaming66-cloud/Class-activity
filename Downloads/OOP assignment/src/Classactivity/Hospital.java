package Classactivity;

import java.util.ArrayList;
import java.io.*;

public class Hospital {
    private String hospitalName;
    private static int totalPatients = 0;

    // Collections to store multiple objects
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    private static final String DOCTORS_FILE = "doctors.txt";
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String APPOINTMENTS_FILE = "appointments.txt";

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    // --- Collections Methods ---

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getName() + " added.");
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
        totalPatients++;
        System.out.println("Patient " + patient.getName() + " admitted.");
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added for " + appointment.getPatient().getName());
    }

    public void listAllDoctors() {
        System.out.println("\n--- Doctors at " + hospitalName + " ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors on record.");
        } else {
            for (Doctor d : doctors) {
                d.displayrole();
            }
        }
    }

    public void listAllPatients() {
        System.out.println("\n--- Patients at " + hospitalName + " ---");
        if (patients.isEmpty()) {
            System.out.println("No patients on record.");
        } else {
            for (Patient p : patients) {
                p.displayrole();
            }
        }
    }

    public void listAllAppointments() {
        System.out.println("\n--- Appointments at " + hospitalName + " ---");
        if (appointments.isEmpty()) {
            System.out.println("No appointments on record.");
        } else {
            for (Appointment a : appointments) {
                a.displayAppointmentDetails();
                System.out.println("----");
            }
        }
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    // --- File Saving Methods ---

    public void saveDataToFiles() {
        saveDoctors();
        savePatients();
        saveAppointments();
        System.out.println("\nAll data saved to files successfully.");
    }

    private void saveDoctors() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTORS_FILE))) {
            for (Doctor d : doctors) {
                writer.write(d.toFileString());
                writer.newLine();
            }
            System.out.println("Doctors saved to " + DOCTORS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving doctors: " + e.getMessage());
        }
    }

    private void savePatients() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            for (Patient p : patients) {
                writer.write(p.toFileString());
                writer.newLine();
            }
            System.out.println("Patients saved to " + PATIENTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }

    private void saveAppointments() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENTS_FILE))) {
            for (Appointment a : appointments) {
                writer.write(a.toFileString());
                writer.newLine();
            }
            System.out.println("Appointments saved to " + APPOINTMENTS_FILE);
        } catch (IOException e) {
            System.out.println("Error saving appointments: " + e.getMessage());
        }
    }

    // --- File Loading Methods ---

    public void loadDataFromFiles() {
        loadDoctors();
        loadPatients();
        loadAppointments();
        System.out.println("\nAll data loaded from files successfully.");
    }

    private void loadDoctors() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTORS_FILE))) {
            doctors.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    doctors.add(Doctor.fromFileString(line));
                }
            }
            System.out.println("Doctors loaded from " + DOCTORS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("No doctors file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }
    }

    private void loadPatients() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            patients.clear();
            totalPatients = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    patients.add(Patient.fromFileString(line));
                    totalPatients++;
                }
            }
            System.out.println("Patients loaded from " + PATIENTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("No patients file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading patients: " + e.getMessage());
        }
    }

    private void loadAppointments() {
        try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
            appointments.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    appointments.add(Appointment.fromFileString(line));
                }
            }
            System.out.println("Appointments loaded from " + APPOINTMENTS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("No appointments file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading appointments: " + e.getMessage());
        }
    }
}