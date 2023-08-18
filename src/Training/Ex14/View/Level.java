package src.Training.Ex14.View;

public enum Level {
    GOOD (1, "Good"), NORMAL(2, "Normal");

    private int value;
    private String string;

    Level(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static String getString(Level level) {
        return level.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static Level getLevel(int value) {
        for (Level level : Level.values()) {
            if (level.value ==  value) {
                return level;
            }
        }
        throw new RuntimeException();
    }
}
