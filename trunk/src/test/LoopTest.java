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
public class LoopTest extends TestCase {
	@Test
	public void testTranslate() throws MalformedURLException, IOException {
		System.out.println("testTranslate");
		for (int i = 0; i<30; i++) {
			System.out.println("Loop: " +i);
			assertEquals("مرحبا العالم", Translate.translate("Hello world", Language.ENGLISH, Language.ARABIC));
		}
	}
}