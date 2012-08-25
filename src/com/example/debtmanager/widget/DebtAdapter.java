package com.example.debtmanager.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.debtmanager.model.Debt;
import com.example.debtmanager.provider.DatabaseHelper;
import com.example.debtmanager.R;

public class DebtAdapter extends BaseAdapter {

	private Context mContext;
	private List<Debt> mDataSource;

	public DebtAdapter(Context pContext) {
		super();
		this.mContext = pContext;

		this.fetchDataSource();
	}
	
	private void fetchDataSource() {
		DatabaseHelper dbHelper = new DatabaseHelper(this.mContext);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(
				"SELECT _id, name, amount FROM data ORDER BY _id DESC", null);
		this.mDataSource = new ArrayList<Debt>();
		while (cursor.moveToNext()) {
			final int id = cursor.getInt(0);
			final String name = cursor.getString(1);
			final Double amount = cursor.getDouble(2);
			Debt debt = new Debt(id, name, amount);
			this.mDataSource.add(debt);
		}
		db.close();
	}

	@Override
	public int getCount() {
		return this.mDataSource.size();
	}

	@Override
	public Object getItem(int position) {
		return this.mDataSource.get(position);
	}

	@Override
	public long getItemId(int position) {
		Debt debt = (Debt) this.mDataSource.get(position);
		return debt.getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(this.mContext).inflate(
					R.layout.list_item, parent, false);

			viewHolder.name = (TextView) convertView.findViewById(R.id.title);
			viewHolder.amount = (TextView) convertView
					.findViewById(R.id.amount);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		Debt debt = (Debt) this.getItem(position);
		
		viewHolder.name.setText(debt.getName());
		viewHolder.amount.setText(debt.getAmount().toString());

		return convertView;
	}
	
	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
		this.fetchDataSource();
	}

	private class ViewHolder {
		TextView name;
		TextView amount;
	}

}
