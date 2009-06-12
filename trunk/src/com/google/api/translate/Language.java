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


/**
 * Defines language information for the Google Translate API.
 *
 * @author Richard Midwinter
 * @author alosii
 * @author bjkuczynski
 */
public enum Language {
	AUTO_DETECT(""),
	ALBANIAN("sq"),
	ARABIC("ar"),
	BULGARIAN("bg"),
	CATALAN("ca"),
	CHINESE("zh"),
	CHINESE_SIMPLIFIED("zh-CN"),
	CHINESE_TRADITIONAL("zh-TW"),
	CROATIAN("hr"),
	CZECH("cs"),
	DANISH("da"),
	DUTCH("nl"),
	ENGLISH("en"),
	ESTONIAN("et"),
	FILIPINO("tl"),
	FINNISH("fi"),
	FRENCH("fr"),
	GALACIAN("gl"),
	GERMAN("de"),
	GREEK("el"),
	HEBREW("iw"),
	HINDI("hi"),
	HUNGARIAN("hu"),
	INDONESIAN("id"),
	ITALIAN("it"),
	JAPANESE("ja"),
	KOREAN("ko"),
	LATVIAN("lv"),
	LITHUANIAN("lt"),
	MALTESE("mt"),
	NORWEGIAN("no"),
	POLISH("pl"),
	PORTUGESE("pt"),
	ROMANIAN("ro"),
	RUSSIAN("ru"),
	SERBIAN("sr"),
	SLOVAK("sk"),
	SLOVENIAN("sl"),
	SPANISH("es"),
	SWEDISH("sv"),
	THAI("th"),
	TURKISH("tr"),
	UKRANIAN("uk"),
	VIETNAMESE("vi");
	
	/**
	 * Google's String representation of this language.
	 */
	private final String language;
	
	/**
	 * Enum constructor.
	 * @param pLanguage The language identifier.
	 */
	private Language(final String pLanguage) {
		language = pLanguage;
	}
	
	/**
	 * Returns the String representation of this language.
	 * @return The String representation of this language.
	 */
	@Override
	public String toString() {
		return language;
	}
}