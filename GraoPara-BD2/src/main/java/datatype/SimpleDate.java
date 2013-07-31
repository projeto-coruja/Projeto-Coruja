package datatype;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe para armazenamento de datas.
 */
public final class SimpleDate implements Serializable{
	
	/*
	 * Seção pública
	 */

	public final static short TRACKS_ONLY_YEAR = 1;
	public final static short TRACKS_YEAR_AND_MONTH = 2;
	public final static short TRACKS_FULL_DATE = 3;

	/**
	 * Construtor para data com dia, mês e ano.
	 * @param year
	 * @param month
	 * @param day
	 */
	public SimpleDate(short year, short month, short day) {
		this(year, month, day, TRACKS_FULL_DATE);
	}
	
	/**
	 * Construtor para data somente com mês e ano.
	 * @param year
	 * @param month
	 */
	public SimpleDate(short year, short month) {
		this(year, month, NOT_DEFINED, TRACKS_YEAR_AND_MONTH);
	}
	
	/**
	 * Construtor para data somente com ano.
	 * @param year
	 */
	public SimpleDate(short year) {
		this(year, NOT_DEFINED, NOT_DEFINED, TRACKS_ONLY_YEAR);
	}
	
	/**
	 * Retorna a data em forma de <i>String</i>
	 * @return - <i>String</i> contendo a data armazenada.
	 */
	public String format() {
		String result = null;
		switch (dateMode) {
		case TRACKS_FULL_DATE:
			result = strYear(year) + "/" + str(month) + "/" + str(day);
			break;
			
		case TRACKS_YEAR_AND_MONTH:
			result = strYear(year) + "/" + str(month);
			break;
			
		case TRACKS_ONLY_YEAR:
			result = strYear(year);
			break;

		default:
			break;
		}
		return result;
	}
	
	/**
	 * Retorna o tipo da data (só ano; mês e ano; dia, mês e ano)
	 * @return dateMode
	 */
	public short tracks() {
		return dateMode;
	}
	
	/**
	 * Retorna o ano.
	 * @return year
	 */
	public short getYear() {
		return year;
	}
	
	/**
	 * Retorna o mês.
	 * @return month
	 * @exception IllegalAccessError caso a data não esteja armazenando mês.
	 */
	public short getMonth() {
		if(dateMode == TRACKS_ONLY_YEAR) {
			throw new IllegalAccessError("Instance doesn't track month");
		} else {
			return month;
		}
	}
	

	/**
	 * Retorna o dia.
	 * @return day
	 * @exception IllegalAccessError caso a data não esteja armazenando dia.
	 */
	public short getDay() {
		if(dateMode == TRACKS_ONLY_YEAR || dateMode == TRACKS_YEAR_AND_MONTH) {
			throw new IllegalAccessError("Instance doesn't track days");
		} else {
			return day;
		}
	}
	
	/**
	 * Instncia a data a partir de uma <i>String</i>.
	 * @param strDate - String contendo a data no formato (dd/MM/yyyy)
	 * @return	data no formato <i>SimpleDate</i>.
	 * @throws IllegalArgumentException
	 */
	public static SimpleDate parse(String strDate) throws IllegalArgumentException {
		String[] parts = strDate.split("/");
		if(parts.length == 1) {
			short year = Short.parseShort(parts[0]);
			if(year < 0 || year > 9999) throw new IllegalArgumentException("Invalid format for string (YYYY)");
			else return new SimpleDate(year);
		}
		else if(parts.length == 2) {
			short year = Short.parseShort(parts[0]);
			short month = Short.parseShort(parts[1]);
			if((year < 0 || year > 9999) && (month < 1 || month > 12)) throw new IllegalArgumentException("Invalid format for string (YYYY-MM)");
			else return new SimpleDate(year, month);
		}
		else if(parts.length == 3) {
			short year = Short.parseShort(parts[0]);
			short month = Short.parseShort(parts[1]);
			short day = Short.parseShort(parts[2]);
			if((year < 0 || year > 9999) && (month < 1 || month > 12) && (day < 1 || day > 31)) throw new IllegalArgumentException("Invalid format for string (YYYY-MM-DD)");
			else return new SimpleDate(year, month, day);
		}
		else {
			throw new IllegalArgumentException("Invalid format for string (YYYY[-MM[-DD]]");
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static SimpleDate getToday() {
		return parse(sdf.format(new Date()));
	}
	
	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object anObject) {
		if(!(anObject instanceof SimpleDate)){
			return false;
		}
		else if(this == anObject) {
			return true;
		}
		else {
			SimpleDate aDate = (SimpleDate) anObject;
			if(aDate.tracks() != dateMode) return false;
			
			if(dateMode == TRACKS_ONLY_YEAR)
				return (aDate.year == this.year);
			else if(dateMode == TRACKS_YEAR_AND_MONTH)
				return (aDate.year == this.year && aDate.month == this.month);
			else if(dateMode == TRACKS_FULL_DATE)
				return (aDate.year == this.year && aDate.month == this.month && aDate.day == this.day);
			else
				throw new RuntimeException("dateMode in SimpleDate instance is invalid");
		}
	}
	
	/**
	 * @return result
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dateMode;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	
	public String toString() {
		return format();
	}
	
	/*
	 * Sessão privada
	 */
	
	private static final long serialVersionUID = 8790883863690026543L;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private final short year;
	private final short month;
	private final short day;
	private final short dateMode;
	
	private final static short NOT_DEFINED = 0;
	
	private boolean isShortMonth(short month) {
		return (month == 4 || month == 6 || month == 9 || month == 11);
	}
	
	private boolean isFebruary(short month) {
		return (month == 2);
	}
	
	private boolean isLeapYear(short year) {
		return (year % 4 == 0);
	}
	
	private String str(short s) {
		return String.format("%02d", s);
	}
	private String strYear(short s) {
		return String.format("%04d", s);
	}
	
	private SimpleDate(short year, short month, short day, short dateMode) {
		boolean suceed = false;
		if((year >= 0 && year <= 9999)) {
			if(isShortMonth(month)) {
				if((day >= 0) && (day <= 30)) {
					suceed = true;
				}
			}
			else if(isFebruary(month)) {
				if(isLeapYear(year)) {
					if((day >= 0) && (day <= 29)) {
						suceed = true;
					}
				}
				else {
					if((day >= 0) && (day <= 28)) {
						suceed = true;
					}
				}
			}
			else if(month >= 0 && month <= 12) {
				if((day >= 0) && (day <= 31)) {
					suceed = true;
				}
			}
		}
		
		if(suceed) {
			this.year = year;
			this.month = month;
			this.day = day;
			this.dateMode = dateMode;
		}
		else throw new IllegalArgumentException("Invalid values");
	}

}
