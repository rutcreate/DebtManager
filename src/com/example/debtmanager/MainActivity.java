package com.example.debtmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mListView;
	private ArrayAdapter<String> mAdapter;
	private Cursor mCursor;
	private ArrayList<String> mData;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.mListView = (ListView) this.findViewById(R.id.list_view);

		DatabaseHelper dbHelper = new DatabaseHelper(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		this.mCursor = db.rawQuery(
				"SELECT name, amount FROM data ORDER BY _id DESC", null);

		this.mData = new ArrayList<String>();
		this.mCursor.moveToFirst();
		do {
			this.mData.add(this.mCursor.getString(0) + " "
					+ this.mCursor.getString(1));
		} while (this.mCursor.moveToNext());

		this.mAdapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.title, this.mData);

		this.mListView.setAdapter(this.mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
