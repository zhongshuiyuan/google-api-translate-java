/**
 * Translate.java
 *
 * Copyright (C) 2007,  Richard Midwinter
 *
 * This file is part of google-api-translate-java.
 *
 * google-api-translate-java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * google-api-translate-java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with google-api-translate-java.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.google.api.translate;

import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.google.api.GoogleAPI;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

/**
 * Makes the Google Translate API available to Java applications.
 * 
 * @author Richard Midwinter
 * @author Emeric Vernat
 * @author Juan B Cabral
 */
public final class Translate extends GoogleAPI {
	
	/**
	 * Constants.
	 */
    private static final String
    		URL = "http://ajax.googleapis.com/ajax/services/language/translate?v=1.0&langpair=#FROM#%7C#TO#&q=";

    /**
     * Translates text from a given language to another given language using Google Translate.
     * 
     * @param text The String to translate.
     * @param from The language code to translate from.
     * @param to The language code to translate to.
     * @return The translated String.
     * @throws Exception on error.
     */
    public static String execute(final String text, final Language from, final Language to) throws Exception {
    	validateReferrer();
    	
    	final URL url = new URL(URL.replaceAll("#FROM#", from.toString()).replaceAll("#TO#", to.toString())
    			+URLEncoder.encode(text, ENCODING));
    	
    	final JSONObject json = retrieveJSON(url, text);
    	final String translatedText = json.getJSONObject("responseData").getString("translatedText");
    	
		return HTMLEntities.unhtmlentities(translatedText);
    }
    
    /**
     * @deprecated Replaced by {@link execute()}.
     */
    @Deprecated
    public static String translate(final String text, final Language from, final Language to) throws Exception {
    	return execute(text, from, to);
    }
}