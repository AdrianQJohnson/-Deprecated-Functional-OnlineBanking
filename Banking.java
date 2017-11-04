import java.math.BigInteger;
import java.time.Year;
import java.util.*;

/*
 * @author: Adrian Johnson
 * @version: 10/27/17
 * Description: Thorough banking app
 * for (int i = 0; i < acctInfo.length; i++)
		System.out.println(acctInfo[i]);		
 */

public class Banking {

	public static void main(String[] args) {
		Scanner menuChoice = new Scanner(System.in);
		int mainMenuChoice = -1, accounts = 0, temp = 0;
		String[][] acctInfo = new String[accounts + 1][40];

		System.out.println("Welcome to 49er Financial.");

		do {
			do {
				try {
					menuChoice = new Scanner(System.in);
					temp = 0;
					displayMainMenu(accounts);
					mainMenuChoice = menuChoice.nextInt();
				} catch (RuntimeException e) {
					System.out.println("Error: Invalid Input - Enter Proper Format");
					temp = 1;
				}
			} while (temp == 1);

			switch (mainMenuChoice) {

			case 1:
				acctInfo = openAccount(acctInfo, accounts);
				accounts = Integer.parseInt(acctInfo[accounts][39]);
				break;
			case 2:
				viewAccount(acctInfo, accounts);
				break;
			case 3:
				transfer(acctInfo, accounts);
				break;
			case 4:
				closeAccount(acctInfo, accounts);
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("Error: Invalid Input - Enter Proper Format");
			}

		} while (mainMenuChoice != 4);
	}

	public static void displayMainMenu(int accounts) {

		if (accounts > 0)
		System.out.print(
				"\nWould you like to:\n\t1) Open An Account\n\t2) View Your Account\n\t3) Transfer Money\n\t4) Close Your Account\n\t5) Exit Application\nChoice: ");
		else
			System.out.print("\nWould you like to:\n\t1) Open An Account\n\t5) Exit Application\nChoice: ");
	}

	public static String[][] openAccount(String[][] acctInfo, int accounts) {
		Scanner info = new Scanner(System.in);
		String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
				"KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
				"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
				"WY" };
		String dob, ssn, adDate, phone, email, confirmEmail, idIssue, idExp, signature;
		int employmentMenuChoice, idMenuChoice, extMenuChoice, temp = 0;

		/*
		 * // Prompt user for First Name System.out.
		 * print("\nFill Out The Following Information:\n\nPersonal Information:\n\tFirst Name:\t"
		 * ); acctInfo[accounts][0] = info.nextLine().trim(); info = new
		 * Scanner(System.in);
		 * 
		 * // Prompt user for Middle Name System.out.print("\tMiddle Name:\t");
		 * acctInfo[accounts][1] = info.nextLine().trim(); info = new
		 * Scanner(System.in);
		 * 
		 * // Prompt user for Last Name System.out.print("\tLast Name:\t");
		 * acctInfo[accounts][2] = info.nextLine().trim(); info = new
		 * Scanner(System.in);
		 * 
		 * // Prompt user for address
		 * System.out.print("\nWhere Do You Live?\n\tStreet Address:\t");
		 * acctInfo[accounts][3] = info.nextLine().trim(); info = new
		 * Scanner(System.in);
		 * 
		 * System.out.print("\tApt/Suite:\t"); acctInfo[accounts][4] =
		 * info.nextLine(); info = new Scanner(System.in);
		 * 
		 * do { System.out.print("\tCity, St, ZIP:\t"); acctInfo[accounts][5] =
		 * info.next(); acctInfo[accounts][5] =
		 * acctInfo[accounts][5].substring(0, acctInfo[accounts][5].length() -
		 * 1); acctInfo[accounts][6] = info.next(); acctInfo[accounts][6] =
		 * acctInfo[accounts][6].substring(0, acctInfo[accounts][6].length() -
		 * 1); for (int i = 0; i < 50; i++) { if
		 * (states[i].equals(acctInfo[accounts][6])) { temp = 0; break; } else
		 * if (i == 49) {
		 * System.out.println("Error: Invalid Input - Enter Abbreviation"); temp
		 * = 1; } } acctInfo[accounts][7] = info.next(); if
		 * (acctInfo[accounts][7].length() != 5) {
		 * System.out.println("Error: Invalid Input - Enter 5 Digit Zip Code");
		 * temp = 1; } else temp = 0;
		 * 
		 * } while (temp == 1);
		 * 
		 * info = new Scanner(System.in);
		 * 
		 * do { try { temp = 0;
		 * System.out.print("\tAt This Address Since\n\t(mm/yyyy):\t"); adDate =
		 * info.nextLine(); acctInfo[accounts][8] =
		 * Integer.toString(Integer.parseInt(adDate.substring(0,
		 * adDate.indexOf("/")))); acctInfo[accounts][9] =
		 * Integer.toString(Integer.parseInt(adDate.substring(adDate.indexOf(
		 * "/") + 1)));
		 * 
		 * if (Integer.parseInt(acctInfo[accounts][8]) < 10 &&
		 * Integer.parseInt(acctInfo[accounts][8]) > 0) acctInfo[accounts][8] =
		 * "0" + acctInfo[accounts][8];
		 * 
		 * if (acctInfo[accounts][8].length() != 2 ||
		 * Integer.parseInt(acctInfo[accounts][8]) > 12 ||
		 * acctInfo[accounts][8].length() < 1 || acctInfo[accounts][9].length()
		 * != 4 || Integer.parseInt(acctInfo[accounts][9]) >
		 * Year.now().getValue()){ temp = 1;
		 * System.out.println("Error: Invalid Input - Enter Proper Format"); } }
		 * catch (RuntimeException e) {
		 * System.out.println("Error: Invalid Input - Enter Proper Format");
		 * temp = 1; info = new Scanner(System.in); }
		 * 
		 * } while (temp == 1);
		 */
		info = new Scanner(System.in);

		// Prompt user for Phone Number
		do {
			System.out.print("\nHow Should We Contact You?\n\tPhone (###)###-####:\t");
			phone = info.nextLine().trim();

			acctInfo[accounts][10] = phone.substring(phone.indexOf("("), phone.indexOf(")"));
			acctInfo[accounts][11] = phone.substring(phone.indexOf(")") + 1, phone.indexOf("-"));
			acctInfo[accounts][12] = phone.substring(phone.indexOf("-") + 1);

			if (phone.length() != 13)
				System.out.println("Error: Invalid Input - Enter Proper Format");
		} while (temp == 1);

		// Prompt user for email
		do {
			System.out.print("\tEmail:\t\t");
			email = info.nextLine().trim();
			System.out.print("\tConfirm Email:\t");
			confirmEmail = info.nextLine().trim();
			acctInfo[accounts][13] = email;

			if (email.equalsIgnoreCase(confirmEmail) == false)
				System.out.println("Error: Emails Do Not Match");
		} while (email.equalsIgnoreCase(confirmEmail) == false);

		// Prompt user for dob and check input
		do {
			info = new Scanner(System.in);
			System.out.print("\nHow Can We Identify You?\n\tDate of Birth (mm/dd/yyyy):\t");
			dob = info.nextLine().trim();
			acctInfo[accounts][14] = dob.substring(0, 2);
			acctInfo[accounts][15] = dob.substring(3, 5);
			acctInfo[accounts][16] = dob.substring(6);

			if (dob.length() != 10)
				System.out.println("Error: Invalid Input");
		} while (dob.length() != 10);

		// Prompt user for ssn and check input
		do {
			info = new Scanner(System.in);
			System.out.print("\tSocial Security Number (XXX-XX-XXXX):\t");
			ssn = info.nextLine().trim();
			acctInfo[accounts][17] = ssn.substring(0, 3);
			acctInfo[accounts][18] = ssn.substring(4, 6);
			acctInfo[accounts][19] = ssn.substring(7);

			if (ssn.length() != 11)
				System.out.println("Error: Invalid Input");
		} while (ssn.length() != 11);

		// Prompt user for Employment Status
		do {
			info = new Scanner(System.in);
			System.out.print(
					"\tEmployment Status:\n\t\t1) Employed\n\t\t2) Self-Employed/Owner/Partner\n\t\t3) Retired\n\t\t4) Homemaker\n\t\t5) Student\n\t\t6) Military\n\t\t7) Not Employed\n\tChoice:\t");
			employmentMenuChoice = info.nextInt();

			switch (employmentMenuChoice) {

			case 1:
				acctInfo[accounts][20] = "Employed";
				break;
			case 2:
				acctInfo[accounts][20] = "Self-Employed/Owner/Partner";
				break;
			case 3:
				acctInfo[accounts][20] = "Retired";
				break;
			case 4:
				acctInfo[accounts][20] = "Homemaker";
				break;
			case 5:
				acctInfo[accounts][20] = "Student";
				break;
			case 6:
				acctInfo[accounts][20] = "Military";
				break;
			case 7:
				acctInfo[accounts][20] = "Not Employed";
				break;
			default:
				System.out.println("Error: Invalid Input");
			}

		} while (employmentMenuChoice > 7 || employmentMenuChoice < 1);

		// Prompt if US Citizen
		do {
			info = new Scanner(System.in);
			System.out.print("\tAre You A U.S. Citizen? (Y/N)\t");
			acctInfo[accounts][21] = info.next().toLowerCase().trim();

			if (acctInfo[accounts][21].equalsIgnoreCase("y") == false
					&& acctInfo[accounts][21].equalsIgnoreCase("n") == false)
				System.out.println("Error: Invalid Input");
		} while (acctInfo[accounts][21].equalsIgnoreCase("y") == false
				&& acctInfo[accounts][21].equalsIgnoreCase("n") == false);

		// Prompt for ID Type
		do {
			info = new Scanner(System.in);
			System.out.print(
					"\tIdentification Type:\n\t\t1) Driver's License\n\t\t2) State Special ID\n\t\t3) U.S. Military ID\n\t\t4) U.S. Passport\n\tChoice:\t");
			idMenuChoice = info.nextInt();

			switch (idMenuChoice) {

			case 1:
				acctInfo[accounts][22] = "Driver's License";
				break;
			case 2:
				acctInfo[accounts][22] = "State Special ID";
				break;
			case 3:
				acctInfo[accounts][22] = "U.S. Military ID";
				break;
			case 4:
				acctInfo[accounts][22] = "U.S. Passport";
				break;
			default:
				System.out.println("Error: Invalid Input");

			}

		} while (idMenuChoice < 1 || idMenuChoice > 4);

		// Prompt for ID Number
		info = new Scanner(System.in);
		System.out.print("\tIdentification Number:\t");
		acctInfo[accounts][23] = info.nextLine().trim();
		info = new Scanner(System.in);

		// Prompt user for ID Issue Date
		System.out.print("\tIssue Date (mm/dd/yyyy):\t");
		idIssue = info.nextLine().trim();
		acctInfo[accounts][24] = idIssue.substring(0, 2);
		acctInfo[accounts][25] = idIssue.substring(3, 5);
		acctInfo[accounts][26] = idIssue.substring(6);
		info = new Scanner(System.in);

		// Prompt user for ID Expiration date
		System.out.print("\tExpiration Date (mm/dd/yyyy):\t");
		idExp = info.nextLine().trim();
		acctInfo[accounts][27] = idExp.substring(0, 2);
		acctInfo[accounts][28] = idExp.substring(3, 5);
		acctInfo[accounts][29] = idExp.substring(6);
		info = new Scanner(System.in);

		// Prompt user for External Account transfer
		System.out.print("\nOpening Deposit Transfer\n\tAccount Holder:\t");
		acctInfo[accounts][30] = info.nextLine().trim();
		info = new Scanner(System.in);

		do {
			System.out.print("\tAcount Type:\n\t\t1) Checking\n\t\t2) Savings\n\tChoice:\t");
			extMenuChoice = info.nextInt();
			info = new Scanner(System.in);

			switch (extMenuChoice) {

			case 1:
				acctInfo[accounts][31] = "Checking";
				break;
			case 2:
				acctInfo[accounts][31] = "Savings";
				break;
			default:
				System.out.println("Error: Invalid Input");
			}
		} while (extMenuChoice != 1 && extMenuChoice != 2);

		System.out.print("\tAccount Number:\t");
		acctInfo[accounts][32] = info.next().trim();
		info = new Scanner(System.in);

		System.out.print("\tRouting Number:\t");
		acctInfo[accounts][33] = info.next().trim();
		info = new Scanner(System.in);

		System.out.print("\tAmount:\t$");
		acctInfo[accounts][34] = Double.toString(info.nextDouble());
		info = new Scanner(System.in);

		System.out.print("\tMemo:\t");
		acctInfo[accounts][35] = info.nextLine();
		info = new Scanner(System.in);

		// Signature to Agree to Terms and finish
		do {
			System.out.print(
					"\n\nTerms and Conditions...\n\nType Your Full Name To Agree to the Terms and Conditions and to Open Your Account:\n\t");
			signature = info.nextLine();
			info = new Scanner(System.in);

			if (signature.equalsIgnoreCase(
					acctInfo[accounts][0] + " " + acctInfo[accounts][1] + " " + acctInfo[accounts][2]) == false)
				System.out.println("Error: Invalid Input");
			else
				acctInfo[accounts][36] = signature;
		} while (signature.equalsIgnoreCase(
				acctInfo[accounts][0] + " " + acctInfo[accounts][1] + " " + acctInfo[accounts][2]) == false);

		// Notify of Account opened
		System.out.println("\nAccount Successfully Opened\n\nReturning To Main Menu...");

		// Routing Number
		acctInfo[accounts][37] = "053103331";
		// Account Number
		acctInfo[accounts][38] = String.format("%12.0f", (Math.random() * 899999999999f + 100000000000f));

		// Increment amounts
		acctInfo[accounts][39] = Integer.toString(accounts + 1);

		// Wait to return to main screen
		try {
			Thread.sleep(2000);
			;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Enter Spacers in console
		for (int i = 0; i < 5; i++)
			System.out.println("");

		// Return Array
		return acctInfo;
	}

	public static void viewAccount(String[][] acctInfo, int accounts) {

		System.out.println(acctInfo[0][38]);

	}

	public static void transfer(String[][] acctInfo, int accounts) {

	}

	public static String[][] closeAccount(String[][] acctInfo, int accounts) {
		Scanner close = new Scanner(System.in);
		String signature = null;
		int temp;

		// Check if there are any open accounts
		if (accounts < 1)
			System.out.println("\nYou Do Not Currently Hold An Account With 49er Financial.");
		else {
			// Get account number to close
			System.out.print("\nTo Close Your Account, Enter The Last Four Digits of Your Account Number:\n\t");
			temp = close.nextInt();

			// Check opened accounts for account number
			for (int i = 0; i < accounts; i++) {
				if (acctInfo[i][38].substring(8).equals(temp)) {
					// Get signature to close account
					System.out.print("Enter E-Signature To Close Account:\n\t");
					signature = close.nextLine().trim();

					// Check if the signature is correct
					if (signature.equalsIgnoreCase(acctInfo[i][36])) {
						System.out.println("Thank You For Your Business, We Are Sad To See You Go.");

						// Clear account array
						for (int j = 0; j < acctInfo.length; j++)
							acctInfo[i][j] = null;

					} else
						System.out.println("Your Account Was Not Closed");
				}
			}
			// If the account number does not exist
			if (signature.isEmpty())
				System.out.println("The Specified Account Does Not Exist");
		}

		// Enter Spacers in console
		for (int i = 0; i < 5; i++)
			System.out.println("");

		// Return array[][]
		return acctInfo;

	}

	public static void exit() {

		System.out.println("\nThank You For Choosing 49er Financial.\nHave A Great Day!");
		System.exit(0);

	}

}
