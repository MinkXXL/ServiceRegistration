package com.service.register.SERVICEREGISTRATION.utility;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    private static Logger log = LoggerFactory.getLogger(EncryptUtil.class);

    public static String hashAlgorithm(String request, String hashTypeAlgolithm) throws NoSuchAlgorithmException {
        String hashValue = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(hashTypeAlgolithm);
            byte[] digest = messageDigest.digest(request.getBytes());

            hashValue = Hex.encodeHexString(digest);
        } catch (NoSuchAlgorithmException ex) {
            log.error("No Such Algorithm: ", ex.getStackTrace());
        } catch (Exception ex) {
            log.error("Error Exception: ", ex.getStackTrace());
        }
        return hashValue;
    }

    public static String decodeHexToString(String request) throws DecoderException, UnsupportedEncodingException {
        byte[] bytes = Hex.decodeHex(request.toCharArray());
        return (new String(bytes, "UTF-8"));
    }

}
