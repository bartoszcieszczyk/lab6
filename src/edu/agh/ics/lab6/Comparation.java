package edu.agh.ics.lab6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuffer;

public class Comparation {
	
	public static void main(String[] args) {
		String input = "User password=23421. Some more text password=33432. This clientNum=100";
		Pattern p = Pattern.compile("(password=) (\\d+)");
		Matcher m = p.matcher(input);
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			System.out.println("Group 1: " + m.group(1));
			System.out.println("Group 2 (masking): " + m.group(2));
			m.appendReplacement(result, m.group(1) + "******");
		}
		m.appendTail(result);
		System.out.println(result);
	}
}
