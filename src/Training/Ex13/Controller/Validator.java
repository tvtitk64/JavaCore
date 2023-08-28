package src.Training.Ex13.Controller;

import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.FullnameException;
import src.Training.Ex13.Exception.PhoneException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Validator {
    public static void birthdayCheck(String birthday) throws BirthdayException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date date = formatter.parse(birthday);

        } catch (ParseException e) {
            throw new BirthdayException("Date illegal");
        }
    }

    public static void phoneCheck(int phone) throws PhoneException {
        String string = Integer.toString(phone);
        if (string.length() == 10 && string.charAt(0) == '0')
            return;
        else
            throw new PhoneException("Phone illegal");
    }

    public static void emailCheck(String email) throws EmailException {
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(pattern)) {
            throw new EmailException("Invalid email address.");
        }
    }

    public static void nameCheck(String name) throws FullnameException {
        if (name.isEmpty()) {
            throw new FullnameException("Name cannot be empty.");
        }

        String pattern = "^[a-zA-Z]+$";
        if (!name.matches(pattern)) {
            throw new FullnameException("Invalid name. Name must contain only alphabetic characters.");
        }
    }
}
