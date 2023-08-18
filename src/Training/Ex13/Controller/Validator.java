package src.Training.Ex13.Controller;

import src.Training.Ex13.Exception.BirthdayException;
import src.Training.Ex13.Exception.EmailException;
import src.Training.Ex13.Exception.FullnameException;
import src.Training.Ex13.Exception.PhoneException;

import java.time.LocalDate;

public class Validator {
    public static void birthdayCheck(LocalDate birthday) throws BirthdayException {
        LocalDate currentDate = LocalDate.now();

        if (birthday.isAfter(currentDate)) {
            throw new BirthdayException("Invalid birthday. Birthday cannot be in the future.");
        } else if (birthday.getMonthValue() > 12 || birthday.getMonthValue() < 1) {
            throw new BirthdayException("Invalid birthday. Month of birthday invalid.");
        } else if (birthday.getDayOfMonth() > 12 || birthday.getDayOfMonth() < 1) {
            throw new BirthdayException("Invalid birthday. Day of birthday invalid.");
        }
    }

    public static void phoneCheck(String phone) throws PhoneException {
        String pattern = "^\\d{10}$";

        if (!phone.matches(pattern)) {
            throw new PhoneException("Invalid phone number. Phone number must be a 10-digit number.");
        }
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
