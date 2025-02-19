import java.util.Scanner;

public class StringEncryption {
    
    // Caesar Cipher Encryption
    public static String caesarEncrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Caesar Cipher Decryption
    public static String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - shift);
    }

    // Vigenere Cipher Encryption
    public static String vigenereEncrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((c - base + shift) % 26 + base));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Vigenère Cipher Decryption
    public static String vigenereDecrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex % key.length()) - 'a';
                result.append((char) ((c - base - shift + 26) % 26 + base));
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt using Caesar Cipher");
        System.out.println("2. Decrypt using Caesar Cipher");
        System.out.println("3. Encrypt using Vigenere Cipher");
        System.out.println("4. Decrypt using Vigenere Cipher");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter shift value:");
                int shift = scanner.nextInt();
                System.out.println("Encrypted Text: " + caesarEncrypt(text, shift));
                break;
            case 2:
                System.out.println("Enter shift value:");
                shift = scanner.nextInt();
                System.out.println("Decrypted Text: " + caesarDecrypt(text, shift));
                break;
            case 3:
                System.out.println("Enter keyword:");
                String key = scanner.nextLine();
                System.out.println("Encrypted Text: " + vigenereEncrypt(text, key));
                break;
            case 4:
                System.out.println("Enter keyword:");
                key = scanner.nextLine();
                System.out.println("Decrypted Text: " + vigenereDecrypt(text, key));
                break;
            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
