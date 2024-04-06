package com.ada.api.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class HashImage {

	public static String hashFileName(String fileName) {
		
        try {
        	
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(fileName.getBytes(StandardCharsets.UTF_8));

            // Converte o hash para uma representação hexadecimal
            StringBuilder hashStringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hashStringBuilder.append(String.format("%02x", b));
            }

            return hashStringBuilder.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
