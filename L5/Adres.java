public class Adres {
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

	
}
