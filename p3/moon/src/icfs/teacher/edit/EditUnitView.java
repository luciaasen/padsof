/**
 * 
 */
package icfs.teacher.edit;

import icfs.LowerPanel;
import icfs.teacher.create.AddUnitView;
import moon.course.Note;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class EditUnitView extends AddUnitView{
	
	private Unit oldUnit;
	
	public  EditUnitView(){
		super();
		
		this.addExe.removeActionListener(this.addExe.getActionListeners()[0]);
		this.exit.removeActionListener(this.exit.getActionListeners()[0]);
		this.save.removeActionListener(this.save.getActionListeners()[0]);
		this.addSub.removeActionListener(this.addSub.getActionListeners()[0]);
		this.addNote.removeActionListener(this.addNote.getActionListeners()[0]);
		
		this.addExe.addActionListener(new EditUnitController(this));
		this.addSub.addActionListener(new EditUnitController(this));
		this.addNote.addActionListener(new EditUnitController(this));
		this.save.addActionListener(new EditUnitController(this));
		this.exit.addActionListener(new EditUnitController(this));
		
		this.exit.setText("Back to course page");
		
		message.setText("Edit unit");
		nameLabel.setText("Edit name: ");
	}
	
	public void setEverything(Unit oldUnit){
		name.setEnabled(true);
		this.oldUnit = oldUnit;
		
		nameLabel.setText("Edit name: ");
		name.setText(oldUnit.getName());
		visibility.setSelected(oldUnit.getVisibility());
	}
	
	public Unit getOldUnit(){
		return oldUnit;
		
	}
}
