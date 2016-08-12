package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORedirect;

import er.extensions.appserver.ERXRedirect;

import com.webobjects.appserver.WOComponent;
import your.app.components.MySignUp;
import your.app.model.SignUp;
import com.webobjects.appserver.WOActionResults;

public class SignUpConfirmation extends WOComponent {
    

	public SignUpConfirmation(WOContext context) {
        super(context);
    }
    
    public SignUp signUp;
	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
    
	}
	public WOActionResults redirect() {
		WORedirect redirect = new WORedirect(context());
		redirect.setUrl(context().directActionURLForActionNamed("signUp",null));

		return redirect;
	}
}