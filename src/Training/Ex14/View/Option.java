package src.Training.Ex14.View;

public enum Option {
    ADD, CHOOSE, SHOW, EXIT;


    public static Option getListOption(int choice) {
        for (Option option : Option.values()) {
            if (option.ordinal() == (choice - 1)) {
                return option;
            }
        }
        throw new RuntimeException();
    }
}

