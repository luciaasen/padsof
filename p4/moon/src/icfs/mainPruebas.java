/**
 * 
 */
package icfs;

import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import icfs.login.*;
import icfs.student.course.StudentCourseView;
import icfs.student.main.MainStudentPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.course.Exercise;
import moon.course.Note;
import moon.course.Unit;
import moon.course.question.*;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class mainPruebas {
	
	public static void main(String[] args) throws Exception {
		/*PARA SETTEAR MOON, ANIADE STUDENTS*/
		setMoon();
		//studentModeTest();
		LoginWindowView l = new LoginWindowView();
		//epilepsiaFotosensible();
		//
	}
	
	public static void setMoon(){
		Academy a = new Academy();
		Academy.setMoon(a);
		try{
			a.loadUsers("StudentData.txt");
		}catch(NumberFormatException | IOException e){
			System.out.println("Error en la lectura de usuarios");
		}
	}
	
	/**
	 * Class designed to destroy your eyes.
	 * @throws Exception
	 */
	public static void epilepsiaFotosensible() throws Exception {
		Course math = new Course("Math");
		new Course("Padsof");
		
		
		Student s = new Student("pepe", "Rodriguez", "134", 1, "superpep.e@uam.es");
		s.apply(math).accept();
		MainStudentPanel aux1 = new MainStudentPanel();
		StudentCourseView aux2 = new StudentCourseView();
		JPanel superPanel = new JPanel();
		CardLayout layout = new CardLayout();
		
		superPanel.setLayout(layout);
		superPanel.add(aux1, "mainPanel");
		superPanel.add(aux2, "coursePanel");
		aux2.setEverything(s, math);
		JFrame window = new JFrame();
		window.getContentPane().add(superPanel);
		aux2.setVisible(true);
		aux1.setVisible(true);
		window.setVisible(true);
		window.setSize(1000, 600);
		
	
		while(true){
			layout.next(superPanel);
			TimeUnit.MILLISECONDS.sleep(50);
			layout.next(superPanel);
			TimeUnit.MILLISECONDS.sleep(50);
		}
		
		
	}
	
	private static void studentModeTest() throws Exception{
		Academy.setMoon(new Academy());
		Course math = new Course("Math");
		new Course("Padsof");
		Unit u1 = new Unit("Unit 123");
		math.addUnit(u1);
		Exercise e = new Exercise();

		e.makeVisible();
		e.setName("Exercise 1");

		e.setRandord(false);
		u1.addElement(e);
		e = new Exercise();

		e.makeVisible();
		e.setName("Exercise 2");
		e.setRandord(false);
		Question q = new TfQuestion("Mola maso moon?", 10, true, e);
		q = new TfQuestion("Por supuesto que mola maso tu ere tonto?", 10, true, e);
		Option o = new Option("Opcion correcta.");
		q = new OpenQuestion("Padsof padsof padsof padsof", 10, new ArrayList<Option>(Arrays.asList(o)), e);
		ArrayList<Option> options = new ArrayList<>();
		
		options.add(o);
		o= new Option("Option1");
		options.add(o);
		o= new Option("Option2");
		options.add(o);
		o= new Option("Option3");
		options.add(o);
		o= new Option("Option4");
		options.add(o);
		o= new Option("Option5");
		options.add(o);
		o= new Option("Option6");
		options.add(o);
		o= new Option("Option7");
		options.add(o);
		o= new Option("Option8");
		options.add(o);
		o= new Option("Option9");
		options.add(o);
		o= new Option("Option10");
		options.add(o);
		o= new Option("Option1");
		options.add(o);
		o= new Option("Option2");
		options.add(o);
		o= new Option("Option3");
		options.add(o);
		o= new Option("Option4");
		options.add(o);
		o= new Option("Option5");
		options.add(o);
		o= new Option("Option6");
		options.add(o);
		o= new Option("Option7");
		options.add(o);
		o= new Option("Option8");
		options.add(o);
		o= new Option("Option9");
		options.add(o);
		o= new Option("Option10");
		options.add(o);
		
		q= new OneChoiceQuestion("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new MultiChoiceQuestion("123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 123456789 ", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		q= new OneChoiceQuestion("padsofito", 10, options, new ArrayList<Option>(Arrays.asList(o)), e);
		
		u1.addElement(e);
		u1.addElement(new Unit("Unit 1.1"));
		Note n = new Note("node.getUserObject() instanceof Exercisenode.getUserObject() instanceof Exercisenode.getUserObject() instanceof Exercisenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenotenote");
		n.setTitle("Note1");
		u1.addElement(n);
		Student s = new Student("pepe", "Rodriguez", "1", 1, "1.1@1.1");
		s.apply(math).accept();

		u1.makeVisible();
		//mainMoon.userMode(s, Academy.getMoonApp());
	}
}
