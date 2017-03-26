/**
 * 
 */
package moon.course.question.test;

import static org.junit.Assert.*;

import moon.course.question.Option;

import org.junit.Before;
import org.junit.Test;


/**
 * @author lucia
 *
 */
public class OptionTest {
	
	Option o1, o2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		o1 = new Option("Option test 1");
		o2 = new Option("Option test 2");
	}

	/**
	 * Test method for {@link moon.course.question.Option#Option(java.lang.String)}.
	 */
	@Test
	public void testOption() {
		assertNotNull(o1);
		assertNotNull(o2);
	}

	/**
	 * Test method for {@link moon.course.question.Option#getOption()}.
	 */
	@Test
	public void testGetOption() {
		assertEquals(o1.getOption(), "Option test 1");
		assertEquals(o2.getOption(), "Option test 2");
	}

	/**
	 * Test method for {@link moon.course.question.Option#setOption(java.lang.String)}.
	 */
	@Test
	public void testSetOption() {
		o1.setOption("New Option test 1");
		o2.setOption("New Option test 2");

		assertEquals(o1.getOption(), "New Option test 1");
		assertEquals(o2.getOption(), "New Option test 2");
	}
	
	/**
	 * Test method for {@link moon.course.question.Option#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals(){
		Object obj = new Object();
		assertTrue(o1.equals(o1));
		assertFalse(o2.equals(obj));
		assertFalse(o1.equals(o2));
		assertFalse(o1.equals(null));
		o2.setOption("Option test 1");
		assertTrue(o1.equals(o2));
	}
}
