import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;

class Program {
    private static final Scanner scan = new Scanner(System.in);

    public static <File> void main(String[] args) {
        MyVector vec1 = new MyVector(scan);
		boolean done = false;

		while(!done) {
			try {
				vec1.inputVectors();
				done = true;
			} catch (WektoryRoznejDlugosciException e) {
				e.printInfo();
			}
		}
			
		// Zapisz do pliku

		String filename = "output.txt";

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filename));
			writer.write("Wynik dodawania: " + vec1.addVec());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

    }
}