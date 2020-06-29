/**
 * 
 */
package p5;

import java.util.*;

import p5.interf.ObservableProperty;
import p5.interf.PropertyObserver;

/**
 * @author lucia
 *
 */
public abstract class DefaultObservableProperty<V>  implements ObservableProperty<V>{
	protected Optional<V> value;
	protected Optional<ArrayList<PropertyObserver<V>>> observers;
	
	/**
	 * Creates a DedaultObservableProperty with value
	 * @param value, the value of the property
	 */
	//TODO this should work for every class extending this class, or just for value?
	public DefaultObservableProperty(V value){
		this.value = Optional.of(value);
		this.observers = Optional.of(new ArrayList<PropertyObserver<V>>());
	}
	
	/**
	 * Value getter
	 * @return value if present, else null
	 */
	public V getValue(){
		return this.value.orElse(null);
	}
	
	/**
	 * Adds the observer from de property observers list
	 * @param o the PropertyObserver to remove
	 */
	public void addObserver( PropertyObserver<V> o){
		this.observers.orElse(null).add(o);
	}
	
	/**
	 * Removes the observer from de property observers list
	 * @param o the PropertyObserver to remove
	 */
	public void removeObserver(PropertyObserver<V> o){
		this.observers.orElse(null).remove(o);
	}
	
	/**
	 * if the value is present, updates it and, if changed, notifies all the observers
	 * @param newValue value to set
	 */
	protected void setValue(V newValue){
		if(this.value.isPresent()){
			if(this.value.get() != newValue){
				V oldValue = this.value.get();
				this.value = Optional.of(newValue);
				/*En el else del orElse devolvemos una lista vacia en vez de null para evitar una excepcion
				 * Al estar la lista vacia, no entrara en el bucle*/
				for (PropertyObserver<V> obs: this.observers.orElse(new ArrayList<PropertyObserver<V>>())){
					obs.propertyChanged(this, oldValue);
				}
			}
		}
	}	
}
