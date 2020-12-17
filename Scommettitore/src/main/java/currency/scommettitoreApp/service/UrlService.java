package currency.scommettitoreApp.service;

/**
 * Classe che genera l'url
 * @author Emanuele Biccheri
 * @author Edoardo Bilancia
 */

public class UrlService {

	/**
	 * Chiave d'accesso al sito
	 */
	
	private static final String ACCESS_KEY = "0533f14c0a3ce40e6a6766be7b2f54e1";
	
	/**
	 * Base dell'url comune a tutti
	 */
	
	private static final String BASE_URL = "http://api.currencylayer.com/";
	
	/**
	 * Endpoint
	 */
	
	private static final String ENDPOINT = "historical";

	/**
	 * Metodo che compone l'url
	 * @param date data da inserire nell'url
	 * @param currencies valute da inserire nell'url
	 * @return una String che rappresenta l'url generato
	 */
	
	public static String getUrl(String date,String currencies) {
		return new String(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&date=" + date + "&currencies=" + currencies);
	}
}
