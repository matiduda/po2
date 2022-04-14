import java.io.PrintStream;

public class Firma extends Wpis {

	private final String nazwa;	
	private final Adres adres;
	
	public Firma(String nazwa, Adres adres) {
		this.nazwa = nazwa;
		this.adres = adres;
	}

	@Override
	void opis(PrintStream out) {
		out.printf("Firma:\t%s\nAdres:\t", nazwa);
		adres.print(out);
	}

	@Override
	int compare(Wpis w) {
		return adres.compareTo(w.getAddress());
	}

	@Override
	public Adres getAddress() {
		return adres;
	}

	
}
