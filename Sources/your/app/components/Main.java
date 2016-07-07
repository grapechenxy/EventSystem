package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import er.extensions.eof.ERXEC;
import your.app.model.Person;


import com.webobjects.appserver.WOActionResults;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSTimestampFormatter;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;






public class Main extends BaseComponent {
	public Main(WOContext context) {
		super(context);
	}
	
//	public boolean showContentPerson = false, showContentEvent = false;
//	public WOActionResults toggleContentPerson(){
//		showContentPerson = !showContentPerson;
//		return null;
//	}	
//
//	public WOActionResults toggleContentEvent(){
//		showContentEvent = !showContentEvent;
//		return null;
//	}
	
	public String activeComponent = "person";

	
	public WOActionResults showPerson(){

			activeComponent = "person";
		return null;
	}
	
	public WOActionResults showEvent(){

		activeComponent = "event";
		return null;
	}
	
	public WOActionResults showLocation() {
		activeComponent = "location";
		return null;
	}
	
	public boolean isPerson(){
		return activeComponent.equals("person");
	}
	
	public boolean isEvent(){
		return activeComponent.equals("event");
	}

	public boolean isLocation(){
		return activeComponent.equals("location");
	}
	
	public String personCSSClass() {
		
		return isPerson()? "active" : null;
	}

	public String eventCSSClass() {
		
		return isEvent()? "active" : null;
	}
	
	public String locationCSSClass() {
		
		return isLocation()? "active" : null;
	}



}
