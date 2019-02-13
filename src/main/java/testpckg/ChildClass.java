package testpckg;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("BType")
public class ChildClass extends ParentClass {
	private String bVal;

	public ChildClass(String bVal) {
		this.bVal = bVal;
	}

	ChildClass() {
		// Constructor for Hibernate
	}

	@Transient
	@Override
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	public String getbVal() {
		return bVal;
	}

	public void setbVal(String bVal) {
		this.bVal = bVal;
	}
}
