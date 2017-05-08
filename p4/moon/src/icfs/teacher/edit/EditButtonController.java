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

						mainMoon.editUnitSetEverything(selected);
						mainMoon.changeCard(mainMoon.EDIT_UNIT);
						
					}else if(button.getText().equals("Remove")){
						selected.getCourse().removeUnit(selected);
					}
				}else if(check != null){
					if(check.isSelected()){
						selected.makeVisible();
					}else{
						selected.makeInvisible();
					}
				}
				view.setEverything(Academy.getMoonApp().getTeacher(), selected.getCourse());
				view.revalidate();
				
							
			/*     COURSE     */	
			}else if (node.getUserObject() instanceof Course) {
				
				Course selected = (Course)node.getUserObject();
				
				if(button.getText().equals("Edit element and contents")){
					mainMoon.editCourseSetEverything(selected);
					mainMoon.changeCard(mainMoon.EDIT_COURSE);
				}	
				
				view.setEverything(Academy.getMoonApp().getTeacher(), selected);
				view.revalidate();
			
			/*     EXERCISE     */
			}else if (node.getUserObject() instanceof Exercise) {
				Exercise selected = (Exercise)node.getUserObject();
				if(selected.hasBeenDone() == false){
					if(button != null){
						if(button.getText().equals("Edit element and contents")){
							mainMoon.editExeSetEverything(selected);
							mainMoon.changeCard(mainMoon.EDIT_EXE);
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
				}else throw new DoneExerciseException();
				view.setEverything(Academy.getMoonApp().getTeacher(), selected.getCourse());
				view.revalidate();
				
			/*      NOTE      */
			}else if (node.getUserObject() instanceof Note) {
				Note selected = (Note)node.getUserObject();
				
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						mainMoon.editNoteSetEverything(selected.getUnit(), selected);
						mainMoon.changeCard(mainMoon.EDIT_NOTE);
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
				
				view.setEverything(Academy.getMoonApp().getTeacher(), selected.getCourse());
				view.revalidate();
				
			/*     QUESTION      */
			}else if (node.getUserObject() instanceof Question) {
				Question selected = (Question)node.getUserObject();
	
				if(button != null){
					if(button.getText().equals("Remove")){
						selected.getExercise().removeQuestion(selected);
					}
				}else if(check != null){
					//TODO add shuffle de las options
				}
				
				view.setEverything(Academy.getMoonApp().getTeacher(), selected.getExercise().getCourse());
				view.revalidate();
			}
			
		}catch(DoneExerciseException ex){
			JOptionPane.showOptionDialog(view, ex.toString(), "Invalid operation", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
	}
}
