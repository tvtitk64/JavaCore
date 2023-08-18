package src.Training.Ex14.View;

public enum Show {
    NAME, PHONE;

    public static Show getChoice(int choice) {
        for (Show show : Show.values()) {
            if (show.ordinal() == (choice - 1)) {
                return show;
            }
        }
        throw new RuntimeException();
    }
}
