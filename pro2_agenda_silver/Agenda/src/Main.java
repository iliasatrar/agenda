import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		welcome();
		askRequest();
		return;
	}

	public static void welcome() {
		System.out.println("==================================");
		System.out.println("Welcome to the Agenda App.");
		System.out.println("");
		System.out.println("[1] Add Appointment");
		System.out.println("[2] Edit Appointment");
		System.out.println("[3] Delete Appointment");
		System.out.println("[4] Add Deadline");
		System.out.println("[5] Edit Deadline");
		System.out.println("[6] Delete Deadline");
		System.out.println("[7] Complete Deadline");
		System.out.println("[8] Uncomplete Deadline");
		System.out.println("[9] Check Deadline");
		System.out.println("[10] View Deadline <Today/This Week/31-12-2018/Week Number>");
		System.out.println("[11] View all appointments");
		System.out.println("[12] View all deadlines");
	}

	public static void askRequest() {
		System.out.println("==================================");
		System.out.println("Please enter your input: [1/10]");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 7 && i != 8 && i != 9 && i != 10 && i != 11
				&& i != 12 && i != 101 && i != 102 && i != 103 && i != 104 && i != 105 && i != 106) {
			welcome();
			askRequest();
			return;
		}
		switch (i) {
		case 1: // Add appointment - works
			Apppointment.askInput(i);
			break;
		case 2: // Edit appointment - works
			Apppointment.askInput(i);
			break;
		case 3: // Delete appointment - works
			Apppointment.askInput(i);
			break;
		case 4: // Add deadline - works
			Deadline.askInput(i);
			break;
		case 5: // Edit deadline - works
			Deadline.askInput(i);
			break;
		case 6: // Delete deadline - works
			Deadline.askInput(i);
			break;
		case 7: // Complete deadline - works
			Deadline.askInput(i);
			break;
		case 8: // Uncomplete deadline - works
			Deadline.askInput(i);
			break;
		case 9: // Check deadline - works
			Deadline.askInput(i);
			break;
		case 10: // view deadline - works
			Deadline.askInput(i);
			break;
		case 11: // view deadline - works
			Apppointment.askInput(i);
			break;
		case 12: // view deadline - works
			Deadline.askInput(i);
			break;

		case 101: // Debug - works
			Apppointment.askInput(i);
			break;
		case 102: // Debug - works
			Apppointment.askInput(i);
			break;
		case 103: // Debug - works
			Apppointment.askInput(i);
			break;
		case 104: // Debug - works
			Deadline.askInput(i);
			break;
		case 105: // Debug - works
			Deadline.askInput(i);
			break;
		case 106: // Debug - works
			Deadline.askInput(i);
			break;
		}
	}

}
