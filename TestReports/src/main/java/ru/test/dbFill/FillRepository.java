package ru.test.dbFill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.test.model.Report;
import ru.test.repository.ReportsRepository;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Component
public class FillRepository implements CommandLineRunner {

    private ReportsRepository reportsRepository;

    @Autowired
    public FillRepository(ReportsRepository reportsRepository) {
        this.reportsRepository = reportsRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Report> reportsList = new ArrayList<>();

        String date1start = "янв 01,2016";
        String date1end = "фев 01,2016";
        String date2start = "мар 02,2015";
        String date2end = "апр 03,2015";
        String date3start = "май 02,2013";
        String date3end = "июн 03,2013";



        SimpleDateFormat format = new SimpleDateFormat("MMM dd,yyyy");

        Date datestart1 = null;
        Date dateend1 = null;
        Date datestart2 = null;
        Date dateend2 = null;
        Date datestart3 = null;
        Date dateend3 = null;

        try {
            datestart1 = format.parse(date1start);
            dateend1 = format.parse(date1end);
            datestart2 = format.parse(date2start);
            dateend2 = format.parse(date2end);
            datestart3 = format.parse(date3start);
            dateend3 = format.parse(date3end);
        } catch (Exception e) {
            e.printStackTrace();
        }



        reportsList.add(new Report(datestart1, dateend1, "Ivan", "Active"));
        reportsList.add(new Report(datestart2, dateend2, "Artem", "Closed"));
        reportsList.add(new Report(datestart3, dateend3, "Petr", "Closed"));

        reportsRepository.save(reportsList);
    }
}
