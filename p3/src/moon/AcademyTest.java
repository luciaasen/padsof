package moon;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import org.junit.Before;

import org.junit.After;

public class AcademyTest {

	@Before
	public void setUp() throws NumberFormatException, IOException{
		Academy moon = Academy.getMoonApp();
		moon.loadUsers("StudentData.txt");
		
		moon.setTeacher(t)	
	}
	
	
	
	@Test
	public void test() throws IOException{
		Academy a = Academy.getMoonApp();
		int users = a.loadUsers("StudentData.txt");
		System.out.println(users);
		
	}

}
