import java.io.PrintStream;
import java.lang.Comparable;

public class Adres implements Comparable<Adres> {
	private final String ulica;
	private final short nrDomu;
	private final String miejscowosc;
	private final int kodPocztowy;
	private final String wojewodztwo;
	private final nrTelefoniczny numer;

	public Adres(String ulica, short nrDomu, String miejscowosc, int kodPocztowy, String wojewodztwo, nrTelefoniczny numer) {
		this.ulica = ulica;
		this.nrDomu = nrDomu;
		this.miejscowosc = miejscowosc;
		this.kodPocztowy = kodPocztowy;
		this.wojewodztwo = wojewodztwo;
		this.numer = numer;
	}

	public void print(PrintStream out) {
		out.printf("%s %s\n\t%d-%d %s\n\twoj. %s\n\t", ulica, nrDomu, kodPocztowy / 1000, kodPocztowy % 1000, miejscowosc, wojewodztwo);
		numer.print(out);
	}

	@Override
	public int compareTo(Adres o) {
		// Compare only by 'ulica'
		return ulica.compareTo(o.getStreet());
	}

	public String getStreet() {
		return ulica;
	}
	
}
