/**
 * Language.java
 *
 * Copyright (C) 2007,  Richard Midwinter
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.google.api.translate;

import java.util.Arrays;
import java.util.List;

/**
 * Defines language information for the Google Translate API.
 * 
 * @author Richard Midwinter
 */

public final class Language {
	public static final String ARABIC = "ar";
	public static final String CHINESE = "zh";
	public static final String CHINESE_SIMPLIFIED = "zh-CN";
	public static final String CHINESE_TRADITIONAL = "zh-TW";
	public static final String DUTCH = "nl";
	public static final String ENGLISH = "en";
	public static final String FRENCH = "fr";
	public static final String GERMAN = "de";
	public static final String GREEK = "el";
	public static final String ITALIAN = "it";
	public static final String JAPANESE = "ja";
	public static final String KOREAN = "ko";
	public static final String PORTUGESE = "pt";
	public static final String RUSSIAN = "ru";
	public static final String SPANISH = "es";
	
	public static final List<String> validLanguages = Arrays.asList(new String[] {
			ARABIC,
			CHINESE,
			CHINESE_SIMPLIFIED,
			CHINESE_TRADITIONAL,
			ENGLISH,
			FRENCH,
			GERMAN,
			ITALIAN,
			JAPANESE,
			KOREAN,
			PORTUGESE,
			RUSSIAN,
			SPANISH
			});
	
	public static final List<String> validLanguagePairs = Arrays.asList(new String[] {
			ARABIC +'|' +ENGLISH,
			CHINESE +'|' +ENGLISH,
			CHINESE_SIMPLIFIED +'|' +CHINESE_TRADITIONAL,
			CHINESE_TRADITIONAL +'|' +CHINESE_SIMPLIFIED,
			DUTCH +'|' +ENGLISH,
			ENGLISH +'|' +ARABIC,
			ENGLISH +'|' +CHINESE,
			ENGLISH +'|' +CHINESE_SIMPLIFIED,
			ENGLISH +'|' +CHINESE_TRADITIONAL,
			ENGLISH +'|' +DUTCH,
			ENGLISH +'|' +FRENCH,
			ENGLISH +'|' +GERMAN,
			ENGLISH +'|' +GREEK,
			ENGLISH +'|' +ITALIAN,
			ENGLISH +'|' +JAPANESE,
			ENGLISH +'|' +KOREAN,
			ENGLISH +'|' +PORTUGESE,
			ENGLISH +'|' +RUSSIAN,
			ENGLISH +'|' +SPANISH,
			FRENCH +'|' +ENGLISH,
			FRENCH +'|' +GERMAN,
			GERMAN +'|' +ENGLISH,
			GERMAN +'|' +FRENCH,
			GREEK +'|' +ENGLISH,
			ITALIAN +'|' +ENGLISH,
			JAPANESE +'|' +ENGLISH,
			KOREAN +'|' +ENGLISH,
			PORTUGESE +'|' +ENGLISH,
			RUSSIAN +'|' +ENGLISH,
			SPANISH +'|' +ENGLISH
	});
	
	/**
	 * Checks a given language is available to use with Google Translate.
	 * 
	 * @param language The language code to check for.
	 * @return true if this language is available to use with Google Translate, false otherwise.
	 */
	public static boolean isValidLanguage(String language) {
		return validLanguages.contains(language);
	}
	
	/**
	 * Checks the languages to translate to and from match with a supported Google Translate pairing.
	 * 
	 * @param from The language code to translate from.
	 * @param to The language code to translate to.
	 * @return true if the language pairing is supported, false otherwise.
	 */
	public static boolean isValidLanguagePair(String from, String to) {
		return validLanguagePairs.contains(from +'|' +to);
	}
}