package src.Training.Ex15.View;

import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex15.Controller.StudentManagement;
import src.Training.Ex15.Exception.InvalidDOBException;
import src.Training.Ex15.Exception.InvalidFullnameException;
import src.Training.Ex15.Model.Student;

public class Main {
    public static void main(String[] args) throws InvalidFullnameException, InvalidDOBException {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.userMenu();
    }
}
