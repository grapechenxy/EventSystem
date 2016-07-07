package your.app.migration.person;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class person2 extends ERXMigrationDatabase.Migration {
	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		ERXMigrationTable eventTable = database.newTableNamed("Event");
		eventTable.newTimestampColumn("DateTime", ALLOWS_NULL);
		eventTable.newStringColumn("eventName", 255, ALLOWS_NULL);
		eventTable.newIntegerColumn("id", NOT_NULL);
		eventTable.create();
	 	eventTable.setPrimaryKey("id");
	 	



	 	ERXMigrationTable personTable = database.existingTableNamed("Person");

		personTable.newIntegerColumn("eventID", ALLOWS_NULL);
		personTable.addForeignKey("eventID", "Event", "id");


	}
}
