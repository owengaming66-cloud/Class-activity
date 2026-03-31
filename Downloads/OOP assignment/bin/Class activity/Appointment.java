package Classactivity;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;

    public Appointment(Doctor doctor, Patient patient, String date) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public String getDate() { return date; }

    public void displayAppointmentDetails() {
        System.out.println("Appointment Details:");
        doctor.displayrole();
        patient.displayrole();
        System.out.println("Date: " + date);
    }

    // Format for saving to file
    public String toFileString() {
        return doctor.toFileString() + "|" + patient.toFileString() + "|" + date;
    }

    // Create Appointment from file string
    public static Appointment fromFileString(String line) {
        String[] parts = line.split("\\|");
        Doctor doctor = Doctor.fromFileString(parts[0]);
        Patient patient = Patient.fromFileString(parts[1]);
        return new Appointment(doctor, patient, parts[2]);
    }
}
