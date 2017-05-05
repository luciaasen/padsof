/**
 * 
 */
package icfs.teacher.main;

import java.awt.*;
import java.util.Collection;

import javax.swing.*;
import javax.swing.event.*;

import moon.Academy;
import moon.course.Course;

/**
 * @author lucia
 *
 */
public class FilteredList<V> extends JPanel {
	private DefaultListModel<V> model = new DefaultListModel<V>() ;
	private Collection<V> defaultCollection;
	private int separation = 0;
	
	public FilteredList(Dimension d, Collection<V> defaultCollection){
		this.setPreferredSize(d);
		this.setBackground(Academy.ORANGE);
		
		/*Create the textfield that will filter the list*/
		JTextField text = filteringTextField();
		text.setSize(d.width, 40);
		text.setPreferredSize(new Dimension(d.width, 25));
		this.add(text, BorderLayout.NORTH);
		
		
		/*Create a scrolled list with a model in it and the size resulted from separation*/
		this.defaultCollection = defaultCollection;
		for (V element: defaultCollection) this.model.addElement(element);
		JList<V> list = new JList<V>(this.model);
		list.setSize(d.width, d.height - separation - text.getHeight());
		list.setPreferredSize(new Dimension(d.width - 18, d.height - separation - text.getHeight()));
		JScrollPane scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(d.width, d.height - separation - text.getHeight()));
		
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
}