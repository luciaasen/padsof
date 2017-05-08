/**
 * 
 */
package icfs.general.course;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.Component;
//import com.sun.xml.internal.ws.api.Component;

import moon.course.*;
import moon.course.question.Question;

/**
 * @author lucia
 *
 */
public class WeWantBeautifulTrees extends DefaultTreeCellRenderer{
	Icon noteIcon;
	Icon exeIcon;
	Icon courseIcon;
	Icon unitIcon;
	Icon questionIcon;
	
	
	public WeWantBeautifulTrees(Icon note, Icon exe, Icon course, Icon unit, Icon question){
		this.exeIcon = exe;
		this.noteIcon = note;
		this.courseIcon = course;
		this.unitIcon = unit;		
		this.questionIcon = question;
	}
	
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree,
	    Object value, boolean selected, boolean expanded,
	    boolean leaf, int row, boolean hasFocus) {
	        super.getTreeCellRendererComponent(tree, value, selected,expanded, leaf, row, hasFocus);
	        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
	        
	        if (isCourse(value) ) {
	            setIcon(courseIcon);
	            setToolTipText("This book is in the Tutorial series.");
	        } else if (isUnit(value)){
	        	setIcon(unitIcon);
	            setToolTipText(null); //no tool tip
	        } else if (isNote(value)){
	        	setIcon(noteIcon);
	        } else if (isExe(value)){
	        	setIcon(exeIcon);
	        } else if(isQuestion(value)){
	        	setIcon(questionIcon);
	        }

	        return this;
	}
	
	private boolean isNote(Object value){
		
		DefaultMutableTreeNode node =
			(DefaultMutableTreeNode)value;
		return (node.getUserObject() instanceof Note);
	}
	private boolean isCourse(Object value){
		DefaultMutableTreeNode node =
				(DefaultMutableTreeNode)value;
			
		return node.getUserObject() instanceof Course;
	}
	private boolean isExe(Object value){
		DefaultMutableTreeNode node =
				(DefaultMutableTreeNode)value;
			
		return node.getUserObject() instanceof Exercise;
	}
	private boolean isUnit(Object value){
		DefaultMutableTreeNode node =
				(DefaultMutableTreeNode)value;
			
		return node.getUserObject() instanceof Unit;
	}	
	private boolean isQuestion(Object value){
		DefaultMutableTreeNode node =
				(DefaultMutableTreeNode)value;
			
		return node.getUserObject() instanceof Question;
	}
	
}
