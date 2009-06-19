/**
 * 
 */
package test;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * @author Richard Midwinter
 *
 */
public class TranslateTest extends TestCase {
	@Test
	public void testTranslate() throws Exception {
		System.out.println("testTranslate");
		
		assertEquals("مرحبا العالم", Translate.translate("Hello world", Language.ENGLISH, Language.ARABIC));
		assertEquals("世界您好", Translate.translate("Hello world", Language.ENGLISH, Language.CHINESE));
		assertEquals("Bonjour le monde", Translate.translate("Hello world", Language.ENGLISH, Language.FRENCH));
		assertEquals("Hallo Welt", Translate.translate("Hello world", Language.ENGLISH, Language.GERMAN));
		assertEquals("नमस्कार दुनिया", Translate.translate("Hello world", Language.ENGLISH, Language.HINDI));
		assertEquals("Ciao mondo", Translate.translate("Hello world", Language.ENGLISH, Language.ITALIAN));
		assertEquals("こんにちは世界", Translate.translate("Hello world", Language.ENGLISH, Language.JAPANESE));
		assertEquals("여보세요 세계", Translate.translate("Hello world", Language.ENGLISH, Language.KOREAN));
		assertEquals("Olá mundo", Translate.translate("Hello world", Language.ENGLISH, Language.PORTUGUESE));
		assertEquals("Привет мир", Translate.translate("Hello world", Language.ENGLISH, Language.RUSSIAN));
		assertEquals("Hola Mundo", Translate.translate("Hello world", Language.ENGLISH, Language.SPANISH));
		assertEquals("Hello dinja", Translate.translate("Hello world", Language.ENGLISH, Language.MALTESE));
		assertEquals("สวัสดีโลก", Translate.translate("Hello world", Language.ENGLISH, Language.THAI));
		assertEquals("Merhaba Dünya", Translate.translate("Hello world", Language.ENGLISH, Language.TURKISH));
		assertEquals("Hola Mundo", Translate.translate("Привет мир", Language.RUSSIAN, Language.SPANISH));
		assertEquals("Ciao mondo", Translate.translate("Hallo welt", Language.GERMAN, Language.ITALIAN));
		assertEquals("D'accord", Translate.translate("Ok", Language.ENGLISH, Language.FRENCH));
		
		assertEquals("Bonjour tout le monde", Translate.translate("Привет мир", Language.AUTO_DETECT, Language.FRENCH));
	}
}