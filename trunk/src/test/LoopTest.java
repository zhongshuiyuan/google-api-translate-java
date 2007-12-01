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
public class LoopTest extends TestCase {
	@Test
	public void testTranslate() throws Exception {
		System.out.println("testTranslate");
		for (int i = 0; i<30; i++) {
			System.out.println("Loop: " +i);
			assertEquals("مرحبا العالم", Translate.translate("Hello world", Language.ENGLISH, Language.ARABIC));
		}
	}
}