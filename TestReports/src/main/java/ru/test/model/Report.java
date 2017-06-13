package ru.test.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;


@Entity
@Table
public class Report implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "MMM dd,yyyy")
    private Date startdate;

    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "MMM dd,yyyy")
    private Date enddate;

    private String performer;

    private String activity;

    public Report() {
    }



    public Report(Date startdate, Date enddate) {
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Report(Date startdate, Date enddate, String performer) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.performer = performer;
    }

    public Report(Date startdate, Date enddate, String performer, String activity) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.performer = performer;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
