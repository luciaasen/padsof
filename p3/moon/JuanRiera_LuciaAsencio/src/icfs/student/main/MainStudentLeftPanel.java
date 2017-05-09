/**
 * 
 */
package icfs.student.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import moon.Academy;
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
	private MainStudentJListController listController;
	MainStudentPanel parent;
	
	MainStudentLeftPanel(MainStudentPanel parent){
		this.setLayout(new BorderLayout(10,10));
		coursesL = new JList<Course>(coursesM);
		coursesL.setSize(300, 300);
		this.parent=parent;
		Border border1 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		this.setBorder(border1);
		coursesL.setBorder(border1);
		
		JPanel borderForTheList = new JPanel();
		borderForTheList.setLayout(new GridLayout(1,1));
		borderForTheList.setBorder(BorderFactory.createLineBorder(Academy.DARK_GREEN, 10, false));
		borderForTheList.add(coursesL);
		this.add(options, BorderLayout.NORTH);
		this.add(borderForTheList, BorderLayout.CENTER);

		this.setBackground(Academy.ORANGE);
		this.setVisible(true);
		this.setSize(100, 200);
		
		scrollP.setVisible(true);
		listController = new MainStudentJListController(parent);
		coursesL.addMouseListener(listController);
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
		listController.setEverything(s);
		options.setSelectedIndex(0);
		optionAllCourses();
	}
	/**
	 * This method will remove the actual list from the panel and add the "all courses" one.
	 */
	public void optionAllCourses(){
		coursesM.removeAllElements();
		for(Course c : parent.controller.getAllCourses()){
			coursesM.addElement(c);
		}
	}
	
	/**
	 * This method will remove the actual list from the panel and add the "my courses" one.
	 */
	public void optionMyCourses() {
		coursesM.removeAllElements();
		for(Course c : parent.controller.getStudentCourses()){
			coursesM.addElement(c);
		}
	}
}
