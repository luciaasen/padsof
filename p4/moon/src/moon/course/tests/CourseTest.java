/**
 * 
 */
package moon.course.tests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import moon.course.Course;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.TfQuestion;
import moon.mark.MCourse;
import moon.mark.MExercise;
import moon.user.Application;
import moon.user.Student;
import es.uam.eps.padsof.emailconnection.*;

/**
 * This is a tester for the class Course.
 * @author Lucia Asencio and Juan Riera
 *
 */
public class CourseTest {
	private Exercise e1, e2, e3, e4;
	private TfQuestion q1, q2, q3, q4, q5, q6;
	private MExercise me1, me2, me3, me4, me5, me6, me7, me8;
	private Student s1, s2, s3;
	private Course c1, c2;
	private Unit u1, u2;
	private MCourse mc1, mc2, mc3, mc4, mc5, mc6;
	private Application a1;

	/**
	 * 1st course with a unit with 2 exes, each one with 2 questions
	 * 2nd course with a unit 2 exes, each one with 1 question
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*Set 4 exercises with its questions and 3 students*/
		LocalDate from = LocalDate.of(2017, 1, 1);
		LocalDate to = LocalDate.of(2017, 12, 12);
		
		e1 = new Exercise();
		e1.setRelevance(2);
		e1.setPenalty(-2);
		e1.setName("Exe One");
		e1.setRandord(false);
		e1.setDates(from, to);
		e1.makeVisible();
		
		e2 = new Exercise();
		e2.setRelevance(1);
		e2.setPenalty(4);
		e2.setName("Exe 2");
		e2.setRandord(false);
		e2.setDates(to,from);
		e2.makeVisible();
		
		e3 = new Exercise();
		e3.setRelevance(1);
		e3.setPenalty(-4);
		e3.setName("Exe 3");
		e3.setRandord(false);
		e3.setDates(from, to);
		e3.makeVisible();
		
		e4 = new Exercise();
		e4.setRelevance(3);
		e4.setPenalty(-1);
		e4.setName("Exe 4");
		e4.setRandord(false);
		e4.setDates(from, to);
		e4.makeVisible();
		
		q1 = new TfQuestion("Am I silly?", 5, false, e1);
		q2 = new TfQuestion("Am I?", 15, true, e1);		
		q3 = new TfQuestion("Am I wrong?", -10, true, e2);
		q4= new TfQuestion("Are you okay?", 3, true, e2);
		q5 = new TfQuestion("uhm?", 5, false, e3);
		q6 = new TfQuestion("Am I tired?", 5, true, e4);
		
		s1 = new Student("Pepe", "Martin", "password", 1, "a.b@c.d");
		s2 = new Student("Mimi", "Gzlez", "wordpass", 2, "a.c@b.d");
		s3 = new Student("Marta", "Fdez", "pwwp", 3, "d.c@b.a");
		
		
		/*Sets 2 courses with one unit each and 2 exercises each*/
		c1 = new Course("Course 1");
		u1 = new Unit("Unit 1");
		u1.setCourse(c1);
		e1.setUnit(u1);
		e2.setUnit(u1);
		
		c2 = new Course("Course 2");
		u2 = new Unit("Viva la doble");
		u2.setCourse(c2);
		e3.setUnit(u2);
		e4.setUnit(u2);
		
		/*Students apply and are accepted*/
		try{
			a1 = s1.apply(c1);
			a1.accept();
			a1 = s1.apply(c2);
			a1.accept();
			a1 = s2.apply(c1);
			a1.accept();
			a1 = s2.apply(c2);
			a1.accept();
			a1 = s3.apply(c1);
			a1.accept();
			a1 = s3.apply(c2);
			a1.accept();
			
		}catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			fail("Error with email system");
		}
		
		/*Emulate students do exercises*/
		
		/*First student is in 2 courses.
		 * 		In c1: answers correctly to everything
		 * 		In c2: answers wrongly to e3, e4
		 */
		mc1 = c1.getMCourse(s1);
		mc2 = c1.getMCourse(s2);
		mc6 = c2.getMCourse(s3);
		
		me1 = new MExercise(e1);
		c1.getMCourse(s1).addMExe(me1);
		q1.answer(false, me1);
		q2.answer(true, me1);
		
		me2 = new MExercise(e2);
		c1.getMCourse(s1).addMExe(me2);
		q3.answer(true, me2);
		q4.answer(true, me2);
		
		me3 = new MExercise(e3);
		c2.getMCourse(s1).addMExe(me3);
		q5.answer(true, me3);
		
		me4 = new MExercise(e4);
		c2.getMCourse(s1).addMExe(me4);
		q6.answer(false, me4);
		
		/*Second student in 2 courses.
		 * 		In c1: correctly answers 1 question in each exe
		 * 		In c2: correctly does one exercise 
		 */
		
		me5 = new MExercise(e1);
		c1.getMCourse(s2).addMExe(me5);
		q1.answer(false, me5);
		
		me6 = new MExercise(e2);
		c1.getMCourse(s2).addMExe(me6);
		q3.answer(true, me6);
		
		me7 = new MExercise(e3);
		c2.getMCourse(s2).addMExe(me7);
		q5.answer(false, me7);
		
		
		/*Third student in 2 courses
		 * 		In c1: answers correctly to one exercise
		 * 		In c2: does nothing
		 */
		
		me8 = new MExercise(e1);
		c1.getMCourse(s3).addMExe(me8);
		q1.answer(false, me8);
		q2.answer(true, me8);
		
		
	
		
	}

	/**
	 * Test method for {@link moon.course.Course#Course(java.lang.String)}.
	 */
	@Test
	public void testCourse() {
		assertNotNull(c1);
	}

	/**
	 * Test method for {@link moon.course.Course#calcAverage()}.
	 */
	@Test
	public void testCalcAverage() {
		assertTrue(c1.calcAverage() > 0.63 && c1.calcAverage() < 0.64);
		assertTrue(c2.calcAverage() > 0.083 && c2.calcAverage() < 0.084);
	}

	/**
	 * Test method for {@link moon.course.Course#calcNPasses()}.
	 */
	@Test
	public void testCalcNPasses() {
		assertTrue(c1.calcNPasses() == 2);
		assertTrue(c2.calcNPasses() == 0);
	}

	/**
	 * Test method for {@link moon.course.Course#calcNFails()}.
	 */
	@Test
	public void testCalcNFails() {
		assertTrue(c1.calcNFails() == 1);
		assertTrue(c2.calcNFails() == 3);
	}

	/**
	 * Test method for {@link moon.course.Course#getCourseMark(moon.user.Student)}.
	 */
	@Test
	public void testGetCourseMark() {
		assertTrue(c1.getCourseMark(s1) == 1);
		assertTrue(c1.getCourseMark(s2) == 0.25);
		assertTrue(c2.getCourseMark(s3) == 0);
	}

	/**
	 * Test method for {@link moon.course.Course#getMCourse(moon.user.Student)}.
	 */
	@Test
	public void testGetMCourse() {
		assertEquals(c1.getMCourse(s1), mc1);
		assertEquals(c1.getMCourse(s2), mc2);
		assertEquals(c2.getMCourse(s3), mc6);
	}

	/**
	 * Test method for {@link moon.course.Course#getStudents()}.
	 */
	@Test
	public void testGetStudents() {
		assertTrue(c1.getStudents().size() == 3);
	}

	/**
	 * Test method for {@link moon.course.Course#addStudent(moon.user.Student)}.
	 */
	@Test
	public void testAddStudent() {
		/*As this method was used for the application, we check students are in the course*/
		assertTrue(c1.getStudents().contains(s1));
		assertTrue(c1.getStudents().contains(s2));
		assertTrue(c1.getStudents().contains(s3));
	}

	/**
	 * Test method for {@link moon.course.Course#expelStudent(moon.user.Student)}.
	 */
	@Test
	public void testExpelStudent() throws InvalidEmailAddressException, FailedInternetConnectionException{
		c1.expelStudent(s1);
		assertTrue(c1.isExpelled(s1));
	}

	/**
	 * Test method for {@link moon.course.Course#readmitStudent(moon.user.Student)}.
	 */
	@Test
	public void testReadmitStudent() throws InvalidEmailAddressException, FailedInternetConnectionException{
		c1.expelStudent(s1);
		c1.readmitStudent(s1);
		assertFalse(c1.isExpelled(s1));
		
	}

	/**
	 * Test method for {@link moon.course.Course#addApplication(moon.user.Application)}.
	 */
	@Test
	public void testAddApplication() {
		/*This method is tested with the "s1.apply(c1)", etc, so we check they are in the course*/
		assertTrue(c1.getStudents().size() == 3);
		assertTrue(c1.getStudents().contains(s1));
		assertTrue(c1.getStudents().contains(s2));
		assertTrue(c1.getStudents().contains(s3));
	}

	/**
	 * Test method for {@link moon.course.Course#removeApplication(moon.user.Application)}.
	 */
	@Test
	public void testRemoveApplication() {
		/*This is used when applications are accepted, so whe check a1 is not in the apps*/
		assertFalse(c1.getApplications().contains(a1));
	}

	/**
	 * Test method for {@link moon.course.Course#isExpelled(moon.user.Student)}.
	 */
	@Test
	public void testIsExpelled() throws InvalidEmailAddressException, FailedInternetConnectionException{
		c1.expelStudent(s1);
		assertTrue(c1.isExpelled(s1));
		c1.readmitStudent(s1);
		assertFalse(c1.isExpelled(s1));
	}

	/**
	 * Test method for {@link moon.course.Course#addUnit(moon.course.Unit)}.
	 */
	@Test
	public void testAddUnit() {
		assertTrue(c1.getUnits().contains(u1));
		assertTrue(c2.getUnits().contains(u2));
		assertFalse(c1.getUnits().contains(u2));
	}

	/**
	 * Test method for {@link moon.course.Course#addMark(moon.mark.MCourse)}.
	 */
	@Test
	public void testAddMark() {
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s1)));
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s2)));
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s3)));
		assertTrue(c1.getStudentMarks().size() == 3);
	}

	/**
	 * Test method for {@link moon.course.Course#getName()}.
	 */
	@Test
	public void testGetName() {
		assertTrue(c1.getName().equals("Course 1"));
		assertTrue(c2.getName().equals("Course 2"));
	}

	/**
	 * Test method for {@link moon.course.Course#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		c1.setName("VivaLaDoble");
		assertTrue(c1.getName().equals("VivaLaDoble"));
	}

	/**
	 * Test method for {@link moon.course.Course#getUnits()}.
	 */
	@Test
	public void testGetUnits() {
		assertTrue(c1.getUnits().size() == 1);
		assertTrue(c2.getUnits().size() == 1);

		assertTrue(c1.getUnits().contains(u1));
		assertTrue(c2.getUnits().contains(u2));
	}

	/**
	 * Test method for {@link moon.course.Course#getExpStudents()}.
	 */
	@Test
	public void testGetExpStudents() throws InvalidEmailAddressException, FailedInternetConnectionException{
		c1.expelStudent(s1);
		assertTrue(c1.getExpStudents().size() == 1);
		assertTrue(c1.getExpStudents().contains(s1));
	}

	/**
	 * Test method for {@link moon.course.Course#getStudentMarks()}.
	 */
	@Test
	public void testGetStudentMarks() {
		assertTrue(c1.getStudentMarks().size() == 3);
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s1)));
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s2)));
		assertTrue(c1.getStudentMarks().contains(c1.getMCourse(s3)));
	}

	/**
	 * Test method for {@link moon.course.Course#getApplications()}.
	 */
	@Test
	public void testGetApplications() {
		assertTrue(c1.getApplications().size() == 0);
		assertTrue(c2.getApplications().size() == 0);
		Course c3 = new Course("Course 3");
		assertTrue(c3.getApplications().size() == 0);
		try{
			s1.apply(c3);
		}catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			fail("Error with email system");
		}
		assertTrue(c3.getApplications().size() == 1);
	}

	/**
	 * Test method for {@link moon.course.Course#getExercises()}.
	 */
	@Test
	public void testGetExercises() {
		assertTrue(c1.getExercises().size() == 2);
		assertTrue(c2.getExercises().size() == 2);
		assertTrue(c1.getExercises().contains(e1));
		assertTrue(c1.getExercises().contains(e2));
	}
	
	/**
	 * Test method for {@link moon.course.Course#equals(Object)}
	 */
	@Test
	public void testEquals(){
		/* The special thing about this equals is that
		 * two courses will be equals if they have the same name.
		 */
		Course course1 = new Course("c1");
		Course course11 = new Course("c1");
		Course course2 = new Course("c2");
		assertTrue(course1.equals(course11));
		assertFalse(course1.equals(course2));
	}
}
