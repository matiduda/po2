import java.io.IOException;
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
				System.out.print(""
				+ "\n1. dodanie produktu do listy zakupów"
				+ "\n2. usunięcie produktu z listy zakupów"
				+ "\n3. usunięcie wszystkich produktów z listy zakupów"
				+ "\n4. zapis listy zakupów na dysku"
				+ "\n5. wyświetlenie listy zakupów"
				+ "\n6. wyjście z programu");
				printMenu = 0;				
			}
			
			System.out.print("\nCo chcesz zrobic? : ");

			try {
				option = this.scan.nextInt();
			} catch(java.util.InputMismatchException exc) {
				System.out.println("Niepoprawny numer akcji.");
				this.scan.nextLine();
				continue;
			}

			switch(option) {
				case 1: // dodanie produktu do listy zakupów
					this.addElement();
					printMenu = 1;
					break;
				case 2: // usunięcie produktu z listy zakupów
					this.deleteElement();
					printMenu = 1;
					break;
				case 3: // usunięcie wszystkich produktów z listy zakupów
					this.list.clearAll();
					break;
				case 4: // zapis listy zakupów na dysku
					try {
						this.list.saveList();
					} catch(IOException exc) {
						System.out.println("Błąd zapisu listy do pliku.");
					}
					System.out.println("Pomyślnie zapisano listę do pliku.");
					break;
				case 5: // wyświetlenie listy zakupów
					this.list.display();
					break;
				case 6: // wyjście z programu
					exit = 1;
					break;
				default:
					System.out.println("Niepoprawny numer akcji.");
					break;
			}
		}
	}

	private void addElement() {

		System.out.println("\n0. [Utworz nowa kategorie]");

		for (Category cat : this.list.list){
			System.out.println((this.list.list.indexOf(cat) + 1) + ". " + cat.categoryName);
		}

		System.out.println("Wybierz kategorie: ");
		int index = this.scan.nextInt();
		this.scan.nextLine(); // clear buffer

		if(index == 0) {
			System.out.print("Podaj nazwe kategorii: ");
			Category newCategory = new Category(this.scan.nextLine());
			this.list.list.add(newCategory);
			index = this.list.list.indexOf(newCategory) + 1;
		}

		System.out.print("Wpisz nazwe produktu: ");
		String product = this.scan.nextLine();
		this.list.addProduct(index - 1, product);
	}

	
	private void deleteElement() {


		for (Category cat : this.list.list){
			System.out.println("\n" + (this.list.list.indexOf(cat) + 1) + ". " + cat.categoryName);
		}
		System.out.print("Wybierz kategorie: ");

		int index = this.scan.nextInt();
		this.scan.nextLine(); // clear buffer

		Category category = this.list.list.get(index - 1);
		for (String product : category.productList) {
			System.out.println((category.productList.indexOf(product) + 1) + ". " + product);
		
		}
		System.out.print("Wybierz produkt: ");
		index = this.scan.nextInt();
		this.scan.nextLine(); // clear buffer

		category.remove(category.productList.get(index - 1));
	}

}