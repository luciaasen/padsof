/**
 * 
 */
package moon.user.tests;

import static org.junit.Assert.*;

import org.junit.Before;

import moon.user.*;
import moon.Academy;
import moon.course.*;

import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class StudentTest {

	Student s1, s2;
	Course c1, c2;
	Application a11, a12, a21, a22, anull1, anull2;
	
	@Before
	public void setUp(){
		s1 = new Student("Juanito", "Perales", "password", 2, "juan.perales@uam.es");
		s2 = new Student("Emilio", "Cuesta", "password", 3, "emi.asturias@uam.es");
		c1 = new Course("Bioquimica aplicada");
		c2 = new Course("SADFOP");
		
	}
	
	/**
	 * Test method for {@link moon.user.Student#Student()}
	 * We also test the getters for the name, last name, email and password.
	 * Technically, the latter is not exactly a getter, because it checks if 
	 * the password it receives as an argument is equal to the password of 
	 * the user. This is also tested in this tester.
	 */
	@Test
	public void testStudent(){
		/* Let's make sure that the Students have been properly intialized */
		assertNotNull(s1);
		assertNotNull(s2);
		
		assertEquals(s1.getName(), "Juanito");
		assertEquals(s2.getName(), "Emilio");
		assertEquals(s1.getLastName(), "Perales");
		assertEquals(s2.getLastName(), "Cuesta");
		assertEquals(s1.getEmail(), "juan.perales@uam.es");
		assertEquals(s2.getEmail(), "emi.asturias@uam.es");
	}
	/**
	 * Test method for {@link moon.user.Student#isTeacher()}.
	 */
	@Test
	public void testIsTeacher() {
		assertFalse(s1.isTeacher());
		assertFalse(s2.isTeacher());
	}
	
	/**
	 * Test method for {@link moon.user.Student#addCourse(moon.course.Course)}.
	 */
	@Test
	public void testAddAndGetCourse() {
		assertTrue(s1.addCourse(c1));
		assertTrue(s1.addCourse(c2));
		assertTrue(s2.addCourse(c1));
		
		/* It is important to note that this method will never be called
		 * in a case where the course has already been added, since it will 
		 * be called always by the method Application.accept(), and that
		 * application will be constructed by Student.apply(Course c) that
		 * makes sure that the student is not in the course when he applies 
		 * for it, and that there is no other application between the same
		 * student and the same course as the one you are trying to create.
		 * 
		 * The method apply is tested below.
		 */
		
		/*Lets now make sure that the lists have been updated */
		
		assertTrue(s1.getCourses().contains(c1));
		assertTrue(s1.getCourses().contains(c2));
		assertTrue(s2.getCourses().contains(c1));
	}
	
	/**
	 * Test method for {@link moon.user.Student#addApplication(moon.user.Application)}.
	 */
	@Test
	public void testAddApplicationAndGetApps() {
		a11 = new Application(s1, c1);
		a12 = new Application(s1, c2);
		
		/* The constructor of application calls to addApplication ,
		 * so let's check that the applications have been added to the list.
		 */
		assertTrue(s1.getApps().contains(a11));
		assertTrue(s2.getApps().contains(a12));
	}
	
	/**
	 * Test method for {@link moon.user.User#checkPwd(java.lang.String)}.
	 */
	@Test
	public void testCheckPwd() {
		assertTrue(s1.checkPwd("password"));
		assertTrue(s2.checkPwd("password"));
		assertFalse(s1.checkPwd("passworD"));
		assertFalse(s2.checkPwd("Password"));
	}

	/**
	 * Test method for {@link moon.user.Student#apply(moon.course.Course)}.
	 */
	@Test
	public void testApply() {
		
		try {
			a11 = s1.apply(c1);
			a12 = s1.apply(c2);
			a22 = s2.apply(c2);
			a21 = s2.apply(c1);
			/* You cannot apply for a course you have already applied for */
			anull1 = s1.apply(c1);
			anull2 = s2.apply(c2);
		} catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			e.printStackTrace();
			fail("Failed with the email system");
		}
		
		/* We are going to check that all the lists have been properly updated */
		/* First let's check that the objects were created */
		assertNotNull(a11);
		assertNotNull(a12);
		assertNotNull(a21);
		assertNotNull(a22);
		assertNull(anull1);
		assertNull(anull2);
		
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
		
		/* You can not apply for a course you are already in */
		try {
			a12.accept();
			a21.accept();
			anull1 = s1.apply(c2);
			anull2 = s2.apply(c1);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Email error");
			e.printStackTrace();
		}
		assertNull(anull1);
		assertNull(anull2);
		
	}

	

	/**
	 * Test method for {@link moon.user.Student#removeApplication(moon.user.Application)}.
	 */
	@Test
	public void testRemoveApplication() {
		a11 = new Application(s1, c1);
		a12 = new Application(s1, c2);
		
		/* The constructor of application calls addAppliation,
		 * so they are added now to the list of applications.
		 * This has already been tested to work.
		 */
		assertTrue(s1.removeApplication(a11));
		assertTrue(s2.removeApplication(a12));
		/* They can not be removed twice */
		assertFalse(s1.removeApplication(a11));
		assertFalse(s2.removeApplication(a12));
		
		/* Now they should not be there anymore */
		assertFalse(s1.getApps().contains(a11));
		assertFalse(s2.getApps().contains(a12));
	}

	/**
	 * Test method for {@link moon.user.Student#calcAverage()}.
	 */
	@Test
	public void testCalcAverage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.user.Student#calcMaximum()}.
	 */
	@Test
	public void testCalcMaximum() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.user.Student#calcMinimum()}.
	 */
	@Test
	public void testCalcMinimum() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.user.Student#coursesInButNotExpelled()}.
	 */
	@Test
	public void testCoursesInButNotExpelled() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link moon.user.Student#addMark(moon.mark.MCourse)}.
	 */
	@Test
	public void testAddMark() {
		fail("Not yet implemented");
	}



}
