package com.example.debtmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.example.debtmanager.widget.DebtAdapter;

public class MainActivity extends Activity {

	private ListView mListView;
	private DebtAdapter mAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.mListView = (ListView) this.findViewById(R.id.list_view);
		this.mAdapter = new DebtAdapter(this);
		this.mListView.setAdapter(this.mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
