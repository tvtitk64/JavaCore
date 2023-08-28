package src.Training.Ex13.View;



public enum EmployeeEnum {
    EXPERIENCE (0,"Experience"),
    FRESHER (1,"Fresher"),
    INTERN (2,"Intern");

    private int value1;
    private String value2;

    EmployeeEnum(int value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static EmployeeEnum getEnumEmployee(int ordinal) {
        for (EmployeeEnum employee : EmployeeEnum.values()) {
            if (employee.value1 == (ordinal - 1))
                return employee;
        }
        throw new RuntimeException();
    }

    public static String getString(EmployeeEnum employee) {
        return employee.value2;
    }
}
