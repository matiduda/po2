class Program {
	public static void main(String[] args) {

		if(args.length != 3) {
			System.out.println("Blad: Wprowadzono bledna liczbe argumentow!\nsprobuj: java Program napis 1 3");
			System.exit(1);
		}
		
		Parser parser = new Parser(args[0], args[1], args[2]);
		parser.printSubstring();
	}
}