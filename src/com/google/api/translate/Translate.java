/**
 * Translate.java
 *
 * Makes the Google Translate API available to Java applications.
 */
package com.google.api.translate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
	
	private static final String ENCODING = "UTF-8";
    private static final String URL_STRING = "http://translate.google.com/translate_t?langpair=";
    private static final String TEXT_VAR = "&text=";
    private static final int RATE_DELAY = 2000;
    
    private static boolean rateControl = true;
    private static long lastQueryTime = 0l;
    
    /**
     * Are we throttling queries to prevent being blocked? Defaults to true.
     * @return Returns true if throttling query frequency.
     */
    public static boolean isUsingRateControl() {
    	return rateControl;
    }
    
    /**
     * Allows turning off rate control
     * @param rateControl Turns on rate control if true, off if false.
     */
    public static void setUsingRateControl(boolean rateControl) {
    	Translate.rateControl = rateControl;
    }

    private static String toString(InputStream inputStream) throws IOException {
    	while (rateControl && (lastQueryTime+RATE_DELAY > System.currentTimeMillis())) {
    		try {
				Thread.sleep(lastQueryTime+RATE_DELAY-System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
        String string;
        StringBuilder outputBuilder = new StringBuilder();
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, ENCODING));
            while (null != (string = reader.readLine())) {
                outputBuilder.append(string).append('\n');
            }
        }
        if (rateControl) lastQueryTime = System.currentTimeMillis();
        return outputBuilder.toString();
    }

    /**
     * Translates text from a given language to another given language using Google Translate
     * @param text The String to translate.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @return The translated String.
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String translate(String text, String from, String to) throws MalformedURLException, IOException {
        StringBuilder url = new StringBuilder();
        url.append(URL_STRING).append(from).append('|').append(to);
        url.append(TEXT_VAR).append(URLEncoder.encode(text, ENCODING));

        HttpURLConnection uc = (HttpURLConnection) new URL(url.toString()).openConnection();
        uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");

        String page = toString(uc.getInputStream());
        
        int resultBox = page.indexOf("<div id=result_box dir=");
        
        if (resultBox < 0) throw new Error("No translation result returned.");

        String start = page.substring(resultBox);
        return start.substring(27, start.indexOf("</div>"));
    }
}