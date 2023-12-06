package javarush;
import java.util.ArrayList;

class CaesarCipher {
    public static int key;
    ArrayList<Character> encryptText(ArrayList<Character> inputtedInitialText, int key) {
        ArrayList<Character> encryptedText = new ArrayList<>();
        for (char chars : inputtedInitialText) {
            if(Constants.ALPHABET_EN.contains(chars)) {
                int position = Constants.ALPHABET_EN.indexOf(chars);
                int encryptIndex = (key + position) % Constants.ALPHABET_EN.size();
                encryptedText.add(Constants.ALPHABET_EN.get(encryptIndex));
            }
            else encryptedText.add(chars);
        }
        return encryptedText;
    }
    ArrayList<Character> decryptText(ArrayList<Character> text, int key){
        ArrayList<Character> decryptedText = new ArrayList<>();
        for (char chars : text) {
            if(Constants.ALPHABET_EN.contains(chars)) {
                int position = Constants.ALPHABET_EN.indexOf(chars);
                int decryptIndex = (position - key) % Constants.ALPHABET_EN.size();
                if (decryptIndex < 0) {
                    decryptIndex = Constants.ALPHABET_EN.size() + decryptIndex;
                }
                decryptedText.add(Constants.ALPHABET_EN.get(decryptIndex));
            }
            else decryptedText.add(chars);

        }
        return decryptedText;
    }
}
