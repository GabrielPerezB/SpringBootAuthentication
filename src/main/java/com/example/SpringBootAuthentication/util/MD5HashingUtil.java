package com.example.SpringBootAuthentication.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashingUtil {

    public String generateHash (String valueToHash){

        String generatedHash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(valueToHash.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }

        return generatedHash;
    }
}
