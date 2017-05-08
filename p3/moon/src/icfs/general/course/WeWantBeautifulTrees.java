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

/**
 * @author lucia
 *
 */
public class WeWantBeautifulTrees extends DefaultTreeCellRenderer{
	Icon noteIcon;
	Icon exeIcon;
	Icon courseIcon;
	Icon unitIcon;
	
	
	public WeWantBeautifulTrees(Icon note, Icon exe, Icon course, Icon unit){
		this.exeIcon = exe;
		this.noteIcon = note;
		this.courseIcon = course;
		this.unitIcon = unit;		
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
	        }

	        return this;
	}
	
	private boolean isNote(Object value){
		return value instanceof Note;
	}
	private boolean isCourse(Object value){
		return value instanceof Course;
	}
	private boolean isExe(Object value){
		return value instanceof Exercise;
	}
	private boolean isUnit(Object value){
		return value instanceof Unit;
	}
	
}
