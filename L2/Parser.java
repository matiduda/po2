class Parser {
	String text = "";
	int startIndex = 0;
	int endIndex = 0;

	Parser(String word, String start, String end) {
		// Przekonwertuj argumenty na wartosci indeksow
		this.text = word;
		try {
			this.startIndex = Integer.parseInt(start);

			if(this.endIndex > this.text.length()) {
				this.endIndex = this.text.length();
			} else {
				this.endIndex = Integer.parseInt(end) + 1;
			}
		}
		catch (NumberFormatException exc) {
			System.out.println("Blad: Podany indeks musi byc liczba calkowita.");
		}

	}

	public void printSubstring() {
		try {
			System.out.println(this.text.substring(this.startIndex, this.endIndex));
		} catch(IndexOutOfBoundsException exc) {
			System.out.println("Blad: Zakres indeksow jest niepoprawny.");
		}
	}

}