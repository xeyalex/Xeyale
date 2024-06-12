package Date;
import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class date {
    public static void main(String[] args) {
        Date currentDate = new Date();
        System.out.println(currentDate);
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

       java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);

        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.println(date);



        LocalTime currentTime = LocalTime.now();
        LocalTime earlierTime = currentTime.minusHours(3);
        System.out.println(earlierTime);



        LocalDate currentDate1 = LocalDate.now();
        LocalDate futureDate = currentDate1.plusDays(5);
        System.out.println(futureDate);




        String dateString = "2024-06-13";
        LocalDate localDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate);

    }



    }

