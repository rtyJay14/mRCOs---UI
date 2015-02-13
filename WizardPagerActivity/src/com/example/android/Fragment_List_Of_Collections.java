package com.example.android;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;

public class Fragment_List_Of_Collections extends Fragment {
	private TableRow tr1, tr2;
	private Drawable d1, d2, d3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Drawables();
		View view = inflater
				.inflate(R.layout.fragment_list_of_collection, null);

		tr1 = (TableRow) view.findViewById(R.id.tableRow1);
		tr1.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("Recycle")
			@Override
			public void onClick(View v) {
				tr1.setBackgroundDrawable(d2);
				tr2.setBackgroundDrawable(d1);
			}
		});

		tr2 = (TableRow) view.findViewById(R.id.tableRow2);
		tr2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				tr1.setBackgroundDrawable(d1);
				tr2.setBackgroundDrawable(d2);
			}
		});
		return view;
	}

	void Drawables() {
		// set background color effect to violet
		d1 = getResources().getDrawable(R.drawable.image_view);
		d1.setAlpha(120);

		// set background color effect to yellow green
		d2 = getResources().getDrawable(R.drawable.bgbot_hover);
		d2.setAlpha(120);

		// set background color effect to blue
		d3 = getResources().getDrawable(R.drawable.image_view_hover);
	}
}