package hospital_managemnet_system;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private List<PatientRecord> patients;

    public Patient() {
        patients = new ArrayList<>();
    }

    // Inner class to represent a Patient Record
    private static class PatientRecord {
        int id;
        String name;
        int age;
        String gender;

        public PatientRecord(int id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }

    // Add Patient
    public void addPatient(int id, String name, int age, String gender) {
        patients.add(new PatientRecord(id, name, age, gender));
        System.out.println("Patient Added Successfully!");
    }

    // View Patients
    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        System.out.println("Patients: ");
        System.out.println("+------------+--------------------+----------+------------+");
        System.out.println("| Patient Id | Name               | Age      | Gender     |");
        System.out.println("+------------+--------------------+----------+------------+");

        for (PatientRecord patient : patients) {
            System.out.printf("| %-10s | %-18s | %-8s | %-10s |\n", patient.id, patient.name, patient.age, patient.gender);
            System.out.println("+------------+--------------------+----------+------------+");
        }
    }

    // Get Patient by ID
    public boolean getPatientById(int id) {
        return patients.stream().anyMatch(p -> p.id == id);
    }
}
