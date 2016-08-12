package your.app.components;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXComponent;
import er.extensions.validation.ERXValidationException;
import er.extensions.validation.ERXValidationFactory;
import your.app.Application;
import your.app.DirectAction;
import your.app.Session;
import your.app.model.Person;

public class BaseComponent extends ERXComponent {
	public BaseComponent(WOContext context) {
		super(context);
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	public Person person;

	@Override
	public Application application() {
		return (Application) super.application();
	}

	@Override
	public Session session() {
		return (Session) super.session();
	}

	public boolean emailIsValid(String emailStr) {
		
		try{
			Matcher	matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
			return matcher.matches();
		}catch(NullPointerException e){
			e.getStackTrace();		
			return false;
		}	
		
	}




}
