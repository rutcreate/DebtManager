package com.example.debtmanager.activity;

import com.example.debtmanager.R;
import com.example.debtmanager.R.id;
import com.example.debtmanager.R.layout;
import com.example.debtmanager.provider.DatabaseHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddDebtActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.add_debt);

		final EditText nameInput = (EditText) this
				.findViewById(R.id.name_input);
		final EditText amountInput = (EditText) this
				.findViewById(R.id.amount_input);

		final Button saveButton = (Button) this.findViewById(R.id.save_button);
		saveButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DatabaseHelper dbHelper = new DatabaseHelper(
						AddDebtActivity.this);
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("name", nameInput.getText().toString());
				values.put("amount", amountInput.getText().toString());
				final long result = db.insert("data", null, values);
				db.close();
				if (result == -1) {
					AddDebtActivity.this.setResult(Activity.RESULT_CANCELED);
				} else {
					AddDebtActivity.this.setResult(Activity.RESULT_OK);
				}
				finish();
			}

		});
	}

}
