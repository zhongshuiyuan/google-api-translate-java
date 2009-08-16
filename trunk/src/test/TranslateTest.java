/**
 * TranslateTest.java
 *
 * Copyright (C) 2008,  Richard Midwinter
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
package test;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * @author Richard Midwinter
 */
public class TranslateTest extends TestCase {
	@Test
	public void testHttpReferrerRequired() throws Exception {
		System.out.println("testHttpReferrerRequired");

		try {
			Translate.execute("Hello world", Language.ENGLISH, Language.ARABIC);
			fail("Should have thrown an error as HTTP referrer is not set.");
		} catch (Exception e) {
			assertEquals("[google-api-translate-java] Referrer is not set. Call setHttpReferrer().", e.getMessage());
		}
	}
	
	@Test
	public void testTranslate() throws Exception {
		System.out.println("testTranslate");
		
		GoogleAPI.setHttpReferrer("http://code.google.com/p/google-api-translate-java/");
		
		assertEquals("مرحبا العالم", Translate.execute("Hello world", Language.ENGLISH, Language.ARABIC));
		assertEquals("世界您好", Translate.execute("Hello world", Language.ENGLISH, Language.CHINESE));
		assertEquals("Bonjour le monde", Translate.execute("Hello world", Language.ENGLISH, Language.FRENCH));
		assertEquals("Hallo Welt", Translate.execute("Hello world", Language.ENGLISH, Language.GERMAN));
		assertEquals("नमस्कार दुनिया", Translate.execute("Hello world", Language.ENGLISH, Language.HINDI));
		assertEquals("Ciao mondo", Translate.execute("Hello world", Language.ENGLISH, Language.ITALIAN));
		assertEquals("こんにちは世界", Translate.execute("Hello world", Language.ENGLISH, Language.JAPANESE));
		assertEquals("여보세요 세계", Translate.execute("Hello world", Language.ENGLISH, Language.KOREAN));
		assertEquals("Olá mundo", Translate.execute("Hello world", Language.ENGLISH, Language.PORTUGUESE));
		assertEquals("Привет мир", Translate.execute("Hello world", Language.ENGLISH, Language.RUSSIAN));
		assertEquals("Hola Mundo", Translate.execute("Hello world", Language.ENGLISH, Language.SPANISH));
		assertEquals("Hello dinja", Translate.execute("Hello world", Language.ENGLISH, Language.MALTESE));
		assertEquals("สวัสดีโลก", Translate.execute("Hello world", Language.ENGLISH, Language.THAI));
		assertEquals("Merhaba Dünya", Translate.execute("Hello world", Language.ENGLISH, Language.TURKISH));
		assertEquals("Hola Mundo", Translate.execute("Привет мир", Language.RUSSIAN, Language.SPANISH));
		assertEquals("Ciao mondo", Translate.execute("Hallo welt", Language.GERMAN, Language.ITALIAN));
		assertEquals("D'accord", Translate.execute("Ok", Language.ENGLISH, Language.FRENCH));
		
		assertEquals("Bonjour tout le monde", Translate.execute("Привет мир", Language.AUTO_DETECT, Language.FRENCH));
	}
	
	@Test
	public void testExample() throws Exception {
		System.out.println("testExample");
		
		GoogleAPI.setHttpReferrer("http://code.google.com/p/google-api-translate-java/");
		
		assertEquals("Hello world", Translate.execute("Bonjour le monde", Language.FRENCH, Language.ENGLISH));
	}
}