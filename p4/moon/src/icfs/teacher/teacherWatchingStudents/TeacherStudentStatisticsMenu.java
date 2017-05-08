/**
 * 
 */
package icfs.teacher.teacherWatchingStudents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import icfs.student.main.StudentSelectCourseStatsPanel;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class TeacherStudentStatisticsMenu extends StudentSelectCourseStatsPanel {
	JLabel name= new JLabel();
	JLabel averageMark = new JLabel();
	JLabel maximumMark = new JLabel();
	JLabel minimumMark = new JLabel();
	
	public TeacherStudentStatisticsMenu(){
		super();
		JPanel north = new JPanel();
		north.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		north.setLayout(new GridLayout(1,4,10,10));
		north.add(name);
		north.add(averageMark);
		north.add(minimumMark);
		north.add(maximumMark);
		north.setBackground(Color.WHITE);
		JScrollPane scroll = new JScrollPane(north);
		this.add(scroll,BorderLayout.NORTH);
	}
	
	public void setEverything(Student s){
		super.setEverything(s);
		name.setText(s.toString());
		averageMark.setText("Average: "+ (new Double(s.calcAverage()).toString()));
		maximumMark.setText("Maximum mark: "+ (new Double(s.calcMaximum()).toString()));
		minimumMark.setText("Minimum mark: "+ (new Double(s.calcMinimum()).toString()));
	}
	
}
