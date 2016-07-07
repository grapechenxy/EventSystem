package your.app;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.appserver.ERXSession;
import er.extensions.eof.ERXEC;

public class Session extends ERXSession {
	private static final long serialVersionUID = 1L;
	public EOEditingContext ec = ERXEC.newEditingContext();

	public Session() {
	}
	
	@Override
	public Application application() {
		return (Application)super.application();
	}
	
}
