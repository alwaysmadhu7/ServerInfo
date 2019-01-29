package com.me.poc;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public class Ciphers {
public static void main(String[] args) throws NoSuchAlgorithmException {
	try {
	    SSLContext ctx = SSLContext.getDefault();
	    ctx.getClientSessionContext().setSessionTimeout(5); // in seconds
	    SSLSocket socket = (SSLSocket) ctx.getSocketFactory().createSocket("github.com", 443);

	    socket.setSoTimeout(5000); // in millis
	    String[] result = socket.getEnabledCipherSuites();
	    Arrays.sort(result);
	    System.out.println(result.length);
	    for (int i = 0; i < result.length; i++) {
	        System.out.println(result[i]); 
	    }
	 } catch (IOException ex) {
	     System.out.println("Error!");
	 }
}
}
