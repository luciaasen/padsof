/**
 * 
 */
package icfs.teacher.edit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import exception.DoneExerciseException;
import icfs.teacher.course.TeacherCourseView;
import main.mainMoon;
import moon.Academy;
import moon.course.*;
import moon.course.question.Question;

/**
 * @author lucia
 *
 */
public class EditButtonController implements ActionListener{

	private  TeacherCourseView view;
	
	public EditButtonController(TeacherCourseView view){
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = null;
		JCheckBox check = null;
		if(e.getSource() instanceof JButton){
			button = (JButton)e.getSource();
		}else if (e.getSource() instanceof JCheckBox){
			check = (JCheckBox)e.getSource();
		}
		
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) view.getTree().getLastSelectedPathComponent();
		
		try{
			if(node==null){
				return;				
			/*    UNIT     */
			}else if (node.getUserObject() instanceof Unit) {
				Unit selected = (Unit)node.getUserObject();
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						selected.getCourse().removeUnit(selected);
						view.setEverything(Academy.getMoonApp().getTeacher(), selected.getCourse());
					}
				}else if(check != null){
					if(check.isSelected()){
						selected.makeVisible();
					}else{
						selected.makeInvisible();
					}
				}
							
			/*     COURSE     */	
			}else if (node.getUserObject() instanceof Course) {
				
				if(button.getText().equals("Edit element and contents")){
					
				}	
				
			/*     EXERCISE     */
			}else if (node.getUserObject() instanceof Exercise) {
				Exercise selected = (Exercise)node.getUserObject();
				
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						selected.getUnit().removeElement(selected);
					}
				}else if(check != null){
					if(check.getText().equals("Visibility")){
						if(check.isSelected()){
							selected.makeVisible();
						}else{
							selected.makeInvisible();
						}
					}else if(check.getText().equals("Random questions order")){
						selected.setRandord(check.isSelected());
					}
				}
				
			/*      NOTE      */
			}else if (node.getUserObject() instanceof Note) {
				Note selected = (Note)node.getUserObject();
				
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						mainMoon.editNoteSetEverything(selected.getUnit(), selected);
					}else if(button.getText().equals("Remove")){
						selected.getUnit().removeElement(selected);
					}
				}else if(check != null){
					if(check.getText().equals("Visibility")){
						if(check.isSelected()){
							selected.makeVisible();
						}else{
							selected.makeInvisible();
						}
					}
				}
				
			/*     QUESTION      */
			}else if (node.getUserObject() instanceof Question) {
				Question selected = (Question)node.getUserObject();
	
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						selected.getExercise().removeQuestion(selected);
					}
				}else if(check != null){
					//TODO set randor to options era un requisito??
				}
		
			}
		}catch(DoneExerciseException ex){
			JOptionPane.showOptionDialog(view, ex.toString(), "Invalid operation", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
	}
}
