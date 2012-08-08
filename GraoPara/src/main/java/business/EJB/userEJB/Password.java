package business.EJB.userEJB;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Password {
	private Password (){}

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

	private static byte[] genHash(String s){
		try{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(s.getBytes(),0,s.length());
			return md5.digest();
		}catch(NoSuchAlgorithmException e){
		}
		return null;
	}

	/**
	 * Transforma uma senha em hash.
	 * @param password - String que será transformado em hash.
	 * @return hashword - Hash da senha.
	 */
	public static String getHash(String password){

		String hashword = null;
		hashword = byteArrayToHexString(genHash(password));
		System.out.println(hashword);
		return hashword;
	}
	
	/**
	 * Gera uma nova senha de n caracteres.
	 * @param n - Número de caracteres que será colocado na nova senha. 
	 * @return password - Nova senha gerado aleatóriamente.
	 */
	public static String genNewRandomPassword(Integer n){
		char c;
		Random r = new Random();
		String password = "";
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
			password += c;
		}
		
		return password;
		
	}

}