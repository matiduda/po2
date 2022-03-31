import java.util.Scanner;

public class UserInterface {

	final List list;
	final Scanner scan;

	UserInterface(List l, Scanner s) {
		this.scan = s;
		this.list = l;
	}

	public void handleUser() {

		int exit = 0;
		int option = 0;
		int printMenu = 1;

		while(exit == 0) {

			if(printMenu == 1) {
				System.out.print("Co chcesz zrobic?\n"
				+ "1. dodanie produktu do listy zakupów\n"
				+ "2. usunięcie produktu z listy zakupów\n"
				+ "3. usunięcie wszystkich produktów z listy zakupów\n"
				+ "4. zapis listy zakupów na dysku\n"
				+ "5. zapis listy zakupów na dysku\n"
				+ "6. wyjście z programu\n"
				+ "\n : ");
				printMenu = 0;				
			}

			try {
				option = this.scan.nextInt();
			} catch(java.util.InputMismatchException exc) {
				System.out.println("Niepoprawny numer akcji.");
				this.scan.nextLine();
				continue;
			}

			switch(option) {
				case 1:
				
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					this.list.display();
					printMenu = 1;
					break;
				case 6:
					exit = 1;
					break;
				default:
					System.out.println("Niepoprawny numer akcji.");
					break;
			}
		}

	}

}