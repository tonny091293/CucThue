package com.startup.model;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import com.startup.control.Controller;

public class CustomerInfo {
	// ten nguoi su dung dat
	private String name_used;
	// ma so thue
	private String ms_thue;
	// = 1 la to chuc kinh te
	private boolean tc_kt;
	// = 1 la ho gia dinh
	private boolean hgd;
	// So nha duong pho
	private String diachi;
	// xa phuong
	private String xa_phuong;
	// ma so diem dat
	private String ms_diemdat;
	// = 1 co giay to , =0 khong co giay to
	private boolean isGiayTo;
	private Controller c = new Controller();

	public String getName_used() {
		return name_used;
	}

	public void setName_used(String name_used) {
		this.name_used = name_used;
	}

	public String getMs_thue() {
		return ms_thue;
	}

	public void setMs_thue(String ms_thue) {
		this.ms_thue = ms_thue;
	}

	public boolean isTc_kt() {
		return tc_kt;
	}

	public void setTc_kt(boolean tc_kt) {
		this.tc_kt = tc_kt;
	}

	public boolean isHgd() {
		return hgd;
	}

	public void setHgd(boolean hgd) {
		this.hgd = hgd;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getXa_phuong() {
		return xa_phuong;
	}

	public void setXa_phuong(String xa_phuong) {
		this.xa_phuong = xa_phuong;
	}

	public String getMs_diemdat() {
		return ms_diemdat;
	}

	public void setMs_diemdat(String ms_diemdat) {
		this.ms_diemdat = ms_diemdat;
	}

	public boolean isGiayTo() {
		return isGiayTo;
	}

	public void setGiayTo(boolean isGiayTo) {
		this.isGiayTo = isGiayTo;
	}

	public CustomerInfo(String name_used, String ms_thue, boolean tc_kt,
			boolean hgd, String diachi, String xa_phuong, String ms_diemdat,
			boolean isGiayTo) {
		this.name_used = name_used;
		this.ms_thue = ms_thue;
		this.tc_kt = tc_kt;
		this.hgd = hgd;
		this.diachi = diachi;
		this.xa_phuong = xa_phuong;
		this.ms_diemdat = ms_diemdat;
		this.isGiayTo = isGiayTo;
	}

	@Override
	public String toString() {
		return "CustomerInfo [name_used=" + name_used + ", ms_thue=" + ms_thue
				+ ", tc_kt=" + tc_kt + ", hgd=" + hgd + ", diachi=" + diachi
				+ ", xa_phuong=" + xa_phuong + ", ms_diemdat=" + ms_diemdat
				+ ", isGiayTo=" + isGiayTo + "]";
	}

	public CustomerInfo() {
		// TODO Auto-generated constructor stub
	}

}
