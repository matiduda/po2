import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class List {
	
	final ArrayList<Category> list;
	final String pathToList;
	
	List(String filename) throws FileNotFoundException {
		this.pathToList = filename;
		this.list = new ArrayList<Category>();

		File file = new File(filename);

		try {
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				
				if(line.isEmpty()) {
					continue;
				}
				
				if(line.charAt(0) == '#') {
					String categoryName = line.substring(2);
					Category catg = new Category(categoryName);
					try {
						while(!(line = reader.nextLine()).isEmpty()) {
							catg.add(line);
						}
					} catch(NoSuchElementException noLine) {
						this.list.add(catg);
						break;
					}

					this.list.add(catg);
				}

			}
			reader.close();
		}
		catch(FileNotFoundException ex) {
			throw ex;
		}

	}

	public void display() {
		
		for (Category cat : this.list){
			System.out.println(" ---   " + cat.categoryName + "   --- ");
			for (String product : cat.productList) {
				System.out.println("- " + product);
			}
			System.out.println();
		}		
	}

	public void addProduct(int categoryIndex, String product) {
		this.list.get(categoryIndex).add(product);
	}

	public void removeProduct(int categoryIndex, String product) {
		this.list.get(categoryIndex).remove(product);
	}

	public void clearAll() {
		this.list.removeAll(this.list);
	}

	public void saveList() throws IOException {

		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(new File(this.pathToList)));
		} catch(IOException exc) {
			System.out.println("Błąd zapisu do pliku.");
			return;
		}
		
		try {
			for (Category cat : this.list){
					writer.write("# " + cat.categoryName + "\n");
		
				for (String product : cat.productList) {
					writer.write(product + "\n");
				}
				writer.write("\n");
			}
		} catch(IOException exc) {
			writer.close();
			return;
		}	
	
		writer.close();
	}
}