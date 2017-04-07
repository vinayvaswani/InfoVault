package com.vlabs.infovault.core;

import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public abstract class AbstractEncryptionUtility {

	
	/* ************** CONSTANTS ******************** */
	
	 
	
	protected final int ITERATIONS = EncryptionConstants.KeyIterations;
	protected final String PWDBASED_KEYGEN_ALGORITHM = EncryptionConstants.PASSKEYHMACSHA;
	protected final String CHARSET = EncryptionConstants.CHARSET;
	private final long SEED = 12345678;
	
	
public abstract byte[] encryptData(String szPlainText, SecretKey objSecKey) {
	
	}
	


protected byte[] genRandomNumber(int iSizeParam, long lSeedParam) {
	
	byte[] arrRandomByte = new byte[iSizeParam];
	
	try
	{
			SecureRandom objRandom = SecureRandom.getInstance(EncryptionConstants.RANDOMNUMGENMETHOD);
			
			if(lSeedParam !=0 ){
				objRandom.setSeed(lSeedParam);
			}
			
			objRandom.nextBytes(arrRandomByte);
			
	} catch(Exception ex) {
		
		ex.printStackTrace();
	}
	return arrRandomByte;
}
	
protected byte[] genSalt(int iSaltSize, long lSeedParam) {
	
	byte[] arrSaltBytes = new byte[iSaltSize];
	arrSaltBytes = genRandomNumber(iSaltSize, lSeedParam);
	
	return arrSaltBytes;
}

protected abstract SecretKey genDataEncryptionKey();




}
