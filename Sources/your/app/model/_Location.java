// DO NOT EDIT.  Make changes to Location.java instead.
package your.app.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;

import er.extensions.eof.*;
import er.extensions.foundation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public abstract class _Location extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Location";

  // Attribute Keys
  public static final ERXKey<String> ADDRESS = new ERXKey<String>("address");
  public static final ERXKey<String> CONTACT_PHONE_NO = new ERXKey<String>("contactPhoneNo");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");

  // Relationship Keys
  public static final ERXKey<your.app.model.Event> EVENTS = new ERXKey<your.app.model.Event>("events");

  // Attributes
  public static final String ADDRESS_KEY = ADDRESS.key();
  public static final String CONTACT_PHONE_NO_KEY = CONTACT_PHONE_NO.key();
  public static final String NAME_KEY = NAME.key();

  // Relationships
  public static final String EVENTS_KEY = EVENTS.key();

  private static final Logger log = LoggerFactory.getLogger(_Location.class);

  public Location localInstanceIn(EOEditingContext editingContext) {
    Location localInstance = (Location)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String address() {
    return (String) storedValueForKey(_Location.ADDRESS_KEY);
  }

  public void setAddress(String value) {
    log.debug( "updating address from {} to {}", address(), value);
    takeStoredValueForKey(value, _Location.ADDRESS_KEY);
  }

  public String contactPhoneNo() {
    return (String) storedValueForKey(_Location.CONTACT_PHONE_NO_KEY);
  }

  public void setContactPhoneNo(String value) {
    log.debug( "updating contactPhoneNo from {} to {}", contactPhoneNo(), value);
    takeStoredValueForKey(value, _Location.CONTACT_PHONE_NO_KEY);
  }

  public String name() {
    return (String) storedValueForKey(_Location.NAME_KEY);
  }

  public void setName(String value) {
    log.debug( "updating name from {} to {}", name(), value);
    takeStoredValueForKey(value, _Location.NAME_KEY);
  }

  public NSArray<your.app.model.Event> events() {
    return (NSArray<your.app.model.Event>)storedValueForKey(_Location.EVENTS_KEY);
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
      EOQualifier inverseQualifier = ERXQ.equals(your.app.model.Event.LOCATION_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
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
    includeObjectIntoPropertyWithKey(object, _Location.EVENTS_KEY);
  }

  public void removeFromEvents(your.app.model.Event object) {
    excludeObjectFromPropertyWithKey(object, _Location.EVENTS_KEY);
  }

  public void addToEventsRelationship(your.app.model.Event object) {
    log.debug("adding {} to events relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToEvents(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Location.EVENTS_KEY);
    }
  }

  public void removeFromEventsRelationship(your.app.model.Event object) {
    log.debug("removing {} from events relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromEvents(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Location.EVENTS_KEY);
    }
  }

  public your.app.model.Event createEventsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  your.app.model.Event.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Location.EVENTS_KEY);
    return (your.app.model.Event) eo;
  }

  public void deleteEventsRelationship(your.app.model.Event object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Location.EVENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllEventsRelationships() {
    Enumeration<your.app.model.Event> objects = events().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteEventsRelationship(objects.nextElement());
    }
  }


  public static Location createLocation(EOEditingContext editingContext) {
    Location eo = (Location) EOUtilities.createAndInsertInstance(editingContext, _Location.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Location> fetchSpec() {
    return new ERXFetchSpecification<Location>(_Location.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Location> fetchAllLocations(EOEditingContext editingContext) {
    return _Location.fetchAllLocations(editingContext, null);
  }

  public static NSArray<Location> fetchAllLocations(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Location.fetchLocations(editingContext, null, sortOrderings);
  }

  public static NSArray<Location> fetchLocations(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Location> fetchSpec = new ERXFetchSpecification<Location>(_Location.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Location> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Location fetchLocation(EOEditingContext editingContext, String keyName, Object value) {
    return _Location.fetchLocation(editingContext, ERXQ.equals(keyName, value));
  }

  public static Location fetchLocation(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Location> eoObjects = _Location.fetchLocations(editingContext, qualifier, null);
    Location eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Location that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Location fetchRequiredLocation(EOEditingContext editingContext, String keyName, Object value) {
    return _Location.fetchRequiredLocation(editingContext, ERXQ.equals(keyName, value));
  }

  public static Location fetchRequiredLocation(EOEditingContext editingContext, EOQualifier qualifier) {
    Location eoObject = _Location.fetchLocation(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Location that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Location localInstanceIn(EOEditingContext editingContext, Location eo) {
    Location localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
