package javarush;
import java.util.ArrayList;
import java.util.Scanner;

class ConsoleTextService {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Character> readInputtedText(){
        ArrayList<Character> inputtedText = new ArrayList<>();
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("END")) break;
            char[] chars = line.toCharArray();
            for (char ch : chars) {
                inputtedText.add(ch);
            }
            inputtedText.add('\n');
        }
        return inputtedText;
    }
    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

}
