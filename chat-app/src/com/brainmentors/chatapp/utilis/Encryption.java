 package com.brainmentors.chatapp.utilis;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException
	{
		 String encryptedPassword=null;
		 MessageDigest messageDigest=MessageDigest.getInstance("MD5");
		 messageDigest.update(plainPassword.getBytes());
		 byte []encrypt=messageDigest.digest();
		 System.out.println(encrypt);
		 StringBuffer sb=new StringBuffer();
		 for(byte b: encrypt)
		 {
			 sb.append(b);
		 }
		 encryptedPassword=sb.toString();
		 return encryptedPassword;
	}

}
  