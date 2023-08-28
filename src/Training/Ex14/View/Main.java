package src.Training.Ex14.View;

import src.Training.Ex14.Controller.CandidatesRecruitment;
import src.Training.Ex14.Exception.InvalidDOBException;
import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex14.Exception.InvalidPhoneNumberException;
import src.Training.Ex14.Exception.OtherException;

public class Main {
    public static void main(String[] args) throws InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException, OtherException {
        try {
            CandidatesRecruitment candidatesRecruitment = new CandidatesRecruitment();
            candidatesRecruitment.userChooseOption();
        } catch (Exception e) {
            throw new OtherException("Input files have unknown errors");
        }
    }
}
