package gui;

import model.BindingDemo;
import model.PersonModel;
import model.TargetPersonModel;

public class PersonMain {

	public static void main(String args[]) {
		TargetPersonModel newTargetPerson = new TargetPersonModel();
		PersonModel per = new PersonModel();
		BindingDemo personMain = new BindingDemo();
		personMain.setNewPerson(per);
		personMain.setNewTargetPerson(newTargetPerson);
		
		personMain.demoPersonMain();
		personMain.changeName("JayJay2");
		System.out.println(newTargetPerson.getFirst());
	}
}