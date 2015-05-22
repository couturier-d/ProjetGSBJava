package com.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertDate {
	public static Date toDate(String date1) {
		Date date2 = null;
		String sFormat = "yyyy-MM-dd"; // voir le format qui vous convient
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		try {
			date2 = sdf.parse(date1); // conversion en java.util.date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date2;
	}
	
	public static String toSQL(Date date1) {
		String date2 = null;
		String sFormat = "yyyy-MM-dd"; // voir le format qui vous convient
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		date2 = sdf.format(date1);
		return date2;
	}

}
