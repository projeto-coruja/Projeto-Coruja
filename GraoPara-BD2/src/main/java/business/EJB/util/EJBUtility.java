package business.EJB.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class EJBUtility {

	private EJBUtility (){}

	private static String byteArrayToHexString(byte[] b){
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++){
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] genHash(String s, String algorithm) throws NoSuchAlgorithmException{
		if(algorithm.isEmpty())	throw new NoSuchAlgorithmException("Nenhum algoritmo passado");
		MessageDigest md5 = MessageDigest.getInstance(algorithm);
		md5.reset();
		md5.update(s.getBytes(),0,s.length());
		return md5.digest();
	}

	/**
	 * Transforma uma senha em hash.
	 * @param s - String que será transformado em hash.
	 * @param algorithm - Algorítmo a ser utilizado. 
	 * Caso <b>null</b> ou algoritmo inexistente, o método utilizará o <b>MD5</b> como padrão. 
	 * @return hashword - Hash da senha.
	 */
	public static String getHash(String s, String algorithm){

		String hashword = null;
		try {
			hashword = byteArrayToHexString(genHash(s, algorithm));
		} catch (NoSuchAlgorithmException e) {
			try {
				hashword = byteArrayToHexString(genHash(s, "MD5"));
			} catch (NoSuchAlgorithmException e1) {
			}
		}
//		System.out.println(hashword);
		return hashword;
	}

	/**
	 * Gera uma String aleatório de n caracteres.
	 * @param n - Número de caracteres que será colocado na String. 
	 * @return String gerado.
	 */
	public static String genRandomString(Integer n){
		char c;
		Random r = new Random();
		String s = "";
		for(int i = 0; i < n; i++){
			switch(r.nextInt(3)){
			case 0:
				c = (char) ('a' + r.nextInt(26));
				break;
			case 1:
				c = (char) ('A' + r.nextInt(26));
				break;
			case 2:
				c = (char) ('0' + r.nextInt(9));
				break;
			default:
				c = '-';
			}
			s += c;
		}
		return s;
	}

}