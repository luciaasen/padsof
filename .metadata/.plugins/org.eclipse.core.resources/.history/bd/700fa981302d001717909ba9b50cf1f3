package p5;

import p5.exc.IllegalArgumentException;
import p5.interf.*;

public class MyAdjustableTime extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer>{
	
	public MyAdjustableTime(Integer value){
		super(value);
	}
	
	@Override
	public void incrementTime(int inc) throws IllegalArgumentException {
		Integer oldValue = super.value.orElse(0);
		Integer	newValue = oldValue + inc;
		if (newValue < 0){
			throw new IllegalArgumentException();
		}
		super.setValue(newValue);		
	}

	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		Integer inc = property.getValue() - oldValue;
		this.incrementTime(inc);
	}
	
	@Override
	public String toString(){
		return "" + super.value.orElse(0);
	}

}
