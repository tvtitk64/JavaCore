package src.Training.Ex13.ModifyEnum;
public enum ModifyIntern {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    MAJORS,
    SEMESTER,
    UNIVERSITY,
    EXIT;

    public static ModifyIntern getEnumModifyIntern(int ordinal) {
        for (ModifyIntern modify : ModifyIntern.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
