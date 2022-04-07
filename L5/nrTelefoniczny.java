public class nrTelefoniczny implements Comparable {
	
	private final byte nrKierunkowy;
	private final int nrTelefonu;
	
	public nrTelefoniczny(byte nrKierunkowy, int nrTelefonu) {
		this.nrKierunkowy = nrKierunkowy;
		this.nrTelefonu = nrTelefonu;
	}

	public byte getNrKierunkowy() {
		return nrKierunkowy;
	}

	public int getNrTelefonu() {
		return nrTelefonu;
	}

}
