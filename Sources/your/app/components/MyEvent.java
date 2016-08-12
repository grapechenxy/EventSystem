package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestampFormatter;

import er.extensions.eof.ERXEC;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import your.app.model.Person;

public class MyEvent extends BaseComponent {
    public MyEvent(WOContext context) {
        super(context);
        
        events = your.app.model.Event.fetchAllEvents(session().ec).mutableClone();
    }
    
    //public EOEditingContext ec = ERXEC.newEditingContext();
    public NSTimestampFormatter nsdf = new NSTimestampFormatter("yyyy/MM/dd HH:MM");
	public your.app.model.Event event;
	public your.app.model.Event selectedEvent;
	private NSMutableArray<your.app.model.Event> events;
	public Person person;
	
	public NSMutableArray<your.app.model.Event> events(){
		return events;
	}
	
	public void setEvents(NSMutableArray<your.app.model.Event> events){
		this.events = events;
	}
    
    public WOActionResults createEvent() {
		selectedEvent = your.app.model.Event.createEvent(session().ec);
		events.add(selectedEvent);
		return null;
	}
	
	public WOActionResults editEvent() {
		selectedEvent = event;
		return null;
	}

	public WOActionResults saveEvent() {
		session().ec.saveChanges();
		return null;
	}
	
	public WOActionResults deleteEvent() {
		session().ec.deleteObject(event);
		session().ec.saveChanges();
		events.remove(event);
		return null;
	}
}