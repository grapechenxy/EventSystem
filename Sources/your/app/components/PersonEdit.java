package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

import your.app.model.Person;

import java.text.NumberFormat;


public class PersonEdit extends BaseComponent {
    public PersonEdit(WOContext context) {
        super(context);
    }
    
    
    public Person person;

	public NumberFormat integerFormatter = NumberFormat.getIntegerInstance();
	public your.app.model.Event event;
	

	public NSArray<your.app.model.Event> events() {
		
		return your.app.model.Event.fetchAllEvents(session().ec);
	}
}