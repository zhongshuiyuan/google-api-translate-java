/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;


/**
 * @author rich
 *
 */
public class IntermediaryTest {
	@Test
	public void testIntermediary() throws Exception {
		System.out.println("testIntermediary");
		assertEquals("zeiden", Translate.translate("zeiden", Language.DUTCH, Language.SPANISH));
	}
}