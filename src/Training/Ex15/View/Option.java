package src.Training.Ex15.View;
public enum Option {
    ADD,
    CHECK_STANDARD,
    COUNT_STANDARD,
    SEARCH_POINT,
    SHOW_HIGHEST_POINT,
    SEARCH_SERVICE_STUDENT,
    SEARCH_POINT_OVER8,
    SEARCH_HIGHEST_SEMESTER_POINT,
    SHOW_BY_ENTRY_YEAR,
    COUNT_BY_ENTRY_YEAR,
    EXIT;

    public static Option getOption(int ordinal){
        for (Option option : Option.values()){
            if (option.ordinal() == (ordinal - 1))
                return option;
        }
        throw new RuntimeException();
    }
}
