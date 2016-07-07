// DO NOT EDIT.  Make changes to Person.java instead.
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
public abstract class _Person extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Person";

  // Attribute Keys
  public static final ERXKey<Integer> AGE = new ERXKey<Integer>("age");
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>("firstName");
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>("lastName");

  // Relationship Keys
  public static final ERXKey<your.app.model.Event> EVENT = new ERXKey<your.app.model.Event>("event");

  // Attributes
  public static final String AGE_KEY = AGE.key();
  public static final String FIRST_NAME_KEY = FIRST_NAME.key();
  public static final String LAST_NAME_KEY = LAST_NAME.key();

  // Relationships
  public static final String EVENT_KEY = EVENT.key();

  private static final Logger log = LoggerFactory.getLogger(_Person.class);

  public Person localInstanceIn(EOEditingContext editingContext) {
    Person localInstance = (Person)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer age() {
    return (Integer) storedValueForKey(_Person.AGE_KEY);
  }

  public void setAge(Integer value) {
    log.debug( "updating age from {} to {}", age(), value);
    takeStoredValueForKey(value, _Person.AGE_KEY);
  }

  public String firstName() {
    return (String) storedValueForKey(_Person.FIRST_NAME_KEY);
  }

  public void setFirstName(String value) {
    log.debug( "updating firstName from {} to {}", firstName(), value);
    takeStoredValueForKey(value, _Person.FIRST_NAME_KEY);
  }

  public String lastName() {
    return (String) storedValueForKey(_Person.LAST_NAME_KEY);
  }

  public void setLastName(String value) {
    log.debug( "updating lastName from {} to {}", lastName(), value);
    takeStoredValueForKey(value, _Person.LAST_NAME_KEY);
  }

  public your.app.model.Event event() {
    return (your.app.model.Event)storedValueForKey(_Person.EVENT_KEY);
  }

  public void setEvent(your.app.model.Event value) {
    takeStoredValueForKey(value, _Person.EVENT_KEY);
  }

  public void setEventRelationship(your.app.model.Event value) {
    log.debug("updating event from {} to {}", event(), value);
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      setEvent(value);
    }
    else if (value == null) {
      your.app.model.Event oldValue = event();
      if (oldValue != null) {
        removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _Person.EVENT_KEY);
      }
    } else {
      addObjectToBothSidesOfRelationshipWithKey(value, _Person.EVENT_KEY);
    }
  }


  public static Person createPerson(EOEditingContext editingContext) {
    Person eo = (Person) EOUtilities.createAndInsertInstance(editingContext, _Person.ENTITY_NAME);
    return eo;
  }

  public static ERXFetchSpecification<Person> fetchSpec() {
    return new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext) {
    return _Person.fetchAllPersons(editingContext, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Person.fetchPersons(editingContext, null, sortOrderings);
  }

  public static NSArray<Person> fetchPersons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<Person> fetchSpec = new ERXFetchSpecification<Person>(_Person.ENTITY_NAME, qualifier, sortOrderings);
    NSArray<Person> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static Person fetchPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchPerson(editingContext, ERXQ.equals(keyName, value));
  }

  public static Person fetchPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Person> eoObjects = _Person.fetchPersons(editingContext, qualifier, null);
    Person eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchRequiredPerson(editingContext, ERXQ.equals(keyName, value));
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    Person eoObject = _Person.fetchPerson(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person localInstanceIn(EOEditingContext editingContext, Person eo) {
    Person localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
