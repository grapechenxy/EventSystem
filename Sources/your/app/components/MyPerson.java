package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.eof.ERXEC;
import your.app.model.Person;
import your.app.model.Person.LoginLevelEnum;

import java.text.NumberFormat;

import org.apache.axis.session.Session;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSArray;
import your.app.model.Event;

public class MyPerson extends BaseComponent {
	public MyPerson(WOContext context) {
		super(context);
		persons = Person.fetchAllPersons(session().ec).mutableClone();
	}

	public Person person;
	public Person selectedPerson;

	private NSMutableArray<Person> persons;
	public NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
	public your.app.model.Event event;
	public LoginLevelEnum loginLevel;
	public PersonEdit personEdit;

	/**
	 * @return the persons
	 */
	public NSMutableArray<Person> persons() {
		return persons;
	}

	/**
	 * @param persons
	 *            the persons to set
	 */
	public void setPersons(NSMutableArray<Person> persons) {
		this.persons = persons;
	}

	public WOActionResults create() {
		selectedPerson = Person.createPerson(session().ec);
		selectedPerson.setLoginLevel(LoginLevelEnum.Normal);
		persons.add(selectedPerson);
		return null;
	}

	public WOActionResults edit() {
		selectedPerson = person;
		return null;
	}

	public WOActionResults save() {
		if (emailIsValid(selectedPerson.email())) {
			session().ec.saveChanges();
			System.out.println("Person saved!");
		} else {
			System.out.println("unvalid email");
		}
		return null;
	}

	public WOActionResults delete() {
		session().ec.deleteObject(person);
		session().ec.saveChanges();
		persons.remove(person);
		return null;
	}

	public boolean showWarning() {
		if (selectedPerson != null && emailIsValid(selectedPerson.email())) {
			return false;
		} else {
			return true;
		}
	}

	public NSArray<your.app.model.Event> events() {

		return your.app.model.Event.fetchAllEvents(session().ec);
	}

	public NSArray<LoginLevelEnum> loginLevels() {
		return new NSArray<LoginLevelEnum>(Person.LoginLevelEnum.values());

	}

}