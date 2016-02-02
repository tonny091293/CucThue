package com.startup.model;

public class StatisticMoneyEarned {
	// so ten thue dat da nop
	private double nop_cho_no_namtruoc;
	private double nop_cho_namnay;
	private double tong_nop;

	// so tien thue dat con no chuyen nam 2016
	private double thongke_no_namtruoc;
	private double thongke_no_namnay;
	private double thongke_tong;

	public double getNop_cho_no_namtruoc() {
		return nop_cho_no_namtruoc;
	}

	public void setNop_cho_no_namtruoc(double nop_cho_no_namtruoc) {
		this.nop_cho_no_namtruoc = nop_cho_no_namtruoc;
	}

	public double getNop_cho_namnay() {
		return nop_cho_namnay;
	}

	public void setNop_cho_namnay(double nop_cho_namnay) {
		this.nop_cho_namnay = nop_cho_namnay;
	}

	public double getTong_nop() {
		return tong_nop;
	}

	public void setTong_nop(double tong_nop) {
		this.tong_nop = tong_nop;
	}

	public double getThongke_no_namtruoc() {
		return thongke_no_namtruoc;
	}

	public void setThongke_no_namtruoc(double thongke_no_namtruoc) {
		this.thongke_no_namtruoc = thongke_no_namtruoc;
	}

	public double getThongke_no_namnay() {
		return thongke_no_namnay;
	}

	public void setThongke_no_namnay(double thongke_no_namnay) {
		this.thongke_no_namnay = thongke_no_namnay;
	}

	public double getThongke_tong() {
		return thongke_tong;
	}

	public void setThongke_tong(double thongke_tong) {
		this.thongke_tong = thongke_tong;
	}

	public StatisticMoneyEarned(double nop_cho_no_namtruoc,
			double nop_cho_namnay, double tong_nop, double thongke_no_namtruoc,
			double thongke_no_namnay, double thongke_tong) {
		this.nop_cho_no_namtruoc = nop_cho_no_namtruoc;
		this.nop_cho_namnay = nop_cho_namnay;
		this.tong_nop = tong_nop;
		this.thongke_no_namtruoc = thongke_no_namtruoc;
		this.thongke_no_namnay = thongke_no_namnay;
		this.thongke_tong = thongke_tong;
	}

	public StatisticMoneyEarned() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StatisticMoneyEarned [nop_cho_no_namtruoc="
				+ nop_cho_no_namtruoc + ", nop_cho_namnay=" + nop_cho_namnay
				+ ", tong_nop=" + tong_nop + ", thongke_no_namtruoc="
				+ thongke_no_namtruoc + ", thongke_no_namnay="
				+ thongke_no_namnay + ", thongke_tong=" + thongke_tong + "]";
	}

}
