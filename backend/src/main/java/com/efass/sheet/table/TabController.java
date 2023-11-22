package com.efass.sheet.table;

import com.efass.ReportGroupEnum;
import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class TabController {

@Autowired
TableService tableService;
    private static ReportGroupEnum reportGroupEnum;

    @GetMapping("/tableList/{report_group}")
    public ResponseEntity<?> getDataByMonth( @PathVariable String report_group) throws ResourceNotFoundException {
        if (report_group.equalsIgnoreCase("M")) {
            setReportGroupEnum(ReportGroupEnum.MONTHLY);
        }
        if (report_group.equalsIgnoreCase("Q")) {
            setReportGroupEnum(ReportGroupEnum.QUARTERLY);
        }
        return tableService.getDataByMonths(report_group);

    }

    public static ReportGroupEnum getReportGroupEnum() {
        return reportGroupEnum;
    }

    public void setReportGroupEnum(ReportGroupEnum reportGroupEnum) {
        TabController.reportGroupEnum = reportGroupEnum;
    }
}


