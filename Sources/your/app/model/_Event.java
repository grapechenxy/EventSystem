// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Event.java instead.
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
 * <h3>Enterprise class - Event</h3>
 * 
 * <b>Attributes</b><pre>
 * dateTime (NSTimestamp)
 * eventName (String)
 * </pre>
 * 
 * <b>To-one relationships</b><pre>
 * location (your.app.model.Location)
 * </pre>
 * 
 * <b>To-many relationships</b><pre>
 * persons (NSArray<your.app.model.Person>)
 * signUps (NSArray<your.app.model.SignUp>)
 * </pre>
 * @see your.app.model.Location
 * @see your.app.model.Person
 * @see your.app.model.SignUp
 */
@SuppressWarnings("all")
public abstract class _Event extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "Event";

	// Attributes
  public static final String DATE_TIME_KEY = "dateTime";
  public static final ERXKey<NSTimestamp> DATE_TIME = new ERXKey<NSTimestamp>(DATE_TIME_KEY);
  public static final String EVENT_NAME_KEY = "eventName";
  public static final ERXKey<String> EVENT_NAME = new ERXKey<String>(EVENT_NAME_KEY);

	// Relationships
  public static final String LOCATION_KEY = "location";
  public static final ERXKey<your.app.model.Location> LOCATION = new ERXKey<your.app.model.Location>(LOCATION_KEY);
  public static final String PERSONS_KEY = "persons";
  public static final ERXKey<your.app.model.Person> PERSONS = new ERXKey<your.app.model.Person>(PERSONS_KEY);
  public static final String SIGN_UPS_KEY = "signUps";
  public static final ERXKey<your.app.model.SignUp> SIGN_UPS = new ERXKey<your.app.model.SignUp>(SIGN_UPS_KEY);

  private static Logger LOG = Logger.getLogger(_Event.class);

  public Event localInstanceIn(EOEditingContext editingContext) {
    Event localInstance = (Event)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp dateTime() {
    return (NSTimestamp) storedValueForKey("dateTime");
  }
  public void setDateTime(NSTimestamp value) {
    if (_Event.LOG.isDebugEnabled()) {
    	_Event.LOG.debug( "updating dateTime from " + dateTime() + " to " + value);
    }
    takeStoredValueForKey(value, "dateTime");
  }

  public String eventName() {
    return (String) storedValueForKey("eventName");
  }
  public void setEventName(String value) {
    if (_Event.LOG.isDebugEnabled()) {
    	_Event.LOG.debug( "updating eventName from " + eventName() + " to " + value);
    }
    takeStoredValueForKey(value, "eventName");
  }

  public your.app.model.Location location() {
    return (your.app.model.Location)storedValueForKey("location");
  }
  
  public your.app.model.Location locationRelationship() {
    return (your.app.model.Location)storedValueForKey("location");
  }

  public void setLocation(your.app.model.Location value) {
    takeStoredValueForKey(value, "location");
  }

  public void setLocationRelationship(your.app.model.Location value) {
    if (_Event.LOG.isDebugEnabled()) {
      _Event.LOG.debug("updating location from " + location() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setLocation(value);
    }
    else if (value == null) {
    	your.app.model.Location oldValue = location();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "location");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "location");
    }
  }
  
  public NSArray<your.app.model.Person> persons() {
    return (NSArray<your.app.model.Person>)storedValueForKey("persons");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.Person.EVENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
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
    includeObjectIntoPropertyWithKey(object, "persons");
  }

  public void removeFromPersons(your.app.model.Person object) {
    excludeObjectFromPropertyWithKey(object, "persons");
  }

  public void addToPersonsRelationship(your.app.model.Person object) {
    if (_Event.LOG.isDebugEnabled()) {
      _Event.LOG.debug("adding " + object + " to persons relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToPersons(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "persons");
    }
  }

  public void removeFromPersonsRelationship(your.app.model.Person object) {
    if (_Event.LOG.isDebugEnabled()) {
      _Event.LOG.debug("removing " + object + " from persons relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromPersons(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "persons");
    }
  }

  public your.app.model.Person createPersonsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("Person");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "persons");
    return (your.app.model.Person) eo;
  }

  public void deletePersonsRelationship(your.app.model.Person object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "persons");
    editingContext().deleteObject(object);
  }

  public void deleteAllPersonsRelationships() {
    Enumeration objects = persons().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deletePersonsRelationship((your.app.model.Person)objects.nextElement());
    }
  }

  public NSArray<your.app.model.SignUp> signUps() {
    return (NSArray<your.app.model.SignUp>)storedValueForKey("signUps");
  }

  public NSArray<your.app.model.SignUp> signUps(EOQualifier qualifier) {
    return signUps(qualifier, null, false);
  }

  public NSArray<your.app.model.SignUp> signUps(EOQualifier qualifier, boolean fetch) {
    return signUps(qualifier, null, fetch);
  }

  public NSArray<your.app.model.SignUp> signUps(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.SignUp> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.SignUp.EVENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray qualifiers = new NSMutableArray();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.model.SignUp.fetchSignUps(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = signUps();
      if (qualifier != null) {
        results = (NSArray<your.app.model.SignUp>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.SignUp>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToSignUps(your.app.model.SignUp object) {
    includeObjectIntoPropertyWithKey(object, "signUps");
  }

  public void removeFromSignUps(your.app.model.SignUp object) {
    excludeObjectFromPropertyWithKey(object, "signUps");
  }

  public void addToSignUpsRelationship(your.app.model.SignUp object) {
    if (_Event.LOG.isDebugEnabled()) {
      _Event.LOG.debug("adding " + object + " to signUps relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToSignUps(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "signUps");
    }
  }

  public void removeFromSignUpsRelationship(your.app.model.SignUp object) {
    if (_Event.LOG.isDebugEnabled()) {
      _Event.LOG.debug("removing " + object + " from signUps relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromSignUps(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, "signUps");
    }
  }

  public your.app.model.SignUp createSignUpsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("SignUp");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "signUps");
    return (your.app.model.SignUp) eo;
  }

  public void deleteSignUpsRelationship(your.app.model.SignUp object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "signUps");
    editingContext().deleteObject(object);
  }

  public void deleteAllSignUpsRelationships() {
    Enumeration objects = signUps().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteSignUpsRelationship((your.app.model.SignUp)objects.nextElement());
    }
  }


  public static Event createEvent(EOEditingContext editingContext) {
    Event eo = (Event) EOUtilities.createAndInsertInstance(editingContext, _Event.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<Event> fetchAllEvents(EOEditingContext editingContext) {
    return _Event.fetchAllEvents(editingContext, null);
  }

  public static NSArray<Event> fetchAllEvents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Event.fetchEvents(editingContext, null, sortOrderings);
  }

  public static NSArray<Event> fetchEvents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Event.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Event> eoObjects = (NSArray<Event>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Event fetchEvent(EOEditingContext editingContext, String keyName, Object value) {
    return _Event.fetchEvent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Event fetchEvent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Event> eoObjects = _Event.fetchEvents(editingContext, qualifier, null);
    Event eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Event)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Event that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Event fetchRequiredEvent(EOEditingContext editingContext, String keyName, Object value) {
    return _Event.fetchRequiredEvent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Event fetchRequiredEvent(EOEditingContext editingContext, EOQualifier qualifier) {
    Event eoObject = _Event.fetchEvent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Event that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Event localInstanceIn(EOEditingContext editingContext, Event eo) {
    Event localInstance = (eo == null) ? null : (Event)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
