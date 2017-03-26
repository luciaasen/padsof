/**
 * 
 */
package moon.user.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import moon.user.Teacher;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class TeacherTest {

	Teacher t1, t2;
	@Before
	public void setUp() {
		t1=new Teacher("Juan", "Gonzalez", "pajword", 3, "pedrito.email@uam.es");
		t2=new Teacher("Jun", "Gonzlez", "pasguord", 3, "pedritu.email@uam.es");
	}
	/**
	 * Test method for {@link moon.user.Teacher#isTeacher()}.
	 */
	@Test
	public void testIsTeacher() {
		assertTrue(t1.isTeacher());
		assertTrue(t2.isTeacher());
	}

}
