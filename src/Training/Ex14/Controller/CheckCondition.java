package src.Training.Ex14.Controller;

import src.Training.Ex14.Exception.InvalidDOBException;
import src.Training.Ex14.Exception.InvalidFullNameException;
import src.Training.Ex14.Exception.InvalidPhoneNumberException;
import src.Training.Ex14.Model.GoodStudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckCondition {
    protected static void checkFullName(String fullName) throws InvalidFullNameException {
        if (fullName.length() > 50 || fullName.length() < 10) {
            throw new InvalidFullNameException("Invalid full name!");
        }
    }

    protected static void checkDOB(String doB) throws InvalidDOBException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String doBString = dateFormat.format(doB);

        if (!doBString.equals(dateFormat.format(parseDate(doBString)))) {
            throw new InvalidDOBException("Invalid date of birth!");
        }
    }

    protected static void checkPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        String[] validPrefixes = {"090", "098", "091", "031", "035", "038"};

        boolean isValidPrefix = false;
        for (String prefix : validPrefixes) {
            if (phoneNumber.startsWith(prefix)) {
                isValidPrefix = true;
                break;
            }
        }

        if (phoneNumber.length() != 10 || !isValidPrefix) {
            throw new InvalidPhoneNumberException("Invalid phone number!");
        }
    }

    protected static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }


}
