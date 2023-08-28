package src.Training.Ex13.ModifyEnum;
public enum ModifyExperience {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    EXPERIENCE_YEAR,
    PRO_SKILL,
    EXIT;

    public static ModifyExperience getEnumModifyExperience(int ordinal) {
        for (ModifyExperience modify : ModifyExperience.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
