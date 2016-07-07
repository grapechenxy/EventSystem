package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person extends _Person {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Person.class);
	
	public String fullName(){
		return firstName() + " " + lastName(); 
	}
}
