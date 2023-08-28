package src.Training.Ex13.View;
public enum Option {
    ADD,
    DELETE,
    MODIFY,
    SEARCH,
    EXIT;

    public static Option getEnumMenu(int ordinal){
        for (Option option : Option.values()){
            if (option.ordinal() == (ordinal - 1))
                return option;
        }
        throw new RuntimeException();
    }
}
