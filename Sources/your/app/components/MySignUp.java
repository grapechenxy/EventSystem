package your.app.components;

import java.text.NumberFormat;
import java.util.Calendar;

import javax.activation.DataHandler;
import javax.mail.MessagingException;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORedirect;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

import er.extensions.appserver.ERXRedirect;
import er.javamail.ERMailDeliveryComponentBased;
import er.javamail.ERMailDeliveryHTML;
import er.javamail.ERMailDeliveryPlainText;
import your.app.model.Person;
import your.app.model.Person.LoginLevelEnum;
import your.app.model.SignUp;
import your.app.components.CreatePerson;

public class MySignUp extends BaseComponent {
	public MySignUp(WOContext context) {
		super(context);

	}

	public SignUp signUp;

	public NSTimestampFormatter nsdf = new NSTimestampFormatter("yyyy/MM/dd HH:MM");
	public NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
	public your.app.model.Event event;
	private NSMutableArray<your.app.model.Event> events;
	public Person signUpPerson;

	// public NSMutableArray<Person> persons;
	public String email;
	public String password;
	public String adminEmail = "grape8441@hotmail.com";
	public String message;
	public SignUpConfirmation signUpConfirmation;
//	public Person person;

	public CreatePerson createPerson;

	public SignUpConfirmation SignUpConfirmation() {
		return signUpConfirmation;
	}

	public SignUp signUp() {
		return signUp;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
		session().ec = signUp.editingContext();
	}

	public NSMutableArray<your.app.model.Event> events() {
		if (events == null) {
			events = your.app.model.Event.fetchAllEvents(session().ec).mutableClone();
		}

		return events;
	}

	public void setEvents(NSMutableArray<your.app.model.Event> events) {
		this.events = events;
	}

	public WOActionResults saveSignUp() {
		NSTimestamp currentDT = new NSTimestamp();
		signUp.setSignUpDateTime(currentDT);
		signUp.person().setEvent(signUp.event());

		session().ec.saveChanges();
		sendEmail();
		SignUpConfirmation confirmation = pageWithName(SignUpConfirmation.class);
		confirmation.setSignUp(signUp);
		return confirmation;
	}

	public WOActionResults update() {
		return null;
	}

	public WOActionResults login() {
		session().person = Person.fetchPerson(session().ec, Person.EMAIL.is(email)
				.and(Person.PASSWORD.is(password).and(Person.LOGIN_LEVEL.is(LoginLevelEnum.Normal))));
		if (session().person != null) {
			session().ec.deleteObject(signUp.person());
			signUp.setPerson(session().person);
		}
		return null;
	}

	public WOActionResults logout() {
		session().person = null;
		signUp.setPerson(Person.createPerson(session().ec));
		return null;
	}

	// public WOActionResults create() {
	// signUpPerson = Person.createPerson(session().ec);
	// signUpPerson.setLoginLevel(LoginLevelEnum.Normal);
	//
	// return null;
	// }
	//
	//
	// public WOActionResults save() {
	//
	// session().ec.saveChanges();
	// if(signUpPerson.firstName() != null){
	// signUp.setPerson(signUpPerson);
	// }
	// return null;
	// }

	public WOActionResults sendEmail() {
		ERMailDeliveryHTML mail = new ERMailDeliveryHTML();
		SignUpConfrimationEmail signUpMail = pageWithName(SignUpConfrimationEmail.class);
		signUpMail.setSignUp(signUp);
		mail.setComponent(signUpMail);

		try {
			mail.newMail();
			mail.setFromAddress(adminEmail);

			mail.setSubject("Thank you for signing up our event" + signUp.event().eventName());
			mail.setToAddress(signUp.person().email());

			mail.sendMail();

			message = "sending email succesful";

		} catch (Exception e) {
			message = e.getMessage();
		}
		System.out.println(message);
		return null;
	}

	public WOActionResults redirect() {
		ERXRedirect redirect = new ERXRedirect(context());
		redirect.setUrl(context().directActionURLForActionNamed("createPerson", null));
		return redirect;
	}

}