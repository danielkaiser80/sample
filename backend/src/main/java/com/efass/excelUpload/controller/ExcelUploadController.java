package com.efass.excelUpload.controller;

import com.efass.sheet.mdfir100.sheet100_Service;
import com.efass.sheet.mdfir101.sheet101_Service;
import com.efass.sheet.mdfir1300.sheet1300_Service;
import com.efass.sheet.mdfir1301.sheet1301_Service;
import com.efass.sheet.mdfir1600.sheet1600_Service;
import com.efass.sheet.mdfir1700.sheet1700_Service;
import com.efass.sheet.mdfir250.sheet250_Service;
import com.efass.sheet.mdfir600.sheet600_Service;
import com.efass.sheet.mdfir601.sheet601_Service;
import com.efass.sheet.mdfir920.sheet920_Service;
import com.efass.sheet.mdfir921.sheet921_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/uploadExcel")
@RequiredArgsConstructor
public class ExcelUploadController {

    private final sheet100_Service sheet100_Service;
    private final sheet1600_Service sheet1600_service;
    private final com.efass.sheet.mdfir920.sheet920_Service sheet920_Service;
    private final sheet921_Service sheet921_service;
    private final sheet1700_Service sheet1700_service;
    private final sheet1301_Service sheet1301_service;

    private final sheet101_Service _sheet101_Service;
    private final sheet250_Service _sheet250_Service;
    private final sheet600_Service _sheet600_service;
    private final sheet601_Service _sheet601_service;
    private final sheet1300_Service _sheet1300_service;

    @PostMapping("mdfir100/{mdfir100}")
    public ResponseEntity<?> uploadSheet(@PathParam("file") MultipartFile file, @PathVariable String mdfir100) {
        sheet100_Service.saveSheet100ToDataBase(file, mdfir100);
        return ResponseEntity.ok(Map.of("Message", "MDFIR100 data uploaded and saved to database"));
    }

    @PostMapping("mdfir1600/{mdfir1600}")
    public ResponseEntity<?> uploadSheet1600(@PathParam("file") MultipartFile file, @PathVariable String mdfir1600) {
        sheet1600_service.saveSheet1301ToDataBase(file, mdfir1600);
        return ResponseEntity.ok(Map.of("Message", "MDFIR1600 data uploaded and saved to database"));
    }

    @PostMapping("mdfir920/{mdfir920}")
    public ResponseEntity<?> uploadSheet920(@PathParam("file") MultipartFile file, @PathVariable String mdfir920) {
        sheet920_Service.saveSheet920ToDataBase(file, mdfir920);
        return ResponseEntity.ok(Map.of("Message", "sheet920 data uploaded and saved to database"));
    }
    @PostMapping("mdfir921/{mdfir921}")
    public ResponseEntity<?> uploadSheet921(@PathParam("file") MultipartFile file, @PathVariable String mdfir921) {
        sheet921_service.saveSheet921ToDataBase(file, mdfir921);
        return ResponseEntity.ok(Map.of("Message", "sheet921 data uploaded and saved to database"));
    }

    @PostMapping("mdfir1700/{mdfir1700}")
    public ResponseEntity<?> uploadSheet1700(@PathParam("file") MultipartFile file, @PathVariable String mdfir1700) {
        sheet1700_service.saveSheet1700ToDataBase(file, mdfir1700);
        return ResponseEntity.ok(Map.of("Message", "sheet1700 data uploaded and saved to database"));
    }

    @PostMapping("mdfir1301/{mdfir1301}")
    public ResponseEntity<?> uploadSheet1301(@PathParam("file") MultipartFile file, @PathVariable String mdfir1301) {
        sheet1301_service.saveSheet1301ToDataBase(file, mdfir1301);
        return ResponseEntity.ok(Map.of("Message", "sheet1301 data uploaded and saved to database"));
    }

    @PostMapping("mdfir101/{mdfir101}")
    public ResponseEntity<?> uploadSheet101(@PathParam("file") MultipartFile file, @PathVariable String mdfir101) {
        _sheet101_Service.saveSheet101ToDataBase(file, mdfir101);
        return ResponseEntity.ok(Map.of("Message", "MDFIR101 data uploaded and saved to database"));
    }

    @PostMapping("mdfir250/{mdfir250}")
    public ResponseEntity<?> uploadSheet250(@PathParam("file") MultipartFile file, @PathVariable String mdfir250) {
        _sheet250_Service.saveSheet250ToDataBase(file, mdfir250);
        return ResponseEntity.ok(Map.of("Message", "MDFIR250 data uploaded and saved to database"));
    }

    @PostMapping("mdfir600/{mdfir600}")
    public ResponseEntity<?> uploadSheet600(@PathParam("file") MultipartFile file, @PathVariable String mdfir600) {
        _sheet600_service.saveSheet600ToDataBase(file, mdfir600);
        return ResponseEntity.ok(Map.of("Message", "Sheet600 data uploaded and saved to database"));
    }

    @PostMapping("mdfir601/{mdfir601}")
    public ResponseEntity<?> uploadSheet601(@PathParam("file") MultipartFile file, @PathVariable String mdfir601) {
        _sheet601_service.saveSheet601ToDataBase(file, mdfir601);
        return ResponseEntity.ok(Map.of("Message", "Sheet601 data uploaded and saved to database"));
    }

    @PostMapping("mdfir1300/{mdfir1300}")
    public ResponseEntity<?> uploadSheet1300(@PathParam("file") MultipartFile file, @PathVariable String mdfir1300) {
        _sheet1300_service.saveSheet1300ToDataBase(file, mdfir1300);
        return ResponseEntity.ok(Map.of("Message", "Sheet1300 data uploaded and saved to database"));
    }
}
