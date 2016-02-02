package com.startup.model;

public class EntityBasic {
	CustomerInfo info;
	MoneyYearAgo money_year_ago;
	MoneyYearPresent money_year_present;
	StatisticMoneyEarned earned;

	public CustomerInfo getInfo() {
		return info;
	}

	public void setInfo(CustomerInfo info) {
		this.info = info;
	}

	public MoneyYearAgo getMoney_year_ago() {
		return money_year_ago;
	}

	public void setMoney_year_ago(MoneyYearAgo money_year_ago) {
		this.money_year_ago = money_year_ago;
	}

	public MoneyYearPresent getMoney_year_present() {
		return money_year_present;
	}

	public void setMoney_year_present(MoneyYearPresent money_year_present) {
		this.money_year_present = money_year_present;
	}

	public StatisticMoneyEarned getEarned() {
		return earned;
	}

	public void setEarned(StatisticMoneyEarned earned) {
		this.earned = earned;
	}

	public EntityBasic(CustomerInfo info, MoneyYearAgo money_year_ago,
			MoneyYearPresent money_year_present, StatisticMoneyEarned earned) {
		this.info = info;
		this.money_year_ago = money_year_ago;
		this.money_year_present = money_year_present;
		this.earned = earned;
	}
	
	public EntityBasic()
	{
		
	}

	

}
