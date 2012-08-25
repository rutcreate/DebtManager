package com.example.debtmanager.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "debt";
	public static final int DATABASE_VERSION = 1;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE data (" + "_id INTEGER PRIMARY KEY,"
				+ "name TEXT NOT NULL," + "amount DOUBLE NOT NULL DEFAULT (0));");
		db.execSQL("INSERT INTO data (name, amount) VALUES ('Nirut', 300);");
		db.execSQL("INSERT INTO data (name, amount) VALUES ('Siriwat', 200);");
		db.execSQL("INSERT INTO data (name, amount) VALUES ('Chatchai', 400);");
		db.execSQL("INSERT INTO data (name, amount) VALUES ('Pirapa', 20);");
		db.execSQL("INSERT INTO data (name, amount) VALUES ('Sarocha', 99);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
