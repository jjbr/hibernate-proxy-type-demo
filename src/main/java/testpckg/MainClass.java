package testpckg;


import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class MainClass {

	private static EntityManager entityManager;

	public static void main(String[] args) {
		persist();
		fetch();
	}

	public static void persist() {
		init();

		ChildClass childClass = new ChildClass("foo");

		ContainerClass cc = new ContainerClass();
		cc.setParentClass(childClass);

		entityManager.getTransaction().begin();
		entityManager.persist(cc);
		entityManager.getTransaction().commit();

		entityManager.close();
	}

	public static void fetch() {
		init();
		ContainerClass cc = entityManager.createQuery("FROM ContainerClass", ContainerClass.class).getResultList().get(0);

		ParentClass parentClass = cc.getParentClass();

		if (parentClass instanceof ChildClass) {
			System.out.println("parentClass is instanceof ChildClass");
		} else {
			System.out.println("parentClass is NOT instanceof ChildClass");
		}

		System.out.println("parentClass reports own class name as: " + parentClass.getClassName());

		entityManager.close();
	}

	private static void init() {
		Configuration conf = new Configuration();

		conf.configure("hibernate-h2.cfg.xml")
				.addAnnotatedClass(ParentClass.class)
				.addAnnotatedClass(ChildClass.class)
				.addAnnotatedClass(ContainerClass.class);

		entityManager = conf.buildSessionFactory().createEntityManager();
	}
}
