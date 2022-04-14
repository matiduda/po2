import static java.lang.System.out;

class WektoryRoznejDlugosciException extends Exception {

	final int a;
	final int b;

	public WektoryRoznejDlugosciException(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void printInfo() {
		out.printf("Długość pierwszego wektora to %d a drugiego to %d\n", a, b);
	}

}