import java.io.PrintStream;

public class Osoba extends Wpis {

	private final String imie;
	private final String nazwisko;
	private final Adres adres;

	public Osoba(String imie, String nazwisko, Adres adres) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
	}

	@Override
	void opis(PrintStream out) {
		out.printf("Osoba:\t%s %s\nAdres:\t", imie, nazwisko);
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
