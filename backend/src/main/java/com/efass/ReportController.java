package com.efass;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.report.ReportService;
import com.efass.sheet.mdfir300.sheet300DAO;
import com.efass.sheet.mdfir300.sheet300_Service;
import com.efass.sheet.mdfir300.sheetQdfir300DAO;
import com.efass.sheet.mdfir302.sheet302DAO;
import com.efass.sheet.mdfir302.sheet302_Service;
import com.efass.sheet.mdfir302.sheetQdfir302DAO;
import com.efass.sheet.mdfir304.sheet304DAO;
import com.efass.sheet.mdfir304.sheet304_Service;
import com.efass.sheet.mdfir304.sheetQdfir304DAO;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheet1000_Service;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir101.sheet101DAO;
import com.efass.sheet.mdfir101.sheet101_Service;
import com.efass.sheet.mdfir101.sheetQdfir101DAO;
import com.efass.sheet.mcfpr1.sheetMcfpr1DAO;
import com.efass.sheet.mcfpr1.sheetMcfpr1_Service;
import com.efass.sheet.mcfpr1.sheetQcfpr1Dao;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir100.sheet100_Service;
import com.efass.sheet.mdfir100.sheetQdfirDAO;
import com.efass.sheet.mdfir1200.sheet1200DAO;
import com.efass.sheet.mdfir1200.sheet1200_Service;
import com.efass.sheet.mdfir1200.sheetQdfir1200DAO;
import com.efass.sheet.mdfir122.sheet122DAO;
import com.efass.sheet.mdfir122.sheet122_Service;
import com.efass.sheet.mdfir122.sheetQdfir122DAO;
import com.efass.sheet.mdfir1300.sheet1300DAO;
import com.efass.sheet.mdfir1300.sheet1300_Service;
import com.efass.sheet.mdfir1300.sheetQdfir1300DAO;
import com.efass.sheet.mdfir1301.sheet1301DAO;
import com.efass.sheet.mdfir1301.sheet1301_Service;
import com.efass.sheet.mdfir1301.sheetQdfir1301DAO;
import com.efass.sheet.mdfir1400.sheet1400DAO;
import com.efass.sheet.mdfir1400.sheet1400_Service;
import com.efass.sheet.mdfir1400.sheetQdfir1400DAO;
import com.efass.sheet.mdfir142.sheet142DAO;
import com.efass.sheet.mdfir142.sheet142_Service;
import com.efass.sheet.mdfir142.sheetQdfir142DAO;
import com.efass.sheet.mdfir1500.sheet1500DAO;
import com.efass.sheet.mdfir1500.sheet1500_Service;
import com.efass.sheet.mdfir1500.sheetQdfir1500DAO;
import com.efass.sheet.mdfir1600.sheet1600DAO;
import com.efass.sheet.mdfir1600.sheet1600_Service;
import com.efass.sheet.mdfir1600.sheetQdfir1600DAO;
import com.efass.sheet.mdfir161.sheet161DAO;
import com.efass.sheet.mdfir161.sheet161_Service;
import com.efass.sheet.mdfir161.sheetQdfir161DAO;
import com.efass.sheet.mdfir1650.sheet1650DAO;
import com.efass.sheet.mdfir1650.sheet1650_Service;
import com.efass.sheet.mdfir1650.sheetQdfir1650DAO;
import com.efass.sheet.mdfir1700.sheet1700DAO;
import com.efass.sheet.mdfir1700.sheet1700_Service;
import com.efass.sheet.mdfir1700.sheetQdfir1700DAO;
import com.efass.sheet.mdfir172.sheet172DAO;
import com.efass.sheet.mdfir172.sheet172_Service;
import com.efass.sheet.mdfir172.sheetQdfir172DAO;
import com.efass.sheet.mdfir182.sheet182DAO;
import com.efass.sheet.mdfir182.sheet182_Service;
import com.efass.sheet.mdfir182.sheetQdfir182DAO;
import com.efass.sheet.mdfir191.sheet191DAO;
import com.efass.sheet.mdfir191.sheet191_Service;
import com.efass.sheet.mdfir191.sheetQdfir191DAO;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheet192_Service;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir193.sheet193DAO;
import com.efass.sheet.mdfir193.sheet193_Service;
import com.efass.sheet.mdfir193.sheetQdfir193DAO;
import com.efass.sheet.mdfir201.sheet201DAO;
import com.efass.sheet.mdfir201.sheet201_Service;
import com.efass.sheet.mdfir201.sheetQdfir201DAO;
import com.efass.sheet.mdfir221.sheet221DAO;
import com.efass.sheet.mdfir221.sheet221_Service;
import com.efass.sheet.mdfir221.sheetQdfir221DAO;
import com.efass.sheet.mdfir223.sheet223DAO;
import com.efass.sheet.mdfir223.sheet223_Service;
import com.efass.sheet.mdfir223.sheetQdfir223DAO;
import com.efass.sheet.mdfir250.sheet250DAO;
import com.efass.sheet.mdfir250.sheet250_Service;
import com.efass.sheet.mdfir250.sheetQdfir250DAO;
import com.efass.sheet.mdfir271.sheet271DAO;
import com.efass.sheet.mdfir271.sheet271_Service;
import com.efass.sheet.mdfir271.sheetQdfir271DAO;
import com.efass.sheet.mdfir291.sheet291DAO;
import com.efass.sheet.mdfir291.sheet291_Service;
import com.efass.sheet.mdfir291.sheetQdfir291DAO;
import com.efass.sheet.mdfir292_1.sheet292_1DAO;
import com.efass.sheet.mdfir292_1.sheet292_1_Service;
import com.efass.sheet.mdfir292_1.sheetQdfir292_1DAO;
import com.efass.sheet.mdfir292_2.sheet292_2DAO;
import com.efass.sheet.mdfir292_2.sheet292_2_Service;
import com.efass.sheet.mdfir292_2.sheetQdfir292_2DAO;
import com.efass.sheet.mdfir292_3.sheet292_3DAO;
import com.efass.sheet.mdfir292_3.sheet292_3_Service;
import com.efass.sheet.mdfir292_3.sheetQdfir292_3DAO;
import com.efass.sheet.mdfir311.sheet311DAO;
import com.efass.sheet.mdfir311.sheet311_Service;
import com.efass.sheet.mdfir311.sheetQdfir311DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.mdfir321.sheet321_Service;
import com.efass.sheet.mdfir321.sheetQdfir321DAO;
import com.efass.sheet.mdfir333.sheet333DAO;
import com.efass.sheet.mdfir333.sheet333_Service;
import com.efass.sheet.mdfir333.sheetQdfir333DAO;
import com.efass.sheet.mdfir363.sheet363DAO;
import com.efass.sheet.mdfir363.sheet363_Service;
import com.efass.sheet.mdfir363.sheetQdfir363DAO;
import com.efass.sheet.mdfir371_1.sheet371_1DAO;
import com.efass.sheet.mdfir371_1.sheet371_1_Service;
import com.efass.sheet.mdfir371_1.sheetQdfir371_1DAO;
import com.efass.sheet.mdfir371_2.sheet371_2DAO;
import com.efass.sheet.mdfir371_2.sheet371_2_Service;
import com.efass.sheet.mdfir371_2.sheetQdfir371_2DAO;
import com.efass.sheet.mdfir371_3.sheet371_3DAO;
import com.efass.sheet.mdfir371_3.sheet371_3_Service;
import com.efass.sheet.mdfir371_3.sheetQdfir371_3DAO;
import com.efass.sheet.mdfir372.sheet372DAO;
import com.efass.sheet.mdfir372.sheet372_Service;
import com.efass.sheet.mdfir372.sheetQdfir372DAO;
import com.efass.sheet.mdfir382.sheet382DAO;
import com.efass.sheet.mdfir382.sheet382_Service;
import com.efass.sheet.mdfir382.sheetQdfir382DAO;
import com.efass.sheet.mdfir400.sheet400_Service;
import com.efass.sheet.mdfir400_1.sheet400_1DAO;
import com.efass.sheet.mdfir400_1.sheet400_1_Service;
import com.efass.sheet.mdfir400_1.sheetQdfir400_1DAO;
import com.efass.sheet.mdfir400_10.sheet400_10DAO;
import com.efass.sheet.mdfir400_10.sheet400_10_Service;
import com.efass.sheet.mdfir400_10.sheetQdfir400_10DAO;
import com.efass.sheet.mdfir400_11.sheet400_11DAO;
import com.efass.sheet.mdfir400_11.sheet400_11_Service;
import com.efass.sheet.mdfir400_11.sheetQdfir400_11DAO;
import com.efass.sheet.mdfir400_12.sheet400_12DAO;
import com.efass.sheet.mdfir400_12.sheet400_12_Service;
import com.efass.sheet.mdfir400_12.sheetQdfir400_12DAO;
import com.efass.sheet.mdfir400_13.sheet400_13DAO;
import com.efass.sheet.mdfir400_13.sheet400_13_Service;
import com.efass.sheet.mdfir400_13.sheetQdfir400_13DAO;
import com.efass.sheet.mdfir400_14.sheet400_14DAO;
import com.efass.sheet.mdfir400_14.sheet400_14_Service;
import com.efass.sheet.mdfir400_14.sheetQdfir400_14DAO;
import com.efass.sheet.mdfir400_15.sheet400_15DAO;
import com.efass.sheet.mdfir400_15.sheet400_15_Service;
import com.efass.sheet.mdfir400_15.sheetQdfir400_15DAO;
import com.efass.sheet.mdfir400_2.sheet400_2DAO;
import com.efass.sheet.mdfir400_2.sheet400_2_Service;
import com.efass.sheet.mdfir400_2.sheetQdfir400_2DAO;
import com.efass.sheet.mdfir400_3.sheet400_3DAO;
import com.efass.sheet.mdfir400_3.sheet400_3_Service;
import com.efass.sheet.mdfir400_3.sheetQdfir400_3DAO;
import com.efass.sheet.mdfir400_4.sheet400_4DAO;
import com.efass.sheet.mdfir400_4.sheet400_4_Service;
import com.efass.sheet.mdfir400_4.sheetQdfir400_4DAO;
import com.efass.sheet.mdfir400_5.sheet400_5DAO;
import com.efass.sheet.mdfir400_5.sheet400_5_Service;
import com.efass.sheet.mdfir400_5.sheetQdfir400_5DAO;
import com.efass.sheet.mdfir400_6.sheet400_6DAO;
import com.efass.sheet.mdfir400_6.sheet400_6_Service;
import com.efass.sheet.mdfir400_6.sheetQdfir400_6DAO;
import com.efass.sheet.mdfir400_7.sheet400_7DAO;
import com.efass.sheet.mdfir400_7.sheet400_7_Service;
import com.efass.sheet.mdfir400_7.sheetQdfir400_7DAO;
import com.efass.sheet.mdfir400_8.sheet400_8DAO;
import com.efass.sheet.mdfir400_8.sheet400_8_Service;
import com.efass.sheet.mdfir400_8.sheetQdfir400_8DAO;
import com.efass.sheet.mdfir400_9.sheet400_9DAO;
import com.efass.sheet.mdfir400_9.sheet400_9_Service;
import com.efass.sheet.mdfir400_9.sheetQdfir400_9DAO;
import com.efass.sheet.mdfir412.sheet412DAO;
import com.efass.sheet.mdfir412.sheet412_Service;
import com.efass.sheet.mdfir412.sheetQdfir412DAO;
import com.efass.sheet.mdfir422.sheet422DAO;
import com.efass.sheet.mdfir422.sheet422_Service;
import com.efass.sheet.mdfir422.sheetQdfir422DAO;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheet423_Service;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir425.sheet425DAO;
import com.efass.sheet.mdfir425.sheet425_Service;
import com.efass.sheet.mdfir425.sheetQdfir425DAO;
import com.efass.sheet.mdfir432.sheet432DAO;
import com.efass.sheet.mdfir432.sheet432_Service;
import com.efass.sheet.mdfir432.sheetQdfir432DAO;
import com.efass.sheet.mdfir450.sheet450_Service;
import com.efass.sheet.mdfir450_1.sheet450_1DAO;
import com.efass.sheet.mdfir450_1.sheet450_1_Service;
import com.efass.sheet.mdfir450_1.sheetQdfir450_1DAO;
import com.efass.sheet.mdfir450_10.sheet450_10DAO;
import com.efass.sheet.mdfir450_10.sheet450_10_Service;
import com.efass.sheet.mdfir450_10.sheetQdfir450_10DAO;
import com.efass.sheet.mdfir450_11.sheet450_11DAO;
import com.efass.sheet.mdfir450_11.sheet450_11_Service;
import com.efass.sheet.mdfir450_11.sheetQdfir450_11DAO;
import com.efass.sheet.mdfir450_12.sheet450_12DAO;
import com.efass.sheet.mdfir450_12.sheet450_12_Service;
import com.efass.sheet.mdfir450_12.sheetQdfir450_12DAO;
import com.efass.sheet.mdfir450_13.sheet450_13DAO;
import com.efass.sheet.mdfir450_13.sheet450_13_Service;
import com.efass.sheet.mdfir450_13.sheetQdfir450_13DAO;
import com.efass.sheet.mdfir450_14.sheet450_14DAO;
import com.efass.sheet.mdfir450_14.sheet450_14_Service;
import com.efass.sheet.mdfir450_14.sheetQdfir450_14DAO;
import com.efass.sheet.mdfir450_15.sheet450_15DAO;
import com.efass.sheet.mdfir450_15.sheet450_15_Service;
import com.efass.sheet.mdfir450_15.sheetQdfir450_15DAO;
import com.efass.sheet.mdfir450_2.sheet450_2DAO;
import com.efass.sheet.mdfir450_2.sheet450_2_Service;
import com.efass.sheet.mdfir450_2.sheetQdfir450_2DAO;
import com.efass.sheet.mdfir450_3.sheet450_3DAO;
import com.efass.sheet.mdfir450_3.sheet450_3_Service;
import com.efass.sheet.mdfir450_3.sheetQdfir450_3DAO;
import com.efass.sheet.mdfir450_4.sheet450_4DAO;
import com.efass.sheet.mdfir450_4.sheet450_4_Service;
import com.efass.sheet.mdfir450_4.sheetQdfir450_4DAO;
import com.efass.sheet.mdfir450_5.sheet450_5DAO;
import com.efass.sheet.mdfir450_5.sheet450_5_Service;
import com.efass.sheet.mdfir450_5.sheetQdfir450_5DAO;
import com.efass.sheet.mdfir450_6.sheet450_6DAO;
import com.efass.sheet.mdfir450_6.sheet450_6_Service;
import com.efass.sheet.mdfir450_6.sheetQdfir450_6DAO;
import com.efass.sheet.mdfir450_7.sheet450_7DAO;
import com.efass.sheet.mdfir450_7.sheet450_7_Service;
import com.efass.sheet.mdfir450_7.sheetQdfir450_7DAO;
import com.efass.sheet.mdfir450_8.sheet450_8DAO;
import com.efass.sheet.mdfir450_8.sheet450_8_Service;
import com.efass.sheet.mdfir450_8.sheetQdfir450_8DAO;
import com.efass.sheet.mdfir450_9.sheet450_9DAO;
import com.efass.sheet.mdfir450_9.sheet450_9_Service;
import com.efass.sheet.mdfir450_9.sheetQdfir450_9DAO;
import com.efass.sheet.mdfir453.sheet453DAO;
import com.efass.sheet.mdfir453.sheet453_Service;
import com.efass.sheet.mdfir453.sheetQdfir453DAO;
import com.efass.sheet.mdfir455.sheet455DAO;
import com.efass.sheet.mdfir455.sheet455_Service;
import com.efass.sheet.mdfir455.sheetQdfir455DAO;
import com.efass.sheet.mdfir493.sheet493DAO;
import com.efass.sheet.mdfir493.sheet493_Service;
import com.efass.sheet.mdfir493.sheetQdfir493DAO;
import com.efass.sheet.mdfir533.sheet533DAO;
import com.efass.sheet.mdfir533.sheet533_Service;
import com.efass.sheet.mdfir533.sheetQdfir533DAO;
import com.efass.sheet.mdfir600.sheet600DAO;
import com.efass.sheet.mdfir600.sheet600_Service;
import com.efass.sheet.mdfir600.sheetQdfir600DAO;
import com.efass.sheet.mdfir601.sheet601DAO;
import com.efass.sheet.mdfir601.sheet601_Service;
import com.efass.sheet.mdfir601.sheetQdfir601DAO;
import com.efass.sheet.mdfir700.sheet700DAO;
import com.efass.sheet.mdfir700.sheet700_Service;
import com.efass.sheet.mdfir700.sheetQdfir700DAO;
import com.efass.sheet.mdfir702.sheet702DAO;
import com.efass.sheet.mdfir702.sheet702_Service;
import com.efass.sheet.mdfir702.sheetQdfir702DAO;
import com.efass.sheet.mdfir800.sheet800DAO;
import com.efass.sheet.mdfir800.sheet800_Service;
import com.efass.sheet.mdfir800.sheetQdfir800DAO;
import com.efass.sheet.mdfir900.sheet900DAO;
import com.efass.sheet.mdfir900.sheet900_Service;
import com.efass.sheet.mdfir900.sheetQdfir900DAO;
import com.efass.sheet.mdfir920.sheet920DAO;
import com.efass.sheet.mdfir920.sheet920_Service;
import com.efass.sheet.mdfir920.sheetQdfir920DAO;
import com.efass.sheet.mdfir921.sheet921DAO;
import com.efass.sheet.mdfir921.sheet921_Service;
import com.efass.sheet.mdfir921.sheetQdfir921DAO;
import com.efass.sheet.mstdr1.sheet001DAO;
import com.efass.sheet.mstdr1.sheet001_Service;
import com.efass.sheet.mstdr1.sheetQstdr1DAO;
import com.efass.sheet.mstdr2.sheet002DAO;
import com.efass.sheet.mstdr2.sheet002_Service;
import com.efass.sheet.mstdr2.sheetQstdr2DAO;
import com.efass.sheet.table.TableService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class ReportController {

	@Autowired
	private sheet221_Service sheet221Svc;

	@Autowired
	private sheet223_Service sheet223Svc;

	@Autowired
	private sheet311_Service sheet311Svc;

	@Autowired
	private sheet321_Service sheet321Svc;

	@Autowired
	private sheet333_Service sheet333Svc;

	@Autowired
	private sheet201_Service sheet201Svc;

	@Autowired
	private sheet191_Service sheet191Svc;

	@Autowired
	private sheet192_Service sheet192Svc;

	@Autowired
	private TableService tableSvc;

	@Autowired
	private sheet1000_Service sheet1000Svc;

	@Autowired
	private ReportService reportSvc;

	@Autowired
	private sheet300_Service sheet300Svc;

	@Autowired
	private sheet100_Service sheet100Svc;

	@Autowired
	private sheet142_Service sheet142Svc;

	@Autowired
	private sheet1200_Service sheet1200Svc;

	@Autowired
	private sheet250_Service sheet250Svc;

	@Autowired
	private sheet271_Service sheet271Svc;

	@Autowired
	private sheet302_Service sheet302Svc;

	@Autowired
	private sheet423_Service sheet423Svc;

	@Autowired
	private sheet533_Service sheet533Svc;

	@Autowired
	private sheet101_Service sheet101Svc;

	@Autowired
	private sheet122_Service sheet122Svc;

	@Autowired
	private sheet161_Service sheet161Svc;

	@Autowired
	private sheet172_Service sheet172Svc;

	@Autowired
	private sheet182_Service sheet182Svc;

	@Autowired
	private sheet193_Service sheet193Svc;

	@Autowired
	private sheet291_Service sheet291Svc;

	@Autowired
	private sheet292_1_Service sheet292_1Svc;

	@Autowired
	private sheet292_2_Service sheet292_2Svc;

	@Autowired
	private sheet292_3_Service sheet292_3Svc;

	@Autowired
	private sheet304_Service sheet304Svc;

	@Autowired
	private sheet363_Service sheet363Svc;

	@Autowired
	private sheet382_Service sheet382Svc;

	@Autowired
	private sheet371_1_Service sheet371_1Svc;

	@Autowired
	private sheet371_2_Service sheet371_2Svc;

	@Autowired
	private sheet371_3_Service sheet371_3Svc;

	@Autowired
	private sheet372_Service sheet372Svc;

	@Autowired
	private sheet400_Service sheet400Svc;

	@Autowired
    private sheet400_1_Service sheet400_1Svc;

	@Autowired
	private sheet400_2_Service sheet400_2Svc;

	@Autowired
	private sheet400_3_Service sheet400_3Svc;

	@Autowired
	private sheet400_4_Service sheet400_4Svc;

	@Autowired
	private sheet400_5_Service sheet400_5Svc;

	@Autowired
	private sheet400_6_Service sheet400_6Svc;

	@Autowired
	private sheet400_7_Service sheet400_7Svc;

	@Autowired
	private sheet400_8_Service sheet400_8Svc;

	@Autowired
	private sheet400_9_Service sheet400_9Svc;

	@Autowired
	private sheet400_10_Service sheet400_10Svc;

	@Autowired
	private sheet400_11_Service sheet400_11Svc;

	@Autowired
	private sheet400_12_Service sheet400_12Svc;

	@Autowired
	private sheet400_13_Service sheet400_13Svc;

	@Autowired
	private sheet400_14_Service sheet400_14Svc;

	@Autowired
	private sheet400_15_Service sheet400_15Svc;

	@Autowired
	private sheet412_Service sheet412Svc;

	@Autowired
	private sheet422_Service sheet422Svc;

	@Autowired
	private sheet425_Service sheet425Svc;

	@Autowired
	private sheet432_Service sheet432Svc;

	@Autowired
	private sheet450_Service sheet450Svc;

	@Autowired
	private sheet450_1_Service sheet450_1Svc;

	@Autowired
	private sheet450_2_Service sheet450_2Svc;

	@Autowired
	private sheet450_3_Service sheet450_3Svc;

	@Autowired
	private sheet450_4_Service sheet450_4Svc;

	@Autowired
	private sheet450_5_Service sheet450_5Svc;

	@Autowired
	private sheet450_6_Service sheet450_6Svc;

	@Autowired
	private sheet450_7_Service sheet450_7Svc;

	@Autowired
	private sheet450_8_Service sheet450_8Svc;

	@Autowired
	private sheet450_9_Service sheet450_9Svc;

	@Autowired
	private sheet450_10_Service sheet450_10Svc;

	@Autowired
	private sheet450_11_Service sheet450_11Svc;

	@Autowired
	private sheet450_12_Service sheet450_12Svc;

	@Autowired
	private sheet450_13_Service sheet450_13Svc;

	@Autowired
	private sheet450_14_Service sheet450_14Svc;

	@Autowired
	private sheet450_15_Service sheet450_15Svc;

	@Autowired
	private sheet453_Service sheet453Svc;

	@Autowired
	private sheet455_Service sheet455Svc;

	@Autowired
	private sheet493_Service sheet493Svc;

	@Autowired
	private sheet600_Service sheet600Svc;

	@Autowired
	private sheet601_Service sheet601Svc;

	@Autowired
	private sheet700_Service sheet700Svc;

	@Autowired
	private sheet702_Service sheet702Svc;

	@Autowired
	private sheet800_Service sheet800Svc;

	@Autowired
	private sheet900_Service sheet900Svc;

	@Autowired
	private sheetMcfpr1_Service sheetMcfpr1Svc;

	@Autowired
	private sheet1300_Service sheet1300Svc;

	@Autowired
	private sheet1301_Service sheet1301Svc;

	@Autowired
	private sheet1400_Service sheet1400Svc;

	@Autowired
	private sheet1500_Service sheet1500Svc;

	@Autowired
	private sheet1600_Service sheet1600Svc;

	@Autowired
	private sheet1650_Service sheet1650Svc;

	@Autowired
	private sheet1700_Service sheet1700Svc;

	@Autowired
	private sheet002_Service sheet002Svc;

	@Autowired
	private sheet001_Service sheet001Svc;

	@Autowired
	private sheet920_Service sheet920Svc;

	@Autowired
	private sheet921_Service sheet921Svc;

	// CHOOSE REPORT DATE
	// You can consume the path .../report/date/2019-04-25
	@RequestMapping("/report/date/{date}")
	public ResponseEntity<?> userAddedSince2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		return reportSvc.selectDate(date);
	}

	// Fetch all table names
	@RequestMapping("/tables/profits")
	public ResponseEntity<?> fetchProfitsChildren() {

		return tableSvc.AssetsTableData();

	}

	// Fetch all table names
	@RequestMapping("/tables/assets")
	public ResponseEntity<?> fetchAssetsChildren() {

		return tableSvc.AssetsTableData();

	}

	// ########################## MDFIR142  ##########################################
	// ####### MONTHLY ##########
	@GetMapping("/mdfir142/{date}")
	public ResponseEntity<?> getAllData142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir142/{date}/{id}")
	public ResponseEntity<?> getDataById142(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir142/{date}")
	public ResponseEntity<?> createData142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet142DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir142/{date}/{id}")
	public ResponseEntity<?> updateData142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet142DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir142/{date}/{id}")
	public ResponseEntity<?> deleteData142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ####### QUARTERLY ##########
	@GetMapping("/qdfir142/{date}")
	public ResponseEntity<?> getAllDataQ142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		System.out.println("DATE : " + date);
		if (evt == true) {
			return sheet142Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir142/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ142(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		// System.out.println("DATE 1 : "+ date);
		if (evt == true) {
			return sheet142Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir142/{date}")
	public ResponseEntity<?> createDataQ142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir142DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir142/{date}/{id}")
	public ResponseEntity<?> updateDataQ142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir142DAO data) throws ResourceNotFoundException {
		data.setId(id);
		System.out.println("DATE 3 : " + date);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir142/{date}/{id}")
	public ResponseEntity<?> deleteDataQ142(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		// System.out.println("DATE 4 : "+ date);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet142Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	 //******************************************************************************************************************

	// ########################## MDFIR161  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir161/{date}")
	public ResponseEntity<?> getAllData161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir161/{date}/{id}")
	public ResponseEntity<?> getDataById161(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir161/{date}")
	public ResponseEntity<?> createData161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet161DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir161/{date}/{id}")
	public ResponseEntity<?> updateData161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet161DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir161/{date}/{id}")
	public ResponseEntity<?> deleteData161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY ############

	@GetMapping("/qdfir161/{date}")
	public ResponseEntity<?> getAllDataQ161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir161/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ161(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir161/{date}")
	public ResponseEntity<?> createDataQ161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir161DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir161/{date}/{id}")
	public ResponseEntity<?> updateDataQ161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir161DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir161/{date}/{id}")
	public ResponseEntity<?> deleteDataQ161(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet161Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
 //******************************************************************************************************************

	// ########################## MDFIR172  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir172/{date}")
	public ResponseEntity<?> getAllData172(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir172/{date}/{id}")
	public ResponseEntity<?> getDataById172(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir172/{date}")
	public ResponseEntity<?> createData172(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet172DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir172/{date}/{id}")
	public ResponseEntity<?> updateData172(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet172DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir172/{date}/{id}")
	public ResponseEntity<?> deleteData172(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir172/{date}")
	public ResponseEntity<?> getAllData172Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir172/{date}/{id}")
	public ResponseEntity<?> getDataById172Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir172/{date}")
	public ResponseEntity<?> createData172Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir172DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir172/{date}/{id}")
	public ResponseEntity<?> updateData172Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir172DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir172/{date}/{id}")
	public ResponseEntity<?> deleteData172Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet172Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR182  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir182/{date}")
	public ResponseEntity<?> getAllData182(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir182/{date}/{id}")
	public ResponseEntity<?> getDataById182(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir182/{date}")
	public ResponseEntity<?> createData182(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet182DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir182/{date}/{id}")
	public ResponseEntity<?> updateData182(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet182DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir182/{date}/{id}")
	public ResponseEntity<?> deleteData182(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir182/{date}")
	public ResponseEntity<?> getAllData182Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir182/{date}/{id}")
	public ResponseEntity<?> getDataById182Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir182/{date}")
	public ResponseEntity<?> createData182Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir182DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir182/{date}/{id}")
	public ResponseEntity<?> updateData182Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir182DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir182/{date}/{id}")
	public ResponseEntity<?> deleteData182Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet182Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR193 ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir193/{date}")
	public ResponseEntity<?> getAllData193(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet193Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir193/{date}/{id}")
	public ResponseEntity<?> getDataById193(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet193Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir193/{date}")
	public ResponseEntity<?> createData193(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet193DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet193Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir193/{date}/{id}")
	public ResponseEntity<?> updateData193(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet193DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet193Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir193/{date}/{id}")
	public ResponseEntity<?> deleteData193(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet193Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY ############
		@GetMapping("/qdfir193/{date}")
		public ResponseEntity<?> getAllData193Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet193Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir193/{date}/{id}")
		public ResponseEntity<?> getDataById193Q(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet193Svc.getDataById(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir193/{date}")
		public ResponseEntity<?> createData193Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir193DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet193Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir193/{date}/{id}")
		public ResponseEntity<?> updateData193Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir193DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet193Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir193/{date}/{id}")
		public ResponseEntity<?> deleteData193Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet193Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}
		//******************************************************************************************************************

	// ########################## MDFIR221  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir221/{date}")
	public ResponseEntity<?> getAllData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir221/{date}/{id}")
	public ResponseEntity<?> getDataById221(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir221/{date}")
	public ResponseEntity<?> createData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet221DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir221/{date}/{id}")
	public ResponseEntity<?> updateData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet221DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir221/{date}/{id}")
	public ResponseEntity<?> deleteData221(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir221/{date}")
	public ResponseEntity<?> getAllData221Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir221/{date}/{id}")
	public ResponseEntity<?> getDataById221Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir221/{date}")
	public ResponseEntity<?> createData221Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir221DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir221/{date}/{id}")
	public ResponseEntity<?> updateData221Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir221DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir221/{date}/{id}")
	public ResponseEntity<?> deleteData221Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet221Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir223  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir223/{date}")
	public ResponseEntity<?> getAllDatamdfir223(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir223/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir223(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir223/{date}")
	public ResponseEntity<?> createDatamdfir223(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet223DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir223/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir223(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet223DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir223/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir223(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir223/{date}")
	public ResponseEntity<?> getAllDatamdfir223Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir223/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir223Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir223/{date}")
	public ResponseEntity<?> createDatamdfir223Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir223DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir223/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir223Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir223DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir223/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir223Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet223Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR300  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir300/{date}")
	public ResponseEntity<?> getAllData300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir300/{date}/{id}")
	public ResponseEntity<?> getDataById300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir300/{date}/{id}")
	public ResponseEntity<?> updateData300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet300DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir300/{date}")
	public ResponseEntity<?> getAllData300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir300/{date}/{id}")
	public ResponseEntity<?> getDataById300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir300/{date}/{id}")
	public ResponseEntity<?> updateData300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir300DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet300Svc.updateDataQ(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR304  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir304/{date}")
	public ResponseEntity<?> getAllData304(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir304/{date}/{id}")
	public ResponseEntity<?> getDataById304(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir304/{date}")
	public ResponseEntity<?> createData304(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet304DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir304/{date}/{id}")
	public ResponseEntity<?> updateData304(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet304DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir304/{date}/{id}")
	public ResponseEntity<?> deleteData304(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir304/{date}")
	public ResponseEntity<?> getAllData304Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir304/{date}/{id}")
	public ResponseEntity<?> getDataById304Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir304/{date}")
	public ResponseEntity<?> createData304Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir304DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir304/{date}/{id}")
	public ResponseEntity<?> updateData304Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir304DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir304/{date}/{id}")
	public ResponseEntity<?> deleteData304Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet304Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir333  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir333/{date}")
	public ResponseEntity<?> getAllDatamdfir333(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir333/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir333(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir333/{date}")
	public ResponseEntity<?> createDatamdfir333(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet333DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir333/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir333(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet333DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir333/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir333(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir333/{date}")
	public ResponseEntity<?> getAllData333Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir333/{date}/{id}")
	public ResponseEntity<?> getDataById333Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir333/{date}")
	public ResponseEntity<?> createData333Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir333DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir333/{date}/{id}")
	public ResponseEntity<?> updateData333Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir333DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir333/{date}/{id}")
	public ResponseEntity<?> deleteData333Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet333Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR100 ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir100/{date}")
	public ResponseEntity<?> getAllData100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir100/{date}/{id}")
	public ResponseEntity<?> getDataById100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir100/{date}/{id}")
	public ResponseEntity<?> updateData100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet100DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir100/{date}")
	public ResponseEntity<?> getAllDataQ100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir100/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir100/{date}/{id}")
	public ResponseEntity<?> updateDataQ100(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfirDAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet100Svc.updateDataQ(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## MDFIR291  ##########################################
	//########### MONTHLY  #############
	@GetMapping("/mdfir291/{date}")
	public ResponseEntity<?> getAllData291(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir291/{date}/{id}")
	public ResponseEntity<?> getDataById291(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir291/{date}")
	public ResponseEntity<?> createData291(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet291DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir291/{date}/{id}")
	public ResponseEntity<?> updateData291(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet291DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir291/{date}/{id}")
	public ResponseEntity<?> deleteData291(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY  #############
	@GetMapping("/qdfir291/{date}")
	public ResponseEntity<?> getAllData291Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir291/{date}/{id}")
	public ResponseEntity<?> getDataById291Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir291/{date}")
	public ResponseEntity<?> createData291Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir291DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir291/{date}/{id}")
	public ResponseEntity<?> updateData291Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir291DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir291/{date}/{id}")
	public ResponseEntity<?> deleteData291Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet291Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//****************************************************************************************************************

	// ########################## MDFIR302 ##########################################
	//########### MONTHLY  #############
	@GetMapping("/mdfir302/{date}")
	public ResponseEntity<?> getAllData302(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir302/{date}/{id}")
	public ResponseEntity<?> getDataById302(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir302/{date}/{id}")
	public ResponseEntity<?> updateData302(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet302DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY  #############
	@GetMapping("/qdfir302/{date}")
	public ResponseEntity<?> getAllData302Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir302/{date}/{id}")
	public ResponseEntity<?> getDataById302Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir302/{date}/{id}")
	public ResponseEntity<?> updateData302Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir302DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet302Svc.updateDataQ(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}
	//****************************************************************************************************************

	// ########################## mdfir311  ##########################################
	//########### MONTHLY  #############
	@GetMapping("/mdfir311/{date}")
	public ResponseEntity<?> getAllData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir311/{date}/{id}")
	public ResponseEntity<?> getDataById311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir311/{date}")
	public ResponseEntity<?> createData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet311DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir311/{date}/{id}")
	public ResponseEntity<?> updateData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet311DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir311/{date}/{id}")
	public ResponseEntity<?> deleteData311(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY  #############
	@GetMapping("/qdfir311/{date}")
	public ResponseEntity<?> getAllData311Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir311/{date}/{id}")
	public ResponseEntity<?> getDataById311Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir311/{date}")
	public ResponseEntity<?> createData311Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir311DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir311/{date}/{id}")
	public ResponseEntity<?> updateData311Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir311DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir311/{date}/{id}")
	public ResponseEntity<?> deleteData311Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet311Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//****************************************************************************************************************

	// ########################## mdfir 321 ################################
	//########### MONTHLY  #############
	@GetMapping("/mdfir321/{date}")
	public ResponseEntity<?> getAllData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir321/{date}/{id}")
	public ResponseEntity<?> getDataById321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir321/{date}")
	public ResponseEntity<?> createData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet321DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir321/{date}/{id}")
	public ResponseEntity<?> updateData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet321DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir321/{date}/{id}")
	public ResponseEntity<?> deleteData321(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY  #############
	@GetMapping("/qdfir321/{date}")
	public ResponseEntity<?> getAllData321Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir321/{date}/{id}")
	public ResponseEntity<?> getDataById321Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir321/{date}")
	public ResponseEntity<?> createData321Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir321DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir321/{date}/{id}")
	public ResponseEntity<?> updateData321Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir321DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir321/{date}/{id}")
	public ResponseEntity<?> deleteData321Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet321Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//****************************************************************************************************************

	// ########################## mdfir201 ##########################
	//##################### MONTHLY #############################
	@GetMapping("/mdfir201/{date}")
	public ResponseEntity<?> getAllData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet201Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir201/{date}/{id}")
	public ResponseEntity<?> getDataById201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet201Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir201/{date}")
	public ResponseEntity<?> createData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet201DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet201Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir201/{date}/{id}")
	public ResponseEntity<?> updateData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet201DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet201Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir201/{date}/{id}")
	public ResponseEntity<?> deleteData201(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet201Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//##################### QUARTERLY #############################
		@GetMapping("/qdfir201/{date}")
		public ResponseEntity<?> getAllData201Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet201Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir201/{date}/{id}")
		public ResponseEntity<?> getDataById201Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet201Svc.getDataById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir201/{date}")
		public ResponseEntity<?> createData201Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir201DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet201Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir201/{date}/{id}")
		public ResponseEntity<?> updateData201Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir201DAO Data) throws ResourceNotFoundException {
			Data.setId(id);
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet201Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir201/{date}/{id}")
		public ResponseEntity<?> deleteData201Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet201Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}


	// ########################## mdfir191 ##########################
	//########### MONTHLY ##############
	@GetMapping("/mdfir191/{date}")
	public ResponseEntity<?> getAllData191(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir191/{date}/{id}")
	public ResponseEntity<?> getDataById191(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir191/{date}")
	public ResponseEntity<?> createData191(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet191DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir191/{date}/{id}")
	public ResponseEntity<?> updateData191(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet191DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir191/{date}/{id}")
	public ResponseEntity<?> deleteData191(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY ##############
	@GetMapping("/qdfir191/{date}")
	public ResponseEntity<?> getAllData191Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir191/{date}/{id}")
	public ResponseEntity<?> getDataById191Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir191/{date}")
	public ResponseEntity<?> createData191Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir191DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir191/{date}/{id}")
	public ResponseEntity<?> updateData191Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir191DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir191/{date}/{id}")
	public ResponseEntity<?> deleteData191Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet191Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//***************************************************************************************************************

	// ########################## mdfir192 ##########################
	//########### MONTHLY ##############
	@GetMapping("/mdfir192/{date}")
	public ResponseEntity<?> getAllData192(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir192/{date}/{id}")
	public ResponseEntity<?> getDataById192(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir192/{date}")
	public ResponseEntity<?> createData192(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet192DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir192/{date}/{id}")
	public ResponseEntity<?> updateData192(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet192DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir192/{date}/{id}")
	public ResponseEntity<?> deleteData192(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########### QUARTERLY ##############
	@GetMapping("/qdfir192/{date}")
	public ResponseEntity<?> getAllData192Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir192/{date}/{id}")
	public ResponseEntity<?> getDataById192Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir192/{date}")
	public ResponseEntity<?> createData192Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir192DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir192/{date}/{id}")
	public ResponseEntity<?> updateData192Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir192DAO Data) throws ResourceNotFoundException {
		Data.setId(id);
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir192/{date}/{id}")
	public ResponseEntity<?> deleteData192Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet192Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	// ########################## MDFIR423 ##########################################

	@GetMapping("/mdfir423/{date}")
	public ResponseEntity<?> getAllData423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet423Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir423/{date}/{id}")
	public ResponseEntity<?> getDataById423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet423Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir423/{date}/{id}")
	public ResponseEntity<?> updateData423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet423DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet423Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR423 ##########################################

		@GetMapping("/qdfir423/{date}")
		public ResponseEntity<?> getAllDataQ423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet423Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir423/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet423Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir423/{date}/{id}")
		public ResponseEntity<?> updateDataQ423(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir423DAO Data) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet423Svc.updateDataQ(id, Data);

			} else {
				return reportSvc.NoDateFound();
			}
		}



	// ########################## MDFIR533 #########################################

	@GetMapping("/mdfir533/{date}")
	public ResponseEntity<?> getAllData533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet533Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir533/{date}/{id}")
	public ResponseEntity<?> getDataById533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet533Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir533/{date}/{id}")
	public ResponseEntity<?> updateData533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet533DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet533Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR533 #########################################

		@GetMapping("/qdfir533/{date}")
		public ResponseEntity<?> getAllDataQ533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet533Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir533/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet533Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir533/{date}/{id}")
		public ResponseEntity<?> updateDataQ533(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir533DAO Data) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet533Svc.updateDataQ(id, Data);

			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ************************************************************************************************************

	// ########################## MDFIR1200  ##########################################
	//########## MONTHLY  ###############
	@GetMapping("/mdfir1200/{date}")
	public ResponseEntity<?> getAllData1200(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1200/{date}/{id}")
	public ResponseEntity<?> getDataById1200(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir1200/{date}/{id}")
	public ResponseEntity<?> updateData1200(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1200DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY  ###############
	@GetMapping("/qdfir1200/{date}")
	public ResponseEntity<?> getAllData1200Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1200/{date}/{id}")
	public ResponseEntity<?> getDataById1200Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir1200/{date}/{id}")
	public ResponseEntity<?> updateData1200(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1200DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1200Svc.updateDataQ(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ************************************************************************************************************

	// ########################## MDFIR 1000 ##########################
	//########## MONTHLY ############
	@GetMapping("/mdfir1000/{date}")
	public ResponseEntity<?> getAllData1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir1000/{date}/{id}")
	public ResponseEntity<?> getDataById1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir1000/{date}/{id}")
	public ResponseEntity<?> updateData1000(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1000DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1000/{date}")
	public ResponseEntity<?> getAllData1000Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir1000/{date}/{id}")
	public ResponseEntity<?> getDataById1000Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir1000/{date}/{id}")
	public ResponseEntity<?> updateData1000Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1000DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1000Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//*******************************************************************************************************************

	// ########################## MDFIR101 #########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir101/{date}")
	public ResponseEntity<?> getAllData101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir101/{date}/{id}")
	public ResponseEntity<?> getDataById101(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir101/{date}")
	public ResponseEntity<?> createData101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet101DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir101/{date}/{id}")
	public ResponseEntity<?> updateData101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet101DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir101/{date}/{id}")
	public ResponseEntity<?> deleteData101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY ############
	@GetMapping("/qdfir101/{date}")
	public ResponseEntity<?> getAllDataQ101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir101/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ101(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir101/{date}")
	public ResponseEntity<?> createDataQ101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir101DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir101/{date}/{id}")
	public ResponseEntity<?> updateDataQ101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir101DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir101/{date}/{id}")
	public ResponseEntity<?> deleteDataQ101(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet101Svc.deleteByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//*******************************************************************************************************************

	// ########################## MDFIR122  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir122/{date}")
	public ResponseEntity<?> getAllData122(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir122/{date}/{id}")
	public ResponseEntity<?> getDataById122(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir122/{date}")
	public ResponseEntity<?> createData122(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet122DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir122/{date}/{id}")
	public ResponseEntity<?> updateData122(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet122DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir122/{date}/{id}")
	public ResponseEntity<?> deleteData122(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY ############
	@GetMapping("/qdfir122/{date}")
	public ResponseEntity<?> getAllData122Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir122/{date}/{id}")
	public ResponseEntity<?> getDataById122Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir122/{date}")
	public ResponseEntity<?> createData122Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir122DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir122/{date}/{id}")
	public ResponseEntity<?> updateData122Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir122DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir122/{date}/{id}")
	public ResponseEntity<?> deleteData122Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet122Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//*******************************************************************************************************************

	// ########################## MDFIR250  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir250/{date}")
	public ResponseEntity<?> getAllData250(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir250/{date}/{id}")
	public ResponseEntity<?> getDataById250(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir250/{date}")
	public ResponseEntity<?> createData250(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet250DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir250/{date}/{id}")
	public ResponseEntity<?> updateData250(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet250DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir250/{date}/{id}")
	public ResponseEntity<?> deleteData250(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir250/{date}")
	public ResponseEntity<?> getAllData250Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir250/{date}/{id}")
	public ResponseEntity<?> getDataById250Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir250/{date}")
	public ResponseEntity<?> createData250Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir250DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir250/{date}/{id}")
	public ResponseEntity<?> updateData250Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir250DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir250/{date}/{id}")
	public ResponseEntity<?> deleteData250Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet250Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//*******************************************************************************************************************

	// ########################## MDFIR271  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir271/{date}")
	public ResponseEntity<?> getAllData271(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir271/{date}/{id}")
	public ResponseEntity<?> getDataById271(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir271/{date}")
	public ResponseEntity<?> createData271(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet271DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir271/{date}/{id}")
	public ResponseEntity<?> updateData271(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet271DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir271/{date}/{id}")
	public ResponseEntity<?> deleteData271(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir271/{date}")
	public ResponseEntity<?> getAllData271Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir271/{date}/{id}")
	public ResponseEntity<?> getDataById271Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir271/{date}")
	public ResponseEntity<?> createData271Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir271DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir271/{date}/{id}")
	public ResponseEntity<?> updateData271Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir271DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir271/{date}/{id}")
	public ResponseEntity<?> deleteData271Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet271Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## MDFIR382 ##########################################

	@GetMapping("/mdfir382/{date}")
	public ResponseEntity<?> getAllData382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet382Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir382/{date}/{id}")
	public ResponseEntity<?> getDataById382(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet382Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir382/{date}")
	public ResponseEntity<?> createData382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet382DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet382Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir382/{date}/{id}")
	public ResponseEntity<?> updateData382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet382DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet382Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir382/{date}/{id}")
	public ResponseEntity<?> deleteData382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet382Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR382 ##########################################

		@GetMapping("/qdfir382/{date}")
		public ResponseEntity<?> getAllDataQ382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet382Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir382/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ382(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet382Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir382/{date}")
		public ResponseEntity<?> createDataQ382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir382DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet382Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir382/{date}/{id}")
		public ResponseEntity<?> updateDataQ382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir382DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet382Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir382/{date}/{id}")
		public ResponseEntity<?> deleteDataQ382(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet382Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR372 ##########################################

	@GetMapping("/mdfir372/{date}")
	public ResponseEntity<?> getAllData372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet372Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir372/{date}/{id}")
	public ResponseEntity<?> getDataById372(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet372Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir372/{date}")
	public ResponseEntity<?> createData372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet372DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet372Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir372/{date}/{id}")
	public ResponseEntity<?> updateData372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet372DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet372Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir372/{date}/{id}")
	public ResponseEntity<?> deleteData372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet372Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ##########################QDFIR372 ##########################################

		@GetMapping("/qdfir372/{date}")
		public ResponseEntity<?> getAllDataQ372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet372Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir372/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ372(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet372Svc.getDataById(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir372/{date}")
		public ResponseEntity<?> createDataQ372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir372DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet372Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir372/{date}/{id}")
		public ResponseEntity<?> updateDataQ372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir372DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet372Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir372/{date}/{id}")
		public ResponseEntity<?> deleteDataQ372(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet372Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## mdfir400_1
	// ##########################################
	@GetMapping("/mdfir400/{date}")
	public ResponseEntity<?> getAllData400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir400/{date}")
	public ResponseEntity<?> getAllDataq400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}


	// ########################## mdfir400_1 ##########################################

    //########## MONTHLY ############
	@GetMapping("/mdfir400.1/{date}")
	public ResponseEntity<?> getAllData400_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.1/{date}/{id}")
	public ResponseEntity<?> getDataById400(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_1Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.1/{date}")
	public ResponseEntity<?> createData400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_1Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.1/{date}/{id}")
	public ResponseEntity<?> updateData400 (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_1Svc.updateData(id,data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.1/{date}/{id}")
	public ResponseEntity<?> deleteData400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_1Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############
    @GetMapping("/qdfir400.1/{date}")
    public ResponseEntity<?> getAllData400_1Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_1Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.1/{date}/{id}")
    public ResponseEntity<?> getDataById400Q(@PathVariable int id, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_1Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.1/{date}")
    public ResponseEntity<?> createData400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                           @RequestBody sheetQdfir400_1DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_1Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.1/{date}/{id}")
    public ResponseEntity<?> updateData400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                    LocalDate date, @PathVariable int id, @RequestBody sheetQdfir400_1DAO data) throws ResourceNotFoundException {
        data.setId(id);
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_1Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.1/{date}/{id}")
    public ResponseEntity<?> deleteData400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                           @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    // ########################## MDFIR400_2// ##########################################
                        //########## MONTHLY ############
	@GetMapping("/mdfir400.2/{date}")
	public ResponseEntity<?> getAllData400_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_2Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.2/{date}/{id}")
	public ResponseEntity<?> getDataById400_2(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_2Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.2/{date}")
	public ResponseEntity<?> createData400_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_2DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_2Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.2/{date}/{id}")
	public ResponseEntity<?> updateData400_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_2DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_2Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.2/{date}/{id}")
	public ResponseEntity<?> deleteData400_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_2Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

                        //########## QUARTERLY ############

    @GetMapping("/qdfir400.2/{date}")
    public ResponseEntity<?> getAllData400_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_2Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.2/{date}/{id}")
    public ResponseEntity<?> getDataById400_2Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_2Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.2/{date}")
    public ResponseEntity<?> createData400_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_2DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_2Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.2/{date}/{id}")
    public ResponseEntity<?> updateData400_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_2DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_2Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.2/{date}/{id}")
    public ResponseEntity<?> deleteData400_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_2Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

	// ########################## MDFIR400_3	// ##########################################
    //########## MONTHLY ############

    @GetMapping("/mdfir400._3/{date}")
	public ResponseEntity<?> getAllData400_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_3Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.3/{date}/{id}")
	public ResponseEntity<?> getDataById400_3(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_3Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.3/{date}")
	public ResponseEntity<?> createData400_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_3DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_3Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.3/{date}/{id}")
	public ResponseEntity<?> updateData400_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_3DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_3Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.3/{date}/{id}")
	public ResponseEntity<?> deleteData400_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_3Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############

    @GetMapping("/qdfir400.3/{date}")
    public ResponseEntity<?> getAllData400_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_3Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.3/{date}/{id}")
    public ResponseEntity<?> getDataById400_3Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_3Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.3/{date}")
    public ResponseEntity<?> createData400_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_3DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_3Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.3/{date}/{id}")
    public ResponseEntity<?> updateData400_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_3DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_3Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.3/{date}/{id}")
    public ResponseEntity<?> deleteData400_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_3Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

	// ########################## MDFIR400_4 // ##########################################
    //########## MONTHLY ############
	@GetMapping("/mdfir400.4/{date}")
	public ResponseEntity<?> getAllData400_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_4Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.4/{date}/{id}")
	public ResponseEntity<?> getDataById400_4(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_4Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.4/{date}")
	public ResponseEntity<?> createData400_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_4DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_4Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.4/{date}/{id}")
	public ResponseEntity<?> updateData400_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_4DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_4Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.4/{date}/{id}")
	public ResponseEntity<?> deleteData400_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_4Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    //########## QUARTERLY ############

    @GetMapping("/qdfir400.4/{date}")
    public ResponseEntity<?> getAllData400_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_4Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qfir400.4/{date}/{id}")
    public ResponseEntity<?> getDataById400_4Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_4Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.4/{date}")
    public ResponseEntity<?> createData400_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_4DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_4Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.4/{date}/{id}")
    public ResponseEntity<?> updateData400_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_4DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_4Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.4/{date}/{id}")
    public ResponseEntity<?> deleteData400_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_4Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## MDFIR400_5	// ##########################################
    //########## MONTHLY ############

	@GetMapping("/mdfir400.5/{date}")
	public ResponseEntity<?> getAllData400_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_5Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.5/{date}/{id}")
	public ResponseEntity<?> getDataById400_5(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_5Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.5/{date}")
	public ResponseEntity<?> createData400_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_5DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_5Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.5/{date}/{id}")
	public ResponseEntity<?> updateData400_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_5DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_5Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.5/{date}/{id}")
	public ResponseEntity<?> deleteData400_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_5Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    //########## QUARTERLY ############
    @GetMapping("/qdfir400.5/{date}")
    public ResponseEntity<?> getAllData400_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_5Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.5/{date}/{id}")
    public ResponseEntity<?> getDataById400_5Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_5Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.5/{date}")
    public ResponseEntity<?> createData400_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_5DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_5Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.5/{date}/{id}")
    public ResponseEntity<?> updateData400_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_5DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_5Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.5/{date}/{id}")
    public ResponseEntity<?> deleteData400_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_5Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }



    // ########################## MDFIR400_6	// ##########################################
//########## MONTHLY ############
	@GetMapping("/mdfir400.6/{date}")
	public ResponseEntity<?> getAllData400_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_6Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.6/{date}/{id}")
	public ResponseEntity<?> getDataById400_6(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_6Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.6/{date}")
	public ResponseEntity<?> createData400_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_6DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_6Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.6/{date}/{id}")
	public ResponseEntity<?> updateData400_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_6DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_6Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.6/{date}/{id}")
	public ResponseEntity<?> deleteData400_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_6Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############
    @GetMapping("/qdfir400.6/{date}")
    public ResponseEntity<?> getAllData400_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_6Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.6/{date}/{id}")
    public ResponseEntity<?> getDataById400_6Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_6Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.6/{date}")
    public ResponseEntity<?> createData400_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_6DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_6Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.6/{date}/{id}")
    public ResponseEntity<?> updateData400_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_6DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_6Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.6/{date}/{id}")
    public ResponseEntity<?> deleteData400_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_6Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## MDFIR400_7	// ##########################################
//########## MONTHLY ############
	@GetMapping("/mdfir400.7/{date}")
	public ResponseEntity<?> getAllData400_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_7Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.7/{date}/{id}")
	public ResponseEntity<?> getDataById400_7(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_7Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.7/{date}")
	public ResponseEntity<?> createData400_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_7DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_7Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.7/{date}/{id}")
	public ResponseEntity<?> updateData400_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_7DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_7Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.7/{date}/{id}")
	public ResponseEntity<?> deleteData400_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_7Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############


    @GetMapping("/qdfir400.7/{date}")
    public ResponseEntity<?> getAllData400_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_7Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.7/{date}/{id}")
    public ResponseEntity<?> getDataById400_7Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_7Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.7/{date}")
    public ResponseEntity<?> createData400_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_7DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_7Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.7/{date}/{id}")
    public ResponseEntity<?> updateData400_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_7DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_7Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.7/{date}/{id}")
    public ResponseEntity<?> deleteData400_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_7Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

	// ########################## MDFIR400_8	// ##########################################
    //########## MONTHLY ############
	@GetMapping("/mdfir400.8/{date}")
	public ResponseEntity<?> getAllData400_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_8Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.8/{date}/{id}")
	public ResponseEntity<?> getDataById400_8(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_8Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.8/{date}")
	public ResponseEntity<?> createData400_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_8DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_8Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.8/{date}/{id}")
	public ResponseEntity<?> updateData400_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_8DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_8Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.8/{date}/{id}")
	public ResponseEntity<?> deleteData400_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_8Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############

    @GetMapping("/qdfir400.8/{date}")
    public ResponseEntity<?> getAllData400_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_8Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.8/{date}/{id}")
    public ResponseEntity<?> getDataById400_8Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_8Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.8/{date}")
    public ResponseEntity<?> createData400_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_8DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_8Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.8/{date}/{id}")
    public ResponseEntity<?> updateData400_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_8DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_8Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.8/{date}/{id}")
    public ResponseEntity<?> deleteData400_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_8Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## MDFIR400_9	// ##########################################
    //########## MONTHLY ############
	@GetMapping("/mdfir400.9/{date}")
	public ResponseEntity<?> getAllData400_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_9Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.9/{date}/{id}")
	public ResponseEntity<?> getDataById400_9(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_9Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.9/{date}")
	public ResponseEntity<?> createData400_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_9DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_9Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.9/{date}/{id}")
	public ResponseEntity<?> updateData400_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_9DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_9Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.9/{date}/{id}")
	public ResponseEntity<?> deleteData400_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_9Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    //########## QUARTERLY ############

    @GetMapping("/qdfir400.9/{date}")
    public ResponseEntity<?> getAllData400_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_9Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.9/{date}/{id}")
    public ResponseEntity<?> getDataById400_9Q(@PathVariable int id,
                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_9Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.9/{date}")
    public ResponseEntity<?> createData400_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @RequestBody sheetQdfir400_9DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_9Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.9/{date}/{id}")
    public ResponseEntity<?> updateData400_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id, @RequestBody sheetQdfir400_9DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_9Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.9/{date}/{id}")
    public ResponseEntity<?> deleteData400_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                             @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_9Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## MDFIR400_10	// ##########################################
// ########################## MONTHLY****************
	@GetMapping("/mdfir400.10/{date}")
	public ResponseEntity<?> getAllData400_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_10Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.10/{date}/{id}")
	public ResponseEntity<?> getDataById400_10(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_10Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.10/{date}")
	public ResponseEntity<?> createData400_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_10DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_10Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.10/{date}/{id}")
	public ResponseEntity<?> updateData400_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_10DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_10Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.10/{date}/{id}")
	public ResponseEntity<?> deleteData400_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_10Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    // ##########################   QUARTERLY  ****************



    @GetMapping("/qdfir400.10/{date}")
    public ResponseEntity<?> getAllData400_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_10Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.10/{date}/{id}")
    public ResponseEntity<?> getDataById400_10Q(@PathVariable int id,
                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_10Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.10/{date}")
    public ResponseEntity<?> createData400_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @RequestBody sheetQdfir400_10DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_10Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.10/{date}/{id}")
    public ResponseEntity<?> updateData400_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id, @RequestBody sheetQdfir400_10DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_10Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.10/{date}/{id}")
    public ResponseEntity<?> deleteData400_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_10Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## MDFIR400_11	// ##########################################
    // ########################## MONTHLY************	****




    @GetMapping("/mdfir400.11/{date}")
	public ResponseEntity<?> getAllData400_11(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_11Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.11/{date}/{id}")
	public ResponseEntity<?> getDataById400_11(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_11Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.11/{date}")
	public ResponseEntity<?> createData400_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_11DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_11Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.11/{date}/{id}")
	public ResponseEntity<?> updateData400_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_11DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_11Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.11/{date}/{id}")
	public ResponseEntity<?> deleteData400_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_11Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

    // ########################## QUARTERLY  ************	****


    @GetMapping("/qdfir400.11/{date}")
    public ResponseEntity<?> getAllData400_11Q(
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_11Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.11/{date}/{id}")
    public ResponseEntity<?> getDataById400_11Q(@PathVariable int id,
                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_11Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.11/{date}")
    public ResponseEntity<?> createData400_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @RequestBody sheetQdfir400_11DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_11Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.11/{date}/{id}")
    public ResponseEntity<?> updateData400_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id, @RequestBody sheetQdfir400_11DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_11Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.11/{date}/{id}")
    public ResponseEntity<?> deleteData400_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_11Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

	// ########################## Mdfir400_12	// ##########################################

    // ########################## MONTHLY  ************	****
	@GetMapping("/mdfir400.12/{date}")
	public ResponseEntity<?> getAllData400_12(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_12Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.12/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir400_12(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_12Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.12/{date}")
	public ResponseEntity<?> createDatamdfir400_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_12DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_12Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.12/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir400_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_12DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_12Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.12/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir400_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_12Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    // ########################## QUARTERLY  ************	****

    @GetMapping("/qdfir400.12/{date}")
    public ResponseEntity<?> getAllData400_12Q(
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_12Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.12/{date}/{id}")
    public ResponseEntity<?> getDataById400_12Q(@PathVariable int id,
                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_12Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.12/{date}")
    public ResponseEntity<?> createData400_12Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @RequestBody sheetQdfir400_12DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_12Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.12/{date}/{id}")
    public ResponseEntity<?> updateData400_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id, @RequestBody sheetQdfir400_12DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_12Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.12/{date}/{id}")
    public ResponseEntity<?> deleteData400_12Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_12Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## Mdfir400_13	// ##########################################
// ########################## MONTHLY  ************	****
	@GetMapping("/mdfir400.13/{date}")
	public ResponseEntity<?> getAllData400_13(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_13Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.13/{date}/{id}")
	public ResponseEntity<?> getDataById400_13(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_13Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.13/{date}")
	public ResponseEntity<?> createData400_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_13DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_13Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.13/{date}/{id}")
	public ResponseEntity<?> updateData400_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_13DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_13Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.13/{date}/{id}")
	public ResponseEntity<?> deleteData400_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_13Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    // ########################## QUARTERLY  ************	****

    @GetMapping("/qdfir400.13/{date}")
    public ResponseEntity<?> getAllData400_13Q(
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_13Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.13/{date}/{id}")
    public ResponseEntity<?> getDataById400_13Q(@PathVariable int id,
                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_13Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.13/{date}")
    public ResponseEntity<?> createData400_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @RequestBody sheetQdfir400_13DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_13Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.13/{date}/{id}")
    public ResponseEntity<?> updateData400_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id, @RequestBody sheetQdfir400_13DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_13Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.13/{date}/{id}")
    public ResponseEntity<?> deleteData400_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                              @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_13Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }



    // ########################## Mdfir400_14	// ##########################################
    // ########################## MONTHLY  ************	****

	@GetMapping("/mdfir400.14/{date}")
	public ResponseEntity<?> getAllDat400_14(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_14Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.14/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir400_14(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_14Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.14/{date}")
	public ResponseEntity<?> createDatamdfir400_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_14DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_14Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.14/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir400_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_14DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_14Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.14/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir400_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_14Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


    // ########################## QUARTERLY  ************	****

    @GetMapping("/qdfir400.14/{date}")
    public ResponseEntity<?> getAllDat400_14Q(
        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_14Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @GetMapping("/qdfir400.14/{date}/{id}")
    public ResponseEntity<?> getDataById400_14Q(@PathVariable int id,
                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_14Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.14/{date}")
    public ResponseEntity<?> createData400_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @RequestBody sheetQdfir400_14DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_14Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.14/{date}/{id}")
    public ResponseEntity<?> updateData400_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id, @RequestBody sheetQdfir400_14DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_14Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.14/{date}/{id}")
    public ResponseEntity<?> deleteData400_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_14Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }


    // ########################## Mdfir400_15	// ##########################################
// ########################## MONTHLY  ************	****
	@GetMapping("/mdfir400.15/{date}")
	public ResponseEntity<?> getAllDatamdfir400_15(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_15Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir400.15/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir400_15(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_15Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir400.15/{date}")
	public ResponseEntity<?> createDatamdfir400_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet400_15DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_15Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir400.15/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir400_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet400_15DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_15Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir400.15/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir400_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet400_15Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
// ########################## QUARTERLY  ************	****

@GetMapping("/qdfir400.15/{date}")
public ResponseEntity<?> getAllData400_15Q(
    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
    Boolean evt = reportSvc.checkDate(date);
    if (evt == true) {
        return sheet400_15Svc.fetchAllData();
    } else {
        return reportSvc.NoDateFound();
    }

}

    @GetMapping("/qdfir400.15/{date}/{id}")
    public ResponseEntity<?> getDataById400_15Q(@PathVariable int id,
                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_15Svc.getDataById(id);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PostMapping("/qdfir400.15/{date}")
    public ResponseEntity<?> createData400_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @RequestBody sheetQdfir400_15DAO data) throws ResourceNotFoundException {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_15Svc.createDataQ(data);
        } else {
            return reportSvc.NoDateFound();
        }

    }

    @PutMapping("/qdfir400.15/{date}/{id}")
    public ResponseEntity<?> updateData400_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id, @RequestBody sheetQdfir400_15DAO data) throws ResourceNotFoundException {
        data.setId(id);

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_15Svc.updateDataQ(id, data);
        } else {
            return reportSvc.NoDateFound();
        }
    }

    @DeleteMapping("/qdfir400.15/{date}/{id}")
    public ResponseEntity<?> deleteData400_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                   @PathVariable int id) throws ResourceNotFoundException {

        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet400_15Svc.deleteById(id);
        } else {
            return reportSvc.NoDateFound();
        }
    }

	// ########################## Mdfir292_1
	// ##########################################

	@GetMapping("/mdfir292.1/{date}")
	public ResponseEntity<?> getAllDatamdfir292_1(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir292.1/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir292_1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir292.1/{date}")
	public ResponseEntity<?> createDatamdfir292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet292_1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir292.1/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet292_1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir292.1/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########### QUARTERLY  #############

	@GetMapping("/qdfir292.1/{date}")
	public ResponseEntity<?> getAllDatamdfirQ292_1(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir292.1/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ292_1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir292.1/{date}")
	public ResponseEntity<?> createDatamdfirQ292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir292_1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir292.1/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir292_1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir292.1/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ292_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_1Svc.deleteByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## Mdfir292_2 ##########################################

	@GetMapping("/mdfir292.2/{date}")
	public ResponseEntity<?> getAllDatamdfir292_2(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir292.2/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir292_2(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir292.2/{date}")
	public ResponseEntity<?> createDatamdfir292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet292_2DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir292.2/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet292_2DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir292.2/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,

			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########################QUARTERLY_QDFIR292_2########################

	@GetMapping("/qdfir292.2/{date}")
	public ResponseEntity<?> getAllDatamdfirQ292_2(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir292.2/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ292_2(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir292.2/{date}")
	public ResponseEntity<?> createDatamdfirQ292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir292_2DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir292.2/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir292_2DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir292.2/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ292_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,

			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_2Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## Mdfir292_3##########################################

	@GetMapping("/mdfir292.3/{date}")
	public ResponseEntity<?> getAllDatamdfir292_3(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir292.3/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir292_3(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir292.3/{date}")
	public ResponseEntity<?> createDatamdfir292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet292_3DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir292.3/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet292_3DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir292.3/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ##############################QUARTERLY_QDFIR292_3

	@GetMapping("/qdfir292.3/{date}")
	public ResponseEntity<?> getAllDatamdfirQ292_3(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir292.3/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ292_3(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir292.3/{date}")
	public ResponseEntity<?> createDatamdfirQ292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir292_3DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir292.3/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir292_3DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir292.3/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ292_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet292_3Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## MDFIR363
	// ##########################################

	@GetMapping("/mdfir363/{date}")
	public ResponseEntity<?> getAllData363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir363/{date}/{id}")
	public ResponseEntity<?> getDataById363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir363/{date}")
	public ResponseEntity<?> createData363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet363DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir363/{date}/{id}")
	public ResponseEntity<?> updateData363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet363DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir363/{date}/{id}")
	public ResponseEntity<?> deleteData363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}



	//################QUARTERLY_QDFIR363################################

	@GetMapping("/qdfir363/{date}")
	public ResponseEntity<?> getAllDataQ363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir363/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir363/{date}")
	public ResponseEntity<?> createDataQ363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir363DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir363/{date}/{id}")
	public ResponseEntity<?> updateDataQ363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir363DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir363/{date}/{id}")
	public ResponseEntity<?> deleteDataQ363(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet363Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

// ########################## Mdfir371_1 ##########################################

	@GetMapping("/mdfir371_1/{date}")
	public ResponseEntity<?> getAllDatamdfir371_1(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir371_1/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir371_1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir371_1/{date}")
	public ResponseEntity<?> createDatamdfir371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet371_1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir371_1/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet371_1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir371_1/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	////##################qdfir371_1#######################################

	@GetMapping("/qdfir371.1/{date}")
	public ResponseEntity<?> getAllDatamdfirQ371_1(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir371.1/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ371_1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir371.1/{date}")
	public ResponseEntity<?> createDatamdfirQ371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir371_1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir371.1/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir371_1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir371.1/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ371_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_1Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## Mdfir371_2 ##########################################

	@GetMapping("/mdfir371_2/{date}")
	public ResponseEntity<?> getAllDatamdfir371_2(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir371_2/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir371_2(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir371_2/{date}")
	public ResponseEntity<?> createDatamdfir371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet371_2DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir371_2/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet371_2DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir371_2/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


////##################qdfir371_2#######################################

	@GetMapping("/qdfir371.2/{date}")
	public ResponseEntity<?> getAllDatamdfirQ371_2(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir371.2/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ371_2(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir371.2/{date}")
	public ResponseEntity<?> createDatamdfirQ371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir371_2DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir371.2/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir371_2DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir371.2/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ371_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_2Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## Mdfir371_3 ##########################################

	@GetMapping("/mdfir371_3/{date}")
	public ResponseEntity<?> getAllDatamdfir371_3(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir371_3/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir371_3(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir371_3/{date}")
	public ResponseEntity<?> createDatamdfir371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet371_3DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir371_3/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet371_3DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir371_3/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

////##################qdfir371_3#######################################

	@GetMapping("/qdfir371.3/{date}")
	public ResponseEntity<?> getAllDatamdfirQ371_3(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir371.3/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfirQ371_3(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir371.3/{date}")
	public ResponseEntity<?> createDatamdfirQ371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir371_3DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir371.3/{date}/{id}")
	public ResponseEntity<?> updateDatamdfirQ371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir371_3DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir371.3/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfirQ371_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet371_3Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## MDFIR412 ##########################################

	@GetMapping("/mdfir412/{date}")
	public ResponseEntity<?> getAllData412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet412Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir412/{date}/{id}")
	public ResponseEntity<?> getDataById412(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet412Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir412/{date}")
	public ResponseEntity<?> createData412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet412DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet412Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir412/{date}/{id}")
	public ResponseEntity<?> updateData412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet412DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet412Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir412/{date}/{id}")
	public ResponseEntity<?> deleteData412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet412Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR412 ##########################################

		@GetMapping("/qdfir412/{date}")
		public ResponseEntity<?> getAllDataQ412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet412Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir412/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ412(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet412Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir412/{date}")
		public ResponseEntity<?> createDataQ412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir412DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet412Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir412/{date}/{id}")
		public ResponseEntity<?> updateDataQ412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir412DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet412Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir412/{date}/{id}")
		public ResponseEntity<?> deleteDataQ412(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet412Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}


	// ########################## MDFIR422 ##########################################

	@GetMapping("/mdfir422/{date}")
	public ResponseEntity<?> getAllData422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet422Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir422/{date}/{id}")
	public ResponseEntity<?> getDataById422(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet422Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir422/{date}")
	public ResponseEntity<?> createData422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet422DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet422Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir422/{date}/{id}")
	public ResponseEntity<?> updateData422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet422DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet422Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir422/{date}/{id}")
	public ResponseEntity<?> deleteData422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet422Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}


	// ########################## MDFIR422 ##########################################

		@GetMapping("/qdfir422/{date}")
		public ResponseEntity<?> getAllDataQ422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet422Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir422/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ422(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet422Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir422/{date}")
		public ResponseEntity<?> createDataQ422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir422DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet422Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir422/{date}/{id}")
		public ResponseEntity<?> updateDataQ422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir422DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet422Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir422/{date}/{id}")
		public ResponseEntity<?> deleteDataQ422(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet422Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}


	// ########################## MDFIR425 ##########################################

	@GetMapping("/mdfir425/{date}")
	public ResponseEntity<?> getAllData425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet425Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir425/{date}/{id}")
	public ResponseEntity<?> getDataById425(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet425Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir425/{date}")
	public ResponseEntity<?> createData425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet425DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet425Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir425/{date}/{id}")
	public ResponseEntity<?> updateData425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet425DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet425Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir425/{date}/{id}")
	public ResponseEntity<?> deleteData425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet425Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR425 ##########################################

		@GetMapping("/qdfir425/{date}")
		public ResponseEntity<?> getAllDataQ425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet425Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir425/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ425(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet425Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir425/{date}")
		public ResponseEntity<?> createDataQ425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir425DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet425Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir425/{date}/{id}")
		public ResponseEntity<?> updateDataQ425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir425DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet425Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir425/{date}/{id}")
		public ResponseEntity<?> deleteDataQ425(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet425Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}
	// ########################## MDFIR432 ##########################################

	@GetMapping("/mdfir432/{date}")
	public ResponseEntity<?> getAllData432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet432Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir432/{date}/{id}")
	public ResponseEntity<?> getDataById432(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet432Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir432/{date}")
	public ResponseEntity<?> createData432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet432DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet432Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir432/{date}/{id}")
	public ResponseEntity<?> updateData432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet432DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet432Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir432/{date}/{id}")
	public ResponseEntity<?> deleteData432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet432Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR432 ##########################################

		@GetMapping("/qdfir432/{date}")
		public ResponseEntity<?> getAllDataQ432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet432Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir432/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ432(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet432Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir432/{date}")
		public ResponseEntity<?> createDataQ432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir432DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet432Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PutMapping("/qdfir432/{date}/{id}")
		public ResponseEntity<?> updateDataQ432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir432DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet432Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir432/{date}/{id}")
		public ResponseEntity<?> deleteDataQ432(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet432Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}
	// ########################## MDFIR453 ##########################################

	@GetMapping("/mdfir453/{date}")
	public ResponseEntity<?> getAllData453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet453Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir453/{date}/{id}")
	public ResponseEntity<?> getDataById453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet453Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir453/{date}")
	public ResponseEntity<?> createData453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet453DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet453Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir453/{date}/{id}")
	public ResponseEntity<?> updateData453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet453DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet453Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir453/{date}/{id}")
	public ResponseEntity<?> deleteData453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet453Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR453 ##########################################

		@GetMapping("/qdfir453/{date}")
		public ResponseEntity<?> getAllDataQ453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet453Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir453/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet453Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir453/{date}")
		public ResponseEntity<?> createDataQ453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir453DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet453Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir453/{date}/{id}")
		public ResponseEntity<?> updateDataQ453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir453DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet453Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir453/{date}/{id}")
		public ResponseEntity<?> deleteDataQ453(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet453Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR455##########################################

	@GetMapping("/mdfir455/{date}")
	public ResponseEntity<?> getAllData455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet455Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir455/{date}/{id}")
	public ResponseEntity<?> getDataById455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet455Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir455/{date}")
	public ResponseEntity<?> createData455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet455DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet455Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir455/{date}/{id}")
	public ResponseEntity<?> updateData455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet455DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet455Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir455/{date}/{id}")
	public ResponseEntity<?> deleteData455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet455Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR455##########################################

		@GetMapping("/qdfir455/{date}")
		public ResponseEntity<?> getAllDataQ455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet455Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir455/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet455Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir455/{date}")
		public ResponseEntity<?> createDataQ455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir455DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet455Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir455/{date}/{id}")
		public ResponseEntity<?> updateDataQ455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir455DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet455Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir455/{date}/{id}")
		public ResponseEntity<?> deleteDataQ455(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet455Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}
	// ########################## MDFIR493##########################################

	@GetMapping("/mdfir493/{date}")
	public ResponseEntity<?> getAllData493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet493Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir493/{date}/{id}")
	public ResponseEntity<?> getDataById493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet493Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir493/{date}")
	public ResponseEntity<?> createData493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet493DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet493Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir493/{date}/{id}")
	public ResponseEntity<?> updateData493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet493DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet493Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir493/{date}/{id}")
	public ResponseEntity<?> deleteData493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet493Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR493##########################################

		@GetMapping("/qdfir493/{date}")
		public ResponseEntity<?> getAllDataQ493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet493Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir493/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet493Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir493/{date}")
		public ResponseEntity<?> createDataQ493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir493DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet493Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir493/{date}/{id}")
		public ResponseEntity<?> updateDataQ493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir493DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet493Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir493/{date}/{id}")
		public ResponseEntity<?> deleteDataQ493(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet493Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}


	// ########################## MDFIR600 ##########################################

	@GetMapping("/mdfir600/{date}")
	public ResponseEntity<?> getAllData600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet600Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir600/{date}/{id}")
	public ResponseEntity<?> getDataById600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet600Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir600/{date}/{id}")
	public ResponseEntity<?> updateData600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet600DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet600Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR600 ##########################################

		@GetMapping("/qdfir600/{date}")
		public ResponseEntity<?> getAllDataQ600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet600Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir600/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet600Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir600/{date}/{id}")
		public ResponseEntity<?> updateDataQ600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir600DAO Data) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet600Svc.updateDataQ(id, Data);

			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR601 ##########################################

	@GetMapping("/mdfir601/{date}")
	public ResponseEntity<?> getAllData601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet601Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir601/{date}/{id}")
	public ResponseEntity<?> getDataById601(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet601Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir601/{date}")
	public ResponseEntity<?> createData601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet601DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet601Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir601/{date}/{id}")
	public ResponseEntity<?> updateData601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet601DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet601Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir601/{date}/{id}")
	public ResponseEntity<?> deleteData601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet601Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR601 ##########################################

		@GetMapping("/qdfir601/{date}")
		public ResponseEntity<?> getAllDataQ601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet601Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@GetMapping("/qdfir601/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ601(@PathVariable int id,
				@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet601Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}

		}

		@PostMapping("/qdfir601/{date}")
		public ResponseEntity<?> createDataQ601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir601DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet601Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir601/{date}/{id}")
		public ResponseEntity<?> updateDataQ601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir601DAO data) throws ResourceNotFoundException {
			data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet601Svc.updateDataQ(id, data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir601/{date}/{id}")
		public ResponseEntity<?> deleteDataQ601(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet601Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR700 ##########################################

	@GetMapping("/mdfir700/{date}")
	public ResponseEntity<?> getAllData700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet700Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir700/{date}/{id}")
	public ResponseEntity<?> getDataById700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet700Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir700/{date}/{id}")
	public ResponseEntity<?> updateData700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet700DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet700Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR700 ##########################################

		@GetMapping("/qdfir700/{date}")
		public ResponseEntity<?> getAllDataQ700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet700Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir700/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet700Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir700/{date}/{id}")
		public ResponseEntity<?> updateDataQ700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir700DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet700Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR702 ##########################################

	@GetMapping("/mdfir702/{date}")
	public ResponseEntity<?> getAllData702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet702Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir702/{date}/{id}")
	public ResponseEntity<?> getDataById702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet702Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir702/{date}")
	public ResponseEntity<?> createData702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet702DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet702Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir702/{date}/{id}")
	public ResponseEntity<?> updateData702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet702DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet702Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir702/{date}/{id}")
	public ResponseEntity<?> deleteData702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet702Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## QDFIR702 ##########################################

		@GetMapping("/qdfir702/{date}")
		public ResponseEntity<?> getAllDataQ702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet702Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir702/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet702Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir702/{date}")
		public ResponseEntity<?> createDataQ702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir702DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet702Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir702/{date}/{id}")
		public ResponseEntity<?> updateDataQ702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir702DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet702Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir702/{date}/{id}")
		public ResponseEntity<?> deleteDataQ702(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet702Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## MDFIR800 ##########################################

	@GetMapping("/mdfir800/{date}")
	public ResponseEntity<?> getAllData800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet800Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir800/{date}/{id}")
	public ResponseEntity<?> getDataById800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet800Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir800/{date}/{id}")
	public ResponseEntity<?> updateData800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet800DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet800Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR800 ##########################################

		@GetMapping("/qdfir800/{date}")
		public ResponseEntity<?> getAllDataQ800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet800Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir800/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet800Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir800/{date}/{id}")
		public ResponseEntity<?> updateDataQ800(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir800DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet800Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

// ########################## MDFIR900 ##########################################

	@GetMapping("/mdfir900/{date}")
	public ResponseEntity<?> getAllData900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet900Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir900/{date}/{id}")
	public ResponseEntity<?> getDataById900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet900Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir900/{date}")
	public ResponseEntity<?> createData900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet900DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet900Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir900/{date}/{id}")
	public ResponseEntity<?> updateData900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet900DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet900Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir900/{date}/{id}")
	public ResponseEntity<?> deleteData900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet900Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## QDFIR900 ##########################################

		@GetMapping("/qdfir900/{date}")
		public ResponseEntity<?> getAllDataQ900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet900Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qdfir900/{date}/{id}")
		public ResponseEntity<?> getDataByIdQ900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet900Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PostMapping("/qdfir900/{date}")
		public ResponseEntity<?> createDataQ900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@RequestBody sheetQdfir900DAO data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet900Svc.createDataQ(data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qdfir900/{date}/{id}")
		public ResponseEntity<?> updateDataQ900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQdfir900DAO Data) throws ResourceNotFoundException {
			Data.setId(id);

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet900Svc.updateDataQ(id, Data);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@DeleteMapping("/qdfir900/{date}/{id}")
		public ResponseEntity<?> deleteDataQ900(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet900Svc.deleteById(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

// ###################################MDFIR920 ##########################################
@PostMapping("/mdfir920/{date}")
public ResponseEntity<?> createData920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                       @RequestBody sheet920DAO data) throws ResourceNotFoundException {
    Boolean evt = reportSvc.checkDate(date);
    if (evt == true) {
        return sheet920Svc.createData(data);
    } else {
        return reportSvc.NoDateFound();
    }
}
	@GetMapping("/mdfir920/{date}")
	public ResponseEntity<?> getAllData920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("mdfir920/{date}/{id}")
	public ResponseEntity<?> getDataById920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir920/{date}/{id}")
	public ResponseEntity<?> updateData920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet920DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ###################################MDFIR920 ##########################################

	@GetMapping("/qdfir920/{date}")
	public ResponseEntity<?> getAllDataQ920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("qdfir920/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir920/{date}/{id}")
	public ResponseEntity<?> updateDataQ920(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir920DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet920Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## MDFIR921 ##########################################

	@GetMapping("/mdfir921/{date}")
	public ResponseEntity<?> getAllData921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mdfir921/{date}/{id}")
	public ResponseEntity<?> getDataById921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/mdfir921/{date}")
	public ResponseEntity<?> createData921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet921DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir921/{date}/{id}")
	public ResponseEntity<?> updateData921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet921DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.updateData(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir921/{date}/{id}")
	public ResponseEntity<?> deleteData921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}


	///////////QUARTERLY

	@GetMapping("/qdfir921/{date}")
	public ResponseEntity<?> getAllDataQ921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir921/{date}/{id}")
	public ResponseEntity<?> getDataByIdQ921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PostMapping("/qdfir921/{date}")
	public ResponseEntity<?> createDataQ921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir921DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir921/{date}/{id}")
	public ResponseEntity<?> updateDataQ921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir921DAO Data) throws ResourceNotFoundException {
		Data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.updateDataQ(id, Data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir921/{date}/{id}")
	public ResponseEntity<?> deleteDataQ921(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet921Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## Mcfpr1 ##########################################
	//########## MONTHLY ############
	@GetMapping("/mcfpr1/{date}")
	public ResponseEntity<?> getAllDataMcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mcfpr1/{date}/{id}")
	public ResponseEntity<?> getDataByIdMcfpr1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mcfpr1/{date}")
	public ResponseEntity<?> createDataMcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetMcfpr1DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mcfpr1/{date}/{id}")
	public ResponseEntity<?> updateDataMcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetMcfpr1DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mcfpr1/{date}/{id}")
	public ResponseEntity<?> deleteDataMcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	//########## QUARTERLY ############
	@GetMapping("/qcfpr1/{date}")
	public ResponseEntity<?> getAllDataQcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qcfpr1/{date}/{id}")
	public ResponseEntity<?> getDataByIdQcfpr1(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.getDataByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qcfpr1/{date}")
	public ResponseEntity<?> createDataQcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQcfpr1Dao data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qcfpr1/{date}/{id}")
	public ResponseEntity<?> updateDataMcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQcfpr1Dao data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qcfpr1/{date}/{id}")
	public ResponseEntity<?> deleteDataQcfpr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheetMcfpr1Svc.deleteByIdQ(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1300  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1300/{date}")
	public ResponseEntity<?> getAllDatamdfir1300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1300/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1300(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1300/{date}")
	public ResponseEntity<?> createDatamdfir1300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1300DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1300/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1300DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1300/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1300(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1300/{date}")
	public ResponseEntity<?> getAllDatamdfir1300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1300/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1300Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1300/{date}")
	public ResponseEntity<?> createDatamdfir1300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1300DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1300/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1300DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1300/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1300Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1300Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1301  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1301/{date}")
	public ResponseEntity<?> getAllDatamdfir1301(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1301/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1301(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1301/{date}")
	public ResponseEntity<?> createDatamdfir1301(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1301DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1301/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1301(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1301DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1301/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1301(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1301/{date}")
	public ResponseEntity<?> getAllDatamdfir1301Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1301/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1301Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1301/{date}")
	public ResponseEntity<?> createDatamdfir1301Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1301DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1301/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1301(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1301DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1301/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1301Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1301Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1400  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1400/{date}")
	public ResponseEntity<?> getAllDatamdfir1400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1400/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1400(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1400/{date}")
	public ResponseEntity<?> createDatamdfir1400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1400DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1400/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1400DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1400/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1400/{date}")
	public ResponseEntity<?> getAllDatamdfir1400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1400/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1400Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1400/{date}")
	public ResponseEntity<?> createDatamdfir1400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1400DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1400/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1400(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1400DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1400/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1400Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1400Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1500  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1500/{date}")
	public ResponseEntity<?> getAllDatamdfir1500(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1500/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1500(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1500/{date}")
	public ResponseEntity<?> createDatamdfir1500(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1500DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1500/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1500(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1500DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1500/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1500(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1500/{date}")
	public ResponseEntity<?> getAllDatamdfir1500Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1500/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1500Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1500/{date}")
	public ResponseEntity<?> createDatamdfir1500Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1500DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1500/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1500Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1500DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1500/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1500Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1500Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1600  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1600/{date}")
	public ResponseEntity<?> getAllDatamdfir1600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1600/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1600(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1600/{date}")
	public ResponseEntity<?> createDatamdfir1600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1600DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mdfir1600/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1600DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1600/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1600(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1600/{date}")
	public ResponseEntity<?> getAllDatamdfir1600Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1600/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1600Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1600/{date}")
	public ResponseEntity<?> createDatamdfir1600Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1600DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/qdfir1600/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1600Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1600DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1600/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1600Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1600Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1650  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1650/{date}")
	public ResponseEntity<?> getAllDatamdfir1650(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1650/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1650(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1650/{date}")
	public ResponseEntity<?> createDatamdfir1650(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1650DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1650/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1650(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1650DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1650/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1650(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1650/{date}")
	public ResponseEntity<?> getAllDatamdfir1650Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/qdfir1650/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1650Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1650/{date}")
	public ResponseEntity<?> createDatamdfir1650Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1650DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1650/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1650(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1650DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1650/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1650Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1650Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	// ########################## Mdfir1700  ##########################################
	//########## MONTHLY ############
	@GetMapping("/mdfir1700/{date}")
	public ResponseEntity<?> getAllDatamdfir1700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@GetMapping("/mdfir1700/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1700(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/mdfir1700/{date}")
	public ResponseEntity<?> createDatamdfir1700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheet1700DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.createData(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/mdfir1700/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet1700DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.updateData(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/mdfir1700/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1700(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//########## QUARTERLY ############
	@GetMapping("/qdfir1700/{date}")
	public ResponseEntity<?> getAllDatamdfir1700Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/qdfir1700/{date}/{id}")
	public ResponseEntity<?> getDataByIdmdfir1700Q(@PathVariable int id,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PostMapping("/qdfir1700/{date}")
	public ResponseEntity<?> createDatamdfir1700Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@RequestBody sheetQdfir1700DAO data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.createDataQ(data);
		} else {
			return reportSvc.NoDateFound();
		}

	}

	@PutMapping("/qdfir1700/{date}/{id}")
	public ResponseEntity<?> updateDatamdfir1700Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheetQdfir1700DAO data) throws ResourceNotFoundException {
		data.setId(id);

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.updateDataQ(id, data);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@DeleteMapping("/qdfir1700/{date}/{id}")
	public ResponseEntity<?> deleteDatamdfir1700Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet1700Svc.deleteById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}
	//******************************************************************************************************************

	  // ########################## mdfir450_1  ##########################################

	@GetMapping("/mdfir450/{date}")
	public ResponseEntity<?> getAllData450(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet450Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}

	}
    //########## QUARTERLY ############

    @GetMapping("/qdfir450/{date}")
    public ResponseEntity<?> getAllData450Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        Boolean evt = reportSvc.checkDate(date);
        if (evt == true) {
            return sheet450Svc.fetchAllData();
        } else {
            return reportSvc.NoDateFound();
        }

    }

	    @GetMapping("/mdfir450.1/{date}")
	    public ResponseEntity<?> getAllData450_1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.1/{date}/{id}")
	    public ResponseEntity<?> getDataById450(@PathVariable int id,
	                                            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.1/{date}")
	    public ResponseEntity<?> createData450(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                           @RequestBody sheet450_1DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.1/{date}/{id}")
	    public ResponseEntity<?> updateData450(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                           @PathVariable int id, @RequestBody sheet450_1DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.1/{date}/{id}")
	    public ResponseEntity<?> deleteData450(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                           @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }


	    //##################### QUARTERLY #############################


	    @GetMapping("/qdfir450.1/{date}")
	    public ResponseEntity<?> getAllData450_1Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.1/{date}/{id}")
	    public ResponseEntity<?> getDataById450Q(@PathVariable int id,
	                                             @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.1/{date}")
	    public ResponseEntity<?> createData450Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                            @RequestBody sheetQdfir450_1DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.1/{date}/{id}")
	    public ResponseEntity<?> updateData450Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                            @PathVariable int id, @RequestBody sheetQdfir450_1DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.1/{date}/{id}")
	    public ResponseEntity<?> deleteData450Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                            @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_1Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_2
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.2/{date}")
	    public ResponseEntity<?> getAllData450_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.2/{date}/{id}")
	    public ResponseEntity<?> getDataById450_2(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.2/{date}")
	    public ResponseEntity<?> createData450_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_2DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.2/{date}/{id}")
	    public ResponseEntity<?> updateData450_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_2DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.2/{date}/{id}")
	    public ResponseEntity<?> deleteData450_2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.2/{date}")
	    public ResponseEntity<?> getAllData450_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.2/{date}/{id}")
	    public ResponseEntity<?> getDataById450_2Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.2/{date}")
	    public ResponseEntity<?> createData450_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_2DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.2/{date}/{id}")
	    public ResponseEntity<?> updateData450_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_2DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.2/{date}/{id}")
	    public ResponseEntity<?> deleteData450_2Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_2Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_3
	    // #################### MONTHLY ######################

	    @GetMapping("/mdfir450.3/{date}")
	    public ResponseEntity<?> getAllData450_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.3/{date}/{id}")
	    public ResponseEntity<?> getDataById450_3(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.3/{date}")
	    public ResponseEntity<?> createData450_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_3DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.3/{date}/{id}")
	    public ResponseEntity<?> updateData450_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_3DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.3/{date}/{id}")
	    public ResponseEntity<?> deleteData450_3(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }


	    // #################### QUARTERLY ######################

	    @GetMapping("/qdfir450.3/{date}")
	    public ResponseEntity<?> getAllData450_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.3/{date}/{id}")
	    public ResponseEntity<?> getDataById450_3Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.3/{date}")
	    public ResponseEntity<?> createData450_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_3DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.3/{date}/{id}")
	    public ResponseEntity<?> updateData450_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_3DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.3/{date}/{id}")
	    public ResponseEntity<?> deleteData450_3Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_3Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_4
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.4/{date}")
	    public ResponseEntity<?> getAllData450_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.4/{date}/{id}")
	    public ResponseEntity<?> getDataById450_4(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.4/{date}")
	    public ResponseEntity<?> createData450_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_4DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.4/{date}/{id}")
	    public ResponseEntity<?> updateData450_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_4DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.4/{date}/{id}")
	    public ResponseEntity<?> deleteData450_4(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.4/{date}")
	    public ResponseEntity<?> getAllData450_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.4/{date}/{id}")
	    public ResponseEntity<?> getDataById450_4Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.4/{date}")
	    public ResponseEntity<?> createData450_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_4DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.4/{date}/{id}")
	    public ResponseEntity<?> updateData450_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_4DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.4/{date}/{id}")
	    public ResponseEntity<?> deleteData450_4Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_4Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_5
	    // ################## MONTHLY ########################

	    @GetMapping("/mdfir450.5/{date}")
	    public ResponseEntity<?> getAllData450_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.5/{date}/{id}")
	    public ResponseEntity<?> getDataById450_5(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.5/{date}")
	    public ResponseEntity<?> createData450_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_5DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.5/{date}/{id}")
	    public ResponseEntity<?> updateData450_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_5DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.5/{date}/{id}")
	    public ResponseEntity<?> deleteData450_5(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ################## QUARTERLY ########################

	    @GetMapping("/qdfir450.5/{date}")
	    public ResponseEntity<?> getAllData450_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.5/{date}/{id}")
	    public ResponseEntity<?> getDataById450_5Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.5/{date}")
	    public ResponseEntity<?> createData450_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_5DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.5/{date}/{id}")
	    public ResponseEntity<?> updateData450_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_5DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.5/{date}/{id}")
	    public ResponseEntity<?> deleteData450_5Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_5Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_6
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.6/{date}")
	    public ResponseEntity<?> getAllData450_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.6/{date}/{id}")
	    public ResponseEntity<?> getDataById450_6(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.6/{date}")
	    public ResponseEntity<?> createData450_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_6DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.6/{date}/{id}")
	    public ResponseEntity<?> updateData450_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_6DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.6/{date}/{id}")
	    public ResponseEntity<?> deleteData450_6(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }


	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.6/{date}")
	    public ResponseEntity<?> getAllData450_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.6/{date}/{id}")
	    public ResponseEntity<?> getDataById450_6Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.6/{date}")
	    public ResponseEntity<?> createData450_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_6DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.6/{date}/{id}")
	    public ResponseEntity<?> updateData450_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	       @PathVariable int id, @RequestBody sheetQdfir450_6DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.6/{date}/{id}")
	    public ResponseEntity<?> deleteData450_6Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_6Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_7
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.7/{date}")
	    public ResponseEntity<?> getAllData450_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.7/{date}/{id}")
	    public ResponseEntity<?> getDataById450_7(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.7/{date}")
	    public ResponseEntity<?> createData450_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_7DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.7/{date}/{id}")
	    public ResponseEntity<?> updateData450_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_7DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.7/{date}/{id}")
	    public ResponseEntity<?> deleteData450_7(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }


	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.7/{date}")
	    public ResponseEntity<?> getAllData450_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.7/{date}/{id}")
	    public ResponseEntity<?> getDataById450_7Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.7/{date}")
	    public ResponseEntity<?> createData450_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_7DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.7/{date}/{id}")
	    public ResponseEntity<?> updateData450_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_7DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.7/{date}/{id}")
	    public ResponseEntity<?> deleteData450_7Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_7Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_8
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.8/{date}")
	    public ResponseEntity<?> getAllData450_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.8/{date}/{id}")
	    public ResponseEntity<?> getDataById450_8(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.8/{date}")
	    public ResponseEntity<?> createData450_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_8DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.8/{date}/{id}")
	    public ResponseEntity<?> updateData450_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_8DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.8/{date}/{id}")
	    public ResponseEntity<?> deleteData450_8(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.8/{date}")
	    public ResponseEntity<?> getAllData450_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.8/{date}/{id}")
	    public ResponseEntity<?> getDataById450_8Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.8/{date}")
	    public ResponseEntity<?> createData450_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_8DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.8/{date}/{id}")
	    public ResponseEntity<?> Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                               @PathVariable int id, @RequestBody sheetQdfir450_8DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.8/{date}/{id}")
	    public ResponseEntity<?> deleteData450_8Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_8Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_9
	    // #################### MONTHLY ######################

	    @GetMapping("/mdfir450.9/{date}")
	    public ResponseEntity<?> getAllData450_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.9/{date}/{id}")
	    public ResponseEntity<?> getDataById450_9(@PathVariable int id,
	                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.9/{date}")
	    public ResponseEntity<?> createData450_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @RequestBody sheet450_9DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.9/{date}/{id}")
	    public ResponseEntity<?> updateData450_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id, @RequestBody sheet450_9DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.9/{date}/{id}")
	    public ResponseEntity<?> deleteData450_9(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                             @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // #################### QUARTERLY ######################

	    @GetMapping("/qdfir450.9/{date}")
	    public ResponseEntity<?> getAllData450_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.9/{date}/{id}")
	    public ResponseEntity<?> getDataById450_9Q(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.9/{date}")
	    public ResponseEntity<?> createData450_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheetQdfir450_9DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.9/{date}/{id}")
	    public ResponseEntity<?> updateData450_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheetQdfir450_9DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.9/{date}/{id}")
	    public ResponseEntity<?> deleteData450_9Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_9Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## MDFIR450_10
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.10/{date}")
	    public ResponseEntity<?> getAllData450_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.10/{date}/{id}")
	    public ResponseEntity<?> getDataById450_10(@PathVariable int id,
	                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.10/{date}")
	    public ResponseEntity<?> createData450_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @RequestBody sheet450_10DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.10/{date}/{id}")
	    public ResponseEntity<?> updateData450_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id, @RequestBody sheet450_10DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.10/{date}/{id}")
	    public ResponseEntity<?> deleteData450_10(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                              @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }
	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.10/{date}")
	    public ResponseEntity<?> getAllData450_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.10/{date}/{id}")
	    public ResponseEntity<?> getDataById450_10Q(@PathVariable int id,
	                                                @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.10/{date}")
	    public ResponseEntity<?> createData450_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                               @RequestBody sheetQdfir450_10DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.10/{date}/{id}")
	    public ResponseEntity<?> updateData450_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                               @PathVariable int id, @RequestBody sheetQdfir450_10DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.10/{date}/{id}")
	    public ResponseEntity<?> deleteData450_10Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                               @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_10Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Mdfir450_11
	    // #################### MONTHLY ######################

	    @GetMapping("/mdfir450.11/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_11(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.11/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_11(@PathVariable int id,
	                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.11/{date}")
	    public ResponseEntity<?> createDatamdfir450_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @RequestBody sheet450_11DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.11/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id, @RequestBody sheet450_11DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.11/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_11(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Qdfir450_11
	    // #################### QUARTERLY ######################

	    @GetMapping("/qdfir450.11/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_11Q(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.11/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_11Q(@PathVariable int id,
	                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.11/{date}")
	    public ResponseEntity<?> createDatamdfir450_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @RequestBody sheetQdfir450_11DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.11/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id, @RequestBody sheetQdfir450_11DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.11/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_11Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_11Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Mdfir450_12
	    // #################### MONTHLY ######################

	    @GetMapping("/mdfir450.12/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_12(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.12/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_12(@PathVariable int id,
	                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.12/{date}")
	    public ResponseEntity<?> createDatamdfir450_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @RequestBody sheet450_12DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.12/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id, @RequestBody sheet450_12DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.12/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_12(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Qdfir450_12
	    // #################### QUARTERLY ######################

	    @GetMapping("/qdfir450.12/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_12Q(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.12/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_12Q(@PathVariable int id,
	                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.12/{date}")
	    public ResponseEntity<?> createDatamdfir450_12Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @RequestBody sheetQdfir450_12DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.12/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_12Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id, @RequestBody sheetQdfir450_12DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.12/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_12Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_12Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Mdfir450_13
	    // ##################### MONTHLY #####################

	    @GetMapping("/mdfir450.13/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_13(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.13/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_13(@PathVariable int id,
	                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.13/{date}")
	    public ResponseEntity<?> createDatamdfir450_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @RequestBody sheet450_13DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.13/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id, @RequestBody sheet450_13DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.13/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_13(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Qdfir450_13
	    // ##################### QUARTERLY #####################

	    @GetMapping("/qdfir450.13/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_13Q(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.13/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_13Q(@PathVariable int id,
	                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.13/{date}")
	    public ResponseEntity<?> createDatamdfir450_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @RequestBody sheetQdfir450_13DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.13/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id, @RequestBody sheetQdfir450_13DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.13/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_13Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_13Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Mdfir450_14
	    // #################### MONTHLY ######################

	    @GetMapping("/mdfir450.14/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_14(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/mdfir450.14/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_14(@PathVariable int id,
	                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/mdfir450.14/{date}")
	    public ResponseEntity<?> createDatamdfir450_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @RequestBody sheet450_14DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/mdfir450.14/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id, @RequestBody sheet450_14DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.14/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_14(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Qdfir450_14
	    // #################### QUARTERLY ######################

	    @GetMapping("/qdfir450.14/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_14Q(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @GetMapping("/qdfir450.14/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_14Q(@PathVariable int id,
	                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PostMapping("/qdfir450.14/{date}")
	    public ResponseEntity<?> createDatamdfir450_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @RequestBody sheetQdfir450_14DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }

	    }

	    @PutMapping("/qdfir450.14/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id, @RequestBody sheetQdfir450_14DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.14/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_14Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_14Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Mdfir450_15
	    // ################### MONTHLY #######################

	    @GetMapping("/mdfir450.15/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_15(
	        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @GetMapping("/mdfir450.15/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_15(@PathVariable int id,
	                                                    @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @PostMapping("/mdfir450.15/{date}")
	    public ResponseEntity<?> createDatamdfir450_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @RequestBody sheet450_15DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.createData(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @PutMapping("/mdfir450.15/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id, @RequestBody sheet450_15DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.updateData(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/mdfir450.15/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_15(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                   @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    // ########################## Qdfir450_15
	    // ################### QUARTERLY #######################

	    @GetMapping("/qdfir450.15/{date}")
	    public ResponseEntity<?> getAllDatamdfir450_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.fetchAllData();
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @GetMapping("/qdfir450.15/{date}/{id}")
	    public ResponseEntity<?> getDataByIdmdfir450_15Q(@PathVariable int id,
	                                                     @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.getDataById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @PostMapping("/qdfir450.15/{date}")
	    public ResponseEntity<?> createDatamdfir450_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @RequestBody sheetQdfir450_15DAO data) throws ResourceNotFoundException {
	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.createDataQ(data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @PutMapping("/qdfir450.15/{date}/{id}")
	    public ResponseEntity<?> updateDatamdfir450_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id, @RequestBody sheetQdfir450_15DAO data) throws ResourceNotFoundException {
	        data.setId(id);

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.updateDataQ(id, data);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }

	    @DeleteMapping("/qdfir450.15/{date}/{id}")
	    public ResponseEntity<?> deleteDatamdfir450_15Q(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
	                                                    @PathVariable int id) throws ResourceNotFoundException {

	        Boolean evt = reportSvc.checkDate(date);
	        if (evt == true) {
	            return sheet450_15Svc.deleteById(id);
	        } else {
	            return reportSvc.NoDateFound();
	        }
	    }


	// ########################## Mstdr1 ##########################################

	@GetMapping("/mstdr1/{date}")
	public ResponseEntity<?> getAllDataMstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet001Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mstdr1/{date}/{id}")
	public ResponseEntity<?> getDataByIdMstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet001Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mstdr1/{date}/{id}")
	public ResponseEntity<?> updateDataMstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet001DAO Data) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet001Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}


	// ########################## Qstdr1 ##########################################

		@GetMapping("/qstdr1/{date}")
		public ResponseEntity<?> getAllDataQstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet001Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qstdr1/{date}/{id}")
		public ResponseEntity<?> getDataByIdQstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet001Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qstdr1/{date}/{id}")
		public ResponseEntity<?> updateDataQstdr1(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQstdr1DAO Data) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet001Svc.updateDataQ(id, Data);

			} else {
				return reportSvc.NoDateFound();
			}
		}

	// ########################## Mstdr2 ##########################################

	@GetMapping("/mstdr2/{date}")
	public ResponseEntity<?> getAllDataMstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet002Svc.fetchAllData();
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@GetMapping("/mstdr2/{date}/{id}")
	public ResponseEntity<?> getDataByIdMstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id) throws ResourceNotFoundException {
		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet002Svc.getDataById(id);
		} else {
			return reportSvc.NoDateFound();
		}
	}

	@PutMapping("/mstdr2/{date}/{id}")
	public ResponseEntity<?> updateDataMstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable int id, @RequestBody sheet002DAO Data) throws ResourceNotFoundException {

		Boolean evt = reportSvc.checkDate(date);
		if (evt == true) {
			return sheet002Svc.updateData(id, Data);

		} else {
			return reportSvc.NoDateFound();
		}
	}

	// ########################## Qstdr2 ##########################################

		@GetMapping("/qstdr2/{date}")
		public ResponseEntity<?> getAllDataQstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet002Svc.fetchAllData();
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@GetMapping("/qstdr2/{date}/{id}")
		public ResponseEntity<?> getDataByIdQstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id) throws ResourceNotFoundException {
			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet002Svc.getDataByIdQ(id);
			} else {
				return reportSvc.NoDateFound();
			}
		}

		@PutMapping("/qstdr2/{date}/{id}")
		public ResponseEntity<?> updateDataQstdr2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
				@PathVariable int id, @RequestBody sheetQstdr2DAO Data) throws ResourceNotFoundException {

			Boolean evt = reportSvc.checkDate(date);
			if (evt == true) {
				return sheet002Svc.updateDataQ(id, Data);

			} else {
				return reportSvc.NoDateFound();
			}
		}

}
