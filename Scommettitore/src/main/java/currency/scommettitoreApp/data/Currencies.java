package currency.scommettitoreApp.data;

import java.io.IOException;
import java.text.ParseException;
import java.util.Set;
import java.util.Vector;

import currency.scommettitoreApp.exceptions.DateException;
import currency.scommettitoreApp.exceptions.UrlException;
import currency.scommettitoreApp.model.ApiModel;
import currency.scommettitoreApp.service.*;

/**
 * Classe per gestire e richiamare il parsing (?)
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class Currencies {

	/**
	 * Metodo che ottiene i valori del giorno odierno e ne ricava il Set di String con i nomi delle valute
	 * @return un Set di String con l'elenco delle valute
	 * @throws UrlException
	 * @throws IOException
	 * @see currency.scommettitoreApp.data.Currencylayer#getJsonAndDecode
	 */
	
	public static Set<String> getCurrencies() throws UrlException, IOException {

		ApiModel p = new ApiModel();

		p = Currencylayer.getJsonAndDecode(UrlService.getUrl(DateService.today(), ""));
		
		return p.quotes.keySet();
	}

	/**
	 * Metodo che ottiene gli oggetti ApiModel e li inserisce in un Vector
	 * @param from data di inizio del periodo voluto
	 * @param to data di fine del periodo voluto
	 * @param currencies elenco delle valute richieste
	 * @return un Vector di ApiModel con gli elementi parsati
	 * @throws UrlException
	 * @throws IOException
	 * @throws DateException
	 * @throws ParseException
	 * @see currency.scommettitoreApp.service.DateService
	 * @see currency.scommettitoreApp.data.Currencylayer
	 */
	
	public static Vector<ApiModel> vectorApiModel(String from, String to, String currencies)
			throws UrlException, IOException, DateException, ParseException{

		Vector<ApiModel> p = new Vector<ApiModel>();

		Vector<String> days = DateService.dateRange(from, to);
		for (String day : days) {
			p.add(Currencylayer.getJsonAndDecode(UrlService.getUrl(day, currencies)));
		}
		return p;
	}

}
