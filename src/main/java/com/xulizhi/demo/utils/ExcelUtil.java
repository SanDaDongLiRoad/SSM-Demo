package com.xulizhi.demo.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ExcelUtil {

    /**
     * 读出excel内容
     *
     * @param
     * @return
     * @throws IOException
     */
    public static List<String[]> getExcelDataOne(File upload) throws IOException {
        // 文件二进制输入流
        InputStream in = new BufferedInputStream(new FileInputStream(upload));
        //解析后的数据集合
        List<String[]> data = new ArrayList<String[]>();
        //读取excel工作簿
        Workbook wb = new XSSFWorkbook(in);
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            // Excel表
            XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(i);
            // excell的行
            Iterator<Row> rit = sheet.rowIterator();
            SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sf2 = new SimpleDateFormat("HH:mm");
            while (rit.hasNext()) {
                XSSFRow row = (XSSFRow) rit.next();
                // 行数
                if (row.getRowNum() == 0) {
                    continue;
                }
                System.out.println("行数：：："+row.getRowNum());
                String[] strArray = new String[row.getLastCellNum()];
                int count = 0;
                for (short j = 0; j < row.getLastCellNum(); j++) {
                    XSSFCell cell = row.getCell(j);
                    if (cell == null) {
                        strArray[count++] = "";
                        continue;
                    }
                    String cellValue = "";
                    switch (cell.getCellType()) {
                        case XSSFCell.CELL_TYPE_NUMERIC:
                            if (HSSFDateUtil.isCellDateFormatted(cell)) {

                                Date date = cell.getDateCellValue();
                                GregorianCalendar cal = new GregorianCalendar();
                                cal.setTime(date);
                                cellValue = cal.get(Calendar.YEAR) < 1950 ? sf2
                                        .format(date) : sf1.format(date);
                            } else {
                                cellValue = cell.getNumericCellValue() + "";
                                //判断是否是科学计数法格式
                                Pattern pattern = Pattern.compile("^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$");
                                if(pattern.matcher(cellValue).matches()){
                                    cellValue = (new BigDecimal(cellValue)).toPlainString();
                                }else {
                                    try {
                                        cellValue = cellValue.substring(0, cellValue
                                                .indexOf("."));
                                    } catch (Exception ignore) {
                                    }
                                }
                            }
                            break;
                        case XSSFCell.CELL_TYPE_STRING:
                            cellValue = cell.getRichStringCellValue().toString();
                            break;
                        case XSSFCell.CELL_TYPE_FORMULA:
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        default:
                            cellValue = "";
                            break;
                    }
                    strArray[count++] = cellValue;
                }
                data.add(strArray);
            }
        }
        //XSSFWorkbook wb = new XSSFWorkbook(in);
        // 如果in不为空，则关闭InputSteam文件输入流
        if (in != null) {
            in.close();
        }
        return data;
    }
}
