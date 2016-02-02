package com.startup.control;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.IndexedColors;

import com.startup.model.EntityBasic;

public class Controller {
	public final int NUMBER_OF_PARAM = 29;
	public final int ROW_BEGIN = 6;
	public final int NUMBER_CELL_TEXT = 8;
	public final int NUMBER_CELL_NUMERIC = 29;
	public final String CREATE_CELL_STRING = "1";
	public final String CREATE_CELL_BOOLEAN = "2";
	public final String CREATE_CELL_NUMERIC = "3";

	public String doOuputXls(HashMap<String, ArrayList<EntityBasic>> mapData,
			Vector<String> key_hashMap) {
		try {
			String path = System.getProperty("user.dir");
			String fileHeader = path + "/HEADER.xls";

			POIFSFileSystem poiFS = new POIFSFileSystem(new FileInputStream(
					fileHeader));
			HSSFWorkbook wbTemplate = new HSSFWorkbook(poiFS, true);
			HSSFSheet sheetTemplate = wbTemplate.getSheetAt(0);
			DataFormat format = wbTemplate.createDataFormat();
			CellStyle numberStyle = wbTemplate.createCellStyle();

			HSSFCellStyle style = wbTemplate.createCellStyle();
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			
			HSSFCellStyle styleYellow = wbTemplate.createCellStyle();
			styleYellow.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			styleYellow.setFillPattern(CellStyle.SOLID_FOREGROUND);
			styleYellow.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleYellow.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleYellow.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleYellow.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			
			int i = 10;// dong
			for (int j = 0; j < key_hashMap.size(); j++) {
				String key = key_hashMap.get(j);
				if (mapData.containsKey(key)) {
					ArrayList<EntityBasic> arr = mapData.get(key);
					int sizeArr = arr.size();
					int count = 1;
					double tienPhaiNop = 0;
					double tienGhiThu = 0;
					double dienTich = 0;
					String empty = "";
					for (EntityBasic entity : arr) {
						HSSFRow row1 = sheetTemplate.createRow(i);
						HSSFCell cell1 = null;
						createRow(entity, row1, cell1, i, style);
						tienGhiThu += entity.getMoney_year_present()
								.getSoTienGhiThu();
						dienTich += entity.getMoney_year_present()
								.getDienTich();
						if (sizeArr > 1 && count == sizeArr) {
							System.out.println("them");
							i++;
							row1 = sheetTemplate.createRow(i);
							// double tienThueDat = ;
							entity.getMoney_year_present().setSoTienGhiThu(
									tienGhiThu);
							entity.getMoney_year_present().setDonGia(0);
							entity.getMoney_year_present()
									.setDienTich(dienTich);
							double tienMienGiam = entity
									.getMoney_year_present()
									.getSoTienMienGiam();
							entity.getMoney_year_present().setTongThu(
									tienGhiThu - tienMienGiam);

							double noNamTruoc = entity.getMoney_year_ago()
									.getTong_nonamtruoc()
									- entity.getEarned()
											.getNop_cho_no_namtruoc();
							entity.getEarned().setThongke_no_namtruoc(
									noNamTruoc);
							
							double noRieng2015 = entity.getMoney_year_present()
									.getTongThu()
									- entity.getMoney_year_ago()
									.getTong_thua_namtruoc()
									- entity.getEarned()
									.getNop_cho_namnay();
							entity.getEarned()
									.setThongke_no_namnay(noRieng2015);
							
							entity.getEarned().setThongke_tong(
									noNamTruoc + noRieng2015);
							createRow(entity, row1, cell1, i, styleYellow);

						}
						count++;
						i++;
					}
				}
			}

			String newFile = getPathOuputSetting() + "/" + "newFile.xls";
			FileOutputStream fos = new FileOutputStream(newFile, false);
			wbTemplate.write(fos);
			fos.flush();
			fos.close();
			return Constans.OUT_RESULT_XLS_SUCCESS;
		} catch (FileNotFoundException ex) {
			// return ex.getMessage();
			return "Đóng tệp Excel đang mở trước khi xuất file";
		} catch (IOException e) {
			return "Tệp Excel không tồn tại";
		}
	}

	public void createCell(String createType, HSSFRow row, HSSFCell cell,
			int j, int cellType, String cellValue, HSSFCellStyle style) {
		cell = row.createCell(j);
		cell.setCellStyle(style);
		if (createType.equals(CREATE_CELL_STRING)) {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		} else if (createType.equals(CREATE_CELL_BOOLEAN)) {
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		}
		String temp = "";
		try {
			DecimalFormat df = new DecimalFormat("#");
			df.setMinimumFractionDigits(0);
			double s = Double.parseDouble(cellValue);
			temp = df.format(s);

		} catch (Exception e) {
			temp = cellValue;
		}

		cell.setCellValue(temp);
	}

	public void createRow(EntityBasic entity, HSSFRow row1, HSSFCell cell1,
			int i, HSSFCellStyle style) {
		createCell(CREATE_CELL_STRING, row1, cell1, 0,
				HSSFCell.CELL_TYPE_STRING, i - 9 + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 1,
				HSSFCell.CELL_TYPE_STRING, entity.getInfo().getName_used(),
				style);
		createCell(CREATE_CELL_STRING, row1, cell1, 2,
				HSSFCell.CELL_TYPE_STRING, entity.getInfo().getMs_thue(), style);
		String tc_kt = entity.getInfo().isTc_kt() ? "X" : "";
		createCell(CREATE_CELL_STRING, row1, cell1, 3,
				HSSFCell.CELL_TYPE_STRING, tc_kt, style);
		String hgd = entity.getInfo().isHgd() ? "X" : "";
		createCell(CREATE_CELL_STRING, row1, cell1, 4,
				HSSFCell.CELL_TYPE_STRING, hgd, style);

		createCell(CREATE_CELL_STRING, row1, cell1, 5,
				HSSFCell.CELL_TYPE_STRING, entity.getInfo().getDiachi(), style);
		createCell(CREATE_CELL_STRING, row1, cell1, 6,
				HSSFCell.CELL_TYPE_STRING, entity.getInfo().getXa_phuong(),
				style);
		createCell(CREATE_CELL_STRING, row1, cell1, 7,
				HSSFCell.CELL_TYPE_STRING, entity.getInfo().getMs_diemdat(),
				style);
		createCell(CREATE_CELL_STRING, row1, cell1, 8,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getTong_nonamtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 9,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getNo_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 10,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getTang_no_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 11,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getGiam_no_namtruoc() + "", style);

		createCell(CREATE_CELL_STRING, row1, cell1, 12,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getTong_thua_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 13,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getThua_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 14,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getTang_thua_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 15,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_ago()
						.getGiam_thua_namtruoc() + "", style);

		createCell(CREATE_CELL_STRING, row1, cell1, 16,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_present()
						.getTongThu() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 17,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_present()
						.getDienTich() + "", style);
		double donGia = entity.getMoney_year_present().getDonGia();
		createCell(CREATE_CELL_STRING, row1, cell1, 18,
				HSSFCell.CELL_TYPE_STRING, (donGia == 0 ? "" : donGia) + "",
				style);
		createCell(CREATE_CELL_STRING, row1, cell1, 19,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_present()
						.getThoigian() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 20,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_present()
						.getSoTienGhiThu() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 21,
				HSSFCell.CELL_TYPE_STRING, entity.getMoney_year_present()
						.getSoTienMienGiam() + "", style);

		createCell(CREATE_CELL_STRING, row1, cell1, 22,
				HSSFCell.CELL_TYPE_STRING, entity.getEarned().getTong_nop()
						+ "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 23,
				HSSFCell.CELL_TYPE_STRING, entity.getEarned()
						.getNop_cho_no_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 24,
				HSSFCell.CELL_TYPE_STRING, entity.getEarned()
						.getNop_cho_namnay() + "", style);

		double cellValue26 = entity.getEarned().getThongke_tong();
		createCell(CREATE_CELL_STRING, row1, cell1, 25,
				HSSFCell.CELL_TYPE_STRING, (cellValue26 < 0 ? "" : cellValue26)
						+ "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 26,
				HSSFCell.CELL_TYPE_STRING, entity.getEarned()
						.getThongke_no_namtruoc() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 27,
				HSSFCell.CELL_TYPE_STRING, entity.getEarned()
						.getThongke_no_namnay() + "", style);
		createCell(CREATE_CELL_STRING, row1, cell1, 28,
				HSSFCell.CELL_TYPE_STRING,
				(cellValue26 < 0 ? Math.abs(cellValue26) : 0d) + "", style);
	}

	public String getHSSFCellValue(HSSFCell cell, DataFormat format,
			CellStyle numberStyle) {
		if (cell == null) {
			return null;
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			double val = cell.getNumericCellValue();
			DecimalFormat df = new DecimalFormat("#,##0.00");
			int fractionalDigits = 2;// 2 chu so thap fan
			df.setMaximumFractionDigits(fractionalDigits);
			String val1 = df.format(val);
			return val1;
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue() + "";
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
			return cell.getErrorCellValue() + "";
		} else {
			return null;
		}
	}

	public String getPathOuputSetting() {
		String path = System.getProperty("user.dir");
		// read ouput path
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path + "/"
					+ Constans.SETTING_FILENAME));
			int fileTypeIndex = Integer.parseInt(br.readLine());
			path = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return path;
	}

	public boolean isNumber(JTextField txtField) {
		try {
			String input = txtField.getText().trim();
			if (input.equals(""))
				return true;
			Double.parseDouble(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Double getTxtDouble(Component txtField) {
		DecimalFormat df = new DecimalFormat("#");
		df.setMinimumFractionDigits(0);
		String input = "";
		if (txtField instanceof JTextField) {
			input = ((JTextField) txtField).getText().trim();
		}
		if (txtField instanceof JLabel) {
			input = ((JLabel) txtField).getText().trim();
		}
		if (input.equals("") || input == null) {
			return 0d;
		} else {
			return Double.parseDouble(input);
		}
	}

	public String formatNumber(Double inputValue) {
		NumberFormat nf = NumberFormat
				.getNumberInstance(new Locale("de", "DE"));
		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("###,##0");// lam tron 3chu so
		String output = df.format((inputValue));
		return output;
	}

	public int checkMDD(String mdd) {
		int result = 0;
		int length = mdd.length();
		if (length > 0 && length < 10)
			result = 1;
		return result;
	}
	/**
	 * @param args
	 */
	public void main(String[] args) {
		String path = "C:/excel_template/Mau01.xls";
		String new_file = "C:/excel_template/new.xls";
		// readXLSFile2(path, new_file);
		// getTemplate();

	}
}
