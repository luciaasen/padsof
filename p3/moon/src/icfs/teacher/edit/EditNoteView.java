/**
 * 
 */
package icfs.teacher.edit;

import icfs.teacher.create.AddNoteView;
import moon.course.Note;
import moon.course.Unit;

/**
 * @author lucia
 *
 */
public class EditNoteView extends AddNoteView{
	private Note oldNote;
	public EditNoteView(){
		super();
		message.setText("Edit note from unit " + parentUnit);;
		nameLabel.setText("Edit name: ");
		contentsLabel.setText("Edit content: ");
		content.setText(oldNote.getText());
		name.setText(oldNote.getTitle());
		visibility.setSelected(oldNote.getVisibility());
		save.setText("Save & back to course tree");
	}
	
	public void setEverything(Unit parentUnit, Note oldNote){
		name.setEnabled(true);
		content.setEnabled(true);
		this.oldNote = oldNote;
		message.setText("Edit note from unit " + parentUnit);;
		nameLabel.setText("Edit name: ");
		contentsLabel.setText("Edit content: ");
		content.setText(oldNote.getText());
		name.setText(oldNote.getTitle());
		visibility.setSelected(oldNote.getVisibility());
	}
}
