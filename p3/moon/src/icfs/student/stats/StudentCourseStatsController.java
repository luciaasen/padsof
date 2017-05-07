/**
 * 
 */
package icfs.student.stats;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.DefaultMutableTreeNode;

import icfs.teacher.stats.TeacherCourseStatsController;
import main.mainMoon;
import moon.course.Course;
import moon.course.CourseElement;
import moon.course.Exercise;
import moon.course.Unit;
import moon.user.Student;

/**
 * @author juan
 *
 */
public class StudentCourseStatsController implements MouseListener {

	StudentCourseStats view;
	Student s;
	Course c;
	/**
	 * @param studentCourseStats
	 */
	public StudentCourseStatsController(StudentCourseStats view) {
		this.view = view;
	}
	
	public void setEverything(Student s, Course c){
		this.s=s;
		this.c=c;
		view.root.removeAllChildren();
		view.courseName.setText(c.getName());
		view.courseMark.setText("Mark: "+c.getCourseMark(s));
		for(Unit unit : c.getUnits()){
			if(unit.getVisibility()){
			}
		}
	}

	/**
	 * Recursive method to set the nodes of the tree.
	 * @param fatherNode
	 * @param element
	 * @param u
	 */
	public void setNodes(DefaultMutableTreeNode fatherNode, CourseElement element){
		if(element.getVisibility()){	
			DefaultMutableTreeNode node;
			if(element instanceof Unit){
				node = new DefaultMutableTreeNode();
				Unit unit = (Unit) element;
				node.setUserObject(element);
				for(CourseElement elem : unit.getContents()){
					setNodes(node, elem);
				}
				fatherNode.add(node);
			} else if(element instanceof Exercise){
				if(((Exercise)element).getExercise(s)!=null){
					node = new DefaultMutableTreeNode();
					node.setUserObject(element);
					fatherNode.add(node);
				}
			}
		}
	
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.tree.getLastSelectedPathComponent();
		if (node == null){
			return;
		} 
		if(node.getUserObject() instanceof Exercise){
			mainMoon.studentExerciseStatsSetEverything(s,c, (Exercise)node.getUserObject());
			mainMoon.changeCard(mainMoon.EXERCISE_STATS);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	
	@Override
	public void mouseExited(MouseEvent arg0) {}

	
	@Override
	public void mousePressed(MouseEvent arg0) {}

	
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
