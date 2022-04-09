import java.io.PrintStream;
import java.lang.Comparable;

public class nrTelefoniczny implements Comparable<nrTelefoniczny> {
	
	private final byte nrKierunkowy;
	private final int nrTelefonu;
	
	public nrTelefoniczny(byte nrKierunkowy, int nrTelefonu) {
		this.nrKierunkowy = nrKierunkowy;
		this.nrTelefonu = nrTelefonu;
	}

	public void print(PrintStream out) {
		out.printf("+%d %d\n", nrKierunkowy, nrTelefonu);
	}

	@Override
	public int compareTo(nrTelefoniczny numer) {
		return numer.getNumber().compareTo(this.getNumber());
	}

	private String getNumber() {
		return String.valueOf(nrKierunkowy) + String.valueOf(nrTelefonu);
	}

	
}
