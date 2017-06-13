package ru.test;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Katy on 12.06.2017.
 */
public class Main {



    public   java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }

    public static void main(String[] args) {

        java.util.Date today=new Date();
        java.sql.Date date=new java.sql.Date(today.getTime()); //your SQL date object
        SimpleDateFormat simpDate = new SimpleDateFormat("MMM dd,yyyy");
        System.out.println(simpDate.format(date)); //output String in MM-dd-yyyy Apr 4, 2005

       String stringDate = today.toString() ;

        System.out.println(stringDate);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM dd,yyyy");
        LocalDate dateL = LocalDate.parse("июн 12,2017", f);
        String str = dateL.format(f);

        System.out.println(str);
//------------------------------------------------------------------

        String date1 = "01.03.2016";
        String date2 = "01.02.2016";

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        Date dateOne = null;
        Date dateTwo = null;

        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Количество дней между датами в миллисекундах
        long difference = dateOne.getTime() - dateTwo.getTime();
        // Перевод количества дней между датами из миллисекунд в дни
        int days =  (int)(difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
        // Вывод разницы между датами в днях на экран
        System.out.println(days + " дн.");


    }

}
