package business.EJB.util;

import java.util.regex.Pattern;

/**
 * Expressões regulares básicas.
 */
public class QuickRegex {
	
	private static final Pattern p = Pattern.compile("[^a-zA-Z0-9àáãâäèéẽêëìíĩîïòóõôöùúũûüçÀÁÃÂÄÈÉẼÊËÌÍĨÎÏÒÓÕÔÖÙÚŨÛÜÇ: -]");
	private static final Pattern q = Pattern.compile("[^0-9]");
	
	/**
	 * Verifica se a string satisfaz a expressão regular "[^a-zA-Z0-9àáãâäèéẽêëìíĩîïòóõôöùúũûüçÀÁÃÂÄÈÉẼÊËÌÍĨÎÏÒÓÕÔÖÙÚŨÛÜÇ: -]"
	 * @param s - String a ser verificado.
	 * @return <b>True</b> se a string string satifaz a expressão regular, <b>False</b> caso contrário. 
	 */
	public static boolean findAN(String s) {
		return p.matcher(s).find();
	}
	
	/**
	 * Verifica se a string satisfaz a expressão regular "[^0-9]"
	 * @param s - String a ser verificado.
	 * @return <b>True</b> se a string string satifaz a expressão regular, <b>False</b> caso contrário. 
	 */
	public static boolean findN(String s) {
		return q.matcher(s).find();
	}

}
