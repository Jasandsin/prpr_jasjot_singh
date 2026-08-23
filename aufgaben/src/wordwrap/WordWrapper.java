package wordwrap;

import java.util.Scanner;

public class WordWrapper {

    private final int maxLinesLength;

    public WordWrapper(int maxLinesLength){
        this.maxLinesLength = maxLinesLength;
    }

    public String wrap (String text){

        Scanner scanner = new Scanner(text);
        String result = "";
        int lineLength = 0;
        int emptySpace = 1;

        while(scanner.hasNext()){
            String word = scanner.next();

            if (lineLength == 0){
                result = result + word;
                lineLength = word.length();

            } else if (lineLength + emptySpace + word.length() <= maxLinesLength){
                result = result + " " + word;
                lineLength = lineLength + emptySpace + word.length();

            } else {
                result = result + "\n" + word;
                lineLength = word.length();
            }
        }
        return result;
    }
}
