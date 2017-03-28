/**
 * 
 */
package moon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.sun.glass.ui.Application;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.course.question.Question;
import moon.course.question.TfQuestion;
import moon.mark.MExercise;
import moon.mark.MQuestion;
import moon.mark.TfAnswer;
import moon.user.Student;
import moon.user.User;

/**
 * @author e336799
 *
 */
public class Demonstrator2 {
	/**
	 * This main will load some users, make a teacher login and 
	 * create some courses with units and exercises, and then students 
	 * will sequentally apply, log in and do the exercises.
	 */
	public static void main(String args[]){
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
		ArrayList<moon.user.Application> applicationList;
		MExercise me;
		MQuestion mq;
		int i =0;
		
		/*Load users and close app*/
		Academy moon = Academy.getMoonApp();
		try { moon.loadUsers("StudentData2.txt"); }
		catch (NumberFormatException | IOException except){
			except.printStackTrace();
		}
		serialize(moon);
		System.out.println("Users loaded from file and serialized app");
		
		/*Emulates teacher doing the courses initialization, the students 
		 * application to courses process and acceptation/rejection.
		 * It also creates the courses and the exercise structure
		 * with units etc */
		moon = deserialize();
		Academy.setMoon(moon);
		
		/* Now lets log in as a teacher and create some courses with some
		 * units. */
		
		u = moon.login("tea.cher@esu.es", "IsALotOfWork13579");
		c = new Course("Course 1");
		unit = new Unit("Unit 1 of course 1");
		unit.setCourse(c);
		/* We add an exercise to the unit */
		e = new Exercise();
		e.setUnit(unit);
		e.setRelevance(4);
		e.setPenalty(-3);
		unit.addElement(e);
		/* With two true/false questions */
		q = new TfQuestion("This is a sample question 1", 2, 
				true, e);
		q = new TfQuestion("This is a sample question 2", 4, 
				true, e);
		
		/* Let's create another unit */
		unit = new Unit("Unit 2 of course 1");
		unit.setCourse(c);
		/* We add an exercise to the unit */
		e = new Exercise();
		e.setUnit(unit);
		e.setRelevance(5);
		e.setPenalty(-2);
		unit.addElement(e);
		/* With one true/false question */
		q = new TfQuestion("This is a sample question 1", 2, 
				true, e);
		
		/* Let's set up another course */
		c = new Course("Course 2");
		/* With one unit */
		unit = new Unit("Unit 1 of course 2");
		unit.setCourse(c);
		/* With one exercise */
		e = new Exercise();
		e.setUnit(unit);
		e.setRelevance(4);
		e.setPenalty(-3);
		unit.addElement(e);
		/* With two TfQuestions */
		q = new TfQuestion("This is another sample question 1", 10, 
				true, e);
		q = new TfQuestion("This is another sample question 1", 2, 
				true, e);
		
		/* The next three lines emulate a close and an open of the
		 * application. After them, we log in as a student.
		 */
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		
		u = moon.login("Jorge.Alcazar@esdu.es", "JoA");
		/* We know it is actually a student but we could try
		 * u.isTeacher() if we didn't. */
		if(u.isTeacher()==false)
			s = (Student)u;
		else return;
		/* The student now checks the courses list and
		 * applies for the two courses */
		courseList = moon.getCourses();
		try {
			s.apply(courseList.get(0));
			s.apply(courseList.get(1));
		} catch (InvalidEmailAddressException | FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}

		/* Now we'll log in as another student, and apply too */
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		
		u = moon.login("Manuel.Blanco@esdu.es", "anuel.Bl");
		/* We know it is actually a student but we could try
		 * u.isTeacher() if we didn't. */
		if(u.isTeacher()==false)
			s = (Student)u;
		else return;
		/* The student now checks the courses list and
		 * applies for the two courses */
		courseList = moon.getCourses();
		try {
			s.apply(courseList.get(0));
			s.apply(courseList.get(1));
		} catch (InvalidEmailAddressException | 
				FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}
		/* Now we are going to accept three of the applications and reject
		 * one.
		 */
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		u = moon.login("tea.cher@edu.es", "IsALotOfWork13579");
		applicationList = moon.getApplications();
		try {
			applicationList.get(0).accept();
			applicationList.get(1).accept();
			applicationList.get(2).accept();
			/* We reject the application from Manuel Blanco to the course 2 */
			applicationList.get(3).reject();
		} catch (InvalidEmailAddressException |
				FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}		
		
		/* Now we'll log in as Manuel Blanco, and access and answer the exercise */
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		u = moon.login("Manuel.Blanco@esdu.es", "anuel.Bl");
		if(u.isTeacher()==false){
			s=(Student)u;
		} else return;
		/* Manuel Blanco has been accepted to the course 1 
		 * so we should be able to check the list of courses
		 * and enter in the course. */
		
		courseList = s.getCourses();
		c = courseList.get(0);
		System.out.println("The student "+ u.getName() + 
				" succesfully logged in \n and accessed the course "+
				c.getName());
		unit = c.getUnits().get(0);
		courseElements = unit.getContents();
		/* We look between the contents for an exercise */
		i=0;
		while(!(courseElements.get(i) instanceof Exercise)&&
				i<courseElements.size()){
			i++;
		}
		e = (Exercise)courseElements.get(i);
		 /* We now access the exercise and answer it */
		/* We create an answer */
		me = new MExercise(e);
		questionList = e.getQuestions();
		/* The exercise has 2 true/false questions */
		questionList.get(0).answer(true, me);
		questionList.get(1).answer(true, me);
		/* We finally save the exercise */
		c.getMCourse(s).addMExe(me);
		/* And check our stats */
		System.out.println("The student " + s.getName() + " " + 
				s.getLastName() + "\n has an average of " + 
				s.calcAverage());
		
		
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
}
