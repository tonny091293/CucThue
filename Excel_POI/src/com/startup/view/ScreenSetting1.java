package com.startup.view;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.startup.control.Constans;

public class ScreenSetting1 extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 450;
	private final int HEIGHT = 200;
	private JTextField txtPath;
	private JButton btnEditPath;
	private JButton btnCancel;
	private JButton btnSave;
	private JComboBox cbbFileType;

	/**
	 * @wbp.nonvisual location=164,309
	 */
	private JFileChooser fileChooser = null;

	/**
	 * Create the panel.
	 */
	public ScreenSetting1() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		// setSize(width, height);
		JLabel lblnhDng = new JLabel("Định dạng");
		lblnhDng.setBounds(10, 10, 100, 30);
		add(lblnhDng);

		txtPath = new JTextField();
		txtPath.setEditable(false);
		txtPath.setBounds(120, 60, 250, 30);
		add(txtPath);
		txtPath.setColumns(10);

		JLabel lblngDn = new JLabel("Đường dẫn");
		lblngDn.setBounds(10, 60, 100, 30);
		add(lblngDn);

		cbbFileType = new JComboBox();
		cbbFileType.setModel(new DefaultComboBoxModel(new String[] {
				".xls (Excel 2003-2007)", ".xlsx (Excel 2011)" }));
		cbbFileType.setSelectedIndex(0);
		cbbFileType.setBounds(120, 10, 150, 30);
		add(cbbFileType);

		btnEditPath = new JButton("Sửa");
		btnEditPath.addActionListener(this);
		btnEditPath.setBounds(380, 60, 60, 30);
		add(btnEditPath);

		btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(this);
		btnCancel.setBounds(380, 142, 60, 30);
		add(btnCancel);

		btnSave = new JButton("Lưu");
		btnSave.addActionListener(this);
		btnSave.setBounds(310, 142, 60, 30);
		add(btnSave);
		doInit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		String result = null;
		if (obj == btnEditPath) {
			System.out.println("btn edit");
			doEditPath();
		} else if (obj == btnSave) {
			System.out.println("btn save");
			result = doSave();
			if (result.equals("1")) {
				System.out.println("thanh cong");
			} else {
				System.out.println(result);
			}
		} else if (obj == btnCancel) {
			System.out.println("btn cancel");
			doClosePanel();
		}
	}

	public void doInit() {
		String path = System.getProperty("user.dir");
		// read ouput path
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path + "/"
					+ Constans.SETTING_FILENAME));
			int fileTypeIndex = Integer.parseInt(br.readLine());
			String txtOutputPath = br.readLine();
			cbbFileType.setSelectedIndex(fileTypeIndex > 1 ? 0 : fileTypeIndex);
			txtPath.setText(txtOutputPath);
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
	}

	public void doEditPath() {
		String outputPath = txtPath.getText().trim();
		File currDir = new File(outputPath);
		if (!currDir.exists()) {
			currDir.mkdir();
		}
		final JFileChooser openFC = new JFileChooser(new File(outputPath));
		openFC.setDialogType(JFileChooser.SAVE_DIALOG);
		openFC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int resultOpen = openFC.showSaveDialog(null);
		if (resultOpen == JFileChooser.APPROVE_OPTION) {
			txtPath.setText(openFC.getSelectedFile().toString());
		} else if (resultOpen == JFileChooser.CANCEL_OPTION) {
			System.out.println("null");
		} else {
			System.out.println("er");
		}
	}

	public String doSave() {
		String result = "0";
		String path = System.getProperty("user.dir");
		int fileType = cbbFileType.getSelectedIndex();
		String outputPath = txtPath.getText().trim();
		try {
			File file = new File(path + "/" + Constans.SETTING_FILENAME);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(fileType + "");
			bw.write("\n");
			bw.write(outputPath);
			bw.close();
			result = "1";
			doClosePanel();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	public void doClosePanel() {
		Window w = SwingUtilities.getWindowAncestor(ScreenSetting1.this);
		w.setVisible(false);
	}

}
