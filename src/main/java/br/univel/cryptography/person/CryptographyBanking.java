package br.univel.cryptography.person;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by felipefrizzo on 8/29/16.
 */
public class CryptographyBanking implements Cryptography {
    @Override
    public String createCryptography(String password) {
        MessageDigest messageDigest;
        StringBuilder string = new StringBuilder();

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());

            byte[] digest = messageDigest.digest();
            for (byte b: digest) {
                string.append(String.format("%02x", b & 0xff));
            }

            return string.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
