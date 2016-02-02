package com.startup.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.startup.control.Constans;
import com.startup.control.Controller;
import com.startup.interfac.ListennerShowTabel;
import com.startup.model.CustomerInfo;
import com.startup.model.EntityBasic;
import com.startup.model.MoneyYearAgo;
import com.startup.model.MoneyYearPresent;
import com.startup.model.StatisticMoneyEarned;

public class ScreenTable extends JFrame implements ListennerShowTabel,
		ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<String, ArrayList<EntityBasic>> mapData;
	Object columnNames[] = { "STT", "Tên", "Mã số thuế", "Có giấy tờ",
			"Tổ chức kinh tế", "Hộ gia đình", "Số nhà, đường phố",
			"Xã, Phường", "Mã đất", "Số nợ phải nộp năm trước",
			"Thừa theo quyết toán năm trước", "Số tiền thuê đất phải nộp",
			"Tổng nộp", "Tổng Nợ" };

	private JButton fixButton = new JButton("Sửa số liệu");
	private JButton deleteButton = new JButton("Xóa số liệu");
	private JButton addButton = new JButton("Thêm số liệu mới");
	private JButton excelButton = new JButton("Xuất ra Excel");
	private JButton settingButton = new JButton("Cấu hình");

	private JDialog dialog;
	private JDialog settingDialog;
	int COLUMN_0_WIDTH = 120;
	DefaultTableModel model;
	JTable table;
	Vector<String> key_HashMap;
	int indexObjectExist = -1;
	int indexObjectFix = -1;
	ScreenAddInfo screen;

	public ScreenTable() {
		key_HashMap = new Vector<String>();
		// setSize(800, 600);
		try {
			// set theme windows
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Exception ex) {
			// Handle Exception
		}
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		mapData = new HashMap<String, ArrayList<EntityBasic>>();
		table = new JTable(model);
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane scrollPane = new JScrollPane(table, v, h);
		scrollPane.setPreferredSize(new Dimension(800, 400));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 3; i < table.getColumnCount(); i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			table.getColumnModel().getColumn(i)
					.setPreferredWidth(column.getWidth() + COLUMN_0_WIDTH);
		}
		add(scrollPane, BorderLayout.CENTER);
		table.setRowHeight(table.getRowHeight() + 20);
		add(scrollPane, BorderLayout.CENTER);
		JPanel btnPanel = new JPanel();
		btnPanel.add(fixButton);
		btnPanel.add(deleteButton);
		btnPanel.add(addButton);
		btnPanel.add(excelButton);
		btnPanel.add(settingButton);
		pack();
		add(btnPanel, BorderLayout.SOUTH);

		Dimension Size = Toolkit.getDefaultToolkit().getScreenSize();
		screen = new ScreenAddInfo(this);
		dialog = new JDialog(this, "Kê Khai Thông Tin", true);
		this.dialog.setResizable(false);
		this.dialog.getContentPane().add(screen);
		this.dialog.pack();
		this.dialog.setSize(600, 450);
		this.dialog.setLocation(
				new Double((Size.getWidth() / 2) - (dialog.getWidth() / 2))
						.intValue(), new Double((Size.getHeight() / 2)
						- (dialog.getHeight() / 2)).intValue());

		JPanel settingPanel = new ScreenSetting1();
		settingDialog = new JDialog(this, "Cấu hình", true);
		this.settingDialog.setResizable(false);
		this.settingDialog.getContentPane().add(settingPanel);
		this.settingDialog.pack();
		this.settingDialog.setSize(450, 220);
		this.settingDialog.setLocation(new Double((Size.getWidth() / 2)
				- (settingDialog.getWidth() / 2)).intValue(),
				new Double((Size.getHeight() / 2)
						- (settingDialog.getHeight() / 2)).intValue());

		deleteButton.addActionListener(this);
		fixButton.addActionListener(this);
		excelButton.addActionListener(this);
		addButton.addActionListener(this);
		settingButton.addActionListener(this);
		createFileSetting();
	}

	public static void main(String[] args) {
		ScreenTable screenTable = new ScreenTable();
		screenTable.setLocationRelativeTo(null);
		screenTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screenTable.setVisible(true);
	}

	@Override
	public void showObjectTable(EntityBasic object_basic) {
		// TODO Auto-generated method stub
		processKeyExist(object_basic);
		dialog.setVisible(false);
	}

	private void processKeyExist(EntityBasic object_basic) {
		ArrayList<EntityBasic> arr = null;
		String key = object_basic.getInfo().getMs_thue() + "-"
				+ object_basic.getInfo().getMs_diemdat();

		if (mapData.containsKey(key)) {
			arr = (ArrayList<EntityBasic>) mapData.get(key);
			if (indexObjectExist < 0 || indexObjectExist >= arr.size()) {
				arr.add(object_basic);
			} else {
				arr.set(indexObjectExist, object_basic);
			}
		} else {
			arr = new ArrayList<EntityBasic>();
			arr.add(object_basic);
			key_HashMap.add(key);
		}
		mapData.put(key, arr);
		Vector<String> vt = new Vector<>();

		CustomerInfo objectInfo = (CustomerInfo) object_basic.getInfo();
		MoneyYearAgo objectMoneyYearAgo = (MoneyYearAgo) object_basic
				.getMoney_year_ago();
		MoneyYearPresent objectMoneyPresent = (MoneyYearPresent) object_basic
				.getMoney_year_present();
		StatisticMoneyEarned objectMoneyEarn = (StatisticMoneyEarned) object_basic
				.getEarned();
		int beginSTT = model.getRowCount();
		vt.add(beginSTT + 1 + "");
		vt.add(objectInfo.getName_used());
		vt.add(objectInfo.getMs_thue());
		if (objectInfo.isGiayTo()) {
			vt.add("X");
		} else {
			vt.add("");
		}

		if (objectInfo.isTc_kt()) {
			vt.add("X");
		} else {
			vt.add("");
		}

		if (objectInfo.isHgd()) {
			vt.add("X");
		} else {
			vt.add("");
		}

		vt.add(objectInfo.getDiachi());
		vt.add(objectInfo.getXa_phuong());
		vt.add(objectInfo.getMs_diemdat());

		vt.add(objectMoneyYearAgo.getTong_nonamtruoc() + "");
		vt.add(objectMoneyYearAgo.getTong_thua_namtruoc() + "");
		vt.add(objectMoneyPresent.getTongThu() + "");
		vt.add(objectMoneyEarn.getTong_nop() + "");
		vt.add(objectMoneyEarn.getThongke_tong() + "");

		model.addRow(vt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addButton) {
//			screen.clearComponent();
			screen.setType(0);
			processAdd();
		} else if (e.getSource() == deleteButton) {
			screen.clearComponent();
			proceesDeleteRow();
		} else if (e.getSource() == fixButton) {
			screen.clearComponent();
			screen.setType(1);
			processFixData();
		} else if (e.getSource() == excelButton) {
			doOutputExcel();
		} else if (e.getSource() == settingButton) {
			processSetting();
		}
	}

	private void processFixData() {
		int rowSelected = table.getSelectedRow();
		if (rowSelected == -1) {
			JOptionPane.showMessageDialog(this, "Hãy chọn ");
		} else {
			EntityBasic entity = resultSelectRow(rowSelected);
			screen.setData(entity);
			dialog.setVisible(true);

		}
	}

	private void processAdd() {
		indexObjectExist = -1;
		screen.clearComponent();
		dialog.setVisible(true);
	}

	private void proceesDeleteRow() {
		int rowSelected = table.getSelectedRow();
		if (rowSelected == -1) {
			JOptionPane.showMessageDialog(this,
					"Bảng chưa có dữ liệu hoặc bạn chưa chọn hàng để xóa");
			return;
		} else {
			convertRowSelectedToIndexMap(rowSelected);
			((DefaultTableModel) table.getModel()).removeRow(rowSelected);
			updateDeleteRowtable();
			// System.out.println("----size map-----" + mapData.size());
		}
	}

	private void processSetting() {
		settingDialog.setVisible(true);

	}

	private void doOutputExcel() {
		// JOptionPane.showInputDialog(null, "Tên file");
		Controller c = new Controller();
		int dataSize = mapData.size();
		if (dataSize == 0) {
			JOptionPane.showMessageDialog(null,
					Constans.DIALOG_MSG_OUT_XLS_CHECK_SIZE,
					Constans.DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		if (dataSize > 0) {
			String result = c.doOuputXls(mapData, key_HashMap);
			if (result.equals(Constans.OUT_RESULT_XLS_SUCCESS)) {
				JOptionPane.showMessageDialog(null,
						Constans.DIALOG_MSG_OUT_XLS_SUCCESS,
						Constans.DIALOG_TITLE, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						Constans.DIALOG_MSG_OUT_XLS_FAILED + result,
						Constans.DIALOG_TITLE, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// phan xoa phan chuyen doi chi so hoi co van de
	private int convertRowSelectedToIndexMap(int rowSelected) {
		int a = 0;
		int sum_after_rowselected = 0;
		for (Entry<String, ArrayList<EntityBasic>> entry : mapData.entrySet()) {
			String key = entry.getKey();
			ArrayList<EntityBasic> value = entry.getValue();
			if ((sum_after_rowselected + value.size() - 1) >= rowSelected) {
				a = rowSelected - sum_after_rowselected;
				System.out.println("a +------" + a);
				value.remove(a);
				if (value.size() == 0) {
					if (key_HashMap.contains(key)) {
						key_HashMap.remove(key);
					}
					mapData.remove(key);
				}
				break;
			}
			sum_after_rowselected += value.size();
		}

		return a;
	}

	private void updateDeleteRowtable() {
		for (int i = 0; i < model.getRowCount(); i++) {
			model.setValueAt(Integer.parseInt((i + 1) + ""), i, 0);
		}
	}

	private EntityBasic resultSelectRow(int rowSelected) {
		int a = 0;
		EntityBasic entity = null;
		int sum_after_rowselected = 0;
		for (Entry<String, ArrayList<EntityBasic>> entry : mapData.entrySet()) {
			ArrayList<EntityBasic> value = entry.getValue();
			if ((sum_after_rowselected + value.size() - 1) >= rowSelected) {
				a = rowSelected - sum_after_rowselected;
				indexObjectFix = a;
				entity = (EntityBasic) value.get(a);
				break;
			}
			sum_after_rowselected += value.size();
		}
		return entity;
	}

	private String createFileSetting() {
		String result = "0";
		String path = System.getProperty("user.dir");
		// set defaul xls
		int fileType = 0;
		BufferedReader br = null;
		try {
			File file = new File(path + "/" + Constans.SETTING_FILENAME);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				File currDir = new File(path);
				if (!currDir.exists()) {
					currDir.mkdir();
				}
				file.createNewFile();
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(fileType + "");
				bw.write("\n");
				bw.write(Constans.DEFAULT_PATH);
				bw.close();
			}
			System.out.println("Done");
			result = "1";
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	@Override
	public void fixObjectTable(EntityBasic object_basic) {
		String key = object_basic.getInfo().getMs_thue() + "-"
				+ object_basic.getInfo().getMs_diemdat();
		ArrayList<EntityBasic> arr = mapData.get(key);
		if (arr != null && arr.size() > 0) {
			arr.set(indexObjectFix, object_basic);
			updateRowFix(object_basic);
			dialog.setVisible(false);
		}
	}

	private void updateRowFix(EntityBasic objec_basic) {
		int rowSelected = table.getSelectedRow();
		CustomerInfo objectInfo = (CustomerInfo) objec_basic.getInfo();
		MoneyYearAgo objectMoneyYearAgo = (MoneyYearAgo) objec_basic
				.getMoney_year_ago();
		MoneyYearPresent objectMoneyPresent = (MoneyYearPresent) objec_basic
				.getMoney_year_present();
		StatisticMoneyEarned objectMoneyEarn = (StatisticMoneyEarned) objec_basic
				.getEarned();
		model.setValueAt(rowSelected + 1, rowSelected, 0);
		model.setValueAt(objectInfo.getName_used(), rowSelected, 1);
		model.setValueAt(objectInfo.getMs_thue(), rowSelected, 2);
		if (objectInfo.isGiayTo()) {
			model.setValueAt("X", rowSelected, 3);
		} else {
			model.setValueAt("", rowSelected, 3);
		}

		if (objectInfo.isTc_kt()) {
			model.setValueAt("X", rowSelected, 4);
		} else {
			model.setValueAt("", rowSelected, 4);
		}

		if (objectInfo.isHgd()) {
			model.setValueAt("X", rowSelected, 5);
		} else {
			model.setValueAt("", rowSelected, 5);
		}
		model.setValueAt(objectInfo.getDiachi(), rowSelected, 6);
		model.setValueAt(objectInfo.getXa_phuong(), rowSelected, 7);
		model.setValueAt(objectInfo.getMs_diemdat(), rowSelected, 8);
		model.setValueAt(objectMoneyYearAgo.getTong_nonamtruoc()+"", rowSelected, 9);
		model.setValueAt(objectMoneyYearAgo.getTong_thua_namtruoc() + "", rowSelected, 10);
		model.setValueAt(objectMoneyPresent.getTongThu() + "", rowSelected, 11);
		model.setValueAt(objectMoneyEarn.getTong_nop() , rowSelected, 12);
		model.setValueAt(objectMoneyEarn.getThongke_tong(), rowSelected, 13);
	}
}
