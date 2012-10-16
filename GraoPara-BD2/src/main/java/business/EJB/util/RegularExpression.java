package business.EJB.util;

import java.util.regex.Pattern;

public class RegularExpression {

	private Pattern p;

	public RegularExpression(String pattern){
		if(pattern.charAt(0) != '^')	pattern = "^" + pattern;
		if(pattern.charAt(pattern.length()-1) != '$')	pattern = pattern + "$";
//		System.out.println(pattern);
		p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
	}

	public boolean check(String string){
		return p.matcher(string).find();
	}

	public String getPattern(){
		return p.pattern();
	}

	public void setPattern(String newPattern){
		if(newPattern.charAt(0) != '^')	newPattern = "^" + newPattern;
		if(newPattern.charAt(newPattern.length()-1) != '$')	newPattern = newPattern + "$";
		p = Pattern.compile(newPattern, Pattern.CASE_INSENSITIVE);
	}
}
