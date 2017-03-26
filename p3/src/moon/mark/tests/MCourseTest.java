/**
 * 
 */
package moon.mark.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.Question;
import moon.course.question.TfQuestion;
import moon.mark.MCourse;
import moon.mark.MExercise;
import moon.user.Application;
import moon.user.Student;

/**
 * @author Lucia Asencio and Juan Riera
 *
 */
public class MCourseTest {

	Exercise e1, e2, e3;
	Question q11, q12, q21, q31;
	MExercise me111, me112, me113, me122, me123;
	MCourse mc11, mc12, mc13, mc2, mc3;
	Course c1, c2, c3;
	Unit u1, u2, u3;
	Student s1, s2, s3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Application a;
		s1=new Student("Juan", "Pepitez", "passwrd", 6, "Juan.pepitez@uam.es");
		s2=new Student("Lucia", "Strepsils", "passwrd", 7, "Lucia.strepsils@uam.es");
		s3=new Student("Antonio", "Rodriguez", "passwrd", 8, "Antonio.rodriguez@uam.es");
		
		c1 = new Course("Padsof");
		c2 = new Course("Mathematics");
		c3 = new Course("Void theory");
		
		e1 = new Exercise();
		e1.setRelevance(1);
		e1.setPenalty(-4);
		e2 = new Exercise();
		e2.setRelevance(2);
		e2.setPenalty(-5);
		e3 = new Exercise();
		e3.setRelevance(3);
		e3.setPenalty(-2);
		
		u1 = new Unit("Unit 1 of course c1");
		u2 = new Unit("Unit 2 of course c1");
		u3 = new Unit("Unit 1 of course c2");
		
		u1.setCourse(c1);
		u2.setCourse(c1);
		u3.setCourse(c2);
		
		c1.addUnit(u1);
		c1.addUnit(u2);
		c2.addUnit(u3);
		
		u1.addElement(e1);
		u1.addElement(e2);
		u2.addElement(e3);
		
		try {
			a=s1.apply(c1);
			a.accept();
			a=s1.apply(c2);
			a.accept();
			a=s1.apply(c3);
			a.accept();
			a=s2.apply(c1);
			a.accept();
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			fail("Error with the email system");
			e.printStackTrace();
		}
		
		
		mc11 = new MCourse(c1, s1);
		mc12 = new MCourse(c1, s2);
		mc13 = new MCourse(c1, s3);
		mc2 = new MCourse(c2, s1);
		mc3 = new MCourse(c3, s1);
				
		q11 = new TfQuestion("This is a sample question 1", 4, false, e1);
		q12 = new TfQuestion("This is a sample question 2", 6, true, e1);
		q21 = new TfQuestion("This is a sample question 3", 7, true, e2);
		q31 = new TfQuestion("This is a sample question 4", 3, false, e3);
		
		me111 = new MExercise(e1);
		mc11.addMExe(me111);
		q11.answer(true, me111);
		q12.answer(false, me111);
		
		me112 = new MExercise(e2);
		mc11.addMExe(me112);
		q21.answer(true, me112);
		
		me113 = new MExercise(e3);
		mc11.addMExe(me113);
		q31.answer(true, me113);
		
		me122 = new MExercise(e2);
		mc12.addMExe(me122);
		q21.answer(false, me122);
		
		me123 = new MExercise(e3);
		mc12.addMExe(me123);
		q31.answer(false, me123);
		
		
		
	}
	/**
	 * Test method for {@link moon.mark.MCourse#MCourse(moon.course.Course, moon.user.Student)}.
	 */
	@Test
	public void testMCourse() {
		/* Let's start checking that none of them are null */
		assertNotNull(mc11);
		assertNotNull(mc12);
		assertNotNull(mc13);
		assertNotNull(mc2);
		assertNotNull(mc3);
	
		/* Let's now check that they have been initialized properly, 
		 * as can be seen, here we are also testing the methods
		 * getCourse() and getStudent() */
		assertEquals(mc11.getCourse(), c1);
		assertEquals(mc11.getStudent(), s1);
		assertEquals(mc12.getCourse(), c1);
		assertEquals(mc12.getStudent(), s2);
		assertEquals(mc13.getCourse(), c1);
		assertEquals(mc13.getStudent(), s3);
		assertEquals(mc2.getCourse(), c2);
		assertEquals(mc2.getStudent(), s1);
		assertEquals(mc3.getCourse(), c3);
		assertEquals(mc3.getStudent(), s1);
		
	}

	/**
	 * Test method for {@link moon.mark.MCourse#getMark()}.
	 */
	@Test
	public void testGetMark() {
		/* Case in which all the exercises have been answered.
		 * It is important to note that this value has been aproximated,
		 * this is why we could not use the operator "==" and we established
		 * an upper and a lower bound and used the operators "<" and ">"*/
		assertTrue(mc11.getMark()<0.33334);
		assertTrue(mc11.getMark()>0.33333);
		
		/* Case in which some exercises of the course have not been done */
		assertTrue(mc12.getMark()==0.5);
		
		/* Case in which none of the exercises have been done */
		assertTrue(mc13.getMark()==0);
		
		/* Case in which there is a unit, but no exercises */
		assertTrue(mc2.getMark()==0);
		
		/* Case in which there is no unit nor exercises */
		assertTrue(mc3.getMark()==0);
	}


	/**
	 * Test method for {@link moon.mark.MCourse#setCourse(moon.course.Course)}.
	 */
	@Test
	public void testSetCourse() {
		assertEquals(mc11.getCourse(), c1);
		mc11.setCourse(c2);
		assertEquals(mc11.getCourse(),c2);
	}


	/**
	 * Test method for {@link moon.mark.MCourse#setStudent(moon.user.Student)}.
	 */
	@Test
	public void testSetStudent() {
		assertEquals(mc11.getStudent(), s1);
		mc11.setStudent(s2);
		assertEquals(mc11.getStudent(),s2);
	}

	/**
	 * Test method for {@link moon.mark.MCourse#getmExes()}.
	 */
	@Test
	public void testGetmExes() {
		fail("Not yet implemented");
	}
	
	
	/**
	 * Test method for {@link moon.mark.MCourse#addMExe()}.
	 */
	@Test
	public void testAddMExes() {
		fail("Not yet implemented");
	}

}
