package your.app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Event extends _Event {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(Event.class);
	
	public String eventInfo(){
		return eventName() + " " + dateTime();
	}
}
