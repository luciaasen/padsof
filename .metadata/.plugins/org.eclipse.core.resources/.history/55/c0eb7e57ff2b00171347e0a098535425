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
	Optional<V> value;
	Optional<ArrayList<PropertyObserver<V>>> observers;
	
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
	public void addObserver( PropertyObserver<V> o){
		this.observers.orElse(null).add(o);
	}
	public void removeObserver(PropertyObserver<V> o){
		this.observers.orElse(null).remove(o);
	}
	protected void setValue(V newValue){
		
	}	
}
