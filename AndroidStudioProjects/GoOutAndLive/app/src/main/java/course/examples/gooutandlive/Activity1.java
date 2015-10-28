package course.examples.gooutandlive;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {
    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    String displayStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        displayStr = "start";
        ListView list = (ListView) findViewById(R.id.listView);

        adapter=new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,
        listItems);

        list.setAdapter(adapter);

        listItems.add(displayStr);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayText(View view) {
        EditText edit = (EditText) findViewById(R.id.editText);

        displayStr = edit.getText().toString();

        listItems.add(displayStr);
        adapter.notifyDataSetChanged();

        edit.setText("");
    }

}


