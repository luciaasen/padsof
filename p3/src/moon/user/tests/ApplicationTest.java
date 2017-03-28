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
import moon.Academy;
import moon.course.*;

/**
 * Class in which we test the applications that students can send to courses
 * if they are interested in them.
 * @author Juan Riera and Lucia Asencio
 *
 */
public class ApplicationTest {

	Student s1, s2;
	Course c1, c2;
	Application a11, a12, a22, a21;
	
	
	/**
	 * In this setup we create and intialize 2 students (s1 and s2)
	 * that apply to 2 courses (c1 and c2)
	 */
	@Before
	public void setUp() {
		s1  = new Student("Pepito", "Gonzalez", "PepGon", 0, "pepito@uam.es");
		s2  = new Student("Juan", "Rodriguez", "JuRo", 1, "juan.rodriguez@uam.es");
		c1 = new Course("Math");
		c2 = new Course("PADSOF");
		try {
			a11 = s1.apply(c1);
			a12 = s1.apply(c2);
			a22 = s2.apply(c2);
			a21 = s2.apply(c1);
		} catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			e.printStackTrace();
			fail("Failed with the email system");
		}
	}
	
	@Test
	/**
	 * Test method for {@link moon.user.Application.Application()}
	 */
	
	public void testApplicationConstructor(){
		/*We will now check that the constructors did all of their jobs*/
		
		/* First let's check that the objects were created */
		assertNotNull(a11);
		assertNotNull(a12);
		assertNotNull(a21);
		assertNotNull(a22);
		
		/*Now let's check that they have been added 
		 * to every list they should be in*/
		assertTrue(s1.getApps().contains(a11));
		assertTrue(s1.getApps().contains(a12));
		assertTrue(s2.getApps().contains(a21));
		assertTrue(s2.getApps().contains(a22));
		
		/* The method Academy.getApplications() looks for all the applications
		 * in the lists stored in the courses.
		 */
		assertTrue(Academy.getMoonApp().getApplications().contains(a11));
		assertTrue(Academy.getMoonApp().getApplications().contains(a21));
		assertTrue(Academy.getMoonApp().getApplications().contains(a12));
		assertTrue(Academy.getMoonApp().getApplications().contains(a22));
	}
	/**
	 * Test method for {@link moon.user.Application#accept()}.
	 */
	@Test
	public void testAccept() {
		
		/* Let's make sure that there are no MCourses and that they are 
		 * created by the method apply(). We'll re-check this later.
		 */
		assertNull(c1.getMCourse(s1));
		assertNull(c1.getMCourse(s2));
		assertNull(c2.getMCourse(s1));
		assertNull(c2.getMCourse(s2));
		
		try {
			assertTrue(a11.accept());
			assertTrue(a22.accept());
			assertTrue(a12.accept());
			/*They have already been accepted, so they can not be accepted again */
			assertFalse(a11.accept());
			assertFalse(a22.accept());
		} catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			e.printStackTrace();
			fail("Failed with the email system");
		}
		
		/* It should have been removed from every list it belonged to */
		assertFalse(s1.getApps().contains(a11));
		assertFalse(s1.getApps().contains(a12));
		assertTrue(s2.getApps().contains(a21)); //This one has not been accepted yet
		assertFalse(s2.getApps().contains(a22));
		
		/* The method Academy.getApplications() looks for all the applications
		 * in the lists stored in the courses.
		 */
		assertFalse(Academy.getMoonApp().getApplications().contains(a11));
		assertTrue(Academy.getMoonApp().getApplications().contains(a21));
		assertFalse(Academy.getMoonApp().getApplications().contains(a12));
		assertFalse(Academy.getMoonApp().getApplications().contains(a22));
		
		/* The accepted applications should have created the correspondent
		 * MCourses */
		assertNotNull(c1.getMCourse(s1));
		assertNull(c1.getMCourse(s2));
		assertNotNull(c2.getMCourse(s1));
		assertNotNull(c2.getMCourse(s2));
	}

	/**
	 * Test method for {@link moon.user.Application#reject()}.
	 */
	@Test
	public void testReject() {
		try {
			assertTrue(a11.reject());
			assertTrue(a22.reject());
			assertTrue(a12.reject());
			/*They have already been rejected, 
			 * so they can not be rejected again */
			assertFalse(a11.reject());
			assertFalse(a22.reject());
		} catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			e.printStackTrace();
			fail("Failed with the email system");
		}
		
		/* It should have been removed from every list it belonged to */
		assertFalse(s1.getApps().contains(a11));
		assertFalse(s1.getApps().contains(a12));
		assertTrue(s2.getApps().contains(a21)); //This one has not been rejected yet
		assertFalse(s2.getApps().contains(a22));
		
		/* The method Academy.getApplications() looks for all the applications
		 * in the lists stored in the courses.
		 */
		assertFalse(Academy.getMoonApp().getApplications().contains(a11));
		assertTrue(Academy.getMoonApp().getApplications().contains(a21));
		assertFalse(Academy.getMoonApp().getApplications().contains(a12));
		assertFalse(Academy.getMoonApp().getApplications().contains(a22));
	}

}
