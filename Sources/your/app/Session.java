package your.app;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXSession;
import er.extensions.eof.ERXEC;
import your.app.model.Person;
import your.app.model.Person.LoginLevelEnum;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	public EOEditingContext ec = ERXEC.newEditingContext();
	public Person person;

	public void loginPerson(String email, String password) {

		person = Person.fetchPerson(ec, Person.EMAIL.is(email).and(Person.PASSWORD.is(password).and(
				(Person.LOGIN_LEVEL.is(LoginLevelEnum.SuperAdmin).or(Person.LOGIN_LEVEL.is(LoginLevelEnum.Admin))))));

	}

	public Session() {
	}

	@Override
	public Application application() {
		return (Application) super.application();
	}

}
