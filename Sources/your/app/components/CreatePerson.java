package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import er.extensions.appserver.ERXRedirect;
import er.extensions.validation.ERXValidationException;
import er.extensions.validation.ERXValidationFactory;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;

import your.app.model.Person;

public class CreatePerson extends BaseComponent {
	public Person person;

	public Person Person() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		session().ec = person.editingContext();
	}

	public CreatePerson(WOContext context) {
		super(context);
	}

	public WOComponent save() {
		// validateEmail(person.email());
		// try{
		// session().ec.saveChanges();
		// System.out.println("Person saved!");
		// }catch (ERXValidationException e) {
		//
		// e.printStackTrace();
		// } catch (NullPointerException el) {
		// el.printStackTrace();
		// }

		if (emailIsValid(person.email())) {
			session().ec.saveChanges();
			System.out.println("Person saved!");
		}
		else{
			System.out.println("unvalid email");
		}
		return null;
	}



	public void validateEmail(String emailStr) {

		if (!emailIsValid(emailStr) || emailStr.equals(null)) {
			// ERXValidationException ex = new
			// ERXValidationException(ERXValidationException.InvalidValueException,
			// person, Person.EMAIL_KEY);
			ERXValidationFactory factory = ERXValidationFactory.defaultFactory();
			ERXValidationException ex = factory.createException(person, Person.EMAIL_KEY, emailStr,
					ERXValidationException.InvalidValueException);
			throw ex;
		}
	}

	public WOActionResults redirectToMySignUp() {

		ERXRedirect redirect = new ERXRedirect(context());
		redirect.setUrl(context().directActionURLForActionNamed("signUp", null));

		return redirect;
	}
}