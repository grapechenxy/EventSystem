// DO NOT EDIT.  Make changes to Event.java instead.
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
public abstract class _Event extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Event";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> DATE_TIME = new ERXKey<NSTimestamp>("dateTime");
  public static final ERXKey<String> EVENT_NAME = new ERXKey<String>("eventName");

  // Relationship Keys
  public static final ERXKey<your.app.model.Location> LOCATION = new ERXKey<your.app.model.Location>("location");
  public static final ERXKey<your.app.model.Person> PERSONS = new ERXKey<your.app.model.Person>("persons");

  // Attributes
  public static final String DATE_TIME_KEY = DATE_TIME.key();
  public static final String EVENT_NAME_KEY = EVENT_NAME.key();

  // Relationships
  public static final String LOCATION_KEY = LOCATION.key();
  public static final String PERSONS_KEY = PERSONS.key();

  private static final Logger log = LoggerFactory.getLogger(_Event.class);

  public Event localInstanceIn(EOEditingContext editingContext) {
    Event localInstance = (Event)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateTime() {
    return (NSTimestamp) storedValueForKey(_Event.DATE_TIME_KEY);
  }

  public void setDateTime(NSTimestamp value) {
    log.debug( "updating dateTime from {} to {}", dateTime(), value);
    takeStoredValueForKey(value, _Event.DATE_TIME_KEY);
  }

  public String eventName() {
    return (String) storedValueForKey(_Event.EVENT_NAME_KEY);
  }

  public void setEventName(String value) {
    log.debug( "updating eventName from {} to {}", eventName(), value);
    takeStoredValueForKey(value, _Event.EVENT_NAME_KEY);
  }

  public your.app.model.Location location() {
    return (your.app.model.Location)storedValueForKey(_Event.LOCATION_KEY);
  }

  public void setLocation(your.app.model.Location value) {
    takeStoredValueForKey(value, _Event.LOCATION_KEY);
  }

  public void setLocationRelationship(your.app.model.Location value) {
    log.debug("updating location from {} to {}", location(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setLocation(value);
    }
    else if (value == null) {
      your.app.model.Location oldValue = location();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Event.LOCATION_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Event.LOCATION_KEY);
    }
  }

  public NSArray<your.app.model.Person> persons() {
    return (NSArray<your.app.model.Person>)storedValueForKey(_Event.PERSONS_KEY);
  }

  public NSArray<your.app.model.Person> persons(EOQualifier qualifier) {
    return persons(qualifier, null, false);
  }

  public NSArray<your.app.model.Person> persons(EOQualifier qualifier, boolean fetch) {
    return persons(qualifier, null, fetch);
  }

  public NSArray<your.app.model.Person> persons(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.Person> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = ERXQ.equals(your.app.model.Person.EVENT_KEY, this);

      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        fullQualifier = ERXQ.and(qualifier, inverseQualifier);
      }

      results = your.app.model.Person.fetchPersons(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = persons();
      if (qualifier != null) {
        results = (NSArray<your.app.model.Person>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.Person>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }

  public void addToPersons(your.app.model.Person object) {
    includeObjectIntoPropertyWithKey(object, _Event.PERSONS_KEY);
  }

  public void removeFromPersons(your.app.model.Person object) {
    excludeObjectFromPropertyWithKey(object, _Event.PERSONS_KEY);
  }

  public void addToPersonsRelationship(your.app.model.Person object) {
    log.debug("adding {} to persons relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToPersons(object);
    }
    else {
      addObjectToBothSidesOfRelationshipWithKey(object, _Event.PERSONS_KEY);
    }
  }

  public void removeFromPersonsRelationship(your.app.model.Person object) {
    log.debug("removing {} from persons relationship", object);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromPersons(object);
    }
    else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, _Event.PERSONS_KEY);
    }
  }

  public your.app.model.Person createPersonsRelationship() {
    EOEnterpriseObject eo = EOUtilities.createAndInsertInstance(editingContext(),  your.app.model.Person.ENTITY_NAME );
    addObjectToBothSidesOfRelationshipWithKey(eo, _Event.PERSONS_KEY);
    return (your.app.model.Person) eo;
  }

  public void deletePersonsRelationship(your.app.model.Person object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Event.PERSONS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllPersonsRelationships() {
    Enumeration<your.app.model.Person> objects = persons().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePersonsRelationship(objects.nextElement());
    }
  }


  public static Event createEvent(EOEditingContext editingContext) {
    Event eo = (Event) EOUtilities.createAndInsertInstance(editingContext, _Event.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Event> fetchSpec() {
    return new ERXFetchSpecification<Event>(_Event.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Event> fetchAllEvents(EOEditingContext editingContext) {
    return _Event.fetchAllEvents(editingContext, null);
  }

  public static NSArray<Event> fetchAllEvents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Event.fetchEvents(editingContext, null, sortOrderings);
  }

  public static NSArray<Event> fetchEvents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Event> fetchSpec = new ERXFetchSpecification<Event>(_Event.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Event> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Event fetchEvent(EOEditingContext editingContext, String keyName, Object value) {
    return _Event.fetchEvent(editingContext, ERXQ.equals(keyName, value));
  }

  public static Event fetchEvent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Event> eoObjects = _Event.fetchEvents(editingContext, qualifier, null);
    Event eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Event that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Event fetchRequiredEvent(EOEditingContext editingContext, String keyName, Object value) {
    return _Event.fetchRequiredEvent(editingContext, ERXQ.equals(keyName, value));
  }

  public static Event fetchRequiredEvent(EOEditingContext editingContext, EOQualifier qualifier) {
    Event eoObject = _Event.fetchEvent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Event that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Event localInstanceIn(EOEditingContext editingContext, Event eo) {
    Event localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
