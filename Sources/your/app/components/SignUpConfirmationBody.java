package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestampFormatter;

import your.app.model.SignUp;

import com.webobjects.appserver.WOComponent;

public class SignUpConfirmationBody extends WOComponent {
    public SignUpConfirmationBody(WOContext context) {
        super(context);
    }
    
    public NSTimestampFormatter nsdf = new NSTimestampFormatter("yyyy/MM/dd HH:MM");

    public SignUp signUp;


	
}