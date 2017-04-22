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

/**
 * @author Juan Riera and Lucia Asencio
 *
 */
public class MainStudentLeftPanel extends JPanel {
	
	String[] whatToShow = {"All Courses", "My Courses"};
	Course[] a = new Course[0];
	JList<Course> allCourses = new JList<Course>(MainStudentController.getAllCourses().toArray(a));
	/* TODO next line */
	JList<Course> myCourses = new JList<Course>();
	JList<Course> actual = allCourses;
	JComboBox<String> options = new JComboBox<>(whatToShow);
	JScrollPane s = new JScrollPane(allCourses);
	
	MainStudentLeftPanel(){
		this.setLayout(new BorderLayout(10,10));
		allCourses.setSize(300, 900);
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		this.setBorder(border1);
		allCourses.setBorder(border1);
		this.add(options, BorderLayout.NORTH);
		this.add(allCourses, BorderLayout.CENTER);

		this.setBackground(Color.black);
		this.setVisible(true);
		this.setSize(100, 200);
		
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
		actual = allCourses;
	}
	
	/**
	 * This method will remove the actual list from the panel and add the "my courses" one.
	 */
	public void optionMyCourses() {
		this.remove(actual);
		this.add(myCourses, BorderLayout.CENTER);
		actual = myCourses;
	}
}
