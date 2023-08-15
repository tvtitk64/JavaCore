package src.Training.Ex10.Controller;

public class WordHandle {
    public static int countCharacters(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int countCharacter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                countWord ++;
            }
        }
        return countWord;
    }
}
