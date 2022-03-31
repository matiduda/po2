import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class List {
	
	final ArrayList<Category> list;
	final String pathToList;

	List(String filename) {
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
						break;
					}

					this.list.add(catg);
				}

			}
			reader.close();
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(1);
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
}