/**
 * 
 */
package icfs.teacher.course;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import icfs.LowerPanel;
import main.mainMoon;
import moon.Academy;
import moon.course.Course;
import moon.user.*;

/**
 * @author juan
 *
 */
public class ApplicationsView extends LowerPanel{
	DefaultListModel<Application> listModel = new DefaultListModel<>();
	JList<Application> list = new JList<>(listModel);
	ApplicationsController controller = new ApplicationsController(this);
	JButton accept = new JButton("Acept");
	JButton reject = new JButton("Reject");
	
	public ApplicationsView(){
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setLayout(new BorderLayout(10,10));
		
		JPanel north = new JPanel();
		north.add(new JLabel("The following students have applied fot rhis course:"));
		this.add(north,BorderLayout.NORTH);
		
		this.add(center(),BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		JButton back = new JButton("Back");
		back.addActionListener(e-> {
			mainMoon.courseSetEverything((Teacher)Academy.getMoonApp().getTeacher(), controller.getCourse());
			mainMoon.changeCard(mainMoon.COURSE);
		});
		south.add(back);
		this.add(south,BorderLayout.SOUTH);
	}

	/**
	 * @return
	 */
	private Component center() {
		JPanel center = new JPanel();
		JPanel up = new JPanel();
		JPanel lower = new JPanel();
		
		list.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(controller);
		up.add(new JScrollPane(list));
		lower.setLayout(new GridLayout(1,2,10,10));
		accept.addActionListener(e -> {
			controller.accept();
		});
		reject.addActionListener(e -> {
			controller.reject();
		});
		lower.add(accept);
		lower.add(reject);
		
		center.setLayout(new BorderLayout(10,10));
		center.add(up, BorderLayout.CENTER);
		center.add(lower, BorderLayout.SOUTH);
		return center;
	}

	public void setEverything(Course c){
		controller.setEverything(c);
		accept.setEnabled(false);
		reject.setEnabled(false);
	}
	
}

