package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestampFormatter;

import your.app.model.SignUp;

public class SignUpConfrimationEmail extends BaseComponent {
    public SignUpConfrimationEmail(WOContext context) {
        super(context);
    }
    

    public SignUp signUp;
	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
    
	}
}