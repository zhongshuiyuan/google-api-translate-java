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
        StringBuilder url = new StringBuilder();
        url.append(URL_STRING).append(from).append('|').append(to);
        url.append(TEXT_VAR).append(URLEncoder.encode(text, "UTF-8"));

        HttpURLConnection uc = (HttpURLConnection) new URL(url.toString()).openConnection();
        uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");

        String page = toString(uc.getInputStream());

        String start = page.substring(page.indexOf("<div id=result_box dir="));
        return start.substring(27, start.indexOf("</div>"));
    }

    private static String toString(InputStream inputStream) throws IOException {
        String string;
        StringBuilder outputBuilder = new StringBuilder();
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (null != (string = reader.readLine())) {
                outputBuilder.append(string).append('\n');
            }
        }
        return outputBuilder.toString();
    }
}