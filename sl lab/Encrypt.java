import java.util.Scanner;

public class Encrypt {

    public static String temp = "";

    // Encrypts text using a shift cipher
    public static StringBuffer encrypt(String m, int k) {
        StringBuffer encrypto = new StringBuffer();
        k = k % 26; // Adjust key for large values of k

        for (int i = 0; i < m.length(); i++) {
            char ch = m.charAt(i);
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((int) ch + k - 65) % 26 + 65);
                encrypto.append(encryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((int) ch + k - 97) % 26 + 97);
                encrypto.append(encryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                encrypto.append(ch);
            }
        }

        temp = encrypto.toString(); // Store encrypted text in temp for later use
        return encrypto;
    }

    // Decrypts text using a shift cipher
    public static StringBuffer decrypt(String temp, int k) {
        StringBuffer decrypto = new StringBuffer();
        k = k % 26; // Adjust key for large values of k

        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            if (Character.isUpperCase(ch)) {
                char decryptedChar = (char) (((int) ch - k - 65 + 26) % 26 + 65);
                decrypto.append(decryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char decryptedChar = (char) (((int) ch - k - 97 + 26) % 26 + 97);
                decrypto.append(decryptedChar);
            } else {
                // Non-alphabetic characters remain unchanged
                decrypto.append(ch);
            }
        }

        return decrypto;
    }

    // Main class & method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a key:");
        int k = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.println("Enter the text:");
        String m = sc.nextLine();

        System.out.println("Text : " + m);
        System.out.println("Key : " + k);

        StringBuffer cipherText = encrypt(m, k);
        System.out.println("Cipher: " + cipherText);

        StringBuffer decryptedText = decrypt(temp, k);
        System.out.println("Decrypted: " + decryptedText);

        sc.close(); // Close the scanner to avoid resource leak
    }
}
