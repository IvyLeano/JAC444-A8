import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Countries {
Map<String, String> m_map = new HashMap<>();

//				25 COUNTRIES AND THEIR CAPITALS, NUMBERED IN ALPHABETICAL ORDER	
public void initialize(){
	m_map.put("AFGHANISTAN", "KABUL");
	m_map.put("ARGENTINA", "BUENOS AIRES");
	m_map.put("AUSTRALIA", "CANBERRA");
	m_map.put("AUSTRIA", "VIENNA");
	m_map.put("BANGLADESH", "DHAKA");
	m_map.put("BELGIUM", "BRUSSELS" );
	m_map.put("CANADA", "OTTAWA");
	m_map.put("CHILE", "SANTIAGO");
	m_map.put("CHINA", "BEIJING");
	m_map.put("COSTA RICA", "SAN JOSE");
	m_map.put("CUBA", "HAVANA");
	m_map.put("ECUADOR", "QUITO");
	m_map.put("FIJI", "SUVA");
	m_map.put("FINLAND", "HELSINKI");
	m_map.put("FRANCE", "PARIS");
	m_map.put("GERMANY", "BERLIN");
	m_map.put("GREECE", "ATHENS");
	m_map.put("INDIA", "NEW DELHI");
	m_map.put("ITALY", "ROME");
	m_map.put("JAPAN", "TOKYO");
	m_map.put("PERU", "LIMA");
	m_map.put("PHILIPPINES", "MANILA");
	m_map.put("POLAND", "WARSAW");
	m_map.put("QATAR", "DOHA");
	m_map.put("VIETNAM", "HANOI");
}	
	
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
	@SuppressWarnings("unlikely-arg-type")
	String getCapital(String country) {
		String capital = country.toUpperCase() + " is currently not listed on the map.\n\n";
		
		if(m_map.containsKey(country.toUpperCase())) {
			capital = "The capital of " + country.toUpperCase() + " is " + m_map.get(country.toUpperCase()) + "\n\n";
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
