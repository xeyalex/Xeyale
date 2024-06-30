package Solid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Phone {
           private static final String PHONE_REGEX =
                "^(?:\\+?1[-.●]?)?(?:\\(?([0-9]{3})\\)?[-.●]?)(?:([0-9]{3})[-.●]?([0-9]{4}))$";

        private static final Pattern pattern = Pattern.compile(PHONE_REGEX);

        public static boolean isValidPhoneNumber(String phoneNumber) {
            Matcher matcher = pattern.matcher(phoneNumber);
            return matcher.matches();
        }

        public static void main(String[] args) {
            String[] phoneNumbers = {
                    "1234567890",
                    "123-456-7890",
                    "(123)456-7890",
                    "(123) 456-7890",
                    "+1-123-456-7890",
                    "+1-(123)-456-7890",
                    "123.456.7890",
                    "123 456 7890",
                    "123456789012345",
                    "12345",
                    "abc1234567",
                    "123.456.7890x123"
            };

            for (String phoneNumber : phoneNumbers) {
                System.out.println(phoneNumber + " is valid? " + isValidPhoneNumber(phoneNumber));
            }
        }
    }


