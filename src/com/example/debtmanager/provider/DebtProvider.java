package com.example.debtmanager.provider;


import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DebtProvider extends ContentProvider {
	
	private DatabaseHelper mDatabaseHelper;
	
	private static final UriMatcher sUriMatcher = buildUrlMatcher();
	
	private static UriMatcher buildUrlMatcher() {
		final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
		
		matcher.addURI("content://com.example.debtmanager", "list", 1);
		
		return matcher;
	}

	@Override
	public boolean onCreate() {
		this.mDatabaseHelper = new DatabaseHelper(this.getContext());
		return false;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		
		final int match = sUriMatcher.match(uri);
		String sql = "";
		
		switch (match) {
		case 1:
			sql = "SELECT _id, name, amount FROM data ORDER BY _id DESC";
		break;
		}
		
		SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		
		cursor.setNotificationUri(this.getContext().getContentResolver(), uri);
		
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
