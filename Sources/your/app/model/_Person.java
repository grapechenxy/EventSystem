// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to Person.java instead.
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
 * <h3>Enterprise class - Person</h3>
 * 
 * <b>Attributes</b><pre>
 * age (Integer)
 * email (String)
 * firstName (String)
 * lastName (String)
 * loginLevel (your.app.model.Person.LoginLevelEnum)
 * password (String)
 * </pre>
 * 
 * <b>To-one relationships</b><pre>
 * event (your.app.model.Event)
 * </pre>
 * 
 * <b>To-many relationships</b><pre>
 * signUps (NSArray<your.app.model.SignUp>)
 * </pre>
 * @see your.app.model.Event
 * @see your.app.model.SignUp
 */
@SuppressWarnings("all")
public abstract class _Person extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "Person";

	// Attributes
  public static final String AGE_KEY = "age";
  public static final ERXKey<Integer> AGE = new ERXKey<Integer>(AGE_KEY);
  public static final String EMAIL_KEY = "email";
  public static final ERXKey<String> EMAIL = new ERXKey<String>(EMAIL_KEY);
  public static final String FIRST_NAME_KEY = "firstName";
  public static final ERXKey<String> FIRST_NAME = new ERXKey<String>(FIRST_NAME_KEY);
  public static final String LAST_NAME_KEY = "lastName";
  public static final ERXKey<String> LAST_NAME = new ERXKey<String>(LAST_NAME_KEY);
  public static final String LOGIN_LEVEL_KEY = "loginLevel";
  public static final ERXKey<your.app.model.Person.LoginLevelEnum> LOGIN_LEVEL = new ERXKey<your.app.model.Person.LoginLevelEnum>(LOGIN_LEVEL_KEY);
  public static final String PASSWORD_KEY = "password";
  public static final ERXKey<String> PASSWORD = new ERXKey<String>(PASSWORD_KEY);

	// Relationships
  public static final String EVENT_KEY = "event";
  public static final ERXKey<your.app.model.Event> EVENT = new ERXKey<your.app.model.Event>(EVENT_KEY);
  public static final String SIGN_UPS_KEY = "signUps";
  public static final ERXKey<your.app.model.SignUp> SIGN_UPS = new ERXKey<your.app.model.SignUp>(SIGN_UPS_KEY);

  private static Logger LOG = Logger.getLogger(_Person.class);

  public Person localInstanceIn(EOEditingContext editingContext) {
    Person localInstance = (Person)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Integer age() {
    return (Integer) storedValueForKey("age");
  }
  public void setAge(Integer value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating age from " + age() + " to " + value);
    }
    takeStoredValueForKey(value, "age");
  }

  public String email() {
    return (String) storedValueForKey("email");
  }
  public void setEmail(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating email from " + email() + " to " + value);
    }
    takeStoredValueForKey(value, "email");
  }

  public String firstName() {
    return (String) storedValueForKey("firstName");
  }
  public void setFirstName(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating firstName from " + firstName() + " to " + value);
    }
    takeStoredValueForKey(value, "firstName");
  }

  public String lastName() {
    return (String) storedValueForKey("lastName");
  }
  public void setLastName(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating lastName from " + lastName() + " to " + value);
    }
    takeStoredValueForKey(value, "lastName");
  }

  public your.app.model.Person.LoginLevelEnum loginLevel() {
    return (your.app.model.Person.LoginLevelEnum) storedValueForKey("loginLevel");
  }
  public void setLoginLevel(your.app.model.Person.LoginLevelEnum value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating loginLevel from " + loginLevel() + " to " + value);
    }
    takeStoredValueForKey(value, "loginLevel");
  }

  public String password() {
    return (String) storedValueForKey("password");
  }
  public void setPassword(String value) {
    if (_Person.LOG.isDebugEnabled()) {
    	_Person.LOG.debug( "updating password from " + password() + " to " + value);
    }
    takeStoredValueForKey(value, "password");
  }

  public your.app.model.Event event() {
    return (your.app.model.Event)storedValueForKey("event");
  }
  
  public your.app.model.Event eventRelationship() {
    return (your.app.model.Event)storedValueForKey("event");
  }

  public void setEvent(your.app.model.Event value) {
    takeStoredValueForKey(value, "event");
  }

  public void setEventRelationship(your.app.model.Event value) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("updating event from " + event() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setEvent(value);
    }
    else if (value == null) {
    	your.app.model.Event oldValue = event();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "event");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "event");
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
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.SignUp.PERSON_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("adding " + object + " to signUps relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToSignUps(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, "signUps");
    }
  }

  public void removeFromSignUpsRelationship(your.app.model.SignUp object) {
    if (_Person.LOG.isDebugEnabled()) {
      _Person.LOG.debug("removing " + object + " from signUps relationship");
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


  public static Person createPerson(EOEditingContext editingContext) {
    Person eo = (Person) EOUtilities.createAndInsertInstance(editingContext, _Person.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext) {
    return _Person.fetchAllPersons(editingContext, null);
  }

  public static NSArray<Person> fetchAllPersons(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Person.fetchPersons(editingContext, null, sortOrderings);
  }

  public static NSArray<Person> fetchPersons(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Person.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Person> eoObjects = (NSArray<Person>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Person fetchPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Person> eoObjects = _Person.fetchPersons(editingContext, qualifier, null);
    Person eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Person)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, String keyName, Object value) {
    return _Person.fetchRequiredPerson(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Person fetchRequiredPerson(EOEditingContext editingContext, EOQualifier qualifier) {
    Person eoObject = _Person.fetchPerson(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Person that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Person localInstanceIn(EOEditingContext editingContext, Person eo) {
    Person localInstance = (eo == null) ? null : (Person)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
