package your.app.components;

import java.text.NumberFormat;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

import your.app.model.Person;
import your.app.model.Person.LoginLevelEnum;

public class PersonEdit extends BaseComponent {
	public PersonEdit(WOContext context) {
		super(context);
	}

	public Person person;

	public NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
	public your.app.model.Event event;

	public LoginLevelEnum loginLevel;

	public NSArray<your.app.model.Event> events() {

		return your.app.model.Event.fetchAllEvents(session().ec);
	}

	public NSArray<LoginLevelEnum> loginLevels() {
		return new NSArray<LoginLevelEnum>(Person.LoginLevelEnum.values());

	}




}