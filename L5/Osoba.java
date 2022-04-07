public class Osoba extends Wpis {

	private final String imie;
	private final String nazwisko;
	private final Adres adres;
	private final nrTelefoniczny numer;

	public Osoba(String imie, String nazwisko, Adres adres, nrTelefoniczny numer) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adres = adres;
		this.numer = numer;
	}

	@Override
	void wpis() {
		// TODO Auto-generated method stub
		
	}
	
}
