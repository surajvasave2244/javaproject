package hospital_managemnet_system;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private List<DoctorRecord> doctors;

    public Doctor() {
        doctors = new ArrayList<>();
    }

    // Inner class to represent a Doctor Record
    private static class DoctorRecord {
        int id;
        String name;
        String specialization;

        public DoctorRecord(int id, String name, String specialization) {
            this.id = id;
            this.name = name;
            this.specialization = specialization;
        }
    }

    // View Doctors
    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }

        System.out.println("Doctors: ");
        System.out.println("+------------+--------------------+------------------+");
        System.out.println("| Doctor Id  | Name               | Specialization   |");
        System.out.println("+------------+--------------------+------------------+");

        for (DoctorRecord doctor : doctors) {
            System.out.printf("| %-10s | %-18s | %-16s |\n", doctor.id, doctor.name, doctor.specialization);
            System.out.println("+------------+--------------------+------------------+");
        }
    }

    // Add Doctor
    public void addDoctor(int id, String name, String specialization) {
        doctors.add(new DoctorRecord(id, name, specialization));
        System.out.println("Doctor Added Successfully!");
    }

    // Get Doctor by ID
    public boolean getDoctorById(int id) {
        return doctors.stream().anyMatch(d -> d.id == id);
    }
}
