// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Location.java instead.
package your.app.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

/**
 * <h3>Enterprise class - Location</h3>
 * 
 * <b>Attributes</b><pre>
 * address (String)
 * contactPhoneNo (String)
 * name (String)
 * </pre>
 * 
 * <b>To-one relationships</b><pre>
 * </pre>
 * 
 * <b>To-many relationships</b><pre>
 * events (NSArray<your.app.model.Event>)
 * </pre>
 * @see your.app.model.Event
 */
@SuppressWarnings("all")
public abstract class _Location extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "Location";

	// Attributes
  public static final String ADDRESS_KEY = "address";
  public static final ERXKey<String> ADDRESS = new ERXKey<String>(ADDRESS_KEY);
  public static final String CONTACT_PHONE_NO_KEY = "contactPhoneNo";
  public static final ERXKey<String> CONTACT_PHONE_NO = new ERXKey<String>(CONTACT_PHONE_NO_KEY);
  public static final String NAME_KEY = "name";
  public static final ERXKey<String> NAME = new ERXKey<String>(NAME_KEY);

	// Relationships
  public static final String EVENTS_KEY = "events";
  public static final ERXKey<your.app.model.Event> EVENTS = new ERXKey<your.app.model.Event>(EVENTS_KEY);

  private static Logger LOG = Logger.getLogger(_Location.class);

  public Location localInstanceIn(EOEditingContext editingContext) {
    Location localInstance = (Location)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String address() {
    return (String) storedValueForKey("address");
  }
  public void setAddress(String value) {
    if (_Location.LOG.isDebugEnabled()) {
    	_Location.LOG.debug( "updating address from " + address() + " to " + value);
    }
    takeStoredValueForKey(value, "address");
  }

  public String contactPhoneNo() {
    return (String) storedValueForKey("contactPhoneNo");
  }
  public void setContactPhoneNo(String value) {
    if (_Location.LOG.isDebugEnabled()) {
    	_Location.LOG.debug( "updating contactPhoneNo from " + contactPhoneNo() + " to " + value);
    }
    takeStoredValueForKey(value, "contactPhoneNo");
  }

  public String name() {
    return (String) storedValueForKey("name");
  }
  public void setName(String value) {
    if (_Location.LOG.isDebugEnabled()) {
    	_Location.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, "name");
  }

  public NSArray<your.app.model.Event> events() {
    return (NSArray<your.app.model.Event>)storedValueForKey("events");
  }

  public NSArray<your.app.model.Event> events(EOQualifier qualifier) {
    return events(qualifier, null, false);
  }

  public NSArray<your.app.model.Event> events(EOQualifier qualifier, boolean fetch) {
    return events(qualifier, null, fetch);
  }

  public NSArray<your.app.model.Event> events(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.Event> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.Event.LOCATION_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.model.Event.fetchEvents(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = events();
      if (qualifier != null) {
        results = (NSArray<your.app.model.Event>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.Event>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToEvents(your.app.model.Event object) {
    includeObjectIntoPropertyWithKey(object, "events");
  }

  public void removeFromEvents(your.app.model.Event object) {
    excludeObjectFromPropertyWithKey(object, "events");
  }

  public void addToEventsRelationship(your.app.model.Event object) {
    if (_Location.LOG.isDebugEnabled()) {
      _Location.LOG.debug("adding " + object + " to events relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToEvents(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "events");
    }
  }

  public void removeFromEventsRelationship(your.app.model.Event object) {
    if (_Location.LOG.isDebugEnabled()) {
      _Location.LOG.debug("removing " + object + " from events relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromEvents(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "events");
    }
  }

  public your.app.model.Event createEventsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Event");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "events");
    return (your.app.model.Event) eo;
  }

  public void deleteEventsRelationship(your.app.model.Event object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "events");
    editingContext().deleteObject(object);
  }

  public void deleteAllEventsRelationships() {
    Enumeration objects = events().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteEventsRelationship((your.app.model.Event)objects.nextElement());
    }
  }


  public static Location createLocation(EOEditingContext editingContext) {
    Location eo = (Location) EOUtilities.createAndInsertInstance(editingContext, _Location.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<Location> fetchAllLocations(EOEditingContext editingContext) {
    return _Location.fetchAllLocations(editingContext, null);
  }

  public static NSArray<Location> fetchAllLocations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Location.fetchLocations(editingContext, null, sortOrderings);
  }

  public static NSArray<Location> fetchLocations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Location.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Location> eoObjects = (NSArray<Location>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Location fetchLocation(EOEditingContext editingContext, String keyName, Object value) {
    return _Location.fetchLocation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Location fetchLocation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Location> eoObjects = _Location.fetchLocations(editingContext, qualifier, null);
    Location eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Location)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Location that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Location fetchRequiredLocation(EOEditingContext editingContext, String keyName, Object value) {
    return _Location.fetchRequiredLocation(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Location fetchRequiredLocation(EOEditingContext editingContext, EOQualifier qualifier) {
    Location eoObject = _Location.fetchLocation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Location that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Location localInstanceIn(EOEditingContext editingContext, Location eo) {
    Location localInstance = (eo == null) ? null : (Location)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
