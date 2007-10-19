/**
 * Translate.java
 * 
 * Makes the Google Translate API available to Java applications.
 */
package com.google.api.translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author rich
 * Makes the Google Translate API available to Java applications.
 */
public class Translate {
	public static final String ARABIC = "ar";
	public static final String CHINESE = "zh";
	public static final String CHINESE_SIMPLIFIED = "zh-CN";
	public static final String CHINESE_TRADITIONAL = "zh-TW";
	public static final String ENGLISH = "en";
	public static final String FRENCH = "fr";
	public static final String GERMAN = "de";
	public static final String ITALIAN = "it";
	public static final String JAPANESE = "jp";
	public static final String KOREAN = "ko";
	public static final String PORTUGESE = "pt";
	public static final String RUSSIAN = "ru";
	public static final String SPANISH = "es";

	private static final String URL_STRING = "http://translate.google.com/translate_t?langpair=";
	private static final String TEXT_VAR = "&text=";

	/**
	 * @param text The String to translate.
	 * @param from The language code to translate from.
	 * @param to The language code to translate to.
	 * @return The translated String.
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String translate(String text, String from, String to) throws MalformedURLException, IOException {
		StringBuffer url = new StringBuffer();
		url.append(URL_STRING);
		url.append(from);
		url.append('|');
		url.append(to);
		url.append(TEXT_VAR);
		url.append(URLEncoder.encode(text, "UTF-8"));

		StringBuffer output = new StringBuffer();
		String line;

		HttpURLConnection uc = (HttpURLConnection) new URL(url.toString()).openConnection();
		uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 4.01; Windows NT)");
		BufferedReader rd = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		while ((line = rd.readLine()) != null) output.append(line);
		rd.close();

		String start = output.substring(output.indexOf("<div id=result_box dir=ltr>"));
		return start.substring(27, start.indexOf("</div>"));
	}
}