import java.util.Scanner;

/*

WAŻNE: Lista zakupow to już ta lista w pliku, nie trzeba do tego robić kolejnej struktury, usunięcie przedmiotu z listy to po prostu usunięcie jej z pliku tekstowego

DO ZROBIENIA:
- podzielic na pliki
- 2d array list (struktura listy zakupow) vvv
	+ obiekt kategoria z arrayList ze Stringami które są przedmiotami
	+ arrayList z kategoriami
- interakcja listy z uzytkownikiem

Przy kolejnym uruchomieniu programu użytkownik może:

wczytać do edycji ostatnio zapisaną listę zakupów (program nie umożliwia jednoczesnego zapisania kilku odrębnych list zakupów)
usunąć wszystkie produkty z ostatnio zapisanej listy i rozpocząć od początku przygotowywanie listy zakupów

*/

public class Program {

	public static void main(String args[]) {


		Scanner inputScanner = new Scanner(System.in);
		User user = new User();

		String filename = user.readPreference();
		System.out.println(filename);
		if(filename.isEmpty()) {
			System.out.print("Podaj nazwę listy: ");
			filename = inputScanner.nextLine();
			user.savePreference(filename);
		}

		List list = new List(filename);
		UserInterface userInterface = new UserInterface(list, inputScanner);

		list.display();	
		userInterface.handleUser();

		inputScanner.close();
	}

		
	
}
