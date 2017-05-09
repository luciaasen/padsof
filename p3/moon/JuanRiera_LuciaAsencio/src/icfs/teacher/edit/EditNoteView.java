/**
 * 
 */
package icfs.teacher.edit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import exception.DuplicateElementException;
import exception.EmptyTextFieldException;
import icfs.teacher.create.AddNoteView;
import main.mainMoon;
import moon.Academy;
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
		message.setText("Edit note ");
		nameLabel.setText("Edit name: ");
		contentsLabel.setText("Edit content: ");
		name.setText(null);
		visibility.setSelected(false);
		save.setVisible(false);
		exit.setVisible(false);
		JButton newSave = new JButton("Save & back to course tree");
		JButton newExit = new JButton("Exit without saving");
		
		layout.putConstraint(SpringLayout.WEST, newSave, 0, SpringLayout.WEST, down);
		layout.putConstraint(SpringLayout.EAST, newExit, 0, SpringLayout.EAST, down);
		layout.putConstraint(SpringLayout.NORTH, newSave, separation, SpringLayout.SOUTH, down);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, newExit, 0, SpringLayout.VERTICAL_CENTER, newSave);
		
		this.add(newSave);
		this.add(newExit);
		
		newExit.addActionListener(new EditNoteController(this));
		newSave.addActionListener(new EditNoteController(this));
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
	
	public Note getOldNote(){
		return oldNote;
	}
}
