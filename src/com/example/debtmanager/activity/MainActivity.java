package com.example.debtmanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.debtmanager.R;
import com.example.debtmanager.R.id;
import com.example.debtmanager.R.layout;
import com.example.debtmanager.R.menu;
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

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_add:
			Intent intent = new Intent();
			intent.setClass(this, AddDebtActivity.class);
			startActivityForResult(intent, 1);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			switch (resultCode) {
			case Activity.RESULT_OK:
				Toast.makeText(this, "Saved.", Toast.LENGTH_LONG).show();
				this.mAdapter.notifyDataSetChanged();
				break;
			default:
				Toast.makeText(this, "Cancelled.", Toast.LENGTH_LONG).show();
				break;
			}
		}
	}
}
