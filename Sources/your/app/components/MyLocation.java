package your.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

import your.app.model.Location;
import your.app.model.Person;

import com.webobjects.appserver.WOActionResults;

public class MyLocation extends BaseComponent {
    public MyLocation(WOContext context) {
        super(context);
        locations = Location.fetchAllLocations(session().ec).mutableClone();
    }
    
    public Location location;
    public Location selectedLocation;
    private NSMutableArray<Location> locations;
    public your.app.model.Event event;
    public Person person;

    
    

    
    public NSMutableArray<Location> locations(){
    	return locations;
    }
    
    public void setLocations(NSMutableArray<Location> locations){
    	this.locations = locations;
    }

	public WOActionResults createLocation() {
		selectedLocation = Location.createLocation(session().ec);
		locations.add(selectedLocation);
		return null;
	}

	public WOActionResults saveLocation() {
		session().ec.saveChanges();
		return null;
	}

	public WOActionResults editLocation() {
		selectedLocation = location;
		return null;
	}

	public WOActionResults deleteLocation() {
		session().ec.deleteObject(location);
		session().ec.saveChanges();
		locations.remove(location);		
		return null;
	}


   
    
    
}