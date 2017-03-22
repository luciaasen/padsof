package moon;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import org.junit.Before;

import org.junit.After;

import moon.user.*;

public class AcademyTest {

	@Before
	public void setUp(){
		Academy moon = Academy.getMoonApp();
		
	}
	
	
	
	@Test
	public void test() throws IOException{
		Academy a = Academy.getMoonApp();
		int users = a.loadUsers("StudentData.txt");
		System.out.println(users);
		ArrayList<User>  list = a.getUsers();
		for(User u: list){
			System.out.println(u);
		}				
	}

}
