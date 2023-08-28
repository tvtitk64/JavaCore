package src.Training.Ex14.Constant;
public class ApplicationConstant {
    private static final String insertStudent = "insert into students(fullName, dateOfBirth, sex, phoneNumber, universityName, grade) values(?,?, ?,?, ?, ?)";
    private static final String insertGoodStudent = "insert into good_students(student_id, gpa, bestReward) values(?, ?, ?)";
    private static final String insertNormalStudent = "insert into normal_students(student_id, entryTestScore, EnglistScore) values(?, ?, ?)";
    private static final String queryGoodStudent = """
            select * from good_student inner join students on good_student.student_id = students.id""";
    private static final String queryNormalStudent = """
            select * from normal_student inner join students on normal_student.student_id = students.id""";
}
