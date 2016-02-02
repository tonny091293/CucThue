package com.startup.model;

public class MoneyYearAgo {
	private double no_namtruoc;
	private double tang_no_namtruoc;
	private double giam_no_namtruoc;
	private double tong_nonamtruoc;
	private double thua_namtruoc;
	private double tang_thua_namtruoc;
	private double giam_thua_namtruoc;
	private double tong_thua_namtruoc;

	public double getNo_namtruoc() {
		return no_namtruoc;
	}

	public void setNo_namtruoc(double no_namtruoc) {
		this.no_namtruoc = no_namtruoc;
	}

	public double getTang_no_namtruoc() {
		return tang_no_namtruoc;
	}

	public void setTang_no_namtruoc(double tang_no_namtruoc) {
		this.tang_no_namtruoc = tang_no_namtruoc;
	}

	public double getGiam_no_namtruoc() {
		return giam_no_namtruoc;
	}

	public void setGiam_no_namtruoc(double giam_no_namtruoc) {
		this.giam_no_namtruoc = giam_no_namtruoc;
	}

	public double getTong_nonamtruoc() {
		return tong_nonamtruoc;
	}

	public void setTong_nonamtruoc(double tong_nonamtruoc) {
		this.tong_nonamtruoc = tong_nonamtruoc;
	}

	public double getThua_namtruoc() {
		return thua_namtruoc;
	}

	public void setThua_namtruoc(double thua_namtruoc) {
		this.thua_namtruoc = thua_namtruoc;
	}

	public double getTang_thua_namtruoc() {
		return tang_thua_namtruoc;
	}

	public void setTang_thua_namtruoc(double tang_thua_namtruoc) {
		this.tang_thua_namtruoc = tang_thua_namtruoc;
	}

	public double getGiam_thua_namtruoc() {
		return giam_thua_namtruoc;
	}

	public void setGiam_thua_namtruoc(double giam_thua_namtruoc) {
		this.giam_thua_namtruoc = giam_thua_namtruoc;
	}

	public double getTong_thua_namtruoc() {
		return tong_thua_namtruoc;
	}

	public void setTong_thua_namtruoc(double tong_thua_namtruoc) {
		this.tong_thua_namtruoc = tong_thua_namtruoc;
	}

	public MoneyYearAgo(double no_namtruoc, double tang_no_namtruoc,
			double giam_no_namtruoc, double tong_nonamtruoc,
			double thua_namtruoc, double tang_thua_namtruoc,
			double giam_thua_namtruoc, double tong_thua_namtruoc) {
		super();
		this.no_namtruoc = no_namtruoc;
		this.tang_no_namtruoc = tang_no_namtruoc;
		this.giam_no_namtruoc = giam_no_namtruoc;
		this.tong_nonamtruoc = tong_nonamtruoc;
		this.thua_namtruoc = thua_namtruoc;
		this.tang_thua_namtruoc = tang_thua_namtruoc;
		this.giam_thua_namtruoc = giam_thua_namtruoc;
		this.tong_thua_namtruoc = tong_thua_namtruoc;
	}

	public MoneyYearAgo() {
	}

	@Override
	public String toString() {
		return "MoneyYearAgo [no_namtruoc=" + no_namtruoc
				+ ", tang_no_namtruoc=" + tang_no_namtruoc
				+ ", giam_no_namtruoc=" + giam_no_namtruoc
				+ ", tong_nonamtruoc=" + tong_nonamtruoc + ", thua_namtruoc="
				+ thua_namtruoc + ", tang_thua_namtruoc=" + tang_thua_namtruoc
				+ ", giam_thua_namtruoc=" + giam_thua_namtruoc
				+ ", tong_thua_namtruoc=" + tong_thua_namtruoc + "]";
	}

}
