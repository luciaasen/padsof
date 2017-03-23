/**
 * 
 */
package moon.user.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.user.*;
import moon.course.*;

/**
 * @author juan
 *
 */
public class ApplicationTest {

	
	@Before
	public void setUp() throws InvalidEmailAddressException, 
		FailedInternetConnectionException{
		Student s1  = new Student("Pepito", "Gonzalez", "PepGon", 0, "pepito@uam.es");
		Student s2  = new Student("Juan", "Rodriguez", "JuRo", 1, "juan.rodriguez@uam.es");
		Course c1 = new Course("Math");
		Course c2 = new Course("PADSOF");
		Application a11 = s1.apply(c1);
		Application a12 = s1.apply(c2);
		Application a22 = s2.apply(c2);
		Application a21 = s2.apply(c1);
	}
	/**
	 * Test method for {@link moon.user.Application#accept()}.
	 */
	@Test
	public void testAccept() throws InvalidEmailAddressException, 
		FailedInternetConnectionException {
		assertTrue(a11.accept());
		assertTrue(a22.accept());
		assertTrue(a12.accept());
		assertFalse(a11.accept());
		assertFalse(a22.accept());
	}

	/**
	 * Test method for {@link moon.user.Application#reject()}.
	 */
	@Test
	public void testReject() {
		assertTrue(a21.reject());
		assertFalse(a21.reject());
	}

}
