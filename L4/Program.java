import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/*


Przy kolejnym uruchomieniu programu użytkownik może:

- wczytać do edycji ostatnio zapisaną listę zakupów (program nie umożliwia jednoczesnego zapisania kilku odrębnych list zakupów)
- usunąć wszystkie produkty z ostatnio zapisanej listy i rozpocząć od początku przygotowywanie listy zakupów

*/

public class Program {

	public static void main(String args[]) {
		
		Scanner inputScanner = new Scanner(System.in);
		User user = new User();
		// user.savePreference("");
		String filename = user.readPreference();
		System.out.println("Wczytano nazwe: " + filename);
		int choice = 0;

		if(filename.isEmpty()) {
			choice = 2;
		} else {

			System.out.print("Witaj!\n" +
				"1. Wczytaj ostatnio zapisaną listę zakupów.\n" +
				"2. Usuń wszystkie produkty i utwórz nową listę zakupów.\n: ");
			

			while(true) {
				try {
					choice = inputScanner.nextInt();
					inputScanner.nextLine();

					if(choice == 1 || choice == 2)
						break;
					} catch(java.util.InputMismatchException exc) {
						inputScanner.nextLine();
					}
				System.out.println("Niepoprawny numer akcji.");
			}
		}

		if(choice == 1 && !filename.isEmpty()) {
			// There is a filename stored, but we need to check
			// if the file exists and the list loads correctly (if not choice == 2)

			try {
				new List(filename);
			} catch(java.io.FileNotFoundException exc) {
				System.out.println("Błąd wczytywania listy `" + filename + "`");
				choice = 2;
			}
		}
				
		if(choice == 2) {
			System.out.print("Podaj nazwę listy: ");
			filename = inputScanner.nextLine();
			user.savePreference(filename);

			// Create empty list file
			File f = new File(filename);
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(2);
			}
		}
		
		List list = null;
		try {
			list = new List(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		UserInterface userInterface = new UserInterface(list, inputScanner);

		list.display();	
		userInterface.handleUser();

		inputScanner.close();
	}

		
	
}
