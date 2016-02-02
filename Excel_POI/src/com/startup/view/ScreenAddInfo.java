package com.startup.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.startup.control.Controller;
import com.startup.interfac.ListennerShowTabel;
import com.startup.model.CustomerInfo;
import com.startup.model.EntityBasic;
import com.startup.model.MoneyYearAgo;
import com.startup.model.MoneyYearPresent;
import com.startup.model.StatisticMoneyEarned;

public class ScreenAddInfo extends JPanel implements KeyListener,
		FocusListener, ChangeListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String WARN_ERR = "Lỗi";
	private static final String WARN_ERR_NUMBER_FORMAT_CONTENT = "Dữ liệu nhập ko phải dạng số";
	private static final String WARN_ERR_MDD = "Mã điểm đất tối đa có 10 ký tự";
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel panel_1 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private Controller c = new Controller();
	private JButton btnAddRow;

	JLabel label_earnYearAgo_view;
	JLabel label_resultNoYearAgo;
	JLabel label_resultNoYearPre;
	JLabel label_resultPayYear;
	JLabel label_resultPhainop;
	JLabel label_noyearAgo_view;
	JLabel label_dcTang_view;
	JLabel label_dcGiam_view;
	JLabel label_resultThua;
	JLabel label_thuayearAgo_view;
	JLabel label_dcThuaTang_view;
	JLabel label_dcThuaGiam_view;
	JLabel label_resultTongThu;
	JLabel label_dientich_view;
	JLabel label_thoiGian_view;
	JLabel label_mienGiam_view;
	JLabel label_dongia_view;
	JLabel label_resultGhiThu_view;
	JLabel label_earnYearPre_view;
	JLabel label_resultThua_view;
	JLabel label_resultPhainop_view;
	JLabel label_resultTongThu_view;
	JLabel label_resultEarn_view;
	JLabel label_resultNoYearAgo_view;
	JLabel label_resultNoYearPre_view;
	JLabel label_resultPayYear_view;

	private JTextField textField;
	private JTextField txt_nsd;
	private JTextField txt_noYearAgo;
	private JTextField txt_mst;
	private JTextField txt_dc;
	private JTextField txt_xp;
	private JTextField txt_mdd;
	private JTextField txt_dcTang;
	private JTextField txt_dcGiam;
	private JTextField txt_thuaYearAgo;
	private JTextField txt_dcThuaTang;
	private JTextField txt_dcThuaGiam;
	private JTextField txt_dientich;
	private JTextField txt_donGia;
	private JTextField txt_thoiGian;
	private JTextField txt_tienMienGiam;
	private JTextField txt_earnYearAgo;
	private JTextField txt_earnYearPre;

	private JLabel label_resultEarn;
	private JTextField txt_resultGhiThu;
	private JRadioButton rd_giayto;
	JRadioButton rd_khongGiayto;
	JRadioButton rd_tckt;
	JRadioButton rd_hgd;

	JTabbedPane tabPanel;
	CustomerInfo info = null;
	MoneyYearAgo moneyYearAgo = null;
	MoneyYearPresent moneyYearPresent = null;
	StatisticMoneyEarned statisticMoneyEearned = null;

	ListennerShowTabel listen_show_table;

	int m_type = 0;

	// =0 : tao moi
	// =1 : sua

	/**
	 * Create the panel.
	 */
	public ScreenAddInfo(ListennerShowTabel listen_show_table) {
		setLayout(null);
		this.listen_show_table = listen_show_table;
		tabbedPane.setBounds(0, 0, 600, 450);
		add(tabbedPane);
		JPanel panel_0 = new JPanel();
		tabbedPane.addTab("Thông tin", null, panel_0, null);
		panel_0.setLayout(null);

		JLabel lblStt = new JLabel("STT");
		lblStt.setBounds(10, 10, 100, 30);
		panel_0.add(lblStt);

		JLabel lblTnNgiS = new JLabel("Tên người sử dụng");
		lblTnNgiS.setBounds(10, 90, 100, 30);
		panel_0.add(lblTnNgiS);

		rd_giayto = new JRadioButton("Có giấy tờ");
		buttonGroup.add(rd_giayto);
		rd_giayto.setSelected(true);
		rd_giayto.setBounds(10, 50, 100, 30);
		panel_0.add(rd_giayto);

		rd_khongGiayto = new JRadioButton("Không có giấy tờ");
		buttonGroup.add(rd_khongGiayto);
		rd_khongGiayto.setBounds(120, 50, 120, 30);
		panel_0.add(rd_khongGiayto);

		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		textField.setBounds(120, 10, 230, 30);
		panel_0.add(textField);

		txt_nsd = new JTextField();
		txt_nsd.setText("Công ty CP Đồng Xuân");
		txt_nsd.setColumns(10);
		txt_nsd.setBounds(120, 90, 230, 30);
		panel_0.add(txt_nsd);

		JLabel lblMSThu = new JLabel("Mã số thuế");
		lblMSThu.setBounds(10, 130, 100, 30);
		panel_0.add(lblMSThu);

		txt_mst = new JTextField();
		txt_mst.setText("0100254713");
		txt_mst.setColumns(10);
		txt_mst.setBounds(120, 130, 230, 30);
		panel_0.add(txt_mst);

		JLabel lblLoiHnhKinh = new JLabel("Loại hình kinh tế");
		lblLoiHnhKinh.setBounds(10, 170, 100, 30);
		panel_0.add(lblLoiHnhKinh);

		rd_tckt = new JRadioButton("Tổ chức kinh tế");
		buttonGroup1.add(rd_tckt);
		rd_tckt.setSelected(true);
		rd_tckt.setBounds(120, 170, 100, 30);
		panel_0.add(rd_tckt);

		rd_hgd = new JRadioButton("Hộ gia đình");
		buttonGroup1.add(rd_hgd);
		rd_hgd.setBounds(230, 170, 120, 30);
		panel_0.add(rd_hgd);

		JLabel lblSNhng = new JLabel("Số nhà, đường, phố");
		lblSNhng.setBounds(10, 210, 100, 30);
		panel_0.add(lblSNhng);

		txt_dc = new JTextField();
		txt_dc.setText("Chợ Đồng Xuân");
		txt_dc.setColumns(10);
		txt_dc.setBounds(120, 210, 230, 30);
		panel_0.add(txt_dc);

		JLabel lblXPhng = new JLabel("Xã, phường");
		lblXPhng.setBounds(10, 250, 100, 30);
		panel_0.add(lblXPhng);

		txt_xp = new JTextField();
		txt_xp.setText("Đồng Xuân");
		txt_xp.setColumns(10);
		txt_xp.setBounds(120, 250, 230, 30);
		panel_0.add(txt_xp);

		JLabel lblMimt = new JLabel("Mã điểm đất");
		lblMimt.setBounds(10, 292, 100, 30);
		panel_0.add(lblMimt);

		txt_mdd = new JTextField();
		txt_mdd.setText("TXU0020");
		txt_mdd.setColumns(10);
		txt_mdd.setBounds(120, 291, 230, 30);
		panel_0.add(txt_mdd);
		tabbedPane.addTab("Năm trước", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNTheoQuyt = new JLabel("Nợ theo quyết toán năm trước");
		lblNTheoQuyt.setBounds(10, 50, 150, 30);
		panel_1.add(lblNTheoQuyt);

		txt_noYearAgo = new JTextField();
		txt_noYearAgo.setText("2000000");
		txt_noYearAgo.setColumns(10);
		txt_noYearAgo.setBounds(200, 50, 180, 30);
		panel_1.add(txt_noYearAgo);

		JLabel lbliuChnhTng = new JLabel("Điều chỉnh Tăng");
		lbliuChnhTng.setBounds(10, 90, 150, 30);
		panel_1.add(lbliuChnhTng);

		JLabel lbliuChnhGim = new JLabel("Điều chỉnh Giảm");
		lbliuChnhGim.setBounds(10, 130, 150, 30);
		panel_1.add(lbliuChnhGim);

		JLabel lblSNPhi = new JLabel("Số nợ phải nộp");
		lblSNPhi.setBounds(10, 170, 150, 30);
		panel_1.add(lblSNPhi);

		JLabel lblThaTheoQuyt = new JLabel("Thừa theo quyết toán năm trước");
		lblThaTheoQuyt.setBounds(10, 250, 170, 30);
		panel_1.add(lblThaTheoQuyt);

		JLabel lbliuChnhTng_1 = new JLabel("Điều chỉnh Tăng");
		lbliuChnhTng_1.setBounds(10, 290, 150, 30);
		panel_1.add(lbliuChnhTng_1);

		JLabel lbliuChnhGim_1 = new JLabel("Điều chỉnh Giảm");
		lbliuChnhGim_1.setBounds(10, 330, 150, 30);
		panel_1.add(lbliuChnhGim_1);

		JLabel lblTngTinTha = new JLabel("Tổng tiền thừa");
		lblTngTinTha.setBounds(10, 370, 150, 30);
		panel_1.add(lblTngTinTha);

		txt_dcTang = new JTextField();
		txt_dcTang.setText("500000");
		txt_dcTang.setColumns(10);
		txt_dcTang.setBounds(200, 90, 180, 30);
		panel_1.add(txt_dcTang);

		label_noyearAgo_view = new JLabel("");
		label_noyearAgo_view.setBounds(390, 50, 180, 30);
		panel_1.add(label_noyearAgo_view);

		txt_dcGiam = new JTextField();
		txt_dcGiam.setText("0");
		txt_dcGiam.setColumns(10);
		txt_dcGiam.setBounds(200, 130, 180, 30);
		panel_1.add(txt_dcGiam);

		txt_thuaYearAgo = new JTextField();
		txt_thuaYearAgo.setColumns(10);
		txt_thuaYearAgo.setBounds(200, 250, 180, 30);
		panel_1.add(txt_thuaYearAgo);

		txt_dcThuaTang = new JTextField();
		txt_dcThuaTang.setColumns(10);
		txt_dcThuaTang.setBounds(200, 290, 180, 30);
		panel_1.add(txt_dcThuaTang);

		txt_dcThuaGiam = new JTextField();
		txt_dcThuaGiam.setText("0");
		txt_dcThuaGiam.setColumns(10);
		txt_dcThuaGiam.setBounds(200, 330, 180, 30);
		panel_1.add(txt_dcThuaGiam);

		label_dcTang_view = new JLabel("");
		label_dcTang_view.setBounds(390, 90, 180, 30);
		panel_1.add(label_dcTang_view);

		label_dcGiam_view = new JLabel("");
		label_dcGiam_view.setBounds(390, 130, 180, 30);
		panel_1.add(label_dcGiam_view);

		label_resultPhainop_view = new JLabel("");
		label_resultPhainop_view.setBounds(390, 170, 180, 30);
		panel_1.add(label_resultPhainop_view);

		label_thuayearAgo_view = new JLabel("");
		label_thuayearAgo_view.setBounds(390, 250, 180, 30);
		panel_1.add(label_thuayearAgo_view);

		label_dcThuaTang_view = new JLabel("");
		label_dcThuaTang_view.setBounds(390, 290, 180, 30);
		panel_1.add(label_dcThuaTang_view);

		label_dcThuaGiam_view = new JLabel("");
		label_dcThuaGiam_view.setBounds(390, 330, 180, 30);
		panel_1.add(label_dcThuaGiam_view);

		label_resultThua_view = new JLabel("");
		label_resultThua_view.setBounds(390, 370, 180, 30);
		panel_1.add(label_resultThua_view);

		label_resultPhainop = new JLabel("");
		label_resultPhainop.setBounds(200, 170, 180, 30);
		panel_1.add(label_resultPhainop);

		label_resultThua = new JLabel("");
		label_resultThua.setBounds(200, 370, 180, 30);
		panel_1.add(label_resultThua);

		JLabel lblTinNNm = new JLabel("TIỀN NỢ NĂM TRƯỚC");
		lblTinNNm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinNNm.setBounds(10, 11, 575, 30);
		panel_1.add(lblTinNNm);

		JLabel lblTinThaNm = new JLabel("TIỀN THỪA NĂM TRƯỚC");
		lblTinThaNm.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinThaNm.setBounds(10, 211, 575, 30);
		panel_1.add(lblTinThaNm);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Năm nay", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblSTinThu = new JLabel("SỐ TIỀN THUÊ ĐẮT PHẢI NỘP CỦA NĂM 2015");
		lblSTinThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSTinThu.setBounds(10, 11, 575, 30);
		panel_2.add(lblSTinThu);

		JLabel lblDinTchTnh = new JLabel("Diện tích tính");
		lblDinTchTnh.setBounds(10, 50, 150, 30);
		panel_2.add(lblDinTchTnh);

		txt_dientich = new JTextField();
		txt_dientich.setText("600");
		txt_dientich.setColumns(10);
		txt_dientich.setBounds(200, 50, 180, 30);
		panel_2.add(txt_dientich);

		label_dientich_view = new JLabel("");
		label_dientich_view.setBounds(390, 50, 180, 30);
		panel_2.add(label_dientich_view);

		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setBounds(10, 90, 150, 30);
		panel_2.add(lblnGi);

		txt_donGia = new JTextField();
		txt_donGia.setText("60000");
		txt_donGia.setColumns(10);
		txt_donGia.setBounds(200, 90, 180, 30);
		panel_2.add(txt_donGia);

		JLabel lblThiGianThu = new JLabel("Thời gian thuê");
		lblThiGianThu.setBounds(10, 130, 150, 30);
		panel_2.add(lblThiGianThu);

		txt_thoiGian = new JTextField();
		txt_thoiGian.setText("365");
		txt_thoiGian.setColumns(10);
		txt_thoiGian.setBounds(200, 130, 180, 30);
		panel_2.add(txt_thoiGian);

		label_thoiGian_view = new JLabel("");
		label_thoiGian_view.setBounds(390, 130, 180, 30);
		panel_2.add(label_thoiGian_view);

		JLabel lblSTinGhi = new JLabel("Số tiền ghi thu");
		lblSTinGhi.setBounds(10, 170, 150, 30);
		panel_2.add(lblSTinGhi);

		label_resultGhiThu_view = new JLabel("");
		label_resultGhiThu_view.setBounds(390, 170, 180, 30);
		panel_2.add(label_resultGhiThu_view);

		JLabel lblSTinc = new JLabel("Số tiền được miễn giảm");
		lblSTinc.setBounds(10, 210, 150, 30);
		panel_2.add(lblSTinc);

		txt_tienMienGiam = new JTextField();
		txt_tienMienGiam.setText("8000000");
		txt_tienMienGiam.setColumns(10);
		txt_tienMienGiam.setBounds(200, 210, 180, 30);
		panel_2.add(txt_tienMienGiam);

		JLabel lblTngTinThu = new JLabel("Tổng tiền thu");
		lblTngTinThu.setBounds(10, 251, 150, 30);
		panel_2.add(lblTngTinThu);

		label_resultTongThu = new JLabel("");
		label_resultTongThu.setBounds(200, 251, 180, 30);
		panel_2.add(label_resultTongThu);

		label_mienGiam_view = new JLabel("");
		label_mienGiam_view.setBounds(390, 210, 180, 30);
		panel_2.add(label_mienGiam_view);

		label_resultTongThu_view = new JLabel("");
		label_resultTongThu_view.setBounds(390, 251, 180, 30);
		panel_2.add(label_resultTongThu_view);

		label_dongia_view = new JLabel("");
		label_dongia_view.setBounds(390, 90, 180, 30);
		panel_2.add(label_dongia_view);

		txt_resultGhiThu = new JTextField();
		txt_resultGhiThu.setEditable(false);
		txt_resultGhiThu.setText("");
		txt_resultGhiThu.setColumns(10);
		txt_resultGhiThu.setBounds(200, 171, 180, 30);
		panel_2.add(txt_resultGhiThu);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Đã nộp năm 2015", null, panel_3, null);
		panel_3.setLayout(null);

		btnAddRow = new JButton("Lưu");
		btnAddRow.setBounds(234, 333, 108, 44);
		panel_3.add(btnAddRow);

		JLabel lblSTinThu_1 = new JLabel("SỐ TIỀN THUÊ ĐẮT ĐÃ NỘP CỦA NĂM 2015");
		lblSTinThu_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSTinThu_1.setBounds(10, 11, 575, 30);
		panel_3.add(lblSTinThu_1);

		JLabel lblNpNCa = new JLabel("Nộp nợ của năm trước");
		lblNpNCa.setBounds(10, 50, 150, 30);
		panel_3.add(lblNpNCa);

		txt_earnYearAgo = new JTextField();
		txt_earnYearAgo.setText("500000");
		txt_earnYearAgo.setColumns(10);
		txt_earnYearAgo.setBounds(200, 50, 180, 30);
		panel_3.add(txt_earnYearAgo);

		label_earnYearAgo_view = new JLabel("");
		label_earnYearAgo_view.setBounds(390, 50, 180, 30);
		panel_3.add(label_earnYearAgo_view);

		JLabel lblNpNCa_1 = new JLabel("Nộp nợ của năm nay");
		lblNpNCa_1.setBounds(10, 90, 150, 30);
		panel_3.add(lblNpNCa_1);

		txt_earnYearPre = new JTextField();
		txt_earnYearPre.setText("30000000");
		txt_earnYearPre.setColumns(10);
		txt_earnYearPre.setBounds(200, 90, 180, 30);
		panel_3.add(txt_earnYearPre);

		label_earnYearPre_view = new JLabel("");
		label_earnYearPre_view.setBounds(390, 90, 180, 30);
		panel_3.add(label_earnYearPre_view);

		JLabel lblTngTin = new JLabel("Tổng tiền đã nộp");
		lblTngTin.setBounds(10, 131, 150, 30);
		panel_3.add(lblTngTin);

		label_resultEarn = new JLabel("");
		label_resultEarn.setBounds(200, 131, 180, 30);
		panel_3.add(label_resultEarn);

		label_resultEarn_view = new JLabel("");
		label_resultEarn_view.setBounds(390, 131, 180, 30);
		panel_3.add(label_resultEarn_view);

		JLabel lblSTinThu_2 = new JLabel(
				"SỐ TIỀN THUÊ ĐẮT CÒN NỢ CHUYỂN SANG NĂM 2016");
		lblSTinThu_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSTinThu_2.setBounds(10, 172, 575, 30);
		panel_3.add(lblSTinThu_2);

		JLabel lblNCaCc = new JLabel("Nợ của các năm trước");
		lblNCaCc.setBounds(10, 211, 150, 30);
		panel_3.add(lblNCaCc);

		label_resultNoYearAgo_view = new JLabel("");
		label_resultNoYearAgo_view.setBounds(390, 211, 180, 30);
		panel_3.add(label_resultNoYearAgo_view);

		label_resultNoYearPre_view = new JLabel("");
		label_resultNoYearPre_view.setBounds(390, 251, 180, 30);
		panel_3.add(label_resultNoYearPre_view);

		label_resultPayYear_view = new JLabel("");
		label_resultPayYear_view.setBounds(390, 292, 180, 30);
		panel_3.add(label_resultPayYear_view);

		label_resultPayYear = new JLabel("0");
		label_resultPayYear.setBounds(200, 292, 180, 30);
		panel_3.add(label_resultPayYear);

		JLabel lblTngNSang = new JLabel("Tổng nợ sang năm 2016");
		lblTngNSang.setBounds(10, 292, 150, 30);
		panel_3.add(lblTngNSang);

		JLabel lblNCaRing = new JLabel("Nợ của riêng năm 2015");
		lblNCaRing.setBounds(10, 251, 150, 30);
		panel_3.add(lblNCaRing);

		label_resultNoYearPre = new JLabel("0");
		label_resultNoYearPre.setBounds(200, 251, 180, 30);
		panel_3.add(label_resultNoYearPre);

		label_resultNoYearAgo = new JLabel("0");
		label_resultNoYearAgo.setBounds(200, 213, 180, 30);
		panel_3.add(label_resultNoYearAgo);

		tabbedPane.addChangeListener(this);
		btnAddRow.addActionListener(this);

		/* panel_01 - EarnYearPre */
		txt_noYearAgo.addKeyListener(this);
		txt_noYearAgo.addFocusListener(this);
		txt_dcTang.addKeyListener(this);
		txt_dcTang.addFocusListener(this);
		txt_dcGiam.addKeyListener(this);
		txt_dcGiam.addFocusListener(this);

		txt_thuaYearAgo.addKeyListener(this);
		txt_thuaYearAgo.addFocusListener(this);
		txt_dcThuaTang.addKeyListener(this);
		txt_dcThuaTang.addFocusListener(this);
		txt_dcThuaGiam.addKeyListener(this);
		txt_dcThuaGiam.addFocusListener(this);

		/* panel_02 - EarnYearPre */
		txt_dientich.addKeyListener(this);
		txt_dientich.addFocusListener(this);
		txt_thoiGian.addKeyListener(this);
		txt_thoiGian.addFocusListener(this);
		txt_donGia.addKeyListener(this);
		txt_donGia.addFocusListener(this);
		txt_tienMienGiam.addKeyListener(this);
		// txt_tienMienGiam.addFocusListener(this);

		/* panel_03 */
		txt_earnYearAgo.addKeyListener(this);
		txt_earnYearAgo.addFocusListener(this);
		txt_earnYearPre.addKeyListener(this);
		txt_earnYearPre.addFocusListener(this);

		/* panel_00 */
		txt_mdd.addKeyListener(this);
		txt_mdd.addFocusListener(this);

	}

	public void warn(String title, String content, JTextField txtField) {
		JOptionPane.showMessageDialog(null, content, title,
				JOptionPane.ERROR_MESSAGE);
		txtField.setText("");
		txtField.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource() == txt_earnYearAgo) {
			System.out.println("keyPressed");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// number format
		DecimalFormat df = new DecimalFormat("#");
		df.setMinimumFractionDigits(0);
		// panel 0
		if (e.getSource() == txt_mdd) {
			if (c.checkMDD(txt_mdd.getText().trim()) == 1) {

			} else {
				warn(WARN_ERR, WARN_ERR_MDD, txt_mdd);
			}
		}
		// panel_03
		if (e.getSource() == txt_earnYearAgo) {
			if (c.isNumber(txt_earnYearAgo)) {
				double tong2015 = c.getTxtDouble(txt_earnYearAgo)
						+ c.getTxtDouble(txt_earnYearPre);
				label_resultEarn.setText(df.format(tong2015) + "");
				label_resultEarn_view.setText(c.formatNumber(tong2015));
				label_earnYearAgo_view.setText(c.formatNumber(c
						.getTxtDouble(txt_earnYearAgo)) + "");

				double noNamTruoc = c.getTxtDouble(label_resultPhainop)
						- c.getTxtDouble(txt_earnYearAgo);
				label_resultNoYearAgo.setText(df.format(noNamTruoc) + "");
				label_resultNoYearAgo_view.setText(c.formatNumber(noNamTruoc));
				double no2015 = tinhNo2015(label_resultTongThu,
						label_resultThua, txt_earnYearPre);
				label_resultNoYearPre.setText(df.format(no2015) + "");
				label_resultNoYearPre_view.setText(c.formatNumber(no2015));
				double no2016 = tinhNo2016(label_resultNoYearAgo,
						label_resultNoYearPre);
				label_resultPayYear.setText(df.format(no2016) + "");
				label_resultPayYear_view.setText(c.formatNumber(no2016));
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_earnYearAgo);
			}
		}
		if (e.getSource() == txt_earnYearPre) {
			if (c.isNumber(txt_earnYearPre)) {
				double tong2015 = c.getTxtDouble(txt_earnYearAgo)
						+ c.getTxtDouble(txt_earnYearPre);
				label_resultEarn.setText(df.format(tong2015) + "");
				label_resultEarn_view.setText(c.formatNumber(tong2015));
				label_earnYearPre_view.setText(c.formatNumber(c
						.getTxtDouble(txt_earnYearPre)) + "");

				double noNamTruoc = c.getTxtDouble(label_resultPhainop)
						- c.getTxtDouble(txt_earnYearAgo);
				label_resultNoYearAgo.setText(df.format(noNamTruoc) + "");
				label_resultNoYearAgo_view.setText(c.formatNumber(noNamTruoc));
				double no2015 = tinhNo2015(label_resultTongThu,
						label_resultThua, txt_earnYearPre);
				label_resultNoYearPre.setText(df.format(no2015) + "");
				label_resultNoYearPre_view.setText(c.formatNumber(no2015));
				double no2016 = tinhNo2016(label_resultNoYearAgo,
						label_resultNoYearPre);
				label_resultPayYear.setText(df.format(no2016) + "");
				label_resultPayYear_view.setText(c.formatNumber(no2016));
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_earnYearAgo);
			}
		}
		// panel_01
		if (e.getSource() == txt_noYearAgo) {
			if (c.isNumber(txt_noYearAgo)) {
				double noPhaiNop = tinhNo(txt_noYearAgo, txt_dcTang, txt_dcGiam);
				label_resultPhainop.setText(df.format(noPhaiNop) + "");
				label_resultPhainop_view.setText(c.formatNumber(noPhaiNop));
				label_noyearAgo_view.setText(c.formatNumber(c
						.getTxtDouble(txt_noYearAgo)) + "");
				// lay du lieu chuan: 22.222.222,22 => 2222222.22
				double noNamTruoc = c.getTxtDouble(label_resultPhainop)
						- c.getTxtDouble(txt_earnYearAgo);
				label_resultNoYearAgo.setText(df.format(noNamTruoc) + "");
				label_resultNoYearAgo_view.setText(c.formatNumber(noNamTruoc));
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_noYearAgo);
			}
		}
		if (e.getSource() == txt_dcTang) {
			if (c.isNumber(txt_dcTang)) {
				double noPhaiNop = tinhNo(txt_noYearAgo, txt_dcTang, txt_dcGiam);
				label_resultPhainop.setText(df.format(noPhaiNop) + "");
				label_resultPhainop_view.setText(c.formatNumber(noPhaiNop));
				label_dcTang_view.setText(c.formatNumber(c
						.getTxtDouble(txt_dcTang)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_dcTang);
			}
		}
		if (e.getSource() == txt_dcGiam) {
			if (c.isNumber(txt_dcGiam)) {
				double noPhaiNop = tinhNo(txt_noYearAgo, txt_dcTang, txt_dcGiam);
				label_resultPhainop.setText(df.format(noPhaiNop) + "");
				label_resultPhainop_view.setText(c.formatNumber(noPhaiNop));
				label_dcGiam_view.setText(c.formatNumber(c
						.getTxtDouble(txt_dcGiam)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_dcGiam);
			}
		}

		if (e.getSource() == txt_thuaYearAgo) {
			if (c.isNumber(txt_thuaYearAgo)) {
				double noPhaiNop = tinhNo(txt_thuaYearAgo, txt_dcThuaTang,
						txt_dcThuaGiam);
				label_resultThua.setText(df.format(noPhaiNop) + "");
				label_resultThua_view.setText(c.formatNumber(noPhaiNop));
				label_thuayearAgo_view.setText(c.formatNumber(c
						.getTxtDouble(txt_thuaYearAgo)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_thuaYearAgo);
			}
		}
		if (e.getSource() == txt_dcThuaTang) {
			if (c.isNumber(txt_dcThuaTang)) {
				double noPhaiNop = tinhNo(txt_thuaYearAgo, txt_dcThuaTang,
						txt_dcThuaGiam);
				label_resultThua.setText(df.format(noPhaiNop) + "");
				label_resultThua_view.setText(c.formatNumber(noPhaiNop));
				label_dcThuaTang_view.setText(c.formatNumber(c
						.getTxtDouble(txt_dcThuaTang)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_dcThuaTang);
			}
		}
		if (e.getSource() == txt_dcThuaGiam) {
			if (c.isNumber(txt_dcThuaGiam)) {
				double noPhaiNop = tinhNo(txt_thuaYearAgo, txt_dcThuaTang,
						txt_dcThuaGiam);
				label_resultThua.setText(df.format(noPhaiNop) + "");
				label_resultThua_view.setText(c.formatNumber(noPhaiNop));
				label_dcThuaGiam_view.setText(c.formatNumber(c
						.getTxtDouble(txt_dcThuaGiam)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_dcThuaGiam);
			}
		}
		// panel_02
		if (e.getSource() == txt_dientich) {
			if (c.isNumber(txt_dientich)) {
				double tienGhiThu = tinhTienGhiThu(txt_dientich, txt_donGia,
						txt_thoiGian);
				txt_resultGhiThu.setText(df.format(tienGhiThu) + "");
				label_resultGhiThu_view
						.setText(c.formatNumber(tienGhiThu) + "");
				label_dientich_view.setText(c.formatNumber(c
						.getTxtDouble(txt_dientich)) + "");
				double tongThu = tinhTongThu(txt_resultGhiThu, txt_tienMienGiam);
				label_resultTongThu.setText(df.format(tongThu) + "");
				label_resultTongThu_view.setText(c.formatNumber(tongThu) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_dientich);
			}
		}
		if (e.getSource() == txt_donGia) {
			if (c.isNumber(txt_donGia)) {
				double tienGhiThu = tinhTienGhiThu(txt_dientich, txt_donGia,
						txt_thoiGian);
				txt_resultGhiThu.setText(df.format(tienGhiThu) + "");
				label_resultGhiThu_view
						.setText(c.formatNumber(tienGhiThu) + "");
				label_dongia_view.setText(c.formatNumber(c
						.getTxtDouble(txt_donGia)) + "");
				double tongThu = tinhTongThu(txt_resultGhiThu, txt_tienMienGiam);
				label_resultTongThu.setText(df.format(tongThu) + "");
				label_resultTongThu_view.setText(c.formatNumber(tongThu) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_donGia);
			}
		}
		if (e.getSource() == txt_thoiGian) {
			if (c.isNumber(txt_thoiGian)) {
				double tienGhiThu = tinhTienGhiThu(txt_dientich, txt_donGia,
						txt_thoiGian);
				txt_resultGhiThu.setText(df.format(tienGhiThu) + "");
				label_resultGhiThu_view
						.setText(c.formatNumber(tienGhiThu) + "");
				label_thoiGian_view.setText(c.formatNumber(c
						.getTxtDouble(txt_thoiGian)) + "");
				double tongThu = tinhTongThu(txt_resultGhiThu, txt_tienMienGiam);
				label_resultTongThu.setText(df.format(tongThu) + "");
				label_resultTongThu_view.setText(c.formatNumber(tongThu) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_thoiGian);
			}
		}
		if (e.getSource() == txt_tienMienGiam) {
			if (c.isNumber(txt_tienMienGiam)) {
				double tongThu = tinhTongThu(txt_resultGhiThu, txt_tienMienGiam);
				label_resultTongThu.setText(df.format(tongThu) + "");
				label_resultTongThu_view.setText(c.formatNumber(tongThu));
				label_mienGiam_view.setText(c.formatNumber(c
						.getTxtDouble(txt_tienMienGiam)) + "");
			} else {
				warn(WARN_ERR, WARN_ERR_NUMBER_FORMAT_CONTENT, txt_tienMienGiam);
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txt_earnYearAgo) {
			System.out.println("keyTyped");
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// number format
		DecimalFormat df = new DecimalFormat("#");
		df.setMinimumFractionDigits(0);
		// panel_01
		if (arg0.getSource() == txt_noYearAgo || arg0.getSource() == txt_dcTang
				|| arg0.getSource() == txt_dcGiam
				|| arg0.getSource() == txt_thuaYearAgo
				|| arg0.getSource() == txt_dcThuaTang
				|| arg0.getSource() == txt_dcThuaGiam) {
			// label_noyearAgo_view.setText(c.formatNumber(c
			// .getTxtDouble(txt_noYearAgo)) + "");

			double noPhaiNop = tinhNo(txt_noYearAgo, txt_dcTang, txt_dcGiam);
			label_resultPhainop.setText(df.format(noPhaiNop) + "");
			double noPhaiNop2 = tinhNo(txt_thuaYearAgo, txt_dcThuaTang,
					txt_dcThuaGiam);
			label_resultThua.setText(df.format(noPhaiNop2) + "");
		}

		// panel_02
		if (arg0.getSource() == txt_dientich || arg0.getSource() == txt_donGia
				|| arg0.getSource() == txt_thoiGian
				|| arg0.getSource() == txt_tienMienGiam) {
			double tienGhiThu = tinhTienGhiThu(txt_dientich, txt_donGia,
					txt_thoiGian);
			txt_resultGhiThu.setText(df.format(tienGhiThu) + "");
			double tongThu = tinhTongThu(txt_resultGhiThu, txt_tienMienGiam);
			label_resultTongThu.setText(df.format(tongThu) + "");
			label_resultTongThu_view.setText(c.formatNumber(tongThu));
			label_mienGiam_view.setText(c.formatNumber(c
					.getTxtDouble(txt_tienMienGiam)) + "");
		}
		// panel_03
		if (arg0.getSource() == txt_earnYearAgo
				|| arg0.getSource() == txt_earnYearPre) {
			double tong2015 = c.getTxtDouble(txt_earnYearAgo)
					+ c.getTxtDouble(txt_earnYearPre);
			label_resultEarn.setText(df.format(tong2015));
			label_resultEarn_view.setText(c.formatNumber(tong2015));
			double noNamTruoc = c.getTxtDouble(label_resultPhainop)
					- c.getTxtDouble(txt_earnYearAgo);
			label_resultNoYearAgo.setText(df.format(noNamTruoc) + "");
			label_resultNoYearAgo_view.setText(c.formatNumber(noNamTruoc));
			double no2015 = tinhNo2015(label_resultTongThu, label_resultThua,
					txt_earnYearPre);
			label_resultNoYearPre.setText(df.format(no2015) + "");
			label_resultNoYearPre_view.setText(c.formatNumber(no2015));
			double no2016 = tinhNo2016(label_resultNoYearAgo,
					label_resultNoYearPre);
			label_resultPayYear.setText(df.format(no2016) + "");
			label_resultPayYear_view.setText(c.formatNumber(no2016));
		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {

	}

	// cong thuc tinh no panel_01
	public double tinhNo(JTextField txt1, JTextField txt2, JTextField txt3) {
		return (c.getTxtDouble(txt1) + c.getTxtDouble(txt2) - c
				.getTxtDouble(txt3));
	}

	public double tinhTienGhiThu(JTextField txt1, JTextField txt2,
			JTextField txt3) {
		System.out
				.println((c.getTxtDouble(txt1) * (c.getTxtDouble(txt2) / 364) * c
						.getTxtDouble(txt3)) + "");
		return (c.getTxtDouble(txt1) * (c.getTxtDouble(txt2) / 365) * c
				.getTxtDouble(txt3));
	}

	public double tinhTongThu(JTextField txt1, JTextField txt2) {
		return (c.getTxtDouble(txt1) - c.getTxtDouble(txt2));
	}

	// panel 03
	public double tinhTongNop(JLabel txt1, JTextField txt2) {
		return (c.getTxtDouble(txt1) - c.getTxtDouble(txt2));
	}

	public double tinhNo2015(JLabel txt1, JLabel txt2, JTextField txt3) {
		return (c.getTxtDouble(txt1) - c.getTxtDouble(txt2) - c
				.getTxtDouble(txt3));
	}

	public double tinhNo2016(JLabel txt1, JLabel txt2) {
		return (c.getTxtDouble(txt1) + c.getTxtDouble(txt2));
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
		int index = sourceTabbedPane.getSelectedIndex();
		System.out.println("Tab changed to: "
				+ sourceTabbedPane.getTitleAt(index));
		// set request vao textfield trong tab de tinh toan ket qua luon
		switch (index) {
		case 0:
			txt_nsd.requestFocus();
			break;
		case 1:
			txt_noYearAgo.requestFocus();
			break;
		case 2:
			txt_dientich.requestFocus();
			break;
		case 3:
			txt_earnYearAgo.requestFocus();
			break;

		default:
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean checkMdd = false;
		if(txt_mdd.getText().trim().length() > 0){
			checkMdd = true;
		}
		if (e.getSource() == btnAddRow && checkMdd) {
			
			info = new CustomerInfo(txt_nsd.getText().trim(), txt_mst.getText()
					.trim(), rd_tckt.isSelected(), rd_hgd.isSelected(), txt_dc
					.getText().trim(), txt_xp.getText().trim(), txt_mdd
					.getText().trim(), rd_giayto.isSelected());
			moneyYearAgo = new MoneyYearAgo(c.getTxtDouble(txt_noYearAgo),
					c.getTxtDouble(txt_dcTang), c.getTxtDouble(txt_dcGiam),
					c.getTxtDouble(label_resultPhainop),
					c.getTxtDouble(txt_thuaYearAgo),
					c.getTxtDouble(txt_dcThuaTang),
					c.getTxtDouble(txt_dcThuaGiam),
					c.getTxtDouble(label_resultThua));
			moneyYearPresent = new MoneyYearPresent(
					c.getTxtDouble(txt_dientich), c.getTxtDouble(txt_donGia),
					c.getTxtDouble(txt_thoiGian),
					c.getTxtDouble(txt_resultGhiThu),
					c.getTxtDouble(txt_tienMienGiam),
					c.getTxtDouble(label_resultTongThu));
			statisticMoneyEearned = new StatisticMoneyEarned(
					c.getTxtDouble(txt_earnYearAgo),
					c.getTxtDouble(txt_earnYearPre),
					c.getTxtDouble(label_resultEarn),
					c.getTxtDouble(label_resultNoYearAgo),
					c.getTxtDouble(label_resultNoYearPre),
					c.getTxtDouble(label_resultPayYear));
			EntityBasic entity = new EntityBasic(info, moneyYearAgo,
					moneyYearPresent, statisticMoneyEearned);
			if (m_type == 0) {
				listen_show_table.showObjectTable(entity);
			} else {
				dialogChoseTypeSave(entity);
			}
		}else if(e.getSource() == btnAddRow && !checkMdd){
			warn(WARN_ERR, WARN_ERR_MDD, txt_mdd);
		}
	}

	// Addd them.
	public void clearComponent() {
		rd_giayto.setSelected(false);
		rd_khongGiayto.setSelected(false);
		rd_hgd.setSelected(false);
		rd_tckt.setSelected(false);
		txt_dc.setText("");
		txt_mdd.setText("");
		txt_mst.setText("");
		txt_nsd.setText("");
		txt_xp.setText("");

		txt_noYearAgo.setText("");
		txt_dcTang.setText("");
		txt_dcGiam.setText("");
		label_resultPhainop.setText("");
		txt_thuaYearAgo.setText("");
		txt_dcThuaTang.setText("");
		txt_dcThuaGiam.setText("");
		label_resultThua.setText("");
		label_dcTang_view.setText("");
		label_dcGiam_view.setText("");
		label_thuayearAgo_view.setText("");
		label_dcThuaTang_view.setText("");
		label_dcThuaGiam_view.setText("");
		label_resultPhainop_view.setText("");
		label_resultThua_view.setText("");

		txt_dientich.setText("");
		txt_donGia.setText("");
		txt_thoiGian.setText("");
		txt_tienMienGiam.setText("");
		txt_resultGhiThu.setText("");
		label_resultTongThu.setText("");
		label_dientich_view.setText("");
		label_dongia_view.setText("");
		label_thoiGian_view.setText("");
		label_mienGiam_view.setText("");
		label_resultGhiThu_view.setText("");
		label_mienGiam_view.setText("");
		label_resultTongThu_view.setText("");

		txt_earnYearAgo.setText("");
		txt_earnYearPre.setText("");
		label_earnYearAgo_view.setText("");
		label_earnYearPre_view.setText("");
		label_noyearAgo_view.setText("");
		label_resultEarn.setText("");
		label_resultNoYearAgo.setText("");
		label_resultNoYearPre.setText("");
		label_resultPayYear.setText("");

	}

	public void setData(EntityBasic entity) {
		// Set Data tab info
		CustomerInfo objectInfo = entity.getInfo();
		rd_giayto.setSelected(objectInfo.isGiayTo());
		rd_khongGiayto.setSelected(!objectInfo.isGiayTo());
		rd_hgd.setSelected(objectInfo.isHgd());
		rd_tckt.setSelected(objectInfo.isTc_kt());
		txt_dc.setText(objectInfo.getDiachi());
		txt_mdd.setText(objectInfo.getMs_diemdat());
		txt_mst.setText(objectInfo.getMs_thue());
		txt_nsd.setText(objectInfo.getName_used());
		txt_xp.setText(objectInfo.getXa_phuong());

		MoneyYearAgo objectMoneyYearAgo = entity.getMoney_year_ago();
		txt_noYearAgo.setText(objectMoneyYearAgo.getNo_namtruoc() + "");
		label_noyearAgo_view.setText(c.formatNumber(c
				.getTxtDouble(txt_noYearAgo)) + "");
		txt_dcTang.setText(objectMoneyYearAgo.getTang_no_namtruoc() + "");
		label_dcTang_view.setText(c.formatNumber(c.getTxtDouble(txt_dcTang))
				+ "");

		txt_dcGiam.setText(objectMoneyYearAgo.getGiam_no_namtruoc() + "");
		label_dcGiam_view.setText(c.formatNumber(c.getTxtDouble(txt_dcGiam))
				+ "");
		label_resultPhainop.setText(objectMoneyYearAgo.getTong_nonamtruoc()
				+ "");

		txt_thuaYearAgo.setText(objectMoneyYearAgo.getThua_namtruoc() + "");
		label_thuayearAgo_view.setText(c.formatNumber(c
				.getTxtDouble(txt_thuaYearAgo)) + "");
		txt_dcThuaTang.setText(objectMoneyYearAgo.getTang_thua_namtruoc() + "");
		label_dcThuaTang_view.setText(c.formatNumber(c
				.getTxtDouble(txt_dcThuaTang)) + "");
		txt_dcThuaGiam.setText(objectMoneyYearAgo.getGiam_thua_namtruoc() + "");
		label_dcThuaGiam_view.setText(c.formatNumber(c
				.getTxtDouble(txt_dcThuaGiam)) + "");
		label_resultThua.setText(objectMoneyYearAgo.getTong_thua_namtruoc()
				+ "");

		MoneyYearPresent objectMoneyYearPresent = entity
				.getMoney_year_present();
		txt_dientich.setText(objectMoneyYearPresent.getDienTich() + "");
		label_dientich_view
				.setText(c.formatNumber(c.getTxtDouble(txt_dientich)) + "");

		txt_donGia.setText(objectMoneyYearPresent.getDonGia() + "");
		label_dongia_view.setText(c.formatNumber(c.getTxtDouble(txt_donGia))
				+ "");

		txt_thoiGian.setText(objectMoneyYearPresent.getThoigian() + "");
		label_thoiGian_view
				.setText(c.formatNumber(c.getTxtDouble(txt_thoiGian)) + "");

		txt_tienMienGiam.setText(objectMoneyYearPresent.getSoTienMienGiam()
				+ "");
		label_mienGiam_view.setText(c.formatNumber(c
				.getTxtDouble(txt_tienMienGiam)) + "");

		txt_resultGhiThu.setText(objectMoneyYearPresent.getSoTienGhiThu() + "");
		label_resultTongThu.setText(objectMoneyYearPresent.getTongThu() + "");

		StatisticMoneyEarned objectMoneyEarn = entity.getEarned();
	}

	private void dialogChoseTypeSave(EntityBasic entity) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Lưu lại thay đổi", "Tạo mới" };
		String initialSelection = "Lưu lại thay đổi";
		Object selection = JOptionPane.showInputDialog(this,
				"Chọn kiểu muốn lưu", "Lựa chọn", JOptionPane.QUESTION_MESSAGE,
				null, selectionValues, initialSelection);
		System.out.println(selection);
		if (selection != null) {
			if (selection.equals("Lưu lại thay đổi")) {
				listen_show_table.fixObjectTable(entity);
			} else if (selection.equals("Tạo mới")) {
				listen_show_table.showObjectTable(entity);
			}
		}
	}

	public void setType(int m_type) {
		this.m_type = m_type;
	}

}
