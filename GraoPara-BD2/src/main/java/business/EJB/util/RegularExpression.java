package business.EJB.util;

import java.util.regex.Pattern;

/**
 * Classe de expressão regular
 */
public class RegularExpression {

	private Pattern p;
	
	/**
	 * Construtor.<br>
	 * Define uma expressão regular.
	 * @param pattern - <i>String</i> contendo a expressão regular que será utilizado.
	 */
	public RegularExpression(String pattern){
		if(pattern.charAt(0) != '^')	pattern = "^" + pattern;
		if(pattern.charAt(pattern.length()-1) != '$')	pattern = pattern + "$";
//		System.out.println(pattern);
		p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * Verifica se uma string satisfaz a expressão regular.
	 * @param string - String que será verificado.
	 * @return <b>True</b> se a string satisfazer a expressão regular, <b>False</b> caso contrário.
	 */
	public boolean check(String string){
		return p.matcher(string).find();
	}

	/**
	 * Retorna a expressão regular que será utilizado nas verificações.
	 * @return <i>String</i> contendo a expressão utilizado.
	 */
	public String getPattern(){
		return p.pattern();
	}

	/**
	 * Define uma nova expressão regular.
	 * @param newPattern - nova expressão regular que será utilizado.
	 */
	public void setPattern(String newPattern){
		if(newPattern.charAt(0) != '^')	newPattern = "^" + newPattern;
		if(newPattern.charAt(newPattern.length()-1) != '$')	newPattern = newPattern + "$";
		p = Pattern.compile(newPattern, Pattern.CASE_INSENSITIVE);
	}
}
