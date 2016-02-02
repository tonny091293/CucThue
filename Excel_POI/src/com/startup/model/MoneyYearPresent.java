package com.startup.model;

public class MoneyYearPresent {
	private double dienTich;
	private double donGia;
	private double thoigian;
	private double soTienGhiThu;
	private double soTienMienGiam;
	private double tongThu;

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getThoigian() {
		return thoigian;
	}

	public void setThoigian(double thoigian) {
		this.thoigian = thoigian;
	}

	public double getSoTienGhiThu() {
		return soTienGhiThu;
	}

	public void setSoTienGhiThu(double soTienGhiThu) {
		this.soTienGhiThu = soTienGhiThu;
	}

	public double getSoTienMienGiam() {
		return soTienMienGiam;
	}

	public void setSoTienMienGiam(double soTienMienGiam) {
		this.soTienMienGiam = soTienMienGiam;
	}

	public double getTongThu() {
		return tongThu;
	}

	public void setTongThu(double tongThu) {
		this.tongThu = tongThu;
	}

	public MoneyYearPresent() {
		// TODO Auto-generated constructor stub
	}

	public MoneyYearPresent(double dienTich, double donGia, double thoigian,
			double soTienGhiThu, double soTienMienGiam, double tongThu) {
		super();
		this.dienTich = dienTich;
		this.donGia = donGia;
		this.thoigian = thoigian;
		this.soTienGhiThu = soTienGhiThu;
		this.soTienMienGiam = soTienMienGiam;
		this.tongThu = tongThu;
	}

	@Override
	public String toString() {
		return "MoneyYearPresent [dienTich=" + dienTich + ", donGia=" + donGia
				+ ", thoigian=" + thoigian + ", soTienGhiThu=" + soTienGhiThu
				+ ", soTienMienGiam=" + soTienMienGiam + ", tongThu=" + tongThu
				+ "]";
	}

}
