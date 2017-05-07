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
			}else if (node.getUserObject() instanceof Unit) {
				Unit selected = (Unit)node.getUserObject();
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						selected.getCourse().removeUnit(selected);
						//TODO recargar el arbols
					}
				}else if(check != null){
					selected.s
				}
							
			}else if (node.getUserObject() instanceof Course) {
				
				if(button.getText().equals("Edit element and contents")){
					
				}	
				
			}else if (node.getUserObject() instanceof Exercise) {
				Exercise selected = (Exercise)node.getUserObject();
				
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						selected.getUnit().removeElement(selected);
					}
				}else if(check != null){
					if(check.getText().equals("Visibility")){
						
					}else if(check.getText().equals("Random questions order")){
						
					}
				}
				
			}else if (node.getUserObject() instanceof Note) {
	
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						
					}
				}else if(check != null){
					if(check.getText().equals("Visibility")){
						
					}
				}
				
			}else if (node.getUserObject() instanceof Question) {
	
				if(button != null){
					if(button.getText().equals("Edit element and contents")){
						
					}else if(button.getText().equals("Remove")){
						
					}
				}else if(check != null){
					if(check.getText().equals("Visibility")){
						
					}else if(check.getText().equals("Random options order")){
						
					}
				}
		
			}
		}catch(DoneExerciseException ex){
			JOptionPane.showOptionDialog(view, ex.toString(), "Invalid operation", JOptionPane.YES_OPTION, 
					JOptionPane.ERROR_MESSAGE, null, new String[]{"Ok"}, null);
		}
	}
}
