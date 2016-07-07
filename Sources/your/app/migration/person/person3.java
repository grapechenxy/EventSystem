package your.app.migration.person;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class person3 extends ERXMigrationDatabase.Migration {
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
		ERXMigrationTable locationTable = database.newTableNamed("Location");
		locationTable.newStringColumn("address", 255, ALLOWS_NULL);
		locationTable.newIntegerColumn("contactPhoneNo", ALLOWS_NULL);
		locationTable.newIntegerColumn("id", NOT_NULL);
		locationTable.newStringColumn("name", 255, ALLOWS_NULL);
		locationTable.create();
	 	locationTable.setPrimaryKey("id");

		ERXMigrationTable eventTable = database.existingTableNamed("Event");
		eventTable.newIntegerColumn("locationID", ALLOWS_NULL);
		eventTable.addForeignKey("locationID", "Location", "id");

	}
}
