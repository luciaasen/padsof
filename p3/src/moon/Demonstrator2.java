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

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.mark.MExercise;
import moon.mark.MQuestion;
import moon.mark.TfAnswer;
import moon.user.Student;
import moon.user.User;
import moon.course.question.*;

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
		Option o;
		ArrayList<Option> options1, options2;
		
		int i =0;
		System.out.println("Application started.");
		/*Load users and close app*/
		System.out.println("Loading users...");
		Academy moon = Academy.getMoonApp();
		try { moon.loadUsers("StudentData2.txt"); }
		catch (NumberFormatException | IOException except){
			except.printStackTrace();
		}
		serialize(moon);
		System.out.println("Users loaded from file and serialized app.\nDeserializing...");
		
		/*Emulates teacher doing the courses initialization, the students 
		 * application to courses process and acceptation/rejection.
		 * It also creates the courses and the exercise structure
		 * with units etc */
		moon = deserialize();
		Academy.setMoon(moon);
		
		/* Now lets log in as a teacher and create some courses with some
		 * units. */
		System.out.println("Moon restarted. Loging  in as a teacher.");
		u = moon.login("tea.cher@esu.es", "IsALotOfWork13579");

		c = new Course("Course 1");
		System.out.println("Created course " + c.getName());
		unit = new Unit("Unit 1 of course 1");
		unit.setCourse(c);
		/* We add an exercise to the unit */
		System.out.println("Adding exercise to unit '" + unit.getName() + "' ");
		e = new Exercise();
		e.setUnit(unit);
		e.setRelevance(4);
		e.setPenalty(-1);
		unit.addElement(e);
		/* With one question of each type */
		System.out.println("Adding True/False question.");
		/* True/False */
		q = new TfQuestion("This is a sample question 1", 2, 
				true, e);
		/* Single choice */
		System.out.println("Adding Single Choice question.");
		options1 = new ArrayList<>();
		options2 = new ArrayList<>();
		o = new moon.course.question.Option("Answer 1");
		options1.add(o);
		o = new moon.course.question.Option("Answer 2");
		options1.add(o);
		options2.add(o);
		o = new moon.course.question.Option("Answer 3");
		options1.add(o);
		o = new moon.course.question.Option("Answer 4");
		options1.add(o);
		
		q = new ChoiceQuestion("This is a sample question 2", 4, 
				options1, options2, e);
		
		/* Multiple choice */
		System.out.println("Adding Multiple Choice question.");
		options1 = new ArrayList<>();
		options2 = new ArrayList<>();
		o = new moon.course.question.Option("Answer 1");
		options1.add(o);
		o = new moon.course.question.Option("Answer 2");
		options1.add(o);
		options2.add(o);
		o = new moon.course.question.Option("Answer 3");
		options1.add(o);
		options2.add(o);
		o = new moon.course.question.Option("Answer 4");
		options1.add(o);
		
		q = new ChoiceQuestion("This is a sample question 3", 5, 
				options1, options2, e);
		
		/* Open answer */
		System.out.println("Adding Open Answer question.");
		o = new Option("This is a sample question 1");
		options1 = new ArrayList<>();
		options1.add(o);
		q = new OpenQuestion("This is a sample question 4", 6, 
						options1, e);
		
		/* Let's set up another course */
		c = new Course("Course 2");
		System.out.println("Added another course "+ c.getName());
		/* With one unit */
		unit = new Unit("Unit 1 of course 2");
		unit.setCourse(c);
		System.out.println("Added a new unit "+ u.getName());
		
		
		/* The next three lines emulate a close and an open of the
		 * application. After them, we log in as a student.
		 */
		System.out.println("Serializing moon...");
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		System.out.println("Moon restarted. Logging in as Manuel Blanco.");
		
		u = moon.login("Manuel.Blanco@esdu.es", "anuel.Bl");
		/* We know it is actually a student but we could try
		 * u.isTeacher() if we didn't. */
		if(u.isTeacher()==false)
			s = (Student)u;
		else return;
		/* The student now checks the courses list and
		 * applies for the two courses */
		System.out.println("Checking course list");
		courseList = moon.getCourses();
		try {
			System.out.println("Applying for both courses");
			s.apply(courseList.get(0));
			s.apply(courseList.get(1));
		} catch (InvalidEmailAddressException | 
				FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}
		/* Now we are going to accept three of the applications and reject
		 * one.
		 */
		System.out.println("Serializing...");
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		System.out.println("Moon restarted. Logging in as the teacher.");
		u = moon.login("tea.cher@edu.es", "IsALotOfWork13579");
		applicationList = moon.getApplications();
		try {
			System.out.println("Accepting applications.");
			applicationList.get(0).accept();
			applicationList.get(1).accept();
		} catch (InvalidEmailAddressException |
				FailedInternetConnectionException e1) {
			e1.printStackTrace();
		}		
		
		/* Now we'll log in as Manuel Blanco, and access and answer the exercise */
		System.out.println("Serializing...");
		serialize(moon);
		moon = deserialize();
		Academy.setMoon(moon);
		System.out.println("Moon restarted. Logging in as Manuel Blanco");
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
		System.out.println("Answering the questions of the exercise.");
		me = new MExercise(e);
		questionList = e.getQuestions();
		/* The exercise has one question of each type */
		
		/* True false question */
		questionList.get(0).answer(true, me);
		
		/* Single choice */
		options1 = new ArrayList<>();
		options2 = ((ChoiceQuestion)questionList.get(1)).getOptions();
		options1.add(options2.get(1));
		questionList.get(1).answer(options1, me);
		
		/* Multiple Choice */
		options1 = new ArrayList<>();
		options2 = ((ChoiceQuestion)questionList.get(1)).getOptions();
		options1.add(options2.get(1));
		options1.add(options2.get(2));
		questionList.get(2).answer(options1, me);
		
		/* Open answer question */
		options1 = new ArrayList<>();
		o = new Option("This is a sample answer 1");
		options1.add(o);
		questionList.get(3).answer(options1, me);
		
		
		/* We finally save the exercise */
		System.out.println("Saving the answer...");
		c.getMCourse(s).addMExe(me);
		/* And check our stats */
		System.out.println("The student " + s.getName() + " " + 
				s.getLastName() + "\n has an average of " + 
				s.calcAverage());
		System.out.println("Serializing...");
		serialize(moon);
		System.out.println("Closing Moon.");
		
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
