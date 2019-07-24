package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Binding;
import org.jdesktop.beansbinding.Bindings;

public class BindingDemo {
	private PersonModel newPerson;

	private TargetPersonModel newTargetPerson;

	public PersonModel getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(PersonModel newPerson) {
		this.newPerson = newPerson;
	}

	public TargetPersonModel getNewTargetPerson() {
		return newTargetPerson;
	}

	public void setNewTargetPerson(TargetPersonModel newTargetPerson) {
		this.newTargetPerson = newTargetPerson;
	}

	public void demoPersonMain() {
		initBindings();
		//addPropertyChangeListener();
	}

	public void changeName(String name) {
		newPerson.setFirst(name);
		System.out.println(newPerson.getFirst());
	}

	private void initBindings() {
		final BeanProperty<PersonModel, String> nameSourceBeanProperty = BeanProperty.create("first");
		final BeanProperty<TargetPersonModel, String> nameTargetBeanProperty = BeanProperty.create("first");

		Binding<PersonModel, String, TargetPersonModel, String> firstNameBinding = Bindings.createAutoBinding(
				UpdateStrategy.READ_WRITE, getNewPerson(), nameSourceBeanProperty, getNewTargetPerson(),
				nameTargetBeanProperty);
		firstNameBinding.bind();
	}

	private void addPropertyChangeListener() {
		getNewPerson().addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("first")) {
					getNewTargetPerson().setFirst(getNewPerson().getFirst());
					System.out.println(getNewTargetPerson().getFirst());
				}
			}
		});
	}
}
