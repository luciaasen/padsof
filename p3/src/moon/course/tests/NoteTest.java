/**
 * 
 */
package moon.course.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.course.*;

/**
 * @author Lucia Asencio and Juan Riera
 *
 */
public class NoteTest {

	Note n1, n2;
	Course c1, c2;
	Unit u1, u2;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp()  {
		n1 = new Note("Note 1");
		n2 = new Note("Note 2");
		c1 = new Course("PADSOF");
		c2 = new Course("PASDOF");
		u1 = new Unit("Unit 1 PADSOF");
		u2 = new Unit("Unit 1 PASDOF");
		u1.setCourse(c1);
		u2.setCourse(c2);
	}

	/**
	 * Test method for {@link moon.course.Note#getText()}.
	 */
	@Test
	public void testGetText() {
		assertEquals(n1.getText(), "Note 1");
		assertEquals(n2.getText(), "Note 2");
	}

	/**
	 * Test method for {@link moon.course.Note#setText(java.lang.String)}.
	 */
	@Test
	public void testSetText() {
		n1.setText("New Note 1");
		n2.setText("New Note 2");
		assertEquals(n1.getText(), "New Note 1");
		assertEquals(n2.getText(), "New Note 2");
	}

	/**
	 * Test method for {@link moon.course.CourseElement#getCourse()}.
	 */
	@Test
	public void testSetAndGetCourse() {
		n1.setCourse(c1);
		n2.setCourse(c1);
		assertEquals(n1.getCourse(), c1);
		assertEquals(n2.getCourse(), c1);
		n1.setCourse(c2);
		assertEquals(n1.getCourse(), c2);
	}

	/**
	 * Test method for {@link moon.course.CourseElement#getUnit()}.
	 */
	@Test
	public void testSetAndGetUnit() {
		n1.setUnit(u1);
		n2.setUnit(u1);
		assertEquals(n1.getUnit(), u1);
		assertEquals(n2.getUnit(), u1);
		/* By setting the unit, we are also setting the course */
		assertEquals(n1.getCourse(), c1);
		assertEquals(n2.getCourse(), c1);
		n1.setUnit(u2);
		assertEquals(n1.getUnit(), u2);
		assertEquals(n1.getCourse(), c2);
		
	}

	/**
	 * Test method for {@link moon.course.CourseElement#makeVisible()}.
	 */
	@Test
	public void testVisibility() {
		n1.makeVisible();
		assertTrue(n1.getVisibility());
		n1.makeInvisible();
		assertFalse(n1.getVisibility());
		n1.makeVisible();
		assertTrue(n1.getVisibility());
	}



}
