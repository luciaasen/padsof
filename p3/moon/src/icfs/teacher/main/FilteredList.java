/**
 * 
 */
package icfs.teacher.main;

import java.awt.*;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.*;
import javax.swing.event.*;

import moon.Academy;
import moon.course.Course;
import moon.user.User;

/**
 * @author lucia
 *
 */
public class FilteredList<V> extends JPanel {
	private JList<V> list;
	private DefaultListModel<V> model = new DefaultListModel<V>() ;
	private Collection<V> defaultCollection;
	private int separation = 0;
	
	public FilteredList(Dimension d, Collection<V> defaultCollection){
		this.setPreferredSize(d);
		this.setBackground(Academy.ORANGE);
		
		
		JPanel text = new JPanel();
		text.setBackground(Academy.ORANGE);
		
		/*Create label*/
		JLabel search = new JLabel("Search by name: ");		
		/*Create the textfield that will filter the list*/
		JTextField input = filteringTextField();
		input.setSize(d.width-160, 25);
		input.setPreferredSize(new Dimension(d.width-160, 25));
		text.add(search, BorderLayout.WEST);
		text.add(input, BorderLayout.EAST);
		
		text.setPreferredSize(new Dimension(d.width, 25));
		
		this.add(text, BorderLayout.NORTH);
		
		
		/*Create a scrolled list with a model in it and the size resulted from separation*/
		this.defaultCollection = defaultCollection;
		for (V element: defaultCollection) this.model.addElement(element);
		JList<V> list = new JList<V>(this.model);
		//list.setSize(d.width-18, d.height - 33);
		list.setPreferredSize(new Dimension(d.width - 18, d.height-33));
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(d.width, d.height -33));
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.list = list;
		this.add(scroll, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	private JTextField filteringTextField(){
		JTextField text = new JTextField();
		text.getDocument().addDocumentListener(new DocumentListener(){
							@Override public void insertUpdate(DocumentEvent e) {myfilter();}
							@Override public void removeUpdate(DocumentEvent e) {myfilter();}
							@Override public void changedUpdate(DocumentEvent e){}
							private void myfilter(){
								String t = text.getText();
								filter(t);
							}
					});
		return text;
	}
	
	private void filter(String t){
		for(V element: this.defaultCollection){
			if(element.toString().contains(t)){
				if( this.model.contains(element) == false){
					this.model.addElement(element);
				}
			}else if(this.model.contains(element)){
				this.model.removeElement(element);
			}
		}
	}
	
	public JList<V> getList(){
		return this.list;
	}
	public void setEverything(Collection<V> newModel){
		this.list.clearSelection();
		this.filteringTextField().setText(null);
		this.model.removeAllElements();
		for (V element: newModel) this.model.addElement(element);		
	}
}
