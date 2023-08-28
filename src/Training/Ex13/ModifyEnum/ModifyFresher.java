package src.Training.Ex13.ModifyEnum;
public enum ModifyFresher {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    GRAD_DATE,
    GRAD_RANK,
    EDUCATION,
    EXIT;

    public static ModifyFresher getEnumModifyFresher(int ordinal) {
        for (ModifyFresher modify : ModifyFresher.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
