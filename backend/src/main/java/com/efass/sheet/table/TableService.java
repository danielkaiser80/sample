package com.efass.sheet.table;

import com.efass.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TableService {

	public  ResponseEntity<?> AssetsTableData();
    ResponseEntity<?> getDataByMonths(String report_group) throws ResourceNotFoundException;

    XmlHeader getTableDataByReportName(String reportName);

}
