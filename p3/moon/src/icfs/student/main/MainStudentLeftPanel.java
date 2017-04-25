/**
 * 
 */
package icfs.student.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import moon.course.Course;
import moon.user.Student;

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MainStudentLeftPanel extends JPanel {
	
	String[] whatToShow = {"All Courses", "My Courses"};
	JList<Course> allCourses;
	JList<Course> myCourses;
	JList<Course> actual = allCourses;
	JComboBox<String> options = new JComboBox<>(whatToShow);
	JScrollPane s = new JScrollPane(allCourses);
	
	MainStudentLeftPanel(Student s, MainStudentPanel parent){
		this.setLayout(new BorderLayout(10,10));
		Course[] a = new Course[0];
		myCourses = new JList<Course>(MainStudentController.getStudentCourses(s).toArray(a));
		allCourses = new JList<Course>(MainStudentController.getAllCourses().toArray(a));
		allCourses.setSize(300, 900);
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		this.setBorder(border1);
		allCourses.setBorder(border1);
		this.add(options, BorderLayout.NORTH);
		this.add(allCourses, BorderLayout.CENTER);

		this.setBackground(Color.black);
		this.setVisible(true);
		this.setSize(100, 200);
		
		allCourses.addMouseListener(new MainStudentJListController(s, parent));
		
		options.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if((String)arg0.getItem()=="All Courses"){
						optionAllCourses();
					} else if((String)arg0.getItem()=="My Courses") {
						optionMyCourses();
					}
				}
			}
		});
		
	}
	
	/**
	 * This method will remove the actual list from the panel and add the "all courses" one.
	 */
	public void optionAllCourses(){
		this.remove(actual);
		this.add(allCourses, BorderLayout.CENTER);
		this.repaint();
		actual = allCourses;
	}
	
	/**
	 * This method will remove the actual list from the panel and add the "my courses" one.
	 */
	public void optionMyCourses() {
		this.remove(actual);
		this.add(myCourses, BorderLayout.CENTER);
		this.repaint();
		actual = myCourses;
	}
}
