package hospital_managemnet_system;

import java.util.Scanner;

public class HospitalManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Patient patient = new Patient();
    private static Doctor doctor = new Doctor();
    private static Appointment appointment = new Appointment();
    private static int patientCounter = 1;
    private static int doctorCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("**------------BLESSING HOSPITAL MANAGEMENT SYSTEM---------------** ");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Add Doctor"); 
            System.out.println("5. Book Appointment");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    patient.viewPatients();
                    break;
                case 3:
                    doctor.viewDoctors();
                    break;
                case 4:
                    addDoctor();  // Add doctor functionality
                    break;
                case 5:
                    bookAppointment();
                    break;
                case 6:
                    System.out.println("THANK YOU FOR USING BLESSING HOSPITAL MANAGEMENT SYSTEM!");
                    return;
                default:
                    System.out.println("Enter valid choice! ");
                    break;
            }
        }
    }

    // Add Patient
    private static void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        int age = -1;
        while (age < 0) {
            System.out.print("Enter Patient Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Age cannot be negative. Please enter a valid age.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number for age.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }

        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();

        patient.addPatient(patientCounter++, name, age, gender);
    }

    // Add Doctor
    private static void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();
        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.next();

        doctor.addDoctor(doctorCounter++, name, specialization);
    }

    // Book Appointment
    private static void bookAppointment() {
        System.out.print("Enter Patient Id: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor Id: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();

        if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId)) {
            if (appointment.checkDoctorAvailability(doctorId, appointmentDate)) {
                appointment.bookAppointment(patientId, doctorId, appointmentDate);
            } else {
                System.out.println("Doctor is not available on this date.");
            }
        } else {
            System.out.println("Either Patient or Doctor does not exist.");
        }
    }
}
