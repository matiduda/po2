/*
	Napisz program proszący o podanie 2 wektorów (wektor to ciąg liczb).
	
	Koniec wektora
	oznacza się za pomocą wciśnięcia klawisza enter.
	
	Jeżeli podany ciąg nie jest liczbą, jest
	ignorowany. Następnie należy spróbować dodać wektory, jeżeli są równej długości (są równej
	długości jeśli mają tę samą liczbę elementów). Jeżeli nie są, rzucany jest własny wyjątek
	WektoryRoznejDlugosciException, za pomocą którego można podać a następnie odczytać
	długości tych wektorów (należy tak skonstruować wyjątek, aby możliwe było skonstruowanie
	zdania po jego przechwyceniu : "Długość pierwszego wektora to AA a drugiego to BB" lub
	dowolnego innego zdania wykorzystującego wartości AA i BB, np. określającego różnicę w
	długościach). Jeżeli są równej długości, wynik dodawania zapisywany jest do pliku. Jeżeli nie
	są równej długości, użytkownik jest proszony o ponowne wprowadzenie tych wektorów.
*/
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

class MyVector {
    private final Scanner scan;
    private ArrayList<Integer> v1;
    private ArrayList<Integer> v2;

	public MyVector(Scanner scan) {
		this.scan = scan;
		this.v1 = new ArrayList<Integer>();
		this.v2 = new ArrayList<Integer>();
	}

	public void inputVectors() throws WektoryRoznejDlugosciException {
		String v1_asString = takeInput("Podaj elementy pierwszego wektora: ");
		String[] numbersAsString = v1_asString.trim().split("\\s+");
		
		for(String str : numbersAsString) {
			
			Integer integer = null;
			try {
				integer = Integer.valueOf(str);
			} catch (java.lang.NumberFormatException e) {
				;
			}
			if (integer != null) {
				v1.add(integer);
			}
		}

		
		String v2_asString = takeInput("Podaj elementy drugiego wektora: ");
		numbersAsString = v2_asString.trim().split("\\s+");
		

		for(String str : numbersAsString) {
			
			Integer integer = null;
			
			try {
				integer = Integer.valueOf(str);
			} catch (java.lang.NumberFormatException e) {
				;
			}
			if (integer != null) {
				v2.add(integer);
			}
		}

		if (!areEqualLength()) {
			WektoryRoznejDlugosciException e = new WektoryRoznejDlugosciException(v1.size(), v2.size());
			v1.clear();
			v2.clear();
			throw e;
		}
	}

	private boolean validateInput(String input) {

		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) != ' ' || !Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private String takeInput(String prompt) {
		String temp = "";
		out.println(prompt);
		while(true) {
			temp = scan.nextLine();
			
			if(!validateInput(temp)) {
				break;
			}
		}
		return temp;
	}

	private boolean areEqualLength() {
		return v1.size() == v2.size();
	}

	public String addVec() {
		if (v1.size() == 0) return "Vectors are epmty";
		String output = "[ ";

		for(int i = 0; i < v1.size(); i++) {
			output += v1.get(i) + v2.get(i);
			output += " ";
		}

m		output += ']';
		return output;
	}
}