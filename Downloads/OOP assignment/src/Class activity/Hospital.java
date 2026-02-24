package Class activity;

public class Hospital {
    private String HospitalName;
    private static int totalPatients = 0;
    public Hospital(String hospitalName) {
        HospitalName = hospitalName;
    }
    public void admitPatient() {
        totalPatients++;
    }
    public static int getTotalPatients() {
        return totalPatients;
    }
    
}
 