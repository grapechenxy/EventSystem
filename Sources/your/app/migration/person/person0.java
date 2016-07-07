package your.app.migration.person;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class person0 extends ERXMigrationDatabase.Migration {
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
		ERXMigrationTable personTable = database.newTableNamed("Person");
		personTable.newStringColumn("firstName", 255, ALLOWS_NULL);
		personTable.newIntegerColumn("id", NOT_NULL);
		personTable.newStringColumn("lastName", 255, ALLOWS_NULL);
		personTable.create();
	 	personTable.setPrimaryKey("id");

	}
}
