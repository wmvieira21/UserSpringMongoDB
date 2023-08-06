package com.userspring.userMongo.controllers.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static LocalDate corvertDate(String date) {
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return LocalDate.parse(date, format1);
	}
}
