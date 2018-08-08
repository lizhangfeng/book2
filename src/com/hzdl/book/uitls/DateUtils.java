package com.hzdl.book.uitls;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final String YYYY_MM_DD = "yyyy年MM月dd日";
	private static final String YYYY_MM_DD_HH_MM_SS = "yyyy_MM_dd_HH_mm_ss_";

	private static SimpleDateFormat sdf;

	public static String getNowTime() {
		sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return sdf.format(new Date());
	}

}
