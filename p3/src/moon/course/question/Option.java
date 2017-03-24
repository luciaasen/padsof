package moon.course.question;

import java.io.Serializable;

public class Option implements Serializable{
	private String option;

	/**
	 * Option constructor
	 * @param option
	 */
	public Option(String option) {
		super();
		this.option = option;
	}

	/**
	 * String getter
	 * @return option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * String setter 
	 * @param option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * An option equals another if their string is equals
	 * @return true if obj is an Option and option strings are equal in both
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Option))
			return false;
		Option other = (Option) obj;
		if (option == null) {
			if (other.option != null)
				return false;
		} else if (!option.equals(other.option))
			return false;
		return true;
	}
	
	
	
}
