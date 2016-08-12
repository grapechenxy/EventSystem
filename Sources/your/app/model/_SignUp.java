// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to SignUp.java instead.
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
 * <h3>Enterprise class - SignUp</h3>
 * 
 * <b>Attributes</b><pre>
 * signUpDateTime (NSTimestamp)
 * </pre>
 * 
 * <b>To-one relationships</b><pre>
 * event (your.app.model.Event)
 * person (your.app.model.Person)
 * </pre>
 * 
 * <b>To-many relationships</b><pre>
 * </pre>
 * @see your.app.model.Event
 * @see your.app.model.Person
 */
@SuppressWarnings("all")
public abstract class _SignUp extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "SignUp";

	// Attributes
  public static final String SIGN_UP_DATE_TIME_KEY = "signUpDateTime";
  public static final ERXKey<NSTimestamp> SIGN_UP_DATE_TIME = new ERXKey<NSTimestamp>(SIGN_UP_DATE_TIME_KEY);

	// Relationships
  public static final String EVENT_KEY = "event";
  public static final ERXKey<your.app.model.Event> EVENT = new ERXKey<your.app.model.Event>(EVENT_KEY);
  public static final String PERSON_KEY = "person";
  public static final ERXKey<your.app.model.Person> PERSON = new ERXKey<your.app.model.Person>(PERSON_KEY);

  private static Logger LOG = Logger.getLogger(_SignUp.class);

  public SignUp localInstanceIn(EOEditingContext editingContext) {
    SignUp localInstance = (SignUp)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp signUpDateTime() {
    return (NSTimestamp) storedValueForKey("signUpDateTime");
  }
  public void setSignUpDateTime(NSTimestamp value) {
    if (_SignUp.LOG.isDebugEnabled()) {
    	_SignUp.LOG.debug( "updating signUpDateTime from " + signUpDateTime() + " to " + value);
    }
    takeStoredValueForKey(value, "signUpDateTime");
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
    if (_SignUp.LOG.isDebugEnabled()) {
      _SignUp.LOG.debug("updating event from " + event() + " to " + value);
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
  
  public your.app.model.Person person() {
    return (your.app.model.Person)storedValueForKey("person");
  }
  
  public your.app.model.Person personRelationship() {
    return (your.app.model.Person)storedValueForKey("person");
  }

  public void setPerson(your.app.model.Person value) {
    takeStoredValueForKey(value, "person");
  }

  public void setPersonRelationship(your.app.model.Person value) {
    if (_SignUp.LOG.isDebugEnabled()) {
      _SignUp.LOG.debug("updating person from " + person() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setPerson(value);
    }
    else if (value == null) {
    	your.app.model.Person oldValue = person();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "person");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "person");
    }
  }
  

  public static SignUp createSignUp(EOEditingContext editingContext) {
    SignUp eo = (SignUp) EOUtilities.createAndInsertInstance(editingContext, _SignUp.ENTITY_NAME);    
    return eo;
  }

  public static NSArray<SignUp> fetchAllSignUps(EOEditingContext editingContext) {
    return _SignUp.fetchAllSignUps(editingContext, null);
  }

  public static NSArray<SignUp> fetchAllSignUps(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SignUp.fetchSignUps(editingContext, null, sortOrderings);
  }

  public static NSArray<SignUp> fetchSignUps(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SignUp.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SignUp> eoObjects = (NSArray<SignUp>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static SignUp fetchSignUp(EOEditingContext editingContext, String keyName, Object value) {
    return _SignUp.fetchSignUp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SignUp fetchSignUp(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SignUp> eoObjects = _SignUp.fetchSignUps(editingContext, qualifier, null);
    SignUp eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (SignUp)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one SignUp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SignUp fetchRequiredSignUp(EOEditingContext editingContext, String keyName, Object value) {
    return _SignUp.fetchRequiredSignUp(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SignUp fetchRequiredSignUp(EOEditingContext editingContext, EOQualifier qualifier) {
    SignUp eoObject = _SignUp.fetchSignUp(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SignUp that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SignUp localInstanceIn(EOEditingContext editingContext, SignUp eo) {
    SignUp localInstance = (eo == null) ? null : (SignUp)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
