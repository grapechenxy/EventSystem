package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestampFormatter;

import your.app.model.Location;
import your.app.model.Person;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;

public class EventEdit extends BaseComponent {
    public EventEdit(WOContext context) {
        super(context);
    }
    
    public NSTimestampFormatter nsdf = new NSTimestampFormatter("yyMMdd HH:MM");
   	public your.app.model.Event event;
   	public Person person;
   	public Location location;
   	
   	public NSMutableArray<Location> locations(){
   		
   		return (NSMutableArray<Location>) Location.fetchAllLocations(session().ec);
   	}

}