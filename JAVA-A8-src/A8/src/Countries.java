import java.util.Scanner;

public class Countries {
	String[][] m_map = 
		{ 
//				25 COUNTRIES AND THEIR CAPITALS, NUMBERED IN ALPHABETICAL ORDER
				{"1", "AFGHANISTAN", "KABUL" }, 
				{"2", "ARGENTINA", "BUENOS AIRES" }, 
				{"3", "AUSTRALIA", "CANBERRA" }, 
				{"4", "AUSTRIA", "VIENNA" }, 
				{"5", "BANGLADESH", "DHAKA" }, 
				{"6", "BELGIUM", "BRUSSELS" }, 
				{"7", "CANADA", "OTTAWA" }, 
				{"8", "CHILE", "SANTIAGO" }, 
				{"9", "CHINA", "BEIJING" }, 
				{"10", "COSTA RICA", "SAN JOSE" }, 
				{"11", "CUBA", "HAVANA" }, 
				{"12", "ECUADOR", "QUITO" }, 
				{"13", "FIJI", "SUVA" }, 
				{"14", "FINLAND", "HELSINKI"}, 
				{"15", "FRANCE", "PARIS" }, 
				{"16", "GERMANY", "BERLIN" }, 
				{"17", "GREECE", "ATHENS" }, 
				{"18", "INDIA", "NEW DELHI" }, 
				{"19", "ITALY", "ROME" }, 
				{"20", "JAPAN", "TOKYO" }, 
				{"21", "PERU", "LIMA" }, 
				{"22", "PHILIPPINES", "MANILA" }, 
				{"23", "POLAND", "WARSAW" }, 
				{"24", "QATAR", "DOHA" }, 
				{"25", "VIETNAM", "HANOI" } 		
		};
	
	
//Prompts user to input country, validates input
	@SuppressWarnings("resource")
	void promptCountry() {
		boolean invalidInput = true;

		while (invalidInput == true) {
			Scanner input = new Scanner(System.in);
			String country = "\0";
			try {
				System.out.print("\nEnter a Country: ");
				input = new Scanner(System.in);

				country = input.next();

				if (country.chars().allMatch(Character::isLetter)) {

					System.out.print(getCapital(country));
					if (!searchAgain()) {
						invalidInput = false;
					}

				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Invalid input.\n\n");
			}
		}

	}

	// searches for the country in the list and returns the capital if the country
	// is listed
	String getCapital(String country) {
		String capital = country + " is currently not listed on the map.\n\n";
		search: for (int i = 0; i < 25; i++) {
			if (m_map[i][1].equalsIgnoreCase(country.toUpperCase())) {
				capital = "The capital of " + country + " is " + m_map[i][2] + "\n\n";
				break search;
			}
		}
		return capital;
	}
// prompts user to search again, validates input
	boolean searchAgain() {
		boolean search = false;
		boolean invalidInput = true;

		while (invalidInput == true) {
			String yes_no;
			try {
				System.out.print("Would you like to try again (Y/N): ");
				Scanner input = new Scanner(System.in);
				yes_no = input.next();

				if (yes_no.chars().allMatch(Character::isLetter) && yes_no.length() == 1) {
					if (yes_no.equalsIgnoreCase("Y")) {
						search = true;
						invalidInput = false;
					} else if (yes_no.equalsIgnoreCase("N")) {
						System.out.print("GoodBye!\n\n");
						search = false;
						invalidInput = false;
					} else {
						System.out.print("Invalid input.\n\n");
					}
				}

				else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.print("Invalid input.\n\n");
			}
		}

		return search;
	}

}
