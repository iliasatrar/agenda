import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Deadline {

	static List<String> deadlines = new ArrayList<String>();

	public static void createDeadline(String task, String date, String time, Boolean finished) {
		String deadline = task + "#" + date + "#" + time + "#" + finished;
		deadlines.add(deadline);
		System.out.println("==================================");
		System.out.println("Added the deadline to your list!");
		Main.welcome();
		Main.askRequest();
	}

	public static void completeDeadline(String subject) {
		if (deadlineExists(subject) == true) {// Deadline has been found
			List<String> new_deadlines = new ArrayList<String>();

			for (String deadline : deadlines) {
				String[] parts = deadline.split("#");
				if (parts[0].equals(subject)) {
					String newparts = subject + "#" + getDate(subject) + "#" + getTime(subject) + "#" + true;
					new_deadlines.add(newparts);
				} else {
					new_deadlines.add(deadline);
				}
			}
			deadlines = new_deadlines;
			System.out.println("==================================");
			System.out.println("Changed deadlines status to finished.");
			Main.welcome();
			Main.askRequest();
			return;
		} else {
			System.out.println("==================================");
			System.out.println("You entered an not valid subject name!");
			Main.welcome();
			Main.askRequest();
			return;
		}
	}

	public static void uncompleteDeadline(String subject) {
		if (deadlineExists(subject) == true) {// Deadline has been found
			List<String> new_deadlines = new ArrayList<String>();

			for (String deadline : deadlines) {
				String[] parts = deadline.split("#");
				if (parts[0].equals(subject)) {
					String newparts = subject + "#" + getDate(subject) + "#" + getTime(subject) + "#" + false;
					new_deadlines.add(newparts);
				} else {
					new_deadlines.add(deadline);
				}
			}
			deadlines = new_deadlines;
			System.out.println("==================================");
			System.out.println("Changed deadlines status to finished.");
			Main.welcome();
			Main.askRequest();
			return;
		} else {
			System.out.println("==================================");
			System.out.println("You entered an not valid subject name!");
			Main.welcome();
			Main.askRequest();
			return;
		}
	}

	public static void checkDeadline(String subject) {
		if (deadlineExists(subject) == true) {// Deadline has been found
			for (String deadline : deadlines) {
				String[] parts = deadline.split("#");
				if (parts[0].equals(subject)) {
					if (parts[3].equals("true")) {
						System.out.println("==================================");
						System.out.println(subject + " has been finished.");
						Main.welcome();
						Main.askRequest();
						return;
					} else if (parts[3].equals("false")) {
						System.out.println("==================================");
						System.out.println(subject + " hasn't been finished.");
						Main.welcome();
						Main.askRequest();
						return;
					}
				}
			}
		} else {
			System.out.println("==================================");
			System.out.println("You entered an not valid subject name!");
			Main.welcome();
			Main.askRequest();
			return;
		}
	}

	public static void editDeadline(String subject) {
		if (deadlineExists(subject) == true) {// Deadline has been found
			System.out.println("==================================");
			System.out.println("    Subject");
			System.out.println("    Date");
			System.out.println("    Time");
			System.out.println();
			System.out.println("What would you like to change:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			in = in.toLowerCase();
			if (!in.equals("subject") && !in.equals("date") && !in.equals("time")) {
				System.out.println("==================================");
				System.out.println("You entered an not valid option!");
				Main.welcome();
				Main.askRequest();
				return;
			}
			switch (in) {
			case "subject":
				System.out.println("==================================");
				System.out.println("Whats the new subject for the deadline:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				List<String> new_deadlines = new ArrayList<String>();
				String newname = in;
				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					if (!parts[0].equals(subject)) {
						new_deadlines.add(deadline);
					}
				}
				new_deadlines.add(newname + "#" + getDate(subject) + "#" + getTime(subject) + "#" + getState(subject));
				deadlines = new_deadlines;
				System.out.println("==================================");
				System.out.println("Changed the subject of the deadline.");
				Main.welcome();
				Main.askRequest();
				return;
			case "date":
				System.out.println("==================================");
				System.out.println("Whats the new date for the deadline:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_deadlines = new ArrayList<String>();
				String newdate = in;
				for (String appointment : deadlines) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_deadlines.add(appointment);
					}
				}
				new_deadlines.add(subject + "#" + newdate + "#" + getTime(subject) + "#" + getState(subject));
				deadlines = new_deadlines;
				System.out.println("==================================");
				System.out.println("Changed the date of the deadline.");
				Main.welcome();
				Main.askRequest();
				return;
			case "time":
				System.out.println("==================================");
				System.out.println("Whats the new time for the deadline:");
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				new_deadlines = new ArrayList<String>();
				String newtime = in;
				for (String appointment : deadlines) {
					String[] parts = appointment.split("#");
					if (!parts[0].equals(subject)) {
						new_deadlines.add(appointment);
					}
				}
				new_deadlines.add(subject + "#" + getDate(subject) + "#" + newtime + "#" + getState(subject));
				deadlines = new_deadlines;
				System.out.println("==================================");
				System.out.println("Changed the time of the deadline.");
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

	public static void deleteDeadline(String subject) {
		if (deadlineExists(subject) == true) {// Deadline has been found
			System.out.println("==================================");
			System.out.println("Are you sure to delete this deadline? [Y/N]");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			in = in.toLowerCase();
			if (in.equals("y")) {
				List<String> new_deadlines = new ArrayList<String>();

				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					if (!parts[0].equals(subject)) {
						new_deadlines.add(deadline);
					}
				}
				deadlines = new_deadlines;
				System.out.println("==================================");
				System.out.println("Successfully deleted deadline: " + subject);
				Main.welcome();
				Main.askRequest();
				return;
			} else {
				Main.welcome();
				Main.askRequest();
				return;
			}
		} else {
			System.out.println("This is not an valid deadline subject!");
			askInput(3);
			return;
		}
	}

	public static String getDate(String subject) {
		for (String part : deadlines) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[1];
			}
		}
		return null;
	}

	public static String getTime(String subject) {
		for (String part : deadlines) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[2];
			}
		}
		return null;
	}

	public static String getState(String subject) {
		for (String part : deadlines) {
			String[] parts = part.split("#");
			if (parts[0].equals(subject)) {
				return parts[3];
			}
		}
		return null;
	}

	public static Boolean deadlineExists(String subject) {
		Boolean found = false;
		for (String part : deadlines) {
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
		if (i == 4) { // Add Deadline
			String task = "N/a";
			String date = "00-00-0000";
			String time = "00:00";
			System.out.println("==================================");
			System.out.println("Please enter your deadline subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid subject!");
				askInput(4);
			} else {
				task = in;
			}
			System.out.println("Please enter your deadline date (31-12-2018):");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("") || !in.contains("-")) {
				System.out.println("This is not valid date format!");
				askInput(4);
			} else {
				date = in;
			}
			System.out.println("Please enter your deadline time (23:59):");
			scanner = new Scanner(System.in);
			in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("") || !in.contains(":")) {
				System.out.println("This is not valid time format!");
				askInput(4);
			} else {
				time = in;
			}
			createDeadline(task, date, time, false);
		}
		if (i == 5) { // Edit Deadline
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your deadlines subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid subject name!");
				askInput(5);
			} else {
				subject = in;
			}
			editDeadline(subject);
		}
		if (i == 6) { // Delete Deadline
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your deadlines subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid deadline subject!");
				askInput(6);
			} else {
				subject = in;
			}
			deleteDeadline(subject);
		}
		if (i == 7) { // Complete Deadline
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your deadlines subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid deadline subject!");
				askInput(7);
			} else {
				subject = in;
			}
			completeDeadline(subject);
		}
		if (i == 8) { // Uncomplete Deadline
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your deadlines subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid deadline subject!");
				askInput(8);
			} else {
				subject = in;
			}
			uncompleteDeadline(subject);
		}
		if (i == 9) { // Check Deadline .
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please enter your deadlines subject:");
			Scanner scanner = new Scanner(System.in);
			String in = scanner.nextLine();
			if (in.equals("") || in.replace(" ", "").equals("")) {
				System.out.println("This is not an valid deadline subject!");
				askInput(9);
			} else {
				subject = in;
			}
			checkDeadline(subject);
		}
		if (i == 10) { // View Deadline
			String subject = "N/a";
			System.out.println("==================================");
			System.out.println("Please select an search type:");
			System.out.println("    [1] - Date");
			System.out.println("    [2] - Today");
			System.out.println("    [3] - Week");
			System.out.println("    [4] - This Week");
			System.out.println();
			Scanner scanner = new Scanner(System.in);
			int in = scanner.nextInt();
			if (in > 4 || in < 1) {
				System.out.println("This is not an valid search type!");
				askInput(10);
			}
			if (in == 1) { // Date (31-12-2018) - working
				System.out.println("==================================");
				System.out.println("Please enter a date. (31-12-2018)");
				scanner = new Scanner(System.in);
				String result = scanner.nextLine();

				List<String> found_deadlines = new ArrayList<String>();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date();

				try {
					date = sdf.parse(result);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				String today = sdf.format(date);
				int results = 0;
				System.out.println("==================================");
				System.out.println("Searching appointments with the date: " + today + "...");
				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					if (parts[1].contains(today)) {
						found_deadlines.add(deadline);
						results++;
					}
				}
				System.out.println("Appointments found: " + results);
				System.out.println("==================================");
				for (String search_result : found_deadlines) {
					String[] parts = search_result.split("#");
					System.out.println("Name: " + parts[0]);
					System.out.println("Deadline Time: " + parts[2]);
					System.out.println("Finished: " + parts[3]);
					System.out.println("==================================");
				}
				System.out.println();
				Main.welcome();
				Main.askRequest();
				return;

			} else if (in == 2) { // Today (null) - working
				List<String> found_deadlines = new ArrayList<String>();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date now = new Date();
				String today = sdf.format(now);
				int results = 0;
				System.out.println("==================================");
				System.out.println("Searching appointments with the date: " + today + "...");
				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					if (parts[1].contains(today)) {
						found_deadlines.add(deadline);
						results++;
					}
				}
				System.out.println("Appointments found: " + results);
				System.out.println("==================================");
				for (String search_result : found_deadlines) {
					String[] parts = search_result.split("#");
					System.out.println("Name: " + parts[0]);
					System.out.println("Deadline Time: " + parts[2]);
					System.out.println("Finished: " + parts[3]);
					System.out.println("==================================");
				}
			} else if (in == 3) { // Certain week (int)
				System.out.println("==================================");
				System.out.println("Please enter a week number.");
				scanner = new Scanner(System.in);
				int result = scanner.nextInt();

				List<LocalDate> week_dates = getWeekDates(result);

				Date begin = Date.from(week_dates.get(0).atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date end = Date.from(week_dates.get(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

				List<String> found_deadlines = new ArrayList<String>();
				int results = 0;
				System.out.println("==================================");
				System.out.println("Searching appointments in week " + result + "...");
				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					String enddate = new SimpleDateFormat("dd-MM-yyyy").format(end);
					String begindate = new SimpleDateFormat("dd-MM-yyyy").format(begin);

					String[] endparts = enddate.split("-");
					String[] beginparts = begindate.split("-");
					String[] searcparts = parts[1].split("-");

					int ey = Integer.parseInt(endparts[2]);
					int by = Integer.parseInt(beginparts[2]);
					int sy = Integer.parseInt(searcparts[2]);
					int em = Integer.parseInt(endparts[1]);
					int bm = Integer.parseInt(beginparts[1]);
					int sm = Integer.parseInt(searcparts[1]);
					int ed = Integer.parseInt(endparts[0]);
					int bd = Integer.parseInt(beginparts[0]);
					int sd = Integer.parseInt(searcparts[0]);
					if (by <= sy && bm <= sm && bd <= sd && ey >= sy && em >= sm && ed >= sd) {
						found_deadlines.add(deadline);
					}
				}
				System.out.println("Appointments found: " + results);
				System.out.println("==================================");
				for (String search_result : found_deadlines) {
					String[] parts = search_result.split("#");
					System.out.println("Name: " + parts[0]);
					System.out.println("Deadline Date: " + parts[1]);
					System.out.println("Deadline Time: " + parts[2]);
					System.out.println("Finished: " + parts[3]);
					System.out.println("==================================");
				}
				System.out.println();
				Main.welcome();
				Main.askRequest();
				return;
			} else if (in == 4) { // This week (null) - working
				Calendar cal = Calendar.getInstance();
				cal.setFirstDayOfWeek(Calendar.SUNDAY);
				int week = cal.get(Calendar.WEEK_OF_YEAR);

				List<LocalDate> week_dates = getWeekDates(week);

				Date begin = Date.from(week_dates.get(0).atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date end = Date.from(week_dates.get(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

				List<String> found_deadlines = new ArrayList<String>();
				int results = 0;
				System.out.println("==================================");
				System.out.println("Searching appointments in week " + week + "...");
				for (String deadline : deadlines) {
					String[] parts = deadline.split("#");
					String enddate = new SimpleDateFormat("dd-MM-yyyy").format(end);
					String begindate = new SimpleDateFormat("dd-MM-yyyy").format(begin);

					String[] endparts = enddate.split("-");
					String[] beginparts = begindate.split("-");
					String[] searcparts = parts[1].split("-");

					int ey = Integer.parseInt(endparts[2]);
					int by = Integer.parseInt(beginparts[2]);
					int sy = Integer.parseInt(searcparts[2]);
					int em = Integer.parseInt(endparts[1]);
					int bm = Integer.parseInt(beginparts[1]);
					int sm = Integer.parseInt(searcparts[1]);
					int ed = Integer.parseInt(endparts[0]);
					int bd = Integer.parseInt(beginparts[0]);
					int sd = Integer.parseInt(searcparts[0]);
					if (by <= sy && bm <= sm && bd <= sd && ey >= sy && em >= sm && ed >= sd) {
						found_deadlines.add(deadline);
					}
				}
				System.out.println("Appointments found: " + results);
				System.out.println("==================================");
				for (String search_result : found_deadlines) {
					String[] parts = search_result.split("#");
					System.out.println("Name: " + parts[0]);
					System.out.println("Deadline Date: " + parts[1]);
					System.out.println("Deadline Time: " + parts[2]);
					System.out.println("Finished: " + parts[3]);
					System.out.println("==================================");
				}
				System.out.println();
				Main.welcome();
				Main.askRequest();
				return;
			} else {
				System.out.println("This is not an valid search type!");
				askInput(10);
			}
		}
		if (i == 104) { // Add Deadline Automatic
			createDeadline("IDK", "23-07-2019", "12:50", false);
		}
		if (i == 105) { // Add Deadline Automatic
			createDeadline("IDK2", "07-01-2019", "15:45", false);
		}
		if (i == 106) { // Add Deadline Automatic
			System.out.println(deadlines.toString());
			Main.askRequest();
			return;
		}
		if(i == 12) {
			for (String deadline : deadlines) {
				String[] parts = deadline.split("#");
				System.out.println("==================================");
				System.out.println("Subject: " + parts[0]);
				System.out.println("Date: " + parts[1]);
				System.out.println("Time: " + parts[2]);
				System.out.println("Finished: " + parts[3]);
			}
			System.out.println();
			Main.welcome();
			Main.askRequest();
			return;
		}
	}

	public static List<LocalDate> getWeekDates(int week) {
		List<LocalDate> found_deadlines = new ArrayList<LocalDate>();
		SimpleDateFormat formatm = new SimpleDateFormat("MM");
		SimpleDateFormat formatd = new SimpleDateFormat("dd");
		SimpleDateFormat formaty = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week - 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		int year = Integer.parseInt(formaty.format(cal.getTime()));
		String months = formatm.format(cal.getTime());
		int day = Integer.parseInt(formatd.format(cal.getTime()));
		Month month = Month.JANUARY;
		switch (months) {
		case "01":
			month = Month.JANUARY;
			break;
		case "02":
			month = Month.FEBRUARY;
			break;
		case "03":
			month = Month.MARCH;
			break;
		case "04":
			month = Month.APRIL;
			break;
		case "05":
			month = Month.MAY;
			break;
		case "06":
			month = Month.JUNE;
			break;
		case "07":
			month = Month.JULY;
			break;
		case "08":
			month = Month.AUGUST;
			break;
		case "09":
			month = Month.SEPTEMBER;
			break;
		case "10":
			month = Month.OCTOBER;
			break;
		case "11":
			month = Month.NOVEMBER;
			break;
		case "12":
			month = Month.DECEMBER;
			break;
		}
		LocalDate today = LocalDate.of(year, month, day);
		LocalDate sunday = today;
		while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
			sunday = sunday.minusDays(1);
		}
		LocalDate saturday = today;
		while (saturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
			saturday = saturday.plusDays(1);
		}
		found_deadlines.add(sunday);
		found_deadlines.add(saturday);
		found_deadlines.add(today);
		return found_deadlines;
	}
}
