package com.efass.memo;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@AllArgsConstructor
public class EfassMemoService {
    private static String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


    private final EfassMemoRepository efassMemoRepository;

    public static List<EfassMemo> excelToEntity(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
            Iterator<Row> rows = sheet.iterator();

            List<EfassMemo> memos = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();

                EfassMemo memo = new EfassMemo();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            memo.setGl_code(currentCell.getStringCellValue());
                            break;

                        case 1:
                            memo.setGl_description(currentCell.getStringCellValue());
                            break;

                        case 2:
                            double drCrValue = currentCell.getNumericCellValue();
                            memo.setDr_cr_ind(drCrValue > 0 ? "DR" : "CR");
                            break;

                        case 3:
                            double amountValue = currentCell.getNumericCellValue();
                            if (amountValue <= 0 && cellsInRow.hasNext()) {
                                currentCell = cellsInRow.next();
                                amountValue = currentCell.getNumericCellValue();
                            }
                            memo.setAmount((int) amountValue);
                            break;

                        case 4:
                            memo.setPeriod(String.valueOf(currentCell.getNumericCellValue()));
                            break;

                        case 5:
                            memo.setYear(String.valueOf(currentCell.getNumericCellValue()));
                            break;

                        case 6:
                            String posting_ind;
                            if (currentCell.getStringCellValue().startsWith("A")) {
                                posting_ind = "A";
                            } else {
                                posting_ind = "M";
                            }
                            memo.setPosting_ind(posting_ind);
                            break;

                        case 7:
                            String posted;
                            if (currentCell.getStringCellValue().equalsIgnoreCase("Yes")) {
                                posted = "P";
                            } else {
                                posted = "N";
                            }
                            memo.setStatus(posted);
                            break;

                        case 8:
                            memo.setCrncy_id((int) currentCell.getNumericCellValue());
                            break;

                        case 9:
                            memo.setCrncy_cd_iso(currentCell.getStringCellValue());
                            break;
                        default:
                            memo.setCreate_dt(new Date());
                            break;
                    }

                    cellIdx++;
                }

                memos.add(memo);
            }

            workbook.close();
            return memos;
        } catch (IOException e) {
            throw new IllegalArgumentException("fail to parse Excel file: " + e.getMessage());
        }
    }

    public void upload(MultipartFile file) {
        if (isValidExcelFile(file)) {
            try {
                List<EfassMemo> data = excelToEntity(file.getInputStream());
                efassMemoRepository.saveAll(data);
            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }else {
            throw new IllegalArgumentException("File is not a valid excel file");
        }
    }

    private EfassMemoDto mapEntityToDto(EfassMemo efassMemo) {
        return EfassMemoDto.builder()
                .id(efassMemo.getId())
                .gl_code(efassMemo.getGl_code())
                .gl_description(efassMemo.getGl_description())
                .dr_cr_ind(efassMemo.getDr_cr_ind())
                .amount(efassMemo.getAmount())
                .period(efassMemo.getPeriod())
                .year(efassMemo.getYear())
                .posting_ind(efassMemo.getPosting_ind())
                .status(efassMemo.getStatus())
                .crncy_id(efassMemo.getCrncy_id())
                .crncy_cd_iso(efassMemo.getCrncy_cd_iso())
                .build();
    }

    public void delete(Integer id) {
        efassMemoRepository.findById(id).ifPresent(efassMemoRepository::delete);
    }

    public EfassMemoDto edit(EfassMemoDto efassMemoDto) {
        EfassMemo efassMemo = efassMemoRepository.findById(efassMemoDto.getId()).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
        efassMemo.setStatus(efassMemoDto.getStatus());
        efassMemo = efassMemoRepository.save(efassMemo);
        return mapEntityToDto(efassMemo);
    }

    public Iterable<EfassMemo> getAll() {
        return efassMemoRepository.findAll();
    }

    public EfassMemo getOne(Integer id) {
        return efassMemoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
    }

    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }
}
