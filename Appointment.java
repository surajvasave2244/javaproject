package hospital_managemnet_system;


	import java.util.ArrayList;
	import java.util.List;

	public class Appointment {
	    private List<AppointmentRecord> appointments;

	    public Appointment() {
	        appointments = new ArrayList<>();
	    }

	    // Inner class to represent an Appointment Record
	    private static class AppointmentRecord {
	        int patientId;
	        int doctorId;
	        String appointmentDate;

	        public AppointmentRecord(int patientId, int doctorId, String appointmentDate) {
	            this.patientId = patientId;
	            this.doctorId = doctorId;
	            this.appointmentDate = appointmentDate;
	        }
	    }

	    // Book an Appointment
	    public void bookAppointment(int patientId, int doctorId, String appointmentDate) {
	        appointments.add(new AppointmentRecord(patientId, doctorId, appointmentDate));
	        System.out.println("Appointment Booked!");
	    }

	    // Check Doctor Availability
	    public boolean checkDoctorAvailability(int doctorId, String appointmentDate) {
	        for (AppointmentRecord appointment : appointments) {
	            if (appointment.doctorId == doctorId && appointment.appointmentDate.equals(appointmentDate)) {
	                return false; // Doctor is already booked for that date
	            }
	        }
	        return true; // Doctor is available
	    }
	}


