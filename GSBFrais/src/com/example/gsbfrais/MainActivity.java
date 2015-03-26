package com.example.gsbfrais;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	private ListView listViewFrais;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialisation();
	}
	
	public void initialisation() {
		listViewFrais = (ListView) findViewById(R.id.listViewFrais);
		
		ArrayList<HashMap<String, String>> listeFiches = new ArrayList<HashMap<String, String>>();
		for(int i = 1; i <= 10; i++ ) {
			HashMap<String, String> itemList = new HashMap<String, String>();
			itemList.put("mois", "mois no " + i + " 2015");
			itemList.put("etat", "remboursé ou en attente");
			itemList.put("montant", Integer.toString(i*100) + " €");
			
			listeFiches.add(itemList);
		}
		
		ListAdapter adapter = new SimpleAdapter(this, listeFiches, R.layout.contenu_list, new String[] {"mois", "etat", "montant"}, 
												new int[] {R.id.textViewMois, R.id.textViewEtat, R.id.textViewMontant});
		
		
		listViewFrais.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
