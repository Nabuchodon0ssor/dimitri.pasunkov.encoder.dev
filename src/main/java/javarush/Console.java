package javarush;
import java.util.Scanner;

class Console {
    Scanner scan = new Scanner(System.in);
    ConsoleTextService cts = new ConsoleTextService();
    FileService fs = new FileService();
    FileWriter fw = new FileWriter();
    CaesarCipher cs = new CaesarCipher();
    BruteForce bf = new BruteForce();
    WorkWithTerminal wwt = new WorkWithTerminal();

    void welcomeMenu() {
                System.out.println("Welcome to the Text Encryption Software! Please write as number: \n" +
                        "1. If You want to input the text into the console \n" +
                        "2. If You want to choose a File with a text \n");
                int number = Integer.parseInt(scan.nextLine());
                if (number == 1) {
                    consoleTextMenu();
                }
                if (number == 2) {
                    consoleFileMenu();
                }
                else welcomeMenu();
    }
    void consoleTextMenu(){
            System.out.println("Please input the text. When the whole text is inputted, please write <<END>> from a new line");
            Texts.inputtedInitialText = cts.readInputtedText();
            System.out.println("The inputted text is: \n" + cts.getStringRepresentation(Texts.inputtedInitialText));
            System.out.println("Please input the encryption key: ");
            CaesarCipher.key = Integer.parseInt(scan.nextLine());
            System.out.println("The encryption key is: " + CaesarCipher.key);
            Texts.inputtedTextEncrypted = cs.encryptText(Texts.inputtedInitialText,CaesarCipher.key);
            System.out.println("The encrypted text is: \n" + cts.getStringRepresentation(Texts.inputtedTextEncrypted));
            while(true) {
                System.out.println("Do You want to decrypt encrypted text back? Yes(1), No(2)");
                int number = Integer.parseInt(scan.nextLine());
                if (number == 2) {
                    System.out.println("Thank You for using this software!");
                    break;
                }
                if (number == 1) {
                    Texts.inputtedTextDecrypted = cs.decryptText(Texts.inputtedTextEncrypted, CaesarCipher.key);
                    System.out.println("The decrypted text is: " + cts.getStringRepresentation(Texts.inputtedTextDecrypted));
                    System.out.println("Thank You for using this software!");
                    break;
                }
            }
    }
    void consoleFileMenu(){
        System.out.println("Please input the file path. \n" +
              "Example: E:\\\\JavaRush\\\\dimitri.pasunkov.encoder\\\\src\\\\main\\\\java\\\\com\\\\javarush\\\\Harry_Potter.txt");
        FileService.originalFilePath = scan.nextLine();
        System.out.println("The file path is: " + FileService.originalFilePath);
        System.out.println("Please input the encryption key: ");
        CaesarCipher.key = Integer.parseInt(scan.nextLine());
        System.out.println("The encryption key is: " + CaesarCipher.key);
        wwt.encryptFile(FileService.originalFilePath,CaesarCipher.key);
        System.out.println("The new file with encrypted text is: " + FileService.filePathEncrypted);
        while(true) {
            System.out.println("Do You want to decrypt encrypted file: \n" +
                    "With the same key (1) \n" +
                    "Using brute force method? (2) \n" +
                    "End working with program (3)");
            int number = scan.nextInt();
            if (number == 3) {
                System.out.println("Thank You for using this software!");
                break;
            }
            if (number == 1) {
                consoleFileMenu1();
                break;
            }
            if (number == 2) {
                consoleFileMenu2();
                break;
            }
        }
    }
    void consoleFileMenu1(){
        Texts.decryptedFileText = cs.decryptText(Texts.encryptedFileText, CaesarCipher.key);
        FileService.filePathDecrypted = fs.createDecryptedFile(FileService.filePathEncrypted);
        fw.writeTextToFile(Texts.decryptedFileText, FileService.filePathDecrypted);
        System.out.println("The new file with decrypted text is: " + FileService.filePathDecrypted);
        System.out.println("Thank You for using this software!");
    }
    void consoleFileMenu2(){
        Texts.decryptedFileText = bf.bruteForce(Texts.encryptedFileText);
        FileService.filePathDecrypted = fs.createDecryptedFile(FileService.filePathEncrypted);
        fw.writeTextToFile(Texts.decryptedFileText, FileService.filePathDecrypted);
        System.out.println("The new file with decrypted text (using brute force method) is: " + FileService.filePathDecrypted);
        System.out.println("Thank You for using this software!");
    }
}
