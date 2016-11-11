package com.liutf.mvc.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExcelOperation {
	Workbook workbook = null;
	boolean isIncludeColunm = true;
	List<String> strList = new ArrayList<String>();
	public final static String DATE_OUTPUT_PATTERNS = "yyyy-MM-dd";
	public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			DATE_OUTPUT_PATTERNS);

	/**
	 * @Title: initinal
	 * @Description: 初始化excelOperation对象
	 * @param 传入file对象
	 * @param isIncludeColunm
	 *            是否包含第一行数据
	 * @return 返回类型 int
	 */
	public int initinal(MultipartFile file, boolean isIncludeColunm) {
		this.isIncludeColunm = isIncludeColunm;
		String fileName = file.getOriginalFilename();
		String[] strs = fileName.split("\\.");
		String suffix = "";
		if (strs.length > 1) {
			suffix = strs[1];
		}
		if (suffix.equals("xls")) {
			try {
				workbook = new HSSFWorkbook(file.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		} else if (suffix.equals("xlsx")) {
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 2;
		} else {
			System.out.println("错误格式");
			return 3;
		}

	}

	public <T> List<T> getObjectDetaiList(Class<T> c) {
		List<T> t = new ArrayList<T>();
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowList = sheet.iterator();
		if (!isIncludeColunm) {
			rowList.next();
		}
		while (rowList.hasNext()) {
			Row row = rowList.next();
			T cl;
			try {
				cl = c.newInstance();
				Field[] me = cl.getClass().getDeclaredFields();
				for (int i = 0; i < 121; i++) {
					Cell cell = row.getCell(i);
					String value = getCellValue(cell);
					me[i + 1].setAccessible(true);

					// System.out.println(me[num].getName());
					me[i + 1].set(cl, value == null ? "null" : value);
					System.out.println(me[i + 1].getName() + "---------------"
							+ value);
					if (me[i + 1].getName().equals("basic_Number")
							&& (value == null || value.equals(""))) {
						return t;
					}
				}
				t.add(cl);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return t;
	}

	public String getCellValue(Cell cell) {
		if (cell == null)
			return "";
		String ret;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			ret = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			ret = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			ret = null;
			break;
		case Cell.CELL_TYPE_FORMULA:
			Workbook wb = cell.getSheet().getWorkbook();
			CreationHelper crateHelper = wb.getCreationHelper();
			FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
			ret = getCellValue(evaluator.evaluateInCell(cell));
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date theDate = cell.getDateCellValue();
				ret = simpleDateFormat.format(theDate);
			} else {
				ret = NumberToTextConverter.toText(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_STRING:
			ret = cell.getRichStringCellValue().getString();
			break;
		default:
			System.out.println("default" + cell.getCellType());
			ret = "";
		}

		return ret; // 有必要自行trim
	}
}
