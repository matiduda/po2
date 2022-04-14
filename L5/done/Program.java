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
		map = removeDuplicates(map);

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
	
	public static TreeMap<nrTelefoniczny, Wpis> removeDuplicates(TreeMap<nrTelefoniczny, Wpis> map) {

		TreeMap<nrTelefoniczny, Wpis> new_map = new TreeMap<>();

		
		for(Map.Entry<nrTelefoniczny, Wpis> entry : map.entrySet()) {
			Wpis value = entry.getValue();
			nrTelefoniczny key = entry.getKey();
			
			boolean is_duplicate = false;
			
			for(Map.Entry<nrTelefoniczny, Wpis> compare : new_map.entrySet()) {
				Wpis valueComp = compare.getValue();
				
				if(entry != compare && value.compare(valueComp) == 0) {
					is_duplicate = true;
					break;
				}
			}

			if (!is_duplicate) {
				new_map.put(key, value);
			}
		}
		return new_map;
	}
}