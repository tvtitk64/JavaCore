package src.Training.Ex10.Model;

import java.util.Scanner;

public class Document {
    private String string;

    public Document() {

    }

    public Document(String string) {
        this.string = string;
    }

    public int countWords() {
        if (string.isEmpty()) {
            return 0;
        }

        String[] countWord = string.split("\\s+");
        return countWord.length;
    }

    public int countCharacters() {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A' || string.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    public void textNormalization() {
        string = string.trim();
        string = string.replaceAll("\\s+", " ");
    }
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
