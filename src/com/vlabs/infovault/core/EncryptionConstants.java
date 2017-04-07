package com.vlabs.infovault.core;

public class EncryptionConstants {

	/**
	 * @
	 */

	public static final String CHARSET = "UTF8";
	
	/****************************   CIPHER / RNG ALGORITHMS   **********************************************************************/
	public static final String AESCIPHER = "AES";
	public static final String DESCIPHER = "DES";
	public static final String DESEDECIPHER = "DESede";
	public static final String PBECIPHER = "PBEWithMD5AndDES";
	public static final String RANDOMNUMGENMETHOD = "SHA1PRNG"; // Random number generator algorithm
	public static final String PASSKEYHMACSHA = "PBKDF2WithHmacSHA1"; // SecretKey Factory Algorithm
	
	

	/****************************  FEEDBACK MODE   **********************************************************************/
	public static final String CBCMODE = "CBC";
	public static final String ECBMODE = "ECB";
	

	/****************************  PADDING    **********************************************************************/
	public static final String NOPAD = "NoPadding";
	public static final String PKCS5PAD = "PKCS5PADDING";

	
	/****************************    DES CIPHER CONSTANTS   **********************************************************************/
	public static final int desKeyLength = 56;
	

	/****************************       AES CIPHER CONSTANTS   **********************************************************************/
	public static final int aesKeyLength1 = 128;
	public static final int aesKeyLength2 = 192;

	public static final int KeyIterations = 1000;
}
