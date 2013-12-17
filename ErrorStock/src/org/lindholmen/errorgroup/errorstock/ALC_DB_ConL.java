package org.lindholmen.errorgroup.errorstock;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ALC_DB_ConL {
	String localhost = "10.0.2.2"; // Localhost address on android, not
									// 127.0.0.1
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "password";
	private static final String DB_ADRESS = "192.168.1.254";

	private static final String DB_NAME = "db_name";
	private static final String DB_TABLE = "db_table";
	private static final int DB_VERSION = 1;

	private ALC_DB_Con_Assistant assist;
	private Context context;
	private SQLiteDatabase database;

	public ALC_DB_ConL(Context context1) {
		context = context1;
	}

	private class ALC_DB_Con_Assistant extends SQLiteOpenHelper {

		public ALC_DB_Con_Assistant(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DB_TABLE + " ("
					+ "SName TEXT NOT NULL, " + "SDate TEXT NOT NULL, "
					+ "SOpening DOUBLE, " + "SClosing DOUBLE, "
					+ "SHigh DOUBLE, " + "SLow DOUBLE, " + "SVolume INTEGER");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE); //If we would
			// want to drop it
		}
	}

	public void open() {
		assist = new ALC_DB_Con_Assistant(context);
		database = assist.getWritableDatabase();
	}

	public void close() {
		assist.close();
	}
}
