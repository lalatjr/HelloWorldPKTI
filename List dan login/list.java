package com.example.mk_00;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class list extends ListActivity {
	/** Called when the activity is first created. */
		    @Override
		    public void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        setContentView(R.layout.list);
		        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		 
		        JSONObject json = JSON.getJSONfromURL("http://10.0.2.2/android/list.php");
		 
		        try{
		 
		            JSONArray  situs = json.getJSONArray("situs");
		 
		            for(int i=0;i<situs.length();i++){
		                HashMap<String, String> map = new HashMap<String, String>();
		                JSONObject jsonobj = situs.getJSONObject(i);
		 
		                map.put("id",  jsonobj.getString("id"));;
		                map.put("alamat", jsonobj.getString("alamat"));
		                map.put("ip",   jsonobj.getString("ip"));
		                mylist.add(map);
		            }
		        }catch(JSONException e)        {
		             Log.e("log_tag", "Error parsing data "+e.toString());
		        }
		 
		        ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.row,
		                        new String[] { "alamat", "ip" },
		                        new int[] { R.id.alamat, R.id.ip });
		 
		        setListAdapter(adapter);
		 
		        final ListView lv = getListView();
		        lv.setTextFilterEnabled(true);
		        lv.setOnItemClickListener(new OnItemClickListener() {
		            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		                @SuppressWarnings("unchecked")
		                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
		                Toast.makeText(list.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show();
		 
		            }
		        });
		    }
		}
