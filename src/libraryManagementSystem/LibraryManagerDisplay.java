package libraryManagementSystem;

import java.util.Scanner;
import java.util.Hashtable;

public class LibraryManagerDisplay {
	// This class handles the console output
	Scanner input = new Scanner(System.in); // TODO Ideally we'd close this scanner at the end of main to prevent memory leaks
	Hashtable<Integer, User> userSelection = new Hashtable<>();
	Hashtable<Integer, String> mainMenu = new Hashtable<>();
	Hashtable<Integer, Materials> materials = new Hashtable<>();
	
	LibraryManagerDisplay(User[] users, Materials[] materials){
		
		this.userSelection = setUpUserSelection(users);
		this.mainMenu = setUpMainMenu();
		this.materials = setUpMaterials(materials);

	}
	
	private Hashtable<Integer, String> setUpMainMenu() {
		
		Hashtable<Integer, String> ht = new Hashtable<>();
		
		ht.put(0, "See current loans");
		ht.put(1, "Check out materials");
		ht.put(2, "Check in materials");
		ht.put(3, "Pay fines");
		
		return ht;
		
	}
	
	private Hashtable<Integer, User> setUpUserSelection(User[] users) {
		Hashtable<Integer, User> ht = new Hashtable<>();
		for(int i = 0; i < users.length; i++) {
			User u = users[i];
			ht.put(i, u);
		}
		
		return ht;
	}
	
	private Hashtable<Integer, Materials> setUpMaterials(Materials[] materials) {
		Hashtable<Integer, Materials> ht = new Hashtable<>();
		for(int i = 0; i < materials.length; i++) {
			Materials m = materials[i];
			ht.put(i, m);
		}
		
		return ht;
	}

	public int getUserInput(){
		
		int selection;
		selection = input.nextInt();
        System.out.println("");
        return selection;
        
        // TODO add a way to exit
		
	}
	
	public User displayUserSelection() {
		
		System.out.println("Pick your user: ");
		for(int i = 0; i < userSelection.size(); i++) {
			User u = userSelection.get(i);
			System.out.println(i + ": " + u.name);
		}
		int user_number = getUserInput();
		System.out.println("");
		User u = userSelection.get(user_number);
		System.out.println("You have chosen " + u.name);
		return u;
		
	}
	
	public int displayMainMenu() {
		System.out.println("How can we help you today? ");
		for(int i = 0; i < mainMenu.size(); i++) {
			String option = mainMenu.get(i);
			System.out.println(i + ": " + option);
		}
		int choice = getUserInput();
		System.out.println("");
		
		return choice;
		
	}
	
	public static void displayCurrentLoans() {
		
		
	}
	
	public Materials handleCheckOut() {
		displayCheckOut();
		System.out.print("Please select which book you would like to check out: ");
		int materialNumber = getUserInput();
		System.out.println("");
		Materials m = materials.get(materialNumber);
		System.out.print("You have chosen ");
		m.printTitle();
		// TODO implement checking user permission, setting up loan
		return m;
	}
	
	public void displayCheckOut() {
		System.out.println("Here are the materials we have at the library: ");
		for(int i = 0; i < materials.size(); i++) {
			System.out.print(i + ": ");
			Materials m = materials.get(i);
			m.printTitle();
		}
	}
	
	public static void displayCheckIn() {
		
		
	}
	
	public static void displayFines() {
		
		
	}
	
	public void directToSubMenu(int choice, User currentUser) {
		if(choice == 0) {
			displayCurrentLoans();
		} else if(choice == 1) {
			handleCheckOut();
		} else if(choice == 2) {
			displayCheckIn();
		} else if(choice == 3) {
			displayFines();
		}
		
	}
	
}
