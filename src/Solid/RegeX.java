package Solid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegeX {
           private static final String EMAIL_REGEX =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

        public static boolean isValidEmail(String email) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        public static void main(String[] args) {
            String[] emails = {
                    "example@example.com",
                    "valid.email-123@subdomain.example.co.in",
                    "user@mail.co",
                    "notavalidemail.com",
                    "invalid@.com",
                    "invalid.email@domain.",
                    "@invalid.com"
            };

            for (String email : emails) {
                System.out.println(email + " is valid? " + isValidEmail(email));
            }
        }
    }


