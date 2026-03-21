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

    public void displayAppointmentDetails() {
        System.out.println("Appointment Details:");
        doctor.displayrole();
        patient.displayrole();
        System.out.println("Date: " + date);
    }
    
}
