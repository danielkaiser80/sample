package com.efass.activity;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.procedures.ProcedureImpl;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/")
public class ActivityController {

    private final ActivityRepo activityRepo;
    private final ProcedureImpl procedure;
    private final ControlParameterRepo controlParameterRepo;
    private String date;
    private String dateCBN;

    public ActivityController(ActivityRepo activityRepo, ProcedureImpl procedure) {
        this.activityRepo = activityRepo;
        this.procedure = procedure;
		this.controlParameterRepo = null;
    }

    @GetMapping("/activities")
    public ResponseEntity<Iterable<ActivityDAO>> getAllActivities() {
        List<ActivityDAO> activityDAOList = activityRepo.findAll();
        activityDAOList.sort((x, y) -> y.getTimestamp().compareTo(x.getTimestamp()));
        return ResponseEntity.ok(activityDAOList);
    }

    @PostMapping("/date")
    public ResponseEntity<String> setDate(@RequestParam @NonNull String date) {
        this.date = date;
        System.out.println(this.date);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter();
        LocalDateTime dateTime = LocalDateTime.parse(getDate(), formatter);
        Month month = dateTime.getMonth();
        Year year = Year.of(dateTime.getYear());
        int start = 1;
        int end = month.maxLength();
        if (month == Month.FEBRUARY && !year.isLeap()) {
            end = 28;
        }
        String startDate = "0" + start + "/" + month.getValue() +  "/" + year;
        String endDate = end + "/" + month.getValue() + "/" + year;
        try {
            procedure.callPrepareTableProcedures(startDate, endDate);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(date, HttpStatus.OK);
    }

   /* @PostMapping("/date")
    public ResponseEntity<String> setDate(@RequestBody String date) {
        this.date = date;
        System.out.println(this.date);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();
        LocalDateTime dateTime = LocalDateTime.parse(getDate(), formatter);
        Month month = dateTime.getMonth();
        Year year = Year.of(dateTime.getYear());
        int start = 1;
        int end = month.maxLength();
        String startDate = "0" + start + "/" + month.getValue() +  "/" + year;
        String endDate = end + "/" + month.getValue() + "/" + year;
        try {
            procedure.callPrepareTableProcedures(startDate, endDate);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(date, HttpStatus.OK);
    }
    */

    @PostMapping("/cbnDate")
    public ResponseEntity<String> setCbnDate(@RequestBody String dateCBN) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate cbnDate = LocalDate.parse(dateCBN, formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String cbnDateString = cbnDate.format(formatter2);

        ControlParameterDao controlParameterDao = new ControlParameterDao();
        controlParameterDao.setParam_value(cbnDateString);
        controlParameterDao.setId(1);
        controlParameterDao.setParam_code("EF01");
        controlParameterDao.setParam_description("Last Date of CBN Examination");
        controlParameterRepo.save(controlParameterDao);

        return new ResponseEntity<>(dateCBN, HttpStatus.OK);
    }


    public ActivityDAO saveActivity(ActivityDAO activityDAO){
        return activityRepo.save(activityDAO);
    }

    @DeleteMapping("/activity/{id}")
    public void deleteActivity(@PathVariable("id") Integer id){
        activityRepo.deleteById(id);
    }

    public int getActivityLength(){
        return activityRepo.findAll().size();
    }

    public String getDate(){
        return this.date.toString();
    }

    public String setCbnDate(){
        return this.dateCBN.toString();
    }

}
