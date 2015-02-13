/*
 * Copyright 2015 Rudson Lima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FragmentMain extends Fragment {

    private boolean mSearchCheck;
    private static final String TEXT_FRAGMENT = "TEXT_FRAGMENT";
	ToggleButton ereceipt, list_of_collections, reprint, cancel_payment,
	settings, more;

	public FragmentMain newInstance(String text){
		FragmentMain mFragment = new FragmentMain();
		Bundle mBundle = new Bundle();
		mBundle.putString(TEXT_FRAGMENT, text);
		mFragment.setArguments(mBundle);
		return mFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub		
		View v = inflater.inflate(R.layout.fragment_main, container, false);

        TextView mTxtTitle = (TextView) v.findViewById(R.id.txtTitle);
        mTxtTitle.setText(getArguments().getString(TEXT_FRAGMENT));

		ereceipt = (ToggleButton) v.findViewById(R.id.ToggleButton1);
		ereceipt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!ereceipt.isChecked()) {
					cancel_payment.setChecked(true);
					reprint.setChecked(true);
					list_of_collections.setChecked(true);
					more.setChecked(true);
					settings.setChecked(true);
					Fragment_Blank_Space();
					Fragment_eReceipt er = new Fragment_eReceipt();
					FragmentManager fm = getFragmentManager();
					FragmentTransaction ft = fm.beginTransaction();
					ft.replace(R.id.layoutToReplace, er);
					ft.commit();
				} else {
					Fragment_Blank_Space();
				}

			}
		});

		list_of_collections = (ToggleButton) v.findViewById(R.id.ToggleButton2);
		list_of_collections.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!list_of_collections.isChecked()) {
					ereceipt.setChecked(true);
					cancel_payment.setChecked(true);
					reprint.setChecked(true);
					list_of_collections.setChecked(false);
					more.setChecked(true);
					settings.setChecked(true);
					
					Fragment_Blank_Space();
					Fragment_List_Of_Collections loc = new Fragment_List_Of_Collections();
					FragmentManager fm = getFragmentManager();
					FragmentTransaction ft = fm.beginTransaction();
					ft.replace(R.id.layoutToReplace, loc);
					ft.commit();
				} else {
					Fragment_Blank_Space();
				}
			}
		});

		reprint = (ToggleButton) v.findViewById(R.id.ToggleButton3);
		reprint.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!reprint.isChecked()) {
					Toast t3 = Toast.makeText(v.getContext(),
							"Reprint", Toast.LENGTH_SHORT);
					t3.show();
					reprint.setChecked(false);
					cancel_payment.setChecked(true);
					ereceipt.setChecked(true);
					list_of_collections.setChecked(true);
					more.setChecked(true);
					settings.setChecked(true);
					
					Fragment_Blank_Space();
				}
			}
		});

		cancel_payment = (ToggleButton) v.findViewById(R.id.ToggleButton4);
		cancel_payment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast t4 = Toast.makeText(v.getContext(),
						"Cancel Payment", Toast.LENGTH_SHORT);
				t4.show();
				if (!cancel_payment.isChecked()) {
					cancel_payment.setChecked(false);
					reprint.setChecked(true);
					ereceipt.setChecked(true);
					list_of_collections.setChecked(true);
					more.setChecked(true);
					settings.setChecked(true);
					
					Fragment_Blank_Space();
				}
			}
		});

		settings = (ToggleButton) v.findViewById(R.id.ToggleButton5);
		settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast t5 = Toast.makeText(v.getContext(), "Settings",
						Toast.LENGTH_SHORT);
				t5.show();
				if (!settings.isChecked()) {
					settings.setChecked(false);
					cancel_payment.setChecked(true);
					reprint.setChecked(true);
					ereceipt.setChecked(true);
					list_of_collections.setChecked(true);
					more.setChecked(true);
					
					Fragment_Blank_Space();
				}
			}
		});

		more = (ToggleButton) v.findViewById(R.id.ToggleButton6);
		more.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast t6 = Toast.makeText(v.getContext(), "More",
						Toast.LENGTH_SHORT);
				t6.show();
				if (!more.isChecked()) {
					more.setChecked(false);
					cancel_payment.setChecked(true);
					reprint.setChecked(true);
					ereceipt.setChecked(true);
					list_of_collections.setChecked(true);
					settings.setChecked(true);
					
					Fragment_Blank_Space();
				}
			}
		});
        
		v.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));		
		return v;		
	}
	
	private void Fragment_Blank_Space() {
		Fragment_Blank_Space r = new Fragment_Blank_Space();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.layoutToReplace, r);
		ft.commit();
	}
	
	@Override
	public void onResume() {
		Fragment_Blank_Space r = new Fragment_Blank_Space();
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.layoutToReplace, r);
		ft.commit();
		
		ereceipt.setChecked(true);
		settings.setChecked(true);
		cancel_payment.setChecked(true);
		reprint.setChecked(true);
		ereceipt.setChecked(true);
		list_of_collections.setChecked(true);
		more.setChecked(true);
		super.onResume();
	}

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setHasOptionsMenu(true);
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu, menu);
        
        //Select search item
        final MenuItem menuItem = menu.findItem(R.id.menu_search);
        menuItem.setVisible(true);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.nliveo_white));
        searchView.setOnQueryTextListener(onQuerySearchView);

		menu.findItem(R.id.menu_add).setVisible(true);

		mSearchCheck = false;	
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {

		case R.id.menu_add:
            Toast.makeText(getActivity(), R.string.add, Toast.LENGTH_SHORT).show();
			break;

		case R.id.menu_search:
			mSearchCheck = true;
            Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
			break;
		}
		return true;
	}	

   private SearchView.OnQueryTextListener onQuerySearchView = new SearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String s) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String s) {
           if (mSearchCheck){
               // implement your search here
           }
           return false;
       }
   };
}
