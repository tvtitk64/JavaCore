package src.Training.Ex15.Controller;

import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex15.Exception.InvalidDOBException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CheckCondition {
    public static void checkFullName(String fullName) throws InvalidFullNameException {
        int length = fullName.length();
        if (length >= 10 && length <= 50)
            return;
        else
            throw new InvalidFullNameException("Name illegal");
    }

    /**********************************
     *            checkDOB            *
     **********************************/
    public static void checkDOB(String doB) throws InvalidDOBException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date date = formatter.parse(doB);

        } catch (ParseException e) {
            throw new InvalidDOBException("Date illegal");
        }
    }
}
