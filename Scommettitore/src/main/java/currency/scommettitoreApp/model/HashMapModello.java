package currency.scommettitoreApp.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import currency.scommettitoreApp.currencylayer.ApiParsing;
import currency.scommettitoreApp.filtriEstatistiche.statistiche;

public class HashMapModello {

	static HashMap<String, ModelloValuta> hs2 = new HashMap<String, ModelloValuta>();
	static Vector<Double> vet;
	public static Double d;
	public static ModelloValuta m;

	public static HashMap<String, ModelloValuta> HashMapValori(Vector<ApiParsing> p) {
		Iterator<ApiParsing> it = p.iterator();
		ApiParsing e = it.next();
		Set<String> x = e.quotes.keySet();

		for (String s : x) {
			Iterator<ApiParsing> it2 = p.iterator();
			vet = new Vector<Double>();
			while (it2.hasNext()) {
				e = it2.next();
				d = e.quotes.get(s);
				vet.add(d);
			}
			m = new ModelloValuta(statistiche.media(vet), statistiche.varianza(vet), vet, statistiche.VariazPercentuale(vet), statistiche.dev_Standard(vet), statistiche.VariazPercentualeGiornaliera(vet));
			hs2.put(s, m);

		}
		return hs2;
	}
	
}
