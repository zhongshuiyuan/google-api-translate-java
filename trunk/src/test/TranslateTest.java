/**
 * 
 */
package test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import junit.framework.TestCase;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * @author rich
 *
 */
public class TranslateTest extends TestCase {
	@Test
	public void testTranslate() throws MalformedURLException, IOException {
		System.out.println("testTranslate");
		assertEquals("مرحبا العالم", Translate.translate("Hello world", Language.ENGLISH, Language.ARABIC));
		assertEquals("你好世界", Translate.translate("Hello world", Language.ENGLISH, Language.CHINESE));
		assertEquals("Bonjour le monde", Translate.translate("Hello world", Language.ENGLISH, Language.FRENCH));
		assertEquals("Hallo welt", Translate.translate("Hello world", Language.ENGLISH, Language.GERMAN));
		assertEquals("Ciao a tutti", Translate.translate("Hello world", Language.ENGLISH, Language.ITALIAN));
		assertEquals("こんにちは世界", Translate.translate("Hello world", Language.ENGLISH, Language.JAPANESE));
		assertEquals("여러분, 안녕하세요", Translate.translate("Hello world", Language.ENGLISH, Language.KOREAN));
		assertEquals("Olá mundo", Translate.translate("Hello world", Language.ENGLISH, Language.PORTUGESE));
		assertEquals("Привет мир", Translate.translate("Hello world", Language.ENGLISH, Language.RUSSIAN));
		assertEquals("Hola mundo", Translate.translate("Hello world", Language.ENGLISH, Language.SPANISH));
	}
}