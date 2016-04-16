package com.denis.shuvalov.algo.arrays;

/**
 * D E F G H I J K L M N  O  P  Q  R  S  T  U  V  W  X  Y  Z  A  B  C
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
 * <p>
 * Using 'T' as an index: 'T' − 'A'
 * In Unicode: 84 − 65
 * Here is the replacement for 'T': 19 -> 'W'
 */
class CaesarCipher {
    char[] encoder = new char[26];
    char[] decoder = new char[26];

    CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded   = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);
    }

    String encrypt(String message) {
        return transform(message, encoder);
    }

    String decrypt(String secret) {
        return transform(secret, decoder);
    }

    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if (Character.isUpperCase(msg[i])) {
                int j = msg[i] - 'A';
                msg[i] = code[j];
            }
        }

        return String.valueOf(msg);
    }
}
