package your.app.migration.person;

import java.sql.JDBCType;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

import er.extensions.jdbc.ERXSQLHelper.ColumnIndex;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationIndex;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class person5 extends ERXMigrationDatabase.Migration {
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
		ERXMigrationTable signUpTable = database.newTableNamed("SignUp");

		
		signUpTable.newIntegerColumn("eventID", NOT_NULL);
		signUpTable.newIntegerColumn("id", NOT_NULL);
		signUpTable.newIntegerColumn("personID", NOT_NULL);
		signUpTable.newTimestampColumn("signUpDateTime", NOT_NULL);
		signUpTable.create();
	 	signUpTable.setPrimaryKey("id");

		signUpTable.addForeignKey("eventID", "Event", "id");
		signUpTable.addForeignKey("personID", "Person", "id");

		
	}
}
