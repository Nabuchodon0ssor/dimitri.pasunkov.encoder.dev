package javarush;

class Application {
    public static void main(String[] args) {
        if(args.length == 2||args.length==3) {
            WorkWithTerminal wwt = new WorkWithTerminal();

            if(args[0].equals("ENCRYPT")){
                wwt.encryptFile(args[1],Integer.parseInt(args[2]));
            }
            if(args[0].equals("DECRYPT")){
                wwt.decryptFile(args[1],Integer.parseInt(args[2]));
            }
            if(args[0].equals("BRUTE_FORCE")){
                wwt.bruteForce(args[1]);
            }
        } else {
            Console console = new Console();
            console.welcomeMenu();
        }
    }
}
