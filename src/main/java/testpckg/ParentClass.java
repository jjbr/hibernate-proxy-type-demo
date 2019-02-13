package testpckg;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "ATable")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class ParentClass {

	private Integer aVal = new Random().nextInt();

	private Integer databaseId;

	@Transient
	public String getClassName() {
		return this.getClass().getSimpleName();
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getDatabaseId() {
		return databaseId;
	}

	private void setDatabaseId(Integer databaseId) {
		this.databaseId = databaseId;
	}

	public Integer getaVal() {
		return aVal;
	}

	public void setaVal(Integer aVal) {
		this.aVal = aVal;
	}
}
