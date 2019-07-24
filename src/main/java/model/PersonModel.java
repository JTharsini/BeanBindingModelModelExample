package model;

public class PersonModel extends AbstractModelObject {
	private String first;

	private short age = 0;

	private boolean known = false;

	public PersonModel() {
		super();
	}

	public PersonModel(String firstName, short age, boolean known) {
		super();
		this.first = firstName;
		this.age = age;
		this.known = known;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String firstName) {
		String oldValue = this.first;
		this.first = firstName;
		firePropertyChange("first", oldValue, firstName);
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		short oldValue = this.age;
		this.age = age;
		firePropertyChange("age", oldValue, age);
	}

	public boolean isKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}
}
