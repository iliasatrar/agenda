import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Apppointment {

	static List<String> appointments = new ArrayList<String>();

	public static void createAppointment(String subject, String date, String time, String location,
			String participants) {
		String appointment = subject + "#" + date + "#" + time + "#" + location + "#" + participants;
		appointments.add(appointment);
		System.out.println("==================================");
		System.out.println("Added " + subject + " to your list!");
		Main.welcome();
		Main.askRequest();
		return;
	}

	public static void deleteAppointment(String subject) {
		if (appointmentExists(subject) == true) {// Appointment has been found
			System.out.println("==================================");
			System.out.println("Are you sure to delete this subject? [Y/N]");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			in = in.toLowerCase();
			if (in.equals("y")) {
				List<String> new_appointments = new ArrayList<String>();
				
				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if(!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				appointments = new_appointments;
				System.out.println("==================================");
				System.out.println("Successfully deleted appointment: " + subject);
				Main.welcome();
				Main.askRequest();
				return;
			} else {
				Main.welcome();
				Main.askRequest();
				return;
			}
		} else {
			System.out.println("This is not an valid subject name!");
			askInput(3);
			return;
		}
	}

	public static void editAppointment(String subject) {
		if (appointmentExists(subject) == true) {// Appointment has been found
			System.out.println("==================================");
			System.out.println("    Subject");
			System.out.println("    Date");
			System.out.println("    Time");
			System.out.println("    Location");
			System.out.println("    Participants");
			System.out.println();
			System.out.println("What would you like to change:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			in = in.toLowerCase();
			if (!in.equals("subject") && !in.equals("date") && !in.equals("time") && !in.equals("location")
					&& !in.equals("participants")) {
				System.out.println("==================================");
				System.out.println("You entered an not valid option!");
				Main.welcome();
				Main.askRequest();
				return;
			}
			switch (in) {
			case "subject":
				System.out.println("==================================");
				System.out.println("Whats the new name for the subject:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				List<String> new_appointments = new ArrayList<String>();
				String newname = in;
				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				new_appointments.add(newname + "#" + getDate(subject) + "#" + getTime(subject) + "#"
						+ getLocation(subject) + "#" + getParticipants(subject));
				appointments = new_appointments;
				System.out.println("==================================");
				System.out.println("Changed the subject of the appointment.");
				Main.welcome();
				Main.askRequest();
				return;
			case "date":
				System.out.println("==================================");
				System.out.println("Whats the new date for the subject:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_appointments = new ArrayList<String>();
				String newdate = in;
				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				new_appointments.add(subject + "#" + newdate + "#" + getTime(subject) + "#" + getLocation(subject) + "#"
						+ getParticipants(subject));
				appointments = new_appointments;
				System.out.println("==================================");
				System.out.println("Changed the date of the appointment.");
				Main.welcome();
				Main.askRequest();
				return;
			case "time":
				System.out.println("==================================");
				System.out.println("Whats the new time for the subject:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_appointments = new ArrayList<String>();
				String newtime = in;
				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				new_appointments.add(subject + "#" + getDate(subject) + "#" + newtime + "#" + getLocation(subject) + "#"
						+ getParticipants(subject));
				appointments = new_appointments;
				System.out.println("==================================");
				System.out.println("Changed the time of the appointment.");
				Main.welcome();
				Main.askRequest();
				return;
			case "location":
				System.out.println("==================================");
				System.out.println("Whats the new location for the subject:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_appointments = new ArrayList<String>();
				String newlocation = in;
				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				new_appointments.add(subject + "#" + getDate(subject) + "#" + getTime(subject) + "#" + newlocation + "#"
						+ getParticipants(subject));
				appointments = new_appointments;
				System.out.println("==================================");
				System.out.println("Changed the location of the appointment.");
				Main.welcome();
				Main.askRequest();
				return;
			case "participants":
				System.out.println("==================================");
				System.out.println("Whats are the new participants for the subject:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_appointments = new ArrayList<String>();
				String newparticipants = in;

				for (String appointment : appointments) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_appointments.add(appointment);
					}
				}
				new_appointments.add(subject + "#" + getDate(subject) + "#" + getTime(subject) + "#"
						+ getLocation(subject) + "#" + newparticipants);
				appointments = new_appointments;

				System.out.println("==================================");
				System.out.println("Changed the participants of the appointment.");
				Main.welcome();
				Main.askRequest();
				return;
			}

		} else {
			System.out.println("==================================");
			System.out.println("You entered an not valid subject name!");
			Main.welcome();
			Main.askRequest();
			return;
		}
	}

	public static String getDate(String subject) {
		for (String part : appointments) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[1];
			}
		}
		return null;
	}

	public static String getTime(String subject) {
		for (String part : appointments) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[2];
			}
		}
		return null;
	}

	public static String getLocation(String subject) {
		for (String part : appointments) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[3];
			}
		}
		return null;
	}

	public static String getParticipants(String subject) {
		for (String part : appointments) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[4];
			}
		}
		return null;
	}

	public static Boolean appointmentExists(String subject) {
		Boolean found = false;
		for (String part : appointments) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				found = true;
			}
		}
		if (found == true) {
			return true;
		} else {
			return false;
		}
	}

	public static void askInput(int i) {
		if (i == 1) { // Add Appointment
			String subject = "N/a";
			String date = "00-00-0000";
			String time = "00:00";
			String location = "Unknown";
			String participants = "";
			System.out.println("==================================");
			System.out.println("Please enter your appointment subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid subject name!");
				askInput(1);
				return;
			} else {
				subject = in;
			}
			System.out.println("Please enter your appointment date (31-12-2018):");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("") || !in.contains("-")) {
				System.out.println("This is not valid date format!");
				askInput(1);
				return;
			} else {
				date = in;
			}
			System.out.println("Please enter your appointment time (23:59):");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("") || !in.contains(":")) {
				System.out.println("This is not valid time format!");
				askInput(1);
				return;
			} else {
				time = in;
			}
			System.out.println("Please enter your appointment location:");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid location!");
				askInput(1);
				return;
			} else {
				location = in;
			}
			System.out.println("Please enter your appointment participants (John Doe, Jane Doe):");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("These are not valid participants!");
				askInput(1);
				return;
			} else {
				participants = in;
			}
			createAppointment(subject, date, time, location, participants);
		}
		if (i == 2) { // Edit Appointment
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your appointment subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid subject name!");
				askInput(2);
			} else {
				subject = in;
			}
			editAppointment(subject);
		}
		if (i == 3) { // Delete Appointment
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your appointment subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid subject name!");
				askInput(3);
			} else {
				subject = in;
			}
			deleteAppointment(subject);
		}
		if(i == 11) {
			for (String appointment : appointments) {
				String[] parts = appointment.split("#");
				System.out.println("==================================");
				System.out.println("Subject: " + parts[0]);
				System.out.println("Date: " + parts[1]);
				System.out.println("Time: " + parts[2]);
				System.out.println("Location: " + parts[3]);
				System.out.println("Participants: " + parts[4]);
			}
			System.out.println();
			Main.welcome();
			Main.askRequest();
			return;
		}
		if (i == 101) { // Add Appointment Automatic
			createAppointment("Test", "23-07-2019", "15:00", "Velserbroek", "John Doe, Jane Doe");
			Deadline.createDeadline("IDK", "23-07-2019", "12:45", false);
		}
		if (i == 102) { // Add Appointment Automatic
			createAppointment("Test2", "23-08-2019", "16:00", "Driehuis", "John Oed, Jane Oed");
			Deadline.createDeadline("IDK2", "23-07-2020", "15:45", false);
		}
		if (i == 103) { // Add Appointment Automatic
			System.out.println(appointments.toString());
			Main.askRequest();
			return;
		}
	}
}
