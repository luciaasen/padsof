
package moon;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.*;
import moon.user.*;
import moon.course.*;
import moon.course.question.*;
import moon.mark.MExercise;
import moon.mark.MQuestion;
import moon.*;


/**
 * @author Lucia Asencio and Juan Riera
 * This class shows the normal functionality of the app
 *
 */
public class Demonstrator {
	/**
	 * This main will load some users, make a teacher login and create some courses with units and exercises, and then students will sequentally apply, log in and do the exercises
	 */
	public static void main(String args[]){

		
		/*Load users and close app*/
		Academy moon = Academy.getMoonApp();
		try { moon.loadUsers("StudentData2.txt"); }
		catch (NumberFormatException | IOException e){
			e.printStackTrace();
		}
		serialize(moon);
		System.out.println("Users loaded from file and serialized app");
		
		/*Emulates teacher doing the courses initialization, the students 
		 * application to courses process and acceptation/rejection.
		 * It also creates the courses and the exercise structure
		 * with units etc */
		Demonstrator.setUpStudents(moon);
		
		/* The next theree lines emulate a close and an open of the
		 * application.
		 */
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		
		doExercises(moon);
	}
	/**
	 * Auxiliar method to serialize moon.
	 * @param moon
	 * @throws IOException
	 */
	public static void serialize(Academy moon) {
		try {
		FileOutputStream fileOut =
				new FileOutputStream("moon.ser");
		ObjectOutputStream out = 
				new ObjectOutputStream(fileOut);
		out.writeObject(moon);
		out.close();
		fileOut.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Auxiliar method to deserialize moon.
	 * @return
	 */
	public static Academy deserialize(){
		Academy moon;
		try{
			FileInputStream fileIn =
					new FileInputStream("moon.ser");
			ObjectInputStream in =
					new ObjectInputStream(fileIn);
			moon = (Academy) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return moon;
	}

	/**
	 * Method that creates a predefined list of 4 exercises, that will be in: 
	 * c1 u1: e1, e2
	 * c1 u2: e3
	 * c2 u1: e4
	 * 
	 * @return ArrayList with the exercises.
	 */
	public static ArrayList<Exercise> setUpExes(){
		Exercise e1, e2, e3, e4;
		Question q1, q2, q3, q4, q5, q6;
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
		q4 = new TfQuestion("Are you okay?", 3, true, e2);
		q5 = new TfQuestion("uhm?", 5, false, e3);
		q6 = new TfQuestion("Am I tired?", 5, true, e4);
		
		ArrayList <Exercise> exe = new ArrayList<>();
		exe.add(e1);
		exe.add(e2);
		exe.add(e3);
		exe.add(e4);
		
		return exe;
	}
	
	/**
	 * This method creates a list of 2 courses and fill them up with some contents (units, exercises, notes)
	 * @param moon, the application
	 * @return list of created courses
	 */
	public static ArrayList<Course> setUpCourses(Academy moon){
		/*Logs in as a teacher*/
		User t = moon.login("tea.cher@edu.es", "IsALotOfWork13579");
		if(t.isTeacher()) System.out.println("Teacher successfuly logged in...");
		
		/*Creates courses and fill them up*/
		ArrayList<Exercise> exe = Demonstrator.setUpExes();		
		Course c1, c2;
		Unit u1, u2, u3, u4, u21;
		Note n1, n2;
				
		/*Adds to units to c1:
		 *  U1: 2 exes. 1 note
		 *  U2: 1 exe, 1 subunit*/
		c1 = new Course("Course 1");
		/*1º unit*/
		u1 = new Unit("Unit 1");
		u1.setCourse(c1);
		exe.get(0).setUnit(u1);
		exe.get(1).setUnit(u1);
		u1.addElement(exe.get(0));
		u1.addElement(exe.get(1));
		n1 = new Note("This is not a long, long note");
		n1.setUnit(u1);
		
		/*2º unit*/
		u2 = new Unit("Unit 2");
		u2.setCourse(c1);
		exe.get(2).setUnit(u2);
		u2.addElement(exe.get(2));
		u21 = new Unit("Subunit 1");
		u21.setUnit(u2);
		u2.addElement(u21);
		
		/*Adds 2 units to c2:
		 * U3: 1 exe
		 * U4: 1 note*/
		c2 = new Course("Course 2");
		/*1º unit*/
		u3 = new Unit("Viva la doble");
		u3.setCourse(c2);
		exe.get(3).setUnit(u2);
		u2.addElement(exe.get(3));
		
		/*2º unit*/
		u4 = new Unit("Second unit in second course, 2*2 = 2^2 :D");
		u4.setCourse(c2);
		n2 = new Note("This is either a long or a short note, but not both at the same time");
		n2.setUnit(u4);
		
		
		ArrayList<Course> c= new ArrayList<>();
		c.add(c1);
		c.add(c2);
		
		System.out.println("And created 2 courses with contents: units, subunits, exercises and notes");
		return c;
	}
	
	/**
	 * This method creates some courses with contents and then emulates the login-apply-logout of 3 students
	 * Afterwards, emulates the login accept-reject of a teacher
	 * @param moon
	 * @return ArrayList of the students added
	 */
	public static void setUpStudents(Academy moon){
		Application a1;
		ArrayList<Course> c = Demonstrator.setUpCourses(moon);
		ArrayList<Student> s = new ArrayList<>();
		User s1, s2, s3, t;
		/* We could have used just one user, the user that is using the
		 * application in that moment, but we thought it was more visual
		 * this way. Each serialization and deserialization emulates
		 * the action of closing and opening the app.
		 */
		try{
			s1 = moon.login("Manuel.Blanco@esdu.es", "anuel.Bl");
			((Student)s1).apply(c.get(0));
			((Student)s1).apply(c.get(1));
			serialize(moon);
			moon = deserialize();
			Academy.setMoon(moon);
			s2 = moon.login("Jorge.Alcazar@esdu.es", "JoA");
			((Student)s2).apply(c.get(0));
			((Student)s2).apply(c.get(1));
			serialize(moon);
			moon = deserialize();
			Academy.setMoon(moon);
			s3 = moon.login("Ana.Cordero@esdu.es", "Coero");
			((Student)s3).apply(c.get(0));
			((Student)s3).apply(c.get(1));
			serialize(moon);
			
			/* We now login as a teacher and accept some applications
			 * and reject others.
			 */
			moon = deserialize();
			Academy.setMoon(moon);
			t = moon.login("tea.cher@edu.es", "IsALotOfWork13579");
			c.get(0).getApplications().get(0).accept();
			c.get(0).getApplications().get(0).accept();
			c.get(0).getApplications().get(0).accept();
			c.get(1).getApplications().get(0).accept();
			c.get(1).getApplications().get(0).accept();
			c.get(1).getApplications().get(0).reject();
			
			if(c.get(0).getStudents().size() == 3 & c.get(1).getStudents().size() == 2 )
				System.out.println("3 students logged in and applied for both courses, 5 applications were accepted and 1 was rejected by the teacher");
						
		}catch(InvalidEmailAddressException | FailedInternetConnectionException e){
			fail("Error with email system");
		}		
		return;
	}
	
	public static void doExercises(Academy moon1){
		User u;
		Student s;
		Course c;
		Unit unit;
		Exercise e;
		Question q;
		ArrayList<Course> courseList;
		ArrayList<Exercise> exerciseList;
		ArrayList<CourseElement> courseElements;
		ArrayList<Question> questionList;
		MExercise me;
		MQuestion mq;
		int i = 0;
		
		u = moon1.login("Jorge.Alcazar@esdu.es", "JoA");
		/* We know it is actually a student but we could try
		 * u.isTeacher() if we didn't. */
		s = (Student)u;
		courseList = s.getCourses();
		
		/* The student has been accepted so we should be able to enter in
		 * the first one */
		
		c = courseList.get(0);
		System.out.println("The student "+ u.getName() + 
				" succesfully logged in \n and accessed the course "+
				c.getName());
		unit = c.getUnits().get(0);
		courseElements = unit.getContents();
		/* We look between the contents for an exercise */
		while(!(courseElements.get(i) instanceof Exercise)&&
				i<courseElements.size()){
			i++;
		}
		e = (Exercise)courseElements.get(i);
		 /* We now access one exercise and answer it */
		/* We create an answer */
		me = new MExercise(e);
		questionList = e.getQuestions();
		i=1;
	}

}
