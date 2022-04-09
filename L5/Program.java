import static java.lang.System.out;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Program {

    public static void main(String[] args) {
    
		nrTelefoniczny numer_1 = new nrTelefoniczny((byte)48, 697551524);
		nrTelefoniczny numer_2 = new nrTelefoniczny((byte)48, 665327427);
		nrTelefoniczny numer_3 = new nrTelefoniczny((byte)37, 524987336);

		Adres adres_1 = new Adres("ul. Kazimierza Wielkiego", (short)8, "Warszawa", 00654, "mazowieckie", numer_1);
		Adres adres_2 = new Adres("ul. Cicha", (short)12, "Łódź", 90005, "łódzkie", numer_2);
		Adres adres_3 = new Adres("ul. Cicha", (short)127, "Łódź", 50021, "łódzkie", numer_3);
		
		Osoba osoba_1 = new Osoba("Antoni", "Anyrob", adres_1);
		Osoba osoba_2 = new Osoba("Zachariasz", "Kowalski", adres_2);

		Firma firma_1 = new Firma("DOM-BUD sp. z o.o.", adres_3);

		TreeMap<nrTelefoniczny, Wpis> map = new TreeMap<>();

		map.put(numer_1, osoba_1);
		map.put(numer_2, osoba_2);
		map.put(numer_3, firma_1);

		displayMap(map);
		removeDuplicates(map);

		out.println("\n\nTreeMapa po usunięciu powtarzajacych się wpisów:");
		displayMap(map);
	}

	public static void displayMap(TreeMap<nrTelefoniczny, Wpis> map) {

		for(Map.Entry<nrTelefoniczny, Wpis> entry : map.entrySet()) {
			nrTelefoniczny key = entry.getKey();
			Wpis value = entry.getValue();
		
			out.print("-------------------------\nNumer: ");
			key.print(out);
			value.opis(out);
		}
	}
	
	public static void removeDuplicates(TreeMap<nrTelefoniczny, Wpis> map) {

		Set<nrTelefoniczny> keysToRemove = new HashSet<>();
		
		for(Map.Entry<nrTelefoniczny, Wpis> entry : map.entrySet()) {
			Wpis value = entry.getValue();

			for(Map.Entry<nrTelefoniczny, Wpis> compare : map.entrySet()) {
				Wpis valueComp = compare.getValue();
				nrTelefoniczny keyComp = compare.getKey();

				if(value != valueComp && value.compare(valueComp) == 0 && !keysToRemove.contains(keyComp)) {
					keysToRemove.add(keyComp);
					break;
				}
			}
		}

		map.keySet().removeAll(keysToRemove);
	}
}