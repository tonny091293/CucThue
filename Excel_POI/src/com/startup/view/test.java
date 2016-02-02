package com.startup.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		DateFormat fromFormat = new SimpleDateFormat("yyyy-MM-dd");
		fromFormat.setLenient(false);
		DateFormat toFormat = new SimpleDateFormat("dd-MM-yyyy");
		toFormat.setLenient(false);
		String dateStr = "2011-07-09 00:00:00";
		Date date;
		try {
			date = fromFormat.parse(dateStr);
			System.out.println(toFormat.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String numb = "55.222.222,33";
		numb = numb.replace(".", "");
		System.out.println(numb);
		numb = numb.replace(",", ".");
		System.out.println(numb);
		System.out.println(Double.parseDouble(numb));
	}
}
