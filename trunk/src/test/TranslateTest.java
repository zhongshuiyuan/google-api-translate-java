/**
 * 
 */
package test;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

/**
 * @author rich
 *
 */
public class TranslateTest extends TestCase {
	@Test
	public void testTranslate() throws Exception {
		System.out.println("testTranslate");
		assertEquals("مرحبا العالم", Translate.translate("Hello world", Language.ENGLISH, Language.ARABIC));
		assertEquals("世界您好", Translate.translate("Hello world", Language.ENGLISH, Language.CHINESE));
		assertEquals("Bonjour monde", Translate.translate("Hello world", Language.ENGLISH, Language.FRENCH));
		assertEquals("Hallo welt", Translate.translate("Hello world", Language.ENGLISH, Language.GERMAN));
		assertEquals("Ciao mondo", Translate.translate("Hello world", Language.ENGLISH, Language.ITALIAN));
		assertEquals("ハロー世界", Translate.translate("Hello world", Language.ENGLISH, Language.JAPANESE));
		assertEquals("여러분, 안녕하세요", Translate.translate("Hello world", Language.ENGLISH, Language.KOREAN));
		assertEquals("Olá mundo", Translate.translate("Hello world", Language.ENGLISH, Language.PORTUGESE));
		assertEquals("Привет мир", Translate.translate("Hello world", Language.ENGLISH, Language.RUSSIAN));
		assertEquals("Hola mundo", Translate.translate("Hello world", Language.ENGLISH, Language.SPANISH));
	}
	
	@Test
	public void testIntermediteTranslate() throws Exception {
		System.out.println("testIntermediateTranslate");
		assertEquals("Hola Mundo", Translate.translate("Привет мир", Language.RUSSIAN, Language.SPANISH));
		assertEquals("Ciao a tutti!", Translate.translate("Hallo welt", Language.GERMAN, Language.ITALIAN));
	}
}