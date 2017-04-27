/**
 * 
 */
package icfs.student.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
	
	private String[] whatToShow = {"All Courses", "My Courses"};
	JList<Course> coursesL;
	private JComboBox<String> options = new JComboBox<>(whatToShow);
	private JScrollPane scrollP = new JScrollPane(coursesL);
	private DefaultListModel<Course> coursesM = new DefaultListModel<Course>();
	
	MainStudentLeftPanel(MainStudentPanel parent){
		this.setLayout(new BorderLayout(10,10));
		coursesL = new JList<Course>(coursesM);
		coursesL.setSize(300, 300);
		
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		this.setBorder(border1);
		coursesL.setBorder(border1);
		this.add(options, BorderLayout.NORTH);
		this.add(coursesL, BorderLayout.CENTER);

		this.setBackground(Color.black);
		this.setVisible(true);
		this.setSize(100, 200);
		
		scrollP.setVisible(true);
		coursesL.addMouseListener(new MainStudentJListController(parent));
		
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
	
	public void setEverything(Student s){
		MainStudentController.setEverything(s);
	}
	/**
	 * This method will remove the actual list from the panel and add the "all courses" one.
	 */
	public void optionAllCourses(){
		coursesM.removeAllElements();
		for(Course c : MainStudentController.getAllCourses()){
			coursesM.addElement(c);
		}
	}
	
	/**
	 * This method will remove the actual list from the panel and add the "my courses" one.
	 */
	public void optionMyCourses() {
		coursesM.removeAllElements();
		for(Course c : MainStudentController.getStudentCourses()){
			coursesM.addElement(c);
		}
	}
}
