package com.bisn.opensource;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

/*
 * Java显示日历(Calendar)名称
 */

public class CalendarTest {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		// Locale locale = Locale.getDefault();
		Locale locale = Locale.ITALIAN;
		Map<String, Integer> names = now.getDisplayNames(Calendar.DAY_OF_WEEK,
				Calendar.LONG, locale);
		System.out.println(names);
		String name = now.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG,
				locale);
		System.out.printf("Today is a %s.%n", name);
	}
}
