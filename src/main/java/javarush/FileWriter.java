package javarush;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

class FileWriter {
    void writeTextToFile(ArrayList<Character> text, String newFilePath) {
        File newFile = new File(newFilePath);

        try{PrintWriter pw = new PrintWriter(newFile);
        for (Character ch : text)
        {
            pw.print(ch);
        }
        pw.close();}
        catch(Exception e){
            System.out.println("File not found");}
    }
}
