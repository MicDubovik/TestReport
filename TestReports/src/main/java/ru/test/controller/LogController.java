package ru.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.test.model.Report;
import ru.test.repository.ReportsRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api/performers")
public class LogController {

    private ReportsRepository repository;

    @Autowired
    public LogController(ReportsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Report> getAll() {

        return repository.findAll();
    }

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public List<Report> getByDate(@RequestBody Report report) {
        List<Report> result = null;
        String perforemer ;
        if (report.getPerformer().equals("All performers")){
              perforemer = null;
        } else {
            perforemer = report.getPerformer();
        }
        if (perforemer==null && report.getStartdate()!=null && report.getEnddate()!=null){
            result = repository.findAllByEndDateAndStartDateBetween(report.getStartdate(), report.getEnddate());
        } else  if (perforemer==null && report.getStartdate()==null && report.getEnddate()!=null){
            result = repository.findAllByEnddate(report.getEnddate());
        } else if (perforemer==null && report.getStartdate()!=null && report.getEnddate()==null){
            result = repository.findAllByStartDate(report.getStartdate());
        }
        else if (perforemer!=null && report.getStartdate()!=null && report.getEnddate()!=null){
            result = repository.findAllByPerformerAndStartdateAndEnddateBetween(report.getStartdate(),report.getEnddate(),perforemer);
        }
        else if (perforemer!=null && report.getStartdate()==null && report.getEnddate()!=null){
            result = repository.findAllByPerformerAndEnddate(report.getEnddate(),perforemer);
        }
        else if (perforemer!=null && report.getStartdate()!=null && report.getEnddate()==null){
            result = repository.findAllByPerformerAndStartdate(report.getStartdate(),perforemer);
        } else if (perforemer!=null && report.getStartdate()==null && report.getEnddate()==null) {
                result = repository.findAllByPerformerWhithoutDate(report.getPerformer());

        } else if (perforemer==null && report.getStartdate()==null && report.getEnddate()==null){

            result = repository.findAll();
        }

        return result ;

    }



}
