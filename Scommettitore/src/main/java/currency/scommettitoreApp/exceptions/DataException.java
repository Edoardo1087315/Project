package currency.scommettitoreApp.exceptions;

public class DataException extends GenericError {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String GetMessaggio() {
		return "La data d'inizio eccede o è uguale alla data di fine";
	}
}
