package com.example.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<AdapterItems> listnewData = new ArrayList<AdapterItems>();
        MyCustomAdapter myAdapter;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);

        //add data and view it
        listnewData.add(new AdapterItems(1 , "developer" , "develop apps"));
        listnewData.add(new AdapterItems(2 , "admin" , "access to servers"));
        listnewData.add(new AdapterItems(3 , "teacher" , "learn students"));
        listnewData.add(new AdapterItems(4 , "driver" , "drive the bus"));
        listnewData.add(new AdapterItems(5 , "cooker" , "cook good food"));
        listnewData.add(new AdapterItems(6 , "maker" , "make things"));

        myAdapter=new MyCustomAdapter(listnewData);
        listView.setAdapter(myAdapter);
    }

    private class MyCustomAdapter extends BaseAdapter{
        public ArrayList<AdapterItems> listnewsDataAdapter;
        //constractor
        public MyCustomAdapter(ArrayList<AdapterItems> listnewsDataAdapter){
            this.listnewsDataAdapter = listnewsDataAdapter;
        }

        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myview = mInflater.inflate(R.layout.showinflater , null);
            final AdapterItems s = listnewsDataAdapter.get(position);
            TextView txtId = (TextView) myview.findViewById(R.id.id);
            txtId.setText(""+s.ID);
            TextView txtJobTitle = (TextView) myview.findViewById(R.id.jobtitle);
            txtJobTitle.setText(s.JobTitle);
            txtJobTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, s.JobTitle, Toast.LENGTH_SHORT).show();
                }
            });
            TextView txtDescription = (TextView) myview.findViewById(R.id.description);
            txtDescription.setText(s.Description);
            return myview;
        }
    }
}