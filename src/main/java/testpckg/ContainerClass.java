package testpckg;

import javax.persistence.*;

@Entity
public class ContainerClass {
	private ParentClass parentClass;

	private Integer databaseId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getDatabaseId() {
		return databaseId;
	}

	private void setDatabaseId(Integer databaseId) {
		this.databaseId = databaseId;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public ParentClass getParentClass() {
		return parentClass;
	}

	public void setParentClass(ParentClass parentClass) {
		this.parentClass = parentClass;
	}
}
