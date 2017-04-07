package com.vlabs.infovault.core;

import javax.crypto.*;

import javax.crypto.spec.*;

import java.security.*;
import sun.misc.*;

import com.vlabs.infovault.core.EncryptionConstants;



public class AESEncryptionUtility extends AbstractEncryptionUtility {


	protected final int KEYLENGTH = EncryptionConstants.aesKeyLength1;
	protected final String CIPHER_ALGORITHM = EncryptionConstants.AESCIPHER;
	
	public AESEncryptionUtility() {
		
	}
	
	
	/**
	 * @param args
	 */
	public byte[] encryptData(String szPlainText, SecretKey objSecKey) {
		
		byte[] bytEncrText = null;
		SecretKey encrKey = null;
		try
		{
		
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM,"SUNJCE");
			cipher.init(Cipher.ENCRYPT_MODE, objSecKey);
			
			bytEncrText = cipher.doFinal(szPlainText.getBytes(CHARSET));
			
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return bytEncrText;
	}
	
protected SecretKey genDataEncryptionKey() {
	

			byte[] arrKeyBytes = null;
			SecretKey objKey = null;

			arrKeyBytes = genRandomNumber(KEYLENGTH,0);

			objKey = new SecretKeySpec(arrKeyBytes,CIPHER_ALGORITHM);

			return objKey;

	}

private SecretKey genPasswordKey(String szPassword, int iSaltbyteSize, int iKeyLength) {
			
			byte[] arrSaltBytes = new byte[iSaltbyteSize];
			PBEKeySpec objKeySpec = null;
			SecretKeyFactory objKeyFactory = null;
			SecretKey objKey = null;
			
			
		try
		{
			
			
			arrSaltBytes = genSalt(iSaltbyteSize, SEED);
			
			objKeySpec = new PBEKeySpec(szPassword.toCharArray(), arrSaltBytes, ITERATIONS, iKeyLength);
			
			objKeyFactory = SecretKeyFactory.getInstance(PWDBASED_KEYGEN_ALGORITHM);
			
		 	objKey = objKeyFactory.generateSecret(objKeySpec);
			
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return objKey;
						
	}	
}
