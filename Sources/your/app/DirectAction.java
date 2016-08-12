package your.app;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WORequest;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXDirectAction;
import er.extensions.eof.ERXEC;
import your.app.components.CreatePerson;
import your.app.components.Main;
import your.app.components.MyEvent;
import your.app.components.MySignUp;
import your.app.components.SignUpConfrimationEmail;
import your.app.model.Person;
import your.app.model.SignUp;
import your.app.model.Person.LoginLevelEnum;

public class DirectAction extends ERXDirectAction {
	public DirectAction(WORequest request) {
		super(request);
	}

	@Override
	public WOActionResults defaultAction() {
		return pageWithName(Main.class.getName());
	}
	
	public WOActionResults signUpAction() {
		String id = (String)request().formValueForKey("id");
		EOEditingContext ec = ERXEC.newEditingContext();
		SignUp signUp;
		if (id != null) {
			signUp = null;//SignUp.fetchAllSignUps(editingContext);
		} else {
			signUp = SignUp.createSignUp(ec);	
			Person person = Person.createPerson(ec);   
			signUp.setPerson(person);
		}
		MySignUp mySignUp = pageWithName(MySignUp.class);
		mySignUp.setSignUp(signUp);
		return mySignUp;
	}
	
	public WOActionResults createPersonAction(){
		EOEditingContext ec = ERXEC.newEditingContext();
		Person person = Person.createPerson(ec);
		person.setLoginLevel(LoginLevelEnum.Normal);
   	    
		CreatePerson createPerson = pageWithName(CreatePerson.class);
		createPerson.setPerson(person);

		return createPerson;
		
		
	}
	
	public Application application() {
		return (Application)WOApplication.application();
	}
	
	@Override
	public Session session() {
		return (Session)super.session();
	}
}
