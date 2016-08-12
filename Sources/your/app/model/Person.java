package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h3>Enterprise class - Person</h3>
 * 
 * <b>Attributes</b><pre>
 * age (Integer)
 * email (String)
 * firstName (String)
 * lastName (String)
 * loginLevel (your.app.model.Person.LoginLevelEnum)
 * password (String)
 * </pre>
 * 
 * <b>To-one relationships</b><pre>
 * event (your.app.model.Event)
 * </pre>
 * 
 * <b>To-many relationships</b><pre>
 * signUps (NSArray<your.app.model.SignUp>)
 * </pre>
 * @see your.app.model.Event
 * @see your.app.model.SignUp
 */
public class Person extends _Person {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Person.class);
	
	public enum LoginLevelEnum {SuperAdmin, Admin, Normal};
	
	public String fullName(){
		return firstName() + " " + lastName(); 
	}
	
	public boolean isSuperAdmin(){
		log.info(loginLevel()+"");
		return loginLevel().equals(LoginLevelEnum.SuperAdmin);
	}
	
	public boolean isAdmin(){
		return loginLevel().equals(LoginLevelEnum.Admin);
	}
	
	public boolean isNormal(){
		return loginLevel().equals(LoginLevelEnum.Normal);
	}
}
