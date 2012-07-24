package persistence.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public static String getHash(String password){

		String hashword = null;
		hashword = byteArrayToHexString(genHash(password));
		System.out.println(hashword);
		return hashword;
	}

}
