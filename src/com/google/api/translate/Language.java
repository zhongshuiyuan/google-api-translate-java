package com.google.api.translate;

import java.util.Arrays;
import java.util.List;

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
	
	private static final List<String> validLanguages = Arrays.asList(new String[] {
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
	
	private static final List<String> validLanguagePairs = Arrays.asList(new String[] {
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
	
	protected static boolean isValidLanguage(String language) {
		return validLanguages.contains(language);
	}
	
	protected static boolean isValidLanguagePair(String from, String to) {
		return validLanguagePairs.contains(from +'|' +to);
	}
}