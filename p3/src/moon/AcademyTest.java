/**
 * 
 */
package moon;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.user.Application;
import moon.user.Student;
import moon.user.Teacher;
import moon.user.User;

/**
 * @author juan
 *
 */
public class AcademyTest {

	Academy a;
	Course c1;
	Course c2;
	User t1, s1, s2, s3;
	int users;
	
	@Before
	public void setUp() throws NumberFormatException, IOException{
		a = Academy.getMoonApp();
		c1 = new Course("PADSOF");
		c2 = new Course("Mathematics");
		t1 = Academy.getMoonApp().getTeacher();
		users = a.loadUsers("StudentData.txt");
		s1 = new Student("Luis", "Gallego", "s.ll", 1264, "Luis.Gallego=esdu.es");
		s2 = new Student("Jorge", "Alcazar","JoA", 1289, "Jorge.Alcazar@esdu.es");
		s3 = new Student("Manuel", "Blanco", "anuel.Bl", 1258, "Manuel.Blanco@esdu.es");
		
	}
	
	/**
	 * Test method for {@link moon.Academy#loadUsers(java.lang.String)}.
	 */
	@Test
	public void testLoadAddAndGetUsers() {
		/* It is 2 because the teacher is not read and one student could not
		 * be added because it had an invalid email */
		assertEquals(users, 2);
		HashSet<User> set = a.getUsers();
		
		/*This user has invalid email,therefore it should not have been added*/
		assertFalse(SpecialContains(set, s1));
		assertTrue(SpecialContains(set, s2));
		assertTrue(SpecialContains(set, s3));
		assertTrue(SpecialContains(set, t1));
	}
	
	/**
	 * Test method for {@link moon.Academy#getTeacher()}.
	 */
	@Test
	public void testGetTeacher() {
		Teacher t = new Teacher("Teacher", "Teacher", "PwdTeacher1357", 1, 
				"tea.cher@edu.es");
		
		assertNotNull(t1);
		/* They are equals because they have the same email */
		assertTrue(t1.equals(t));
	}
	
	/**
	 * Test method for {@link moon.Academy#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogin() {
		
		/*Logging in as a teacher*/
		assertNotEquals(a.login("t.eacher@edu.es", "PwdTeacher1358"), t1);
		assertEquals(a.login("tea.cher@edu.es", "IsALotOfWork13579"), t1);
		
		/*Logging in as a student*/
		assertNull(a.login("Jorge.Alcazar@esdu.es", "joa"));
		assertNotNull(a.login("Jorge.Alcazar@esdu.es", "JoA"));
		
		/*This student had wrong email and should not be able to log in */
		assertNull((a.login("Luis.Gallego=esdu.es", "s.ll")));
	}

	/**
	 * Test method for {@link moon.Academy#getApplications()}.
	 */
	@Test
	public void testGetApplications() {
		Application p1 = null, p2=null, p3=null, p4=null;
		try {
			p1 = ((Student)s1).apply(c1);
			p2 = ((Student)s1).apply(c1);
			p3 = ((Student)s2).apply(c1);
			p4 = ((Student)s2).apply(c2);
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e) {
			e.printStackTrace();
			fail("Error with the email System");
			
		}
		
		ArrayList<Application> list = new ArrayList<>();
		list.addAll(a.getApplications());
		
		assertTrue(a.getApplications().contains(p1));
		/* A student can not apply twice to the same course */
		assertFalse(a.getApplications().contains(p2));
		assertTrue(a.getApplications().contains(p3));
		assertTrue(a.getApplications().contains(p4));
	}


	/**
	 * Test method for {@link moon.Academy#addCourse(moon.course.Course)}.
	 */
	@Test
	public void testAddCourseAndGetThem() {
		/* These should both fail, because both courses have already been added 
		 * from the constructor */
		assertFalse(a.addCourse(c1));
		assertFalse(a.addCourse(c2));
		
		/* Now lets make sure that they are really in, and that that was the reason
		 * why they were not added on our last try.
		 */
		HashSet<Course> set = a.getCourses();
		assertTrue(set.contains(c1));
		assertTrue(set.contains(c2));
		
	}
	
	/**
	 * Test method for {@link moon.Academy#Academy()}
	 * and {@link moon.Academy#setMoon(Academy)}
	 */
	@Test
	public void testAcademyAndSetMoon(){
		Academy a1 = new Academy();
		
		assertNotNull(a1);
		assertNotNull(a1.getTeacher());
		assertEquals(a1.getTeacher(), a1.login("tea.cher@edu.es", "IsALotOfWork13579"));
		
		Academy.setMoon(a1);
		assertEquals(Academy.getMoonApp(), a1);
	}
	
	/** Auxiliar function for testGetUsers. It recieves a HashSet of users
	 * and a user, and checks if any of the users in the set is equal to the user
	 * passed as an argument. This means that it works in the same way as the
	 * method contains, but using equals instead.
	 * 
	 * @param set
	 * @param u
	 * @return
	 */
	public boolean SpecialContains(HashSet<User> set, User u){
		for(User user : set){
			if(user.equals(u)){
				return true;
			}
		}
		return false;
	}
	


}
