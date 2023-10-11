package ru.kpfu.itis.bagaviev.utils;

import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryptUtil {

    public static String encrypt(String password) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] digest = messageDigest.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }

}
