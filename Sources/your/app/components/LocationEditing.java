package your.app.components;

import com.webobjects.appserver.WOContext;

import your.app.model.Location;

import com.webobjects.appserver.WOComponent;

public class LocationEditing extends BaseComponent {
    public LocationEditing(WOContext context) {
        super(context);
    }
    
    public Location location;
}