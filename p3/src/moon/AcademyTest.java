package moon;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;

import org.junit.Before;

import org.junit.After;

import moon.user.*;

import moon.course.Course;

public class AcademyTest {

	@Before
	public void setUp() throws NumberFormatException, IOException{
		
	}
	
	
	
	@Test
	public void test() throws IOException, InvalidEmailAddressException, FailedInternetConnectionException{
		Academy a = Academy.getMoonApp();
		Course c1 = new Course("PADSOF");
		Course c2 = new Course("Mathematics");
		User t1 = new Teacher("Teacher", "Moon", "Moon1357", 0, "Teacher1@moon.es");
		User t2 = new Teacher("Teacher", "Moon", "Moon1357", 0, "Teacher2@moon.es");
		
		assertTrue(a.setTeacher(t1));
		assertFalse(a.setTeacher(t1));
		assertEquals(a.getTeacher(), t1);
		assertTrue(a.setTeacher(t2));
		assertEquals(a.getTeacher(), t2);
		
		int users = a.loadUsers("StudentData.txt");
		System.out.println(users);
		HashSet<User>  set = a.getUsers();
		for(User u: set){
			System.out.println(u);
		}	
		
		assertTrue(a.addCourse(c1));
		assertTrue(a.addCourse(c2));
		assertFalse(a.addCourse(c1));
		
		assertEquals(a.login("Teacher2@moon.es", "Moon1357"), t2);
		assertNull(a.login("Jorge.Alcazar@esdu.es", "joa"));
		assertNotNull(a.login("Jorge.Alcazar@esdu.es", "JoA"));
		
		Student u1 = (Student)a.login("Jorge.Alcazar@esdu.es", "JoA");
		Student u2 = (Student)a.login("Antonio.Ortega@esdu.es", "onni");
		
		assertNotNull(u1);
		assertNotNull(u2);
		
		Application p1 = u1.apply(c1);
		Application p2 = u2.apply(c2);
		assertTrue(a.getApplications().contains(p1));
		assertTrue(a.getApplications().contains(p2));
		
		assertTrue(a.getCourses().contains(c1));
		assertTrue(a.getCourses().contains(c2));
		
		
	}

}
