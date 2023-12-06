package javarush;

class WorkWithTerminal {
    FileService fs = new FileService();
    FileReader fr = new FileReader();
    FileWriter fw = new FileWriter();
    CaesarCipher cs = new CaesarCipher();
    BruteForce bf = new BruteForce();

    void encryptFile(String path, int key){
        Texts.originalTextFromFile = fr.readTextFromFile(path);
        Texts.encryptedFileText = cs.encryptText(Texts.originalTextFromFile,key);
        FileService.filePathEncrypted = fs.createEncryptedFile(path);
        fw.writeTextToFile(Texts.encryptedFileText, FileService.filePathEncrypted);
    }
    void decryptFile(String path, int key){
        Texts.encryptedFileText = fr.readTextFromFile(path);
        Texts.decryptedFileText = cs.decryptText(Texts.encryptedFileText,key);
        FileService.filePathDecrypted = fs.createDecryptedFile(path);
        fw.writeTextToFile(Texts.decryptedFileText, FileService.filePathDecrypted);
    }
    void bruteForce(String path){
        Texts.encryptedFileText = fr.readTextFromFile(path);
        Texts.decryptedFileText = bf.bruteForce(Texts.encryptedFileText);
        FileService.filePathDecrypted = fs.createDecryptedFile(path);
        fw.writeTextToFile(Texts.decryptedFileText, FileService.filePathDecrypted);
    }
}
